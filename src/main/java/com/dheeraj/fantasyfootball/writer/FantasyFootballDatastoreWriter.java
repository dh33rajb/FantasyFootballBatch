package com.dheeraj.fantasyfootball.writer;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import com.dheeraj.fantasyfootball.domain.model.FantasyFootballResponse;
import com.dheeraj.fantasyfootball.domain.model.Player;
import com.dheeraj.fantasyfootball.domain.model.Position;
import com.dheeraj.fantasyfootball.domain.model.Team;

/**
 * This class writes the FantasyFootballResponse over to the underlying
 * datastore.
 */
public class FantasyFootballDatastoreWriter implements ItemWriter<FantasyFootballResponse> {

	@Autowired
	JdbcTemplate mysqlJdbcTemplate;

	@Override
	public void write(List<? extends FantasyFootballResponse> items) throws Exception {
		if (items == null || items.size() > 0) {
			FantasyFootballResponse fantasyFootballResponse = items.get(0);
			executePreWriteScripts();
			writePositions(fantasyFootballResponse.getPositions());
			writeTeams(fantasyFootballResponse.getTeams());
			writePlayers(fantasyFootballResponse.getPlayers());
		}
	}

	private String WRITE_TEAM = "INSERT INTO FantasyFootball.Team (TeamId, TeamName, ShortName, Image) VALUES (?, ?, ?, ?);";
	private String WRITE_TEAM_STATS = "INSERT INTO FantasyFootball.TeamStats (TeamId, Position, Played, Win, Loss, Draw, Points) VALUES (?, ?, ?, ?, ?, ?, ?);";

	private void writeTeams(List<Team> teams) {
		teams.forEach(team -> {
			this.mysqlJdbcTemplate.update(WRITE_TEAM, team.getTeamId(), team.getTeamName(), team.getShortName(),
					team.getImage());
			this.mysqlJdbcTemplate.update(WRITE_TEAM_STATS, team.getTeamId(), team.getTeamStats().getPosition(),
					team.getTeamStats().getPlayed(), team.getTeamStats().getWin(), team.getTeamStats().getLoss(),
					team.getTeamStats().getDraw(), team.getTeamStats().getPoints());
		});
	}

	private static String WRITE_PLAYER = "INSERT INTO Player(PlayerId, TeamId, DisplayName, FirstName, LastName, Photo, SquadNumber, PositionId) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	private static String WRITE_PLAYER_STATS = "INSERT INTO PlayerStats (PlayerId, MinutesPlayed, GoalsScored, Assists, CleanSheets, GoalsConceded, OwnGoals, PenalitiesSaved, PenalitiesMissed, YellowCards, RedCards, Saves) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static String WRITE_PLAYER_PERFORMANCE_STATS = "INSERT INTO PlayerPerformanceStats (PlayerId, ICTIndex, Influence, Creativity, Threat) VALUES (?, ?, ?, ?, ?);";

	private void writePlayers(List<Player> players) {
		players.forEach(player -> {
			this.mysqlJdbcTemplate.update(WRITE_PLAYER, player.getPlayerId(), player.getTeamId(),
					player.getDisplayName(), player.getFirstName(), player.getLastName(), player.getPhoto(),
					player.getSquadNumber(), player.getPositionId());
			this.mysqlJdbcTemplate.update(WRITE_PLAYER_STATS, player.getPlayerId(),
					player.getPlayerStats().getMinutesPlayed(), player.getPlayerStats().getGoalsScored(),
					player.getPlayerStats().getAssists(), player.getPlayerStats().getCleanSheets(),
					player.getPlayerStats().getGoalsConceded(), player.getPlayerStats().getOwnGoals(),
					player.getPlayerStats().getPenalitiesSaved(), player.getPlayerStats().getPenalitiesMissed(),
					player.getPlayerStats().getYellowCards(), player.getPlayerStats().getRedCards(), player.getPlayerStats().getSaves());
			this.mysqlJdbcTemplate.update(WRITE_PLAYER_PERFORMANCE_STATS, player.getPlayerId(),
					player.getPlayerPerformanceStats().getIctIndex(),
					player.getPlayerPerformanceStats().getInfluenceScore(),
					player.getPlayerPerformanceStats().getCreativityScore(),
					player.getPlayerPerformanceStats().getThreatScore());
		});
	}

	public void executePreWriteScripts() {
		executePreWriteScript("sql/clear_all_tables.sql");
	}

	public void executePreWriteScript(String path) {
		DataSource dataSource = mysqlJdbcTemplate.getDataSource();
		Resource resource = new ClassPathResource(path);
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
		databasePopulator.execute(dataSource);
	}

	private String WRITE_POSITION = "INSERT INTO FantasyFootball.Position (PositionId, PositionName, ShortName) VALUES (?, ?, ?);";

	private void writePositions(List<Position> positions) {
		positions.forEach(position -> {
			this.mysqlJdbcTemplate.update(WRITE_POSITION, position.getPositionId(), position.getPositionName(),
					position.getPositionShortName());
		});
	}
}

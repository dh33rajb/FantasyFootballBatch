package com.dheeraj.fantasyfootball.domain.deserializer;

import static com.dheeraj.fantasyfootball.domain.deserializer.DeserializerUtil.getIntNodeValue;
import static com.dheeraj.fantasyfootball.domain.deserializer.DeserializerUtil.getTextNodeValue;

import java.io.IOException;

import com.dheeraj.fantasyfootball.domain.model.Player;
import com.dheeraj.fantasyfootball.domain.model.PlayerPerformanceStats;
import com.dheeraj.fantasyfootball.domain.model.PlayerStats;
import com.dheeraj.fantasyfootball.domain.model.builder.PlayerBuilder;
import com.dheeraj.fantasyfootball.domain.model.builder.PlayerPerformanceStatsBuilder;
import com.dheeraj.fantasyfootball.domain.model.builder.PlayerStatsBuilder;
import com.dheeraj.fantasyfootball.domain.model.builder.factory.PlayerBuilderFactory;
import com.dheeraj.fantasyfootball.domain.model.builder.factory.PlayerPerformanceStatsBuilderFactory;
import com.dheeraj.fantasyfootball.domain.model.builder.factory.PlayerStatsBuilderFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class PlayerDeserializer extends JsonDeserializer<Player> {

	static String ID_KEY = "id";

	static String TEAM_KEY = "team";

	static String WEB_NAME_KEY = "web_name";

	static String FIRST_NAME_KEY = "first_name";

	static String SECOND_NAME_KEY = "second_name";

	static String PHOTO_KEY = "photo";

	static String SQUAD_NUMBER_KEY = "squad_number";

	static String ELEMENT_TYPE_KEY = "element_type";

	static String MINUTES_KEY = "minutes";

	static String GOALS_SCORED_KEY = "goals_scored";

	static String ASSISTS_KEY = "assists";

	static String CLEAN_SHEETS_KEY = "clean_sheets";

	static String GOALS_CONCEEDED_KEY = "goals_conceded";

	static String OWN_GOALS_KEY = "own_goals";

	static String PENALITIES_SAVED_KEY = "penalties_saved";

	static String PENALITIES_MISSED_KEY = "penalties_missed";

	static String YELLOW_CARDS_KEY = "yellow_cards";

	static String RED_CARDS_KEY = "red_cards";

	static String SAVES_KEY = "saves";

	static String ICT_INDEX_KEY = "ict_index";

	static String INFLUENCE_KEY = "influence";

	static String CREATIVITY_KEY = "creativity";

	static String THREAT_KEY = "threat";

	@Override
	public Player deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		JsonNode teamNode = parser.getCodec().readTree(parser);

		PlayerPerformanceStatsBuilder playerPerformanceStatsBuilder = PlayerPerformanceStatsBuilderFactory.create();
		PlayerPerformanceStats playerPerformanceStats = playerPerformanceStatsBuilder
				.ictIndex(Float.valueOf(getTextNodeValue(teamNode, ICT_INDEX_KEY)))
				.influenceScore(Float.valueOf(getTextNodeValue(teamNode, INFLUENCE_KEY)))
				.threatScore(Float.valueOf(getTextNodeValue(teamNode, THREAT_KEY))).build();

		PlayerStatsBuilder playerStatsBuilder = PlayerStatsBuilderFactory.create();
		PlayerStats playerStats = playerStatsBuilder.minutesPlayed(getIntNodeValue(teamNode, MINUTES_KEY))
				.goalsScored(getIntNodeValue(teamNode, GOALS_SCORED_KEY))
				.assists(getIntNodeValue(teamNode, ASSISTS_KEY))
				.cleanSheets(getIntNodeValue(teamNode, CLEAN_SHEETS_KEY))
				.goalsConceded(getIntNodeValue(teamNode, GOALS_CONCEEDED_KEY))
				.ownGoals(getIntNodeValue(teamNode, OWN_GOALS_KEY))
				.penalitiesSaved(getIntNodeValue(teamNode, PENALITIES_SAVED_KEY))
				.penalitiesMissed(getIntNodeValue(teamNode, PENALITIES_MISSED_KEY))
				.yellowCards(getIntNodeValue(teamNode, YELLOW_CARDS_KEY))
				.redCards(getIntNodeValue(teamNode, RED_CARDS_KEY)).saves(getIntNodeValue(teamNode, SAVES_KEY)).build();

		PlayerBuilder playerBuilder = PlayerBuilderFactory.create();
		playerBuilder.playerId(getIntNodeValue(teamNode, ID_KEY)).teamId(getIntNodeValue(teamNode, TEAM_KEY))
				.displayName(getTextNodeValue(teamNode, WEB_NAME_KEY))
				.firstName(getTextNodeValue(teamNode, FIRST_NAME_KEY))
				.lastName(getTextNodeValue(teamNode, SECOND_NAME_KEY)).photo(getTextNodeValue(teamNode, PHOTO_KEY))
				.squadNumber(getIntNodeValue(teamNode, SQUAD_NUMBER_KEY))
				.positionId(getIntNodeValue(teamNode, ELEMENT_TYPE_KEY)).playerStats(playerStats)
				.playerPerformanceStats(playerPerformanceStats);
		Player player = playerBuilder.build();
		return player;
	}
}

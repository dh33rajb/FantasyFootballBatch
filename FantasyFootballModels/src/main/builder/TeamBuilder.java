package com.dheeraj.fantasyfootball.domain.model.builder;

import com.dheeraj.fantasyfootball.domain.model.Team;
import com.dheeraj.fantasyfootball.domain.model.TeamStats;

public class TeamBuilder {
	private final Team team;

	public TeamBuilder() {
		this.team = new Team();
	}

	public TeamBuilder teamId(int teamId) {
		this.team.setTeamId(teamId);
		return this;
	}

	public TeamBuilder teamName(String teamName) {
		this.team.setTeamName(teamName);
		return this;
	}

	public TeamBuilder shortName(String shortName) {
		this.team.setShortName(shortName);
		return this;
	}

	public TeamBuilder image(String image) {
		this.team.setImage(image);
		return this;
	}

	public TeamBuilder teamStats(TeamStats teamStats) {
		this.team.setTeamStats(teamStats);
		return this;
	}

	public Team build() {
		return this.team;
	}
}
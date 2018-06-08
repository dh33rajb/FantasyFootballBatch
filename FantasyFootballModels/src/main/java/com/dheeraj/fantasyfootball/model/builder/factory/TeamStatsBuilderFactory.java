package com.dheeraj.fantasyfootball.model.builder.factory;

import com.dheeraj.fantasyfootball.model.builder.TeamStatsBuilder;

public class TeamStatsBuilderFactory {

	public static TeamStatsBuilder create() {
		return new TeamStatsBuilder();
	}
}

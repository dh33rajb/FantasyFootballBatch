package com.dheeraj.fantasyfootball.domain.model.builder.factory;

import com.dheeraj.fantasyfootball.domain.model.builder.TeamStatsBuilder;

public class TeamStatsBuilderFactory {
	public static TeamStatsBuilder create() {
		return new TeamStatsBuilder();
	}
}

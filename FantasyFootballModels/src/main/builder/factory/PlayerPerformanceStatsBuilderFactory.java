package com.dheeraj.fantasyfootball.domain.model.builder.factory;

import com.dheeraj.fantasyfootball.domain.model.builder.PlayerPerformanceStatsBuilder;

public class PlayerPerformanceStatsBuilderFactory {

	public static PlayerPerformanceStatsBuilder create() {
		return new PlayerPerformanceStatsBuilder();
	}
}

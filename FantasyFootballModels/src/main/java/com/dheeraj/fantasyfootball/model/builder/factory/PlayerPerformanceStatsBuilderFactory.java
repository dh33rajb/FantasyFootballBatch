package com.dheeraj.fantasyfootball.model.builder.factory;

import com.dheeraj.fantasyfootball.model.builder.PlayerPerformanceStatsBuilder;

public class PlayerPerformanceStatsBuilderFactory {

	public static PlayerPerformanceStatsBuilder create() {
		return new PlayerPerformanceStatsBuilder();
	}
}

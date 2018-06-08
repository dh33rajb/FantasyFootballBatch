package com.dheeraj.fantasyfootball.model.builder.factory;

import com.dheeraj.fantasyfootball.model.builder.PlayerStatsBuilder;

public class PlayerStatsBuilderFactory {

	public static PlayerStatsBuilder create() {
		return new PlayerStatsBuilder();
	}
}

package com.dheeraj.fantasyfootball.domain.model.builder.factory;

import com.dheeraj.fantasyfootball.domain.model.builder.PlayerStatsBuilder;

public class PlayerStatsBuilderFactory {

	public static PlayerStatsBuilder create() {
		return new PlayerStatsBuilder();
	}
}

package com.dheeraj.fantasyfootball.domain.model.builder.factory;

import com.dheeraj.fantasyfootball.domain.model.builder.PlayerBuilder;

public class PlayerBuilderFactory {
	
	public static PlayerBuilder create() {
		return new PlayerBuilder();
	}
}

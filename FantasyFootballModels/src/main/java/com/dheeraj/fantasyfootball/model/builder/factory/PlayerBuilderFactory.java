package com.dheeraj.fantasyfootball.model.builder.factory;

import com.dheeraj.fantasyfootball.model.builder.PlayerBuilder;

public class PlayerBuilderFactory {
	
	public static PlayerBuilder create() {
		return new PlayerBuilder();
	}
}

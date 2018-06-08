package com.dheeraj.fantasyfootball.model.builder.factory;

import com.dheeraj.fantasyfootball.model.builder.TeamBuilder;

public class TeamBuilderFactory {

	public static TeamBuilder create() {
		return new TeamBuilder();
	}
}

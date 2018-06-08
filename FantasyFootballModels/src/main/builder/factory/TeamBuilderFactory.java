package com.dheeraj.fantasyfootball.domain.model.builder.factory;

import com.dheeraj.fantasyfootball.domain.model.builder.TeamBuilder;

public class TeamBuilderFactory {
	public static TeamBuilder create() {
		return new TeamBuilder();
	}
}

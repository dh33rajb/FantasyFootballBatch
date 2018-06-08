package com.dheeraj.fantasyfootball.model.builder;

import com.dheeraj.fantasyfootball.model.PlayerStats;

public class PlayerStatsBuilder {

	private final PlayerStats playerStats;

	public PlayerStatsBuilder() {
		this.playerStats = new PlayerStats();
	}

	public PlayerStatsBuilder minutesPlayed(int minutesPlayed) {
		this.playerStats.setMinutesPlayed(minutesPlayed);
		return this;
	}

	public PlayerStatsBuilder goalsScored(int goalsScored) {
		this.playerStats.setGoalsScored(goalsScored);
		return this;
	}

	public PlayerStatsBuilder assists(int assists) {
		this.playerStats.setAssists(assists);
		return this;
	}

	public PlayerStatsBuilder cleanSheets(int cleanSheets) {
		this.playerStats.setCleanSheets(cleanSheets);
		return this;
	}

	public PlayerStatsBuilder goalsConceded(int goalsConceded) {
		this.playerStats.setGoalsConceded(goalsConceded);
		return this;
	}

	public PlayerStatsBuilder ownGoals(int ownGoals) {
		this.playerStats.setOwnGoals(ownGoals);
		return this;
	}

	public PlayerStatsBuilder penalitiesSaved(int penalitiesSaved) {
		this.playerStats.setPenalitiesSaved(penalitiesSaved);
		return this;
	}

	public PlayerStatsBuilder penalitiesMissed(int penalitiesMissed) {
		this.playerStats.setPenalitiesMissed(penalitiesMissed);
		return this;
	}

	public PlayerStatsBuilder yellowCards(int yellowCards) {
		this.playerStats.setYellowCards(yellowCards);
		return this;
	}

	public PlayerStatsBuilder redCards(int redCards) {
		this.playerStats.setRedCards(redCards);
		return this;
	}

	public PlayerStatsBuilder saves(int saves) {
		this.playerStats.setSaves(saves);
		return this;
	}

	public PlayerStats build() {
		return this.playerStats;
	}
}

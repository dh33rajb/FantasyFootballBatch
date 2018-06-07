package com.dheeraj.fantasyfootball.domain.model;

public class PlayerStats {

	private int minutesPlayed;

	private int goalsScored;

	private int assists;

	private int cleanSheets;

	private int goalsConceded;

	private int ownGoals;

	private int penalitiesSaved;

	private int penalitiesMissed;

	private int yellowCards;

	private int redCards;

	private int saves;

	public int getMinutesPlayed() {
		return minutesPlayed;
	}

	public void setMinutesPlayed(int minutesPlayed) {
		this.minutesPlayed = minutesPlayed;
	}

	public int getGoalsScored() {
		return goalsScored;
	}

	public void setGoalsScored(int goalsScored) {
		this.goalsScored = goalsScored;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getCleanSheets() {
		return cleanSheets;
	}

	public void setCleanSheets(int cleanSheets) {
		this.cleanSheets = cleanSheets;
	}

	public int getGoalsConceded() {
		return goalsConceded;
	}

	public void setGoalsConceded(int goalsConceded) {
		this.goalsConceded = goalsConceded;
	}

	public int getOwnGoals() {
		return ownGoals;
	}

	public void setOwnGoals(int ownGoals) {
		this.ownGoals = ownGoals;
	}

	public int getPenalitiesSaved() {
		return penalitiesSaved;
	}

	public void setPenalitiesSaved(int penalitiesSaved) {
		this.penalitiesSaved = penalitiesSaved;
	}

	public int getPenalitiesMissed() {
		return penalitiesMissed;
	}

	public void setPenalitiesMissed(int penalitiesMissed) {
		this.penalitiesMissed = penalitiesMissed;
	}

	public int getYellowCards() {
		return yellowCards;
	}

	public void setYellowCards(int yellowCards) {
		this.yellowCards = yellowCards;
	}

	public int getRedCards() {
		return redCards;
	}

	public void setRedCards(int redCards) {
		this.redCards = redCards;
	}

	public int getSaves() {
		return saves;
	}

	public void setSaves(int saves) {
		this.saves = saves;
	}
}

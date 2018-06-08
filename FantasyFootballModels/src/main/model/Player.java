package com.dheeraj.fantasyfootball.domain.model;

import com.dheeraj.fantasyfootball.domain.deserializer.PlayerDeserializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(Include.NON_NULL)
@JsonDeserialize(using = PlayerDeserializer.class)
public class Player {

	private int playerId;

	private int teamId;

	private String displayName;

	private String firstName;

	private String lastName;

	private String photo;

	private int squadNumber;

	private int positionId;

	private PlayerStats playerStats;

	private PlayerPerformanceStats playerPerformanceStats;

	public PlayerStats getPlayerStats() {
		return playerStats;
	}

	public void setPlayerStats(PlayerStats playerStats) {
		this.playerStats = playerStats;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getSquadNumber() {
		return squadNumber;
	}

	public void setSquadNumber(int squadNumber) {
		this.squadNumber = squadNumber;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public PlayerPerformanceStats getPlayerPerformanceStats() {
		return playerPerformanceStats;
	}

	public void setPlayerPerformanceStats(PlayerPerformanceStats playerPerformanceStats) {
		this.playerPerformanceStats = playerPerformanceStats;
	}
}

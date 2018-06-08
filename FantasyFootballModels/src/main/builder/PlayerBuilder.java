package com.dheeraj.fantasyfootball.domain.model.builder;

import com.dheeraj.fantasyfootball.domain.model.Player;
import com.dheeraj.fantasyfootball.domain.model.PlayerPerformanceStats;
import com.dheeraj.fantasyfootball.domain.model.PlayerStats;

public class PlayerBuilder {

	private final Player player;

	public PlayerBuilder() {
		this.player = new Player();
	}

	public PlayerBuilder playerId(int playerId) {
		this.player.setPlayerId(playerId);
		return this;
	}

	public PlayerBuilder teamId(int teamId) {
		this.player.setTeamId(teamId);
		return this;
	}

	public PlayerBuilder displayName(String displayName) {
		this.player.setDisplayName(displayName);
		return this;
	}

	public PlayerBuilder firstName(String firstName) {
		this.player.setFirstName(firstName);
		return this;
	}

	public PlayerBuilder lastName(String lastName) {
		this.player.setLastName(lastName);
		return this;
	}

	public PlayerBuilder photo(String photo) {
		this.player.setPhoto(photo);
		return this;
	}

	public PlayerBuilder squadNumber(int squadNumber) {
		this.player.setSquadNumber(squadNumber);
		return this;
	}

	public PlayerBuilder positionId(int positionId) {
		this.player.setPositionId(positionId);
		return this;
	}

	public PlayerBuilder playerStats(PlayerStats playerStats) {
		this.player.setPlayerStats(playerStats);
		return this;
	}

	public PlayerBuilder playerPerformanceStats(PlayerPerformanceStats playerPerformanceStats) {
		this.player.setPlayerPerformanceStats(playerPerformanceStats);
		return this;
	}

	public Player build() {
		return this.player;
	}
}

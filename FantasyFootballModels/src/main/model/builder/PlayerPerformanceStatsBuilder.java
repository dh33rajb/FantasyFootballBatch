package com.dheeraj.fantasyfootball.domain.model.builder;

import com.dheeraj.fantasyfootball.domain.model.PlayerPerformanceStats;

public class PlayerPerformanceStatsBuilder {

	private final PlayerPerformanceStats playerPerformanceStats;

	public PlayerPerformanceStatsBuilder() {
		this.playerPerformanceStats = new PlayerPerformanceStats();
	}

	public PlayerPerformanceStatsBuilder ictIndex(float ictIndex) {
		this.playerPerformanceStats.setIctIndex(ictIndex);
		return this;
	}

	public PlayerPerformanceStatsBuilder influenceScore(float influenceScore) {
		this.playerPerformanceStats.setInfluenceScore(influenceScore);
		return this;
	}

	public PlayerPerformanceStatsBuilder creativityScore(float creativityScore) {
		this.playerPerformanceStats.setCreativityScore(creativityScore);
		return this;
	}

	public PlayerPerformanceStatsBuilder threatScore(float threatScore) {
		this.playerPerformanceStats.setThreatScore(threatScore);
		return this;
	}

	public PlayerPerformanceStats build() {
		return this.playerPerformanceStats;
	}
}

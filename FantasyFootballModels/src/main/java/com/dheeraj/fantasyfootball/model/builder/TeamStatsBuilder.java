package com.dheeraj.fantasyfootball.model.builder;

import com.dheeraj.fantasyfootball.model.TeamStats;

public class TeamStatsBuilder {
	private final TeamStats teamStats;

	public TeamStatsBuilder() {
		this.teamStats = new TeamStats();
	}

	public TeamStatsBuilder position(int position) {
		this.teamStats.setPosition(position);
		return this;
	}

	public TeamStatsBuilder played(int played) {
		this.teamStats.setPlayed(played);
		return this;
	}

	public TeamStatsBuilder win(int win) {
		this.teamStats.setWin(win);
		return this;
	}

	public TeamStatsBuilder loss(int loss) {
		this.teamStats.setLoss(loss);
		return this;
	}

	public TeamStatsBuilder draw(int draw) {
		this.teamStats.setDraw(draw);
		return this;
	}

	public TeamStatsBuilder points(int points) {
		this.teamStats.setPoints(points);
		return this;
	}

	public TeamStats build() {
		return this.teamStats;
	}
}
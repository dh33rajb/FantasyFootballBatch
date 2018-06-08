package com.dheeraj.fantasyfootball.domain.model;

public class TeamStats {

	private int position;

	private int played;

	private int win;

	private int loss;

	private int draw;

	private int points;

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPlayed() {
		return played;
	}

	public void setPlayed(int played) {
		this.played = played;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLoss() {
		return loss;
	}

	public void setLoss(int loss) {
		this.loss = loss;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}

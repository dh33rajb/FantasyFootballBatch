package com.dheeraj.fantasyfootball.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Position {

	@JsonProperty("id")
	private int positionId;

	@JsonProperty("singular_name")
	private String positionName;

	@JsonProperty("singular_name_short")
	private String positionShortName;

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionShortName() {
		return positionShortName;
	}

	public void setPositionShortName(String positionShortName) {
		this.positionShortName = positionShortName;
	}
}

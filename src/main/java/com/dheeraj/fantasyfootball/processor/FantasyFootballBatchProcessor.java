package com.dheeraj.fantasyfootball.processor;

import org.springframework.batch.item.ItemProcessor;

import com.dheeraj.fantasyfootball.domain.model.FantasyFootballResponse;

public class FantasyFootballBatchProcessor implements ItemProcessor<FantasyFootballResponse, FantasyFootballResponse> {

	@Override
	public FantasyFootballResponse process(FantasyFootballResponse item) throws Exception {
		return item;
	}
}

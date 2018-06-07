package com.dheeraj.fantasyfootball.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.dheeraj.fantasyfootball.domain.model.FantasyFootballResponse;

/**
 * This class writes the FantasyFootballResponse over to the underlying
 * datastore.
 */
public class FantasyFootballDatastoreWriter implements ItemWriter<FantasyFootballResponse> {

	@Override
	public void write(List<? extends FantasyFootballResponse> items) throws Exception {
	}
}

package com.dheeraj.fantasyfootball.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dheeraj.fantasyfootball.model.FantasyFootballResponse;

/**
 * This class reads {@link FantasyFootballResponse} from Fantasy Football API.
 */
public class FantasyFootballApiReader implements ItemReader<FantasyFootballResponse> {

	static final String FANTASY_FOOTBALL_DUMP_URL = "https://fantasy.premierleague.com/drf/bootstrap-static";

	private final String apiUrl;

	private final RestTemplate restTemplate;

	private int count = 0;

	public FantasyFootballApiReader() {
		this.apiUrl = FANTASY_FOOTBALL_DUMP_URL;
		this.restTemplate = new RestTemplate();
	}

	@Override
	public FantasyFootballResponse read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		return fetchResponseFromApi();
	}

	private FantasyFootballResponse fetchResponseFromApi() {
		ResponseEntity<FantasyFootballResponse> responseEntity = this.restTemplate.getForEntity(apiUrl,
				FantasyFootballResponse.class);
		FantasyFootballResponse response = responseEntity.getBody();
		if (count++ == 0)
			return response;
		return null; // null needs to be returned to mark a job complete
	}
}

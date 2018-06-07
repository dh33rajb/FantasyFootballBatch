package com.dheeraj.fantasyfootball.domain.deserializer;

import static com.dheeraj.fantasyfootball.domain.deserializer.DeserializerUtil.getIntNodeValue;
import static com.dheeraj.fantasyfootball.domain.deserializer.DeserializerUtil.getTextNodeValue;

import java.io.IOException;

import com.dheeraj.fantasyfootball.domain.model.Team;
import com.dheeraj.fantasyfootball.domain.model.TeamStats;
import com.dheeraj.fantasyfootball.domain.model.builder.TeamBuilder;
import com.dheeraj.fantasyfootball.domain.model.builder.TeamStatsBuilder;
import com.dheeraj.fantasyfootball.domain.model.builder.factory.TeamBuilderFactory;
import com.dheeraj.fantasyfootball.domain.model.builder.factory.TeamStatsBuilderFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class TeamDeserializer extends JsonDeserializer<Team> {

	static String ID_KEY = "id";

	static String NAME_KEY = "name";

	static String SHORT_NAME_KEY = "short_name";

	static String POSITION_KEY = "position";

	static String PLAYED_KEY = "played";

	static String WIN_KEY = "win";

	static String LOSS_KEY = "loss";

	static String DRAW_KEY = "draw";

	static String POINTS_KEY = "points";

	@Override
	public Team deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		JsonNode teamNode = parser.getCodec().readTree(parser);

		TeamStatsBuilder teamStatsBuilder = TeamStatsBuilderFactory.create();
		TeamStats teamStats = teamStatsBuilder.position(getIntNodeValue(teamNode, POSITION_KEY))
				.played(getIntNodeValue(teamNode, PLAYED_KEY)).win(getIntNodeValue(teamNode, WIN_KEY))
				.loss(getIntNodeValue(teamNode, LOSS_KEY)).draw(getIntNodeValue(teamNode, DRAW_KEY))
				.points(getIntNodeValue(teamNode, POINTS_KEY)).build();

		TeamBuilder teamBuilder = TeamBuilderFactory.create();
		Team team = teamBuilder.teamId(getIntNodeValue(teamNode, ID_KEY)).teamName(getTextNodeValue(teamNode, NAME_KEY))
				.shortName(getTextNodeValue(teamNode, SHORT_NAME_KEY)).teamStats(teamStats).build();
		return team;
	}
}

package com.dheeraj.fantasyfootball.domain.deserializer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.FloatNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.TextNode;

public class DeserializerUtil {

	public static int getIntNodeValue(JsonNode teamNode, String key) {
		JsonNode node = teamNode.get(key);
		if (node instanceof IntNode)
			return (Integer) ((IntNode) node).numberValue();
		return -1;
	}

	public static String getTextNodeValue(JsonNode teamNode, String key) {
		JsonNode node = teamNode.get(key);
		if (node instanceof TextNode)
			return (String) ((TextNode) node).textValue();
		return null;
	}

	public static float getFloatNodeValue(JsonNode teamNode, String key) {
		JsonNode node = teamNode.get(key);
		if (node instanceof FloatNode)
			return (Float) ((FloatNode) node).floatValue();
		return -1;
	}
}

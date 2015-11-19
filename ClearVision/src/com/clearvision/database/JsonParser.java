package com.clearvision.database;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.clearvision.model.Leaf;

public class JsonParser {
	String tag;

	public JsonParser() {
	}

	public void generateJSON(ArrayList<Leaf> leaves) throws JSONException {

		ArrayList<String> topics = new ArrayList<String>();
		ArrayList<String> tags = new ArrayList<String>();

		JSONArray arrayTopics = new JSONArray();

		ArrayList<JSONObject> tagArrayList = new ArrayList<JSONObject>();

		for (Leaf leaf : leaves) {
			if (!topics.contains(leaf.getBookmarkTopic())) {
				topics.add(leaf.getBookmarkTopic());
			}
			if (!tags.contains(leaf.getTag())) {
				tags.add(leaf.getTag());
			}
		}

		for (String tag : tags) {
			JSONArray arrayLeaves = new JSONArray();
			JSONObject tagJSON = new JSONObject();
			tagJSON.put("name", tag);
			for (Leaf leaf : leaves) {
				if (leaf.getTag().equals(tag)) {
					JSONObject leafJSON = new JSONObject();
					leafJSON.put("name", leaf.getBookmarkName());
					leafJSON.put("url", leaf.getBookmarkURL());
					leafJSON.put("size", 1);
					arrayLeaves.put(leafJSON);
				}
			}
			tagJSON.put("children", arrayLeaves);
			tagArrayList.add(tagJSON);
		}

		for (String topic : topics) {
			JSONArray arrayTags = new JSONArray();
			JSONObject topicJSON = new JSONObject();
			topicJSON.put("name", topic);
			for (JSONObject tagJSON : tagArrayList) {
				for (Leaf leaf : leaves) {
					if (leaf.getBookmarkTopic().equals(topic) && leaf.getTag().equals(tagJSON.get("name"))) {
						arrayTags.put(tagJSON);
						break;
					}
				}
			}
			topicJSON.put("children", arrayTags);
			arrayTopics.put(topicJSON);
		}

		JSONObject fullJSON = new JSONObject();
		fullJSON.put("name", "Elicit");
		fullJSON.put("children", arrayTopics);

		try (FileWriter file = new FileWriter("/Users/CharlieWinnard/Documents/FinalJavaProject/ClearVision/WebContent/dat/flare.json")) {
			file.write(fullJSON.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

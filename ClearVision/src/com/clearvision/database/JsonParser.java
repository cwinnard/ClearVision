package com.clearvision.database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.clearvision.model.Bookmark;
import com.clearvision.model.Leaf;

public class JsonParser {
	String tag;

	public JsonParser() {
	}

	public void generateJSON(ArrayList<Leaf> leaves) throws JSONException {

		ArrayList<String> topics = new ArrayList<String>();
		ArrayList<String> tags = new ArrayList<String>();
		JSONArray arrayLeaves = new JSONArray();
		JSONArray arrayTags = new JSONArray();
		JSONArray arrayTopics = new JSONArray();

		// JSONObject fullJSON = new JSONObject();
		// fullJSON.put("name","flare");
		// fullJSON.put("children", arrayTopics);
		// for (Leaf leaf : leaves) {
		// if (!topics.contains(leaf.getBookmarkTopic())) {
		// topics.add(leaf.getBookmarkTopic());
		// }
		// for (String topic : topics) {
		// JSONObject topicJSON = new JSONObject();
		// topicJSON.put("name", topic);
		// topicJSON.put("children", arrayTags);
		// arrayTopics.put(topicJSON);
		// if (leaf.getBookmarkTopic().equals(topic)) {
		// if (!tags.contains(leaf.getTag())) {
		// tags.add(leaf.getTag());
		// }
		// for (String tag : tags) {
		// JSONObject tagJSON = new JSONObject();
		// tagJSON.put("name", tag);
		// tagJSON.put("children", arrayLeaves);
		// arrayTags.put(tagJSON);
		// if (leaf.getTag().equals(tag)) {
		// JSONObject leafJSON = new JSONObject();
		// leafJSON.put("name", leaf.getBookmarkName());
		// leafJSON.put("url", leaf.getBookmarkURL());
		// arrayLeaves.put(leafJSON);
		// }
		// }
		// }
		// }
		// }

		JSONObject fullJSON = new JSONObject();
		fullJSON.put("name", "flare");
		fullJSON.put("children", arrayTopics);

		for (Leaf leaf : leaves) {
			if (!topics.contains(leaf.getBookmarkTopic())) {
				topics.add(leaf.getBookmarkTopic());
			}
			if (!tags.contains(leaf.getTag())) {
				tags.add(leaf.getTag());
			}
		}
		for (Leaf leaf : leaves) {
			JSONObject leafJSON = new JSONObject();
			leafJSON.put("name", leaf.getBookmarkName());
			leafJSON.put("url", leaf.getBookmarkURL());
			for (String topic : topics) {
				for (String tag : tags) {
					if (leaf.getTag().equals(tag) && leaf.getBookmarkTopic().equals(topic)) {
						JSONObject topicJSON = new JSONObject();
						topicJSON.put("name", leaf.getBookmarkTopic());
						topicJSON.put("children", arrayTags);
						arrayTopics.put(topicJSON);
						
						JSONObject tagJSON = new JSONObject();
						tagJSON.put("name", leaf.getTag());
						tagJSON.put("children", arrayLeaves);
						arrayTags.put(tagJSON);
						
						arrayLeaves.put(leafJSON);
					}
				}
			}
		}

		// try (FileWriter file = new FileWriter("dat/jsonData.txt")) {
		// file.write(fullJSON.toString());
		// System.out.println("Successfully Copied JSON Object to File...");
		// }

		for (String topic : topics) {
			System.out.println(topic);
		}
		for (String tag : tags) {
			System.out.println(tag);
		}
		System.out.println(fullJSON.toString());
	}
}

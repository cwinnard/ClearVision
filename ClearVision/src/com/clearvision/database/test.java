package com.clearvision.database;

import java.util.ArrayList;

import org.json.JSONException;

import com.clearvision.model.Leaf;

public class test {

	public static void main(String[] args) {
		ArrayList <Leaf> test = new ArrayList<Leaf>();
		
		Leaf leaf1 = new Leaf();
		leaf1.setBookmarkName("testName1");
		leaf1.setBookmarkTopic("testTopic1");
		leaf1.setBookmarkURL("testURL1");
		leaf1.setTag("testTag1");
		test.add(leaf1);
		
		Leaf leaf2 = new Leaf();
		leaf2.setBookmarkName("testName2");
		leaf2.setBookmarkTopic("testTopic1");
		leaf2.setBookmarkURL("testURL2");
		leaf2.setTag("testTag2");
		test.add(leaf2);
		
		Leaf leaf3 = new Leaf();
		leaf3.setBookmarkName("testName3");
		leaf3.setBookmarkTopic("testTopic2");
		leaf3.setBookmarkURL("testURL3");
		leaf3.setTag("testTag3");
		test.add(leaf3);

		try {
		JsonParser parser = new JsonParser();
		parser.generateJSON(test);
		}
		catch (JSONException e) {
			System.err.println("test");
		}
	}

}

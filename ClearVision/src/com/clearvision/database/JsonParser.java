package com.clearvision.database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.clearvision.model.Bookmark;

public class JsonParser {
	String tag;
	public JsonParser(String topic, String name, String url, List tags) {
		
        JSONObject jsonObj = new JSONObject();  
        jsonObj.put("Name", name);  
        jsonObj.put("Url", url); 
        jsonObj.put("Parent", topic); 
       
		while (tags.iterator().hasNext()){
			tag = tags.next();
			JSONArray children = new JSONArray();
			children.add("Child: " + tag);
		}
		jsonObj.put("child list", children);
		try (FileWriter file = new FileWriter("dat/jsonData.txt")) {
			file.write(jsonObj.toString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + jsonObj);
		}  
	}
}
	


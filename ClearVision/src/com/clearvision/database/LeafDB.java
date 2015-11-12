package com.clearvision.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clearvision.model.Leaf;

public class LeafDB {
	
	public LeafDB() {}
	
	public List<Leaf> pullLeavesFromDatabase() {

		ArrayList<Leaf> leaves = new ArrayList<Leaf>();

		try {
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from UserBookmarkTag");

			while (rs.next()) {
				String email = rs.getString(1);
				String bookmarkName = rs.getString(2);
				String bookmarkURL = rs.getString(3);
				String bookmarkTopic = rs.getString(4);
				String tag = rs.getString(5);
				Leaf leaf = new Leaf(email, bookmarkName, bookmarkURL, bookmarkTopic, tag);
				leaves.add(leaf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return leaves;
	}
}

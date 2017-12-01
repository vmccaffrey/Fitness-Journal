/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Hantao
 */
public class DBConnection {
    private static Connection connect() {
		String url = "jdbc:sqlite:lib\\sql\\TrainingSoftware.sqlite";
		Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
            JOptionPane.showMessageDialog(null, "Connection Successful");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
		return conn;
    }

	public static void insert(String date, int pushups, int situps, float distance, float time){
		String sql = "INSERT INTO DailyTracker(date, pushups, situps, distance, time) VALUES(?,?,?,?,?)";

		try (Connection conn = connect();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, date);
			statement.setInt(2, pushups);
			statement.setInt(3, situps);
			statement.setFloat(4, distance);
			statement.setFloat(5, time);
			statement.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public static void select(String string){
		String sql = "SELECT string FROM DailyTracker";

		try (Connection conn = connect();
			 Statement statement  = conn.createStatement();
			 ResultSet result = statement.executeQuery(sql)){

			while (result.next()) {
				String temp = result.getString(string);
				JOptionPane.showMessageDialog(null, temp);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public static void selectAll(){
		String sql = "SELECT * FROM DailyTracker";
		List<String> list = new ArrayList<String>();

		try (Connection conn = connect();
			 Statement statement  = conn.createStatement();
			 ResultSet result = statement.executeQuery(sql)){

			while (result.next()) {
				String temp = result.getString("Date") + " " + result.getInt("Pushups") + " " + result.getInt("Situps") + " " + result.getFloat("Distance") + " " + result.getFloat("Time");
				JOptionPane.showMessageDialog(null, temp);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public static List<String> selectExercise(String date){
		String sql = "SELECT * FROM DailyTracker WHERE Date = date";
		List<String> list = new ArrayList<String>();

		try (Connection conn = connect();
			Statement statement  = conn.createStatement();
			ResultSet result = statement.executeQuery(sql)){

			list.add(result.getString("Pushups"));
			list.add(result.getString("Situps"));
			list.add(result.getString("Distance"));
			list.add(result.getString("Time"));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}

		return list;
	}
}
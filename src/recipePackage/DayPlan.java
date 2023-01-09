/**
 * @author Ammar A
 */
package recipePackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DayPlan {
	Recipe breakfast;
	Recipe lunch;
	Recipe dinner;
	Recipe snack;
	int dayNum = 1;	// Day number
	Connection con;	// Connection to database
	List<Recipe> planList = new ArrayList<>();	// List of Recipe objects
	enum Categories {	// enum containing the 4 possible categories for recipes
		BREAKFAST("Breakfast"), LUNCH("Lunch"), DINNER("Dinner"), SNACK("Snack");

		final String cat;

		Categories(String category) {
			cat = category;
		}
	}

	/**
	 * Constructor that only sets con
	 * @param connection	Connection to database
	 */
	DayPlan(Connection connection){
		dayNum = 1;
		con = connection;
		generateDayPlan();
	}
	
	/**
	 * Constructor that sets con and dayNum
	 * @param connection	Connection to database
	 * @param i				Day number
	 */
	DayPlan(Connection connection, int i){
		dayNum = i;
		con = connection;
		generateDayPlan();
	}
	
	/**
	 * Constructor that sets connection, breakfast, lunch, dinner, and snack
	 * @param connection	Connection to database
	 * @param newbreakfast	Breakfast recipe
	 * @param newlunch		Lunch recipe
	 * @param newdinner		Dinner recipe
	 * @param newsnack		Snack recipe
	 */
	DayPlan(Connection connection, Recipe newbreakfast, Recipe newlunch, Recipe newdinner, Recipe newsnack) {
		dayNum = 1;
		con = connection;
		breakfast = newbreakfast;
		lunch = newlunch;
		dinner = newdinner;
		snack = newsnack;
	}
	
	/**
	 * Constructor that sets connection, dayNum, breakfast, lunch, dinner, and snack
	 * @param connection	Connection to database
	 * @param i				DayNum
	 * @param newbreakfast	Breakfast recipe
	 * @param newlunch		Lunch recipe
	 * @param newdinner		Dinner recipe
	 * @param newsnack		Snack recipe
	 */
	DayPlan(Connection connection, int i, Recipe newbreakfast, Recipe newlunch, Recipe newdinner, Recipe newsnack) {
		con = connection;
		breakfast = newbreakfast;
		lunch = newlunch;
		dinner = newdinner;
		snack = newsnack;
		dayNum = i;
	}

	/**
	 * Turns DayPlan into a String
	 * @return returns values of DayPlan object as formatted String
	 */
	public String toString() {
		String output = "\n\n\t\t\t\t\t| DAY "+ dayNum + " |\n";
		for(Recipe item : planList) {
			output+=item.toString();
		}
		output+="\n";
		return output;
	}
	
	/**
	 * Creates a meal plan for one day by randomly choosing a breakfast, lunch, dinner, and snack from the database
	 * @return	returns a list of Recipe objects
	 */
	public List<Recipe> generateDayPlan() {
		for (Categories categories : Categories.values()) {	// for every value in the enum Categories, select a random recipe from the database
			try {
				// Query database for a random recipe of category categories
				String query = "SELECT * FROM recipes WHERE recipe_category = \"" + categories.cat
						+ "\" ORDER BY RAND() LIMIT 1;\r\n";
				Statement sql = con.createStatement();
				ResultSet result = sql.executeQuery(query);
				// New Recipe object to receive data from database
				Recipe newRecipe;
				while (result.next()) {	// Takes the result set from the above query, constructs newRecipe, and adds it to the list
					newRecipe = new Recipe(result.getString("recipe_name"), result.getString("recipe_category"),
							result.getString("description"));
					planList.add(newRecipe);
				}
				sql.close();
				result.close();
			} catch (SQLException e) {	// Handles any general SQL exceptions
				System.out.println("SQL exception while generating a new day plan");
				e.printStackTrace();
			}
		}
		return planList;
	}
}

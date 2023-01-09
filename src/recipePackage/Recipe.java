/**
 * @author Ammar A
 */
package recipePackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Recipe implements RecipeInterface {

	private String name;
	private String category;
	private String description;

	/**
	 * No arguments default constructor
	 */
	public Recipe() {}

	/**
	 * Constructor that sets name
	 * @param newName
	 */
	public Recipe(String newName) {
		name = newName;
	}

	/**
	 * Constructor that sets name, category, and description
	 * @param newName
	 * @param cat
	 * @param desc
	 */
	public Recipe(String newName, String cat, String desc) {
		name = newName;
		category = cat;
		description = desc;
	}

	/**
	 * Setter for name
	 * @param newName
	 */
	public void changeName(String newName) {
		name = newName;
	}

	/**
	 * Setter for category
	 * @param cat
	 */
	public void changeCategory(String cat) {
		category = cat;
	}

	/**
	 * Setter for description
	 * @param newDesc
	 */
	public void changeDesc(String newDesc) {
		description = newDesc;
	}

	/**
	 * Getter for name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Getter for description
	 */
	public String getDesc() {
		return description;
	}

	/**
	 * Uploads the Recipe to the database
	 * @param con
	 */
	public void addToDB(Connection con) {
		// if entry already exists for name, exit
		name.toUpperCase();	// names in the database are all capitalized
		try {
			// Query database to see if recipe with name name already exists
			String query = "SELECT * FROM recipes WHERE recipe_name = \"" + name + "\"";
			Statement sql = con.createStatement();
			ResultSet result = sql.executeQuery(query);
			
			if (result.next()) {	// If entry already exists, tell user
				System.out.println("Entry with the name " + name + " already exists. However, you may update the entry from the main menu.");
			} else {	// Else, enter recipe into database
				enterIntoDB(con);
			}
			result.close();
			sql.close();
		} catch (SQLException e) {	// Handles general SQL exceptions
			System.out.println("SQL Exception in Recipe.readFromDB");
			e.printStackTrace();
		}

	}

	/**
	 * Print out the recipe data, and delete entry
	 * @param con	Connection to database
	 */
	public void removeFromDB(Connection con) {
		name.toUpperCase();	// names in the database are all capitalized
		String update = "DELETE FROM recipes WHERE recipe_name = \"" + name + "\";"; // SQL command
		try {	// Delete recipe from database
			Statement sql = con.createStatement();
			sql.executeUpdate(update);
			sql.close();
		} catch (SQLException e) {	// Handles general SQL exceptions
			System.out.println("SQL Exception in Recipe.refreshDB");
			e.printStackTrace();
		}
		System.out.println("\nDeleted an entry from the database.");
	}

	/**
	 * Look in DB for recipe with same name and change the category and description
	 * @param con	Connection to database
	 * @return	Returns the new recipe entry as a String
	 */
	public String readFromDB(Connection con) {
		name.toUpperCase();	// names in the database are all capitalized
		String output = "";
		try {
			// Query database to see if recipe with name name exists
			output = null;
			String query = "SELECT * FROM recipes WHERE recipe_name = \"" + name + "\"";
			Statement sql = con.createStatement();
			ResultSet result = sql.executeQuery(query);
			while (result.next()) {	// Iterate through result while result.next() returns true and collect the name, category and description
				output = "\n-------------------------------------------------------------------------------------\nEntry for: "
						+ result.getString("recipe_name") + "\n";
				output += "Category: " + result.getString("recipe_category") + "\n";
				output += "Description: " + result.getString("description")
						+ "\n-------------------------------------------------------------------------------------";
			}
			result.close();
			sql.close();
		} catch (SQLException e) {	// Handles general SQL exceptions
			System.out.println("SQL Exception in Recipe.readFromDB");
			e.printStackTrace();
		}

		return output;
	}

	/**
	 * Look in database for recipe with this name and insert new description and category
	 * @param con	Connection to database
	 */
	public void editFromDB(Connection con) {
		// TODO Look in DB for recipe with name this.name and insert new description and
		// category
		name.toUpperCase();	// names in the database are all capitalized
		String update = "UPDATE recipes SET recipe_category = \"" + category + "\", description = \"" + description
				+ "\" WHERE recipe_name = \"" + name + "\";";
		try {	// Execute SQL command
			Statement sql = con.createStatement();
			sql.executeUpdate(update);
			sql.close();
		} catch (SQLException e) {	// Handles general SQL exceptions
			System.out.println("SQL Exception in Recipe.refreshDB");
			e.printStackTrace();
		}
		System.out.println("\nUpdated an entry in the database.");
	}

	/**
	 * Uploads category and description to DB
	 * @param con	Connection to database
	 */
	public void enterIntoDB(Connection con) {
		name.toUpperCase();	// names in the database are all capitalized
		String update = "INSERT INTO recipes(recipe_name, recipe_category, description) VALUES (\"" + name + "\",\""
				+ category + "\",\"" + description + "\");";
		try {	// Execute SQL command
			Statement sql = con.createStatement();
			sql.executeUpdate(update);
			sql.close();
		} catch (SQLException e) {	// Handles general SQL exceptions
			System.out.println("SQL Exception in Recipe.refreshDB");
			e.printStackTrace();
		}
		System.out.println("\nMade an entry into the database.");

	} // end refreshDB

	/**
	 * Turns Recipe object into a String
	 * @return	Returns contents of Recipe object as a formatted String
	 */
	public String toString() {
		String output = "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\tName: "
				+ name + " | Category: " + category + "\n\t Description: " + description + "\n";
		return output;
	}
} // end Recipe

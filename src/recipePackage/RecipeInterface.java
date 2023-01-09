/**
 * @author Ammar A
 */
package recipePackage;

import java.sql.Connection;

public interface RecipeInterface {
	void changeName(String newName);
	void changeCategory(String cat);
	void changeDesc(String newDesc);
	String getName();
	String getCategory();
	String getDesc();
	void addToDB(Connection con);
	String readFromDB(Connection con);
	void removeFromDB(Connection con);
	void editFromDB(Connection con);
	
}

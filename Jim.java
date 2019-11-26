
public class Jim {
	//Jim needs: 
	
	private static int str;
	private static int dex;
	private static int con;
	private static int intel;
	private static int wis;
	private static int cha;
	
	private static int level;
	
	private static ChClass playerClass;
	
	private static ArrayList<Item> inventory;
	
	Jim(int aStr, int aDex, int aCon, int aInt, int aWis, int aCha, int aLevel, ChClass aClass) {
		str = aStr;
		dex = aDex;
		con = aCon;
		intel = aInt;
		wis = aWis;
		cha = aCha;
		playerClass = aClass;
		level = aLevel;
		inventory = new ArrayList<Item>();
	}
 	
	public static int getStrMod() {
	}
	
	public static int getDexMod() {
	}
	
	public static int getConMod() {
	}
	
	public static int getIntMod() {
	}
	
	public static int getWisMod() {
	}
	
	public static int getChaMod() {
	}
	
	public static int getStr() {
	}
	
	public static int getDex() {
	}
	
	public static int getCon() {
	}
	
	public static int getInt() {
	}
	
	public static int getWis() {
	}
	
	public static int getCha() {
	}
	
	public static void setStr() {
	}
	
	public static void setDex() {
	}
	
	public static void setCon() {
	}
	
	public static void setInt() {
	}
	
	public static void setWis() {
	}
	
	public static void setCha() {
	}
	
	public static void addItem(Item anItem) {
	}
	
	public static void removeItem(String check) {
	}
}

/*
Jim has all 6 stats, with get and set methods, and also get methods for his modifiers.
Inventory is a list of all of the items a character owns. One page can be set up to display the inventory and allow them to add/remove items (hence add/remove item methods)

*/

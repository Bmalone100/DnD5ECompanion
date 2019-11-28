
public class Character {
	//Jim needs: 
	
	private static int str;
	private static int dex;
	private static int con;
	private static int intel;
	private static int wis;
	private static int cha;
	private static int level;
	
	private static int hitDice;
	private static int health;
	
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
		
		hitDice = playerClass.getHitDice();
		
		health = hitDice + getConMod();
	}
 	
	public static int getStrMod() {
		return (str-10) / 2;
	}
	
	public static int getDexMod() {
		return (dex-10) / 2;
	}
	
	public static int getConMod() {
		return (con-10) / 2;
	}
	
	public static int getIntMod() {
		return (intel - 10) / 2;
	}
	
	public static int getWisMod() {
		return (wis - 10) / 2;
	}
	
	public static int getChaMod() {
		return(cha - 10) / 2;
	}
	
	public static int getStr() {
		return str;
	}
	
	public static int getDex() {
		return dex;
	}
	
	public static int getCon() {
		return con;
	}
	
	public static int getInt() {
		return intel;
	}
	
	public static int getWis() {
		return wis;
	}
	
	public static int getCha() {
		return cha;
	}
	
	public static void setStr(int aStr) {
		str = aStr;
	}
	
	public static void setDex(aDex) {
		dex = aDex;
	}
	
	public static void setCon(aCon) {
		con = aCon;
	}
	
	public static void setInt(aIntel) {
		intel = aIntel
	}
	
	public static void setWis(aWis) {
		wis = aWis;
	}
	
	public static void setCha(aCha) {
		cha = aCha;
	}
	
	public static void addItem(Item anItem) {
		inventory.add(anItem);
	}
	
	public static void removeItem(String check) {
		inventory.remove(check);
	}
	
	public static int getHealth() {
		return health;
	}
	
	public static int getLevel() {
		return level;
	}
	
	public static int getHD() {
		return hitDice;
	}
	
	public static void levelUp() {
		health += (int)((Math.random*hitDice) +1);
		health += getConMod();
		level += 1;
		if((level / 4) = 0) {
			//System.out.println("Congratulations! you can now increase either one stat by 2 points, two stats by 1, or gain a feat!);
		}
	}
	
}

/*
Jim has all 6 stats, with get and set methods, and also get methods for his modifiers.
Inventory is a list of all of the items a character owns. One page can be set up to display the inventory and allow them to add/remove items (hence add/remove item methods)

*/

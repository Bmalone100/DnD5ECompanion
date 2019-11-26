
public class ChClass {
	
	private static String name;
	private static boolean spellcaster;
	private static String spellType;
	private static String[][] abilities;
	
	
	/*
	Name is simply the name of the class
	Spellcaster is a boolean that says if the class is able to cast any spells. If it's true, then certain other variables get used if called.
	SpellType is the type of stat (int, cha, wis) used to cast spells. If it isn't used then it is left blank.
	Abilities is a 2d array list with 2 columns - Column 0 has the levels up to level 20, and column 1 has the abilities associated with each level. Domains are not counted.
	
	*/
	
	ChClass(String aName, boolean aSpellcaster, String aSpellType, String[][] anAbilities) {
		name = aName;
		spellcaster = aSpellcaster;
		spellType = aSpellType;
		abilities = anAbilities;
	}
	
	public static String getName() {
	}
	
	public static boolean getSpellcaster() {
	}
	
	public static String getSpellType() {
	}
	
	public static String[] getAbilities(int currentLevel) {
	}
}
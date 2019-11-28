
public class ChClass {
	
	private static String name;
	private static boolean spellcaster;
	private static String spellType;
	private static String[] abilities;
	private static int hitDice;
	
	
	/*
	Name is simply the name of the class
	Spellcaster is a boolean that says if the class is able to cast any spells. If it's true, then certain other variables get used if called.
	SpellType is the type of stat (int, cha, wis) used to cast spells. If it isn't used then it is left blank.
	Abilities is an array of length 20 - with each slot showing the abilities gained at each level. Domains are not counted.
	
	*/
	
	ChClass(String aName, boolean aSpellcaster, String aSpellType, String[] anAbilities, int aHitDice) {
		name = aName;
		spellcaster = aSpellcaster;
		spellType = aSpellType;
		abilities = anAbilities;
		hitDice = aHitDice;
	}
	
	public static String getName() {
		return name;
	}
	
	public static boolean getSpellcaster() {
		return spellcaster;
	}
	
	public static String getSpellType() {
		return spellType;
	}
	
	public static String[] getAbilities(int currentLevel) {
		String[] result = new String[currentLevel];
		
		for(int i = 0; i < currentLevel; i++) {
			result[i] = abilities[i];
		}
		
		return result;
	}
}
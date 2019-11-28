
public class Item {
	
	private static String name;
	private static boolean weapon;
	private static String damage;
	private static String features;
	
	
	Item(String aName, boolean aWeapon, String aDamage, String aFeatures) {
		name = aName;
		weapon = aWeapon;
		damage = aDamage;
		features = aFeatures;
	}
	/*
	Every item has a name
	Weapon is a boolean that tells the inventory if the item can be used as a weapon or not. If it is, then the next two strings become important
	Damage shows the damage that a weapon does (i.e. 2d6, 1d12, 3d4).
	Features shows if the weapon has any special features to it (versatile, etc)
	*/
	
	public static String getName() {
		return name;
	}
	
	public static boolean getWeapon() {
		return weapon;
	}
	
	public static String getDamage() {
		return damage;
	}
	
	public static String features() {
		return features;
	}
}	
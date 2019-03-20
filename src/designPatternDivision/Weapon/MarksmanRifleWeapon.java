package designPatternDivision.Weapon;

import designPatternDivision.Damage.DamageModule;

public abstract class MarksmanRifleWeapon extends Weapon
{
	public abstract DamageModule useWeapon();
	
	public double getHeadshotDamageMultiplier ()
	{
		return 1.0 ;
	}
}

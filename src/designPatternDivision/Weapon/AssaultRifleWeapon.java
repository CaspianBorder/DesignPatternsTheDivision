package designPatternDivision.Weapon;

import designPatternDivision.Damage.DamageModule;

public abstract class AssaultRifleWeapon extends Weapon
{
	public abstract DamageModule useWeapon();
	
	public double getHeadshotDamageMultiplier ()
	{
		return 0 ;
	}
}

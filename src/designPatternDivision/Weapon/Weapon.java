package designPatternDivision.Weapon;

import designPatternDivision.Damage.DamageModule;

public abstract class Weapon
{
	public abstract DamageModule useWeapon();

	public abstract double getHeadshotDamageMultiplier();
}

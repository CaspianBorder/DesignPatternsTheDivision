package designPatternDivision.Damage;

public class HeadshotDamageModifier extends DamageModifier
{
	public HeadshotDamageModifier ( DamageModule module )
	{
		damageModule = module;
		multiplier = 0;
	}

	public void setHeadshotMultiplier( double headshotMultiplier )
	{
		multiplier = headshotMultiplier;
	}
}

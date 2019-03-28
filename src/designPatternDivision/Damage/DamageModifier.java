package designPatternDivision.Damage;

public abstract class DamageModifier extends DamageModule
{
	double multiplier;
	DamageModule damageModule;

	public DamageModifier( DamageModule inputDamageModule)
	{
		damageModule = inputDamageModule;
	}

	public int getDamage()
	{
		return (int) ( 1 + multiplier ) * damageModule.getDamage();
	}
}

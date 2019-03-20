package designPatternDivision.Damage;

public class PlayerDamage extends DamageModule
{
	public void setDamage( int damage )
	{
		basicDamage = damage;
	}

	public int getDamage()
	{
		return basicDamage;
	}
}

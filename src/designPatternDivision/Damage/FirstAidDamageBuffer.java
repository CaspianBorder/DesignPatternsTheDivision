package designPatternDivision.Damage;

public class FirstAidDamageBuffer extends FirstAidDamageModifier
{
	public FirstAidDamageBuffer ( DamageModule module )
	{
		damageModule = module;
		multiplier = FIRST_AID_DAMAGE_MULTIPLIER;
	}
}

package designPatternDivision.Damage;

public class FirstAidDamageDebuffer extends FirstAidDamageModifier
{
    public FirstAidDamageDebuffer( DamageModule module )
    {
        super( module );
        multiplier = -FIRST_AID_DAMAGE_MULTIPLIER;
    }
}

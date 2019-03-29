package designPatternDivision.Damage;

public abstract class FirstAidDamageModifier extends DamageModifier
{
    public FirstAidDamageModifier( DamageModule damageModule )
    {
        super( damageModule );
    }

    static final double FIRST_AID_DAMAGE_MULTIPLIER = 0.2;
}

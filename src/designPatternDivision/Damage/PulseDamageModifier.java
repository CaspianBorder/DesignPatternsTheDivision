package designPatternDivision.Damage;

public class PulseDamageModifier extends DamageModifier
{
    private static final double PULSE_DAMAGE_MULTIPLIER = 0.3;

    public PulseDamageModifier( DamageModule module )
    {
        super( module );
        multiplier = PULSE_DAMAGE_MULTIPLIER;
    }
}

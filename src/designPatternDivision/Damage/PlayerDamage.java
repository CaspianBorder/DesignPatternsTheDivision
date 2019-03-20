package designPatternDivision.Damage;

public class PlayerDamage extends DamageModule
{
    public PlayerDamage( int damage )
    {
        basicDamage = damage;
    }

    public int getDamage()
    {
        return basicDamage;
    }
}

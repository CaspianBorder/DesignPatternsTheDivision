package designPatternDivision.Damage;

public class DamageModule
{
    int basicDamage;

    public DamageModule()
    {

    }

    public DamageModule( int inputDamage )
    {
        basicDamage = inputDamage;
    }

    public int getDamage()
    {
        return basicDamage;
    }
}

package designPatternDivision.Damage;

public class DamageModule
{
    int basicDamage;
    int shotFire;

    public DamageModule()
    {
        shotFire = 1;
    }

    public DamageModule( int inputDamage )
    {
        basicDamage = inputDamage;
        shotFire = 1;
    }

    public int getDamage()
    {
        return basicDamage * shotFire;
    }

    public int getShotFire()
    {
        return shotFire;
    }
}

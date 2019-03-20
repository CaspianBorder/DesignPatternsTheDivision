package designPatternDivision.Damage;

public class PlayerDamage extends DamageModule
{
    int shotFire;

    public PlayerDamage( int damage )
    {
        basicDamage = damage;
    }

    public int getDamage()
    {
        return basicDamage;
    }

    public void setShotFire( int shot )
    {
        shotFire = shot;
        return;
    }

    public int getShotFire()
    {
        return shotFire;
    }
}

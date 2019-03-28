package designPatternDivision.Damage;

public class PlayerDamage extends DamageModule
{
    int shotFire;

    public PlayerDamage (int inputDamage)
    {
        super(inputDamage);
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

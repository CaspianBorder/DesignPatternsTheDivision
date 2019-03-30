package designPatternDivision.Damage;

public class PlayerDamage extends DamageModule
{
    public PlayerDamage (int inputDamage)
    {
        super(inputDamage);
    }

    public void setShotFire( int shot )
    {
        shotFire = shot;
        return;
    }

    @Override
    public int getShotFire()
    {
        return shotFire;
    }
}

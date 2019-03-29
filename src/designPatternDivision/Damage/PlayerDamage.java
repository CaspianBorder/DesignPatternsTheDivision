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

    @Override
    public int getShotFire()
    {
        return shotFire;
    }

    @Override
    public int getDamage()
    {
        return super.getDamage() * shotFire;
    }
}

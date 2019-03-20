package designPatternDivision.Weapon;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Damage.PlayerDamage;

public abstract class Weapon
{
    int singleShotDamage;
    int rateOfFire;
    int magazineSize;
    int shotLeft;
    int burstShot;
    PlayerDamage playerDamage;

    public DamageModule useWeapon()
    {
        playerDamage.setShotFire( getBurstShot() );
        return playerDamage;
    }

    public abstract double getHeadshotDamageMultiplier();

    public void setSingleShotDamage( int damage )
    {
        singleShotDamage = damage;
        setDamageModule();
        return;
    }

    public void setWeaponInitial()
    {
        setRateOfFire();
        setMagazineSize();
        setShotLeft();
        setDamageModule();
        return;
    }

    public int getSingleShotDamage()
    {
        return singleShotDamage;
    }

    public int getRateOfFire()
    {
        return rateOfFire;
    }

    public int getMagazineSize()
    {
        return magazineSize;
    }

    public int getShotLeft()
    {
        return shotLeft;
    }

    public int getBurstShot()
    {
        burstShot = shotLeft >= rateOfFire ? rateOfFire : shotLeft;
        shotLeft -= burstShot;
        return burstShot;
    }

    public void changeRateOfFire( double modifiedRate )
    {
        rateOfFire *= ( 1 + modifiedRate );
    }

    public void reloadMagazine()
    {
        shotLeft = shotLeft == 0 ? magazineSize : magazineSize + 1;
        return;
    }

    abstract void setRateOfFire();

    abstract void setMagazineSize();

    void setShotLeft()
    {
        shotLeft = magazineSize + 1;
        return;
    }

    void setDamageModule()
    {
        playerDamage = new PlayerDamage( singleShotDamage );
        return;
    }
}

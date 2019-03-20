package designPatternDivision.Weapon;

import designPatternDivision.Damage.DamageModule;

public abstract class Weapon
{
    int singleShotDamage;
    int rateOfFire;
    int magazineSize;
    int shotLeft;
    int burstShot;
    DamageModule damageModule;

    public abstract DamageModule useWeapon();

    public abstract double getHeadshotDamageMultiplier();

    public void setRateOfFire( double modifiedRate )
    {
        rateOfFire *= ( 1 + modifiedRate );
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

    public void reloadMagazine()
    {
        shotLeft = shotLeft == 0 ? magazineSize : magazineSize + 1;
        return;
    }
}

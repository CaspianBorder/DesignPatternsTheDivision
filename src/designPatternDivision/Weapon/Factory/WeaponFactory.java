package designPatternDivision.Weapon.Factory;

import designPatternDivision.Weapon.Weapon;

public abstract class WeaponFactory
{
    abstract Weapon initialWeapon( String weaponType );

    public Weapon createWeapon( String weaponType , int damage )
    {
        Weapon weapon;
        weapon = initialWeapon( weaponType );
        weapon.setSingleShotDamage( damage );
        weapon.setWeaponInitial();
        return weapon;
    }
}

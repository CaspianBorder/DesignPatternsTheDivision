package designPatternDivision.Weapon.Factory;

import designPatternDivision.Weapon.Weapon;

import java.util.Random;

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

    public Weapon createWeapon( String weaponType )
    {
        Weapon weapon;
        Random random = new Random();
        double damageMultiplier = createDamageMultiplier();
        weapon = initialWeapon( weaponType );
        weapon.setSingleShotDamage( (int) ( weapon.getINITIAL_DAMAGE() * damageMultiplier ) );
        weapon.setWeaponInitial();
        return weapon;
    }

    private double createDamageMultiplier()
    {
        Random random = new Random();
        double damageMultiplier = random.nextDouble();
        if ( Math.abs( damageMultiplier - 0.5 ) < 0.1 )
        {
            damageMultiplier = 1;
        }
        else if ( Math.abs( damageMultiplier - 0.5 ) < 0.3 )
        {
            if ( damageMultiplier - 0.5 > 0 )
            {
                damageMultiplier = 1 + ( damageMultiplier - 0.6 ) * 0.5;
            }
            else
            {
                damageMultiplier = 1 + ( damageMultiplier - 0.4 ) * 0.5;
            }
        }
        else
        {
            if ( damageMultiplier - 0.5 > 0 )
            {
                damageMultiplier = 1.1 + ( damageMultiplier - 0.8 ) * 0.25;
            }
            else
            {
                damageMultiplier = 0.9 + ( damageMultiplier - 0.2 ) * 0.25;
            }
        }
        return damageMultiplier;
    }
}

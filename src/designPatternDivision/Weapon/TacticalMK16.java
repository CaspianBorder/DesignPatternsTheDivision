package designPatternDivision.Weapon;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Damage.PlayerDamage;

public class TacticalMK16 extends AssaultRifleWeapon
{
    private static final int TACTICAL_MK16_RATE_OF_FIRE = 5;
    private static final int TACTICAL_MK16_MAGAZINE_SIZE = 30;

    public TacticalMK16( int damage )
    {
        rateOfFire = TACTICAL_MK16_RATE_OF_FIRE;
        magazineSize = TACTICAL_MK16_MAGAZINE_SIZE;
        singleShotDamage = damage;
        damageModule = new PlayerDamage( singleShotDamage );
        shotLeft = magazineSize + 1;
    }

    @Override
    public DamageModule useWeapon()
    {
        return damageModule;
    }
}

package designPatternDivision.Weapon;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Damage.PlayerDamage;

public class LightweightM4 extends AssaultRifleWeapon
{
    private static final int LIGHTWEIGHT_M4_RATE_OF_FIRE = 7;
    private static final int LIGHTWEIGHT_M4_MAGAZINE_SIZE = 30;

    public LightweightM4( int damage )
    {
        rateOfFire = LIGHTWEIGHT_M4_RATE_OF_FIRE;
        magazineSize = LIGHTWEIGHT_M4_MAGAZINE_SIZE;
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

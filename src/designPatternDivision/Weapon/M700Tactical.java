package designPatternDivision.Weapon;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Damage.PlayerDamage;

public class M700Tactical extends MarksmanRifleWeapon
{
    private static final int M700_TACTICAL_RATE_OF_FIRE = 1;
    private static final int M700_TACTICAL_MAGAZINE_SIZE = 5;

    public M700Tactical( int damage )
    {
        rateOfFire = M700_TACTICAL_RATE_OF_FIRE;
        magazineSize = M700_TACTICAL_MAGAZINE_SIZE;
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

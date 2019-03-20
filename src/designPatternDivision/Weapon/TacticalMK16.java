package designPatternDivision.Weapon;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Damage.PlayerDamage;

public class TacticalMK16 extends AssaultRifleWeapon
{
    private static final int TACTICAL_MK16_RATE_OF_FIRE = 5;
    private static final int TACTICAL_MK16_MAGAZINE_SIZE = 30;

    @Override
    public DamageModule useWeapon()
    {
        return damageModule;
    }

    @Override
    void setRateOfFire()
    {
        rateOfFire = TACTICAL_MK16_RATE_OF_FIRE;
        return;
    }

    @Override
    void setMagazineSize()
    {
        magazineSize = TACTICAL_MK16_MAGAZINE_SIZE;
        return;
    }

}

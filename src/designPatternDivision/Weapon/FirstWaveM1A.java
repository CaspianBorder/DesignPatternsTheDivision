package designPatternDivision.Weapon;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Damage.PlayerDamage;

public class FirstWaveM1A extends MarksmanRifleWeapon
{
    private static final int FIRST_WAVE_M1A_RATE_OF_FIRE = 2;
    private static final int FIRST_WAVE_M1A_MAGAZINE_SIZE = 10;

    @Override
    public DamageModule useWeapon()
    {
        return damageModule;
    }

    @Override
    void setRateOfFire()
    {
        rateOfFire = FIRST_WAVE_M1A_RATE_OF_FIRE;
        return;
    }

    @Override
    void setMagazineSize()
    {
        magazineSize = FIRST_WAVE_M1A_MAGAZINE_SIZE;
        return;
    }
}

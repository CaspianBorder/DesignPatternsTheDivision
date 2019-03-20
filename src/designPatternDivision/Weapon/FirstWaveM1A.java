package designPatternDivision.Weapon;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Damage.PlayerDamage;

public class FirstWaveM1A extends MarksmanRifleWeapon
{
    private static final int FIRST_WAVE_M1A_RATE_OF_FIRE = 2;
    private static final int FIRST_WAVE_M1A_MAGAZINE_SIZE = 10;

    public FirstWaveM1A(int damage)
    {
        rateOfFire = FIRST_WAVE_M1A_RATE_OF_FIRE;
        magazineSize = FIRST_WAVE_M1A_MAGAZINE_SIZE;
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

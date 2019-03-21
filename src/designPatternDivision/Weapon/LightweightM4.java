package designPatternDivision.Weapon;

public class LightweightM4 extends AssaultRifleWeapon
{
    private static final int LIGHTWEIGHT_M4_RATE_OF_FIRE = 7;
    private static final int LIGHTWEIGHT_M4_MAGAZINE_SIZE = 30;

    @Override
    void setRateOfFire()
    {
        rateOfFire = LIGHTWEIGHT_M4_RATE_OF_FIRE;
        return;
    }

    @Override
    void setMagazineSize()
    {
        magazineSize = LIGHTWEIGHT_M4_MAGAZINE_SIZE;
        return;
    }

}

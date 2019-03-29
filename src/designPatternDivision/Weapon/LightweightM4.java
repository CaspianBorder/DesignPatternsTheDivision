package designPatternDivision.Weapon;

public class LightweightM4 extends AssaultRifleWeapon
{
    private static final int LIGHTWEIGHT_M4_INITIAL_DAMAGE = 30;
    private static final int LIGHTWEIGHT_M4_RATE_OF_FIRE = 7;
    private static final int LIGHTWEIGHT_M4_MAGAZINE_SIZE = 30;

    @Override
    public String getWeaponName()
    {
        return WeaponName.LIGHTWEIGHT_M4;
    }

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

    @Override
    public int getINITIAL_DAMAGE()
    {
        return LIGHTWEIGHT_M4_INITIAL_DAMAGE;
    }
}

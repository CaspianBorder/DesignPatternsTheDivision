package designPatternDivision.Weapon;

public class TacticalMK16 extends AssaultRifleWeapon
{
    private static final int TACTICAL_MK16_INITIAL_DAMAGE = 40;
    private static final int TACTICAL_MK16_RATE_OF_FIRE = 5;
    private static final int TACTICAL_MK16_MAGAZINE_SIZE = 30;

    @Override
    public String getWeaponName()
    {
        return WeaponName.TACTICAL_MK16;
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

    @Override
    public int getINITIAL_DAMAGE()
    {
        return TACTICAL_MK16_INITIAL_DAMAGE;
    }
}

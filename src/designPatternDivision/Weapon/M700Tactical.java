package designPatternDivision.Weapon;

public class M700Tactical extends MarksmanRifleWeapon
{
    private static final int M700_TACTICAL_RATE_OF_FIRE = 1;
    private static final int M700_TACTICAL_MAGAZINE_SIZE = 5;

    @Override
    void setRateOfFire()
    {
        rateOfFire = M700_TACTICAL_RATE_OF_FIRE;
        return;
    }

    @Override
    void setMagazineSize()
    {
        magazineSize = M700_TACTICAL_MAGAZINE_SIZE;
        return;
    }

}

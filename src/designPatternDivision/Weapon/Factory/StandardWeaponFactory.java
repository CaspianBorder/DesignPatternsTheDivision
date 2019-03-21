package designPatternDivision.Weapon.Factory;

import designPatternDivision.Weapon.*;

public class StandardWeaponFactory extends WeaponFactory implements WeaponName
{
    @Override
    Weapon initialWeapon( String weaponType )
    {
        switch ( weaponType )
        {
            case LIGHTWEIGHT_M4:
            {
                return new LightweightM4();
            }
            case TACTICAL_MK16:
            {
                return new TacticalMK16();
            }
            case M700TACTICAL:
            {
                return new M700Tactical();
            }
            case FIRST_WAVE_M1A:
            {
                return new FirstWaveM1A();
            }
            default:
            {
                return null;
            }
        }
    }
}

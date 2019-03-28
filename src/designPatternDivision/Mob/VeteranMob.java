package designPatternDivision.Mob;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.HealthPoint.HealthPoint;

public class VeteranMob extends Mob
{
    Mob mob;

    public VeteranMob( Mob inputMob )
    {
        mob = inputMob;
        mobColor = "PURPLE";
        setDamageModule();
        setHealthPoint();
        shootPosibility *= 1.25;
    }

    void setDamageModule()
    {
        damageModule = new DamageModule( (int) ( basicDamage * 1.2 ) );
        return;
    }

    void setHealthPoint()
    {
        healthPoint = new HealthPoint( (int) (basicHealth * 1.5) );
    }




}

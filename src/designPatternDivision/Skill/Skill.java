package designPatternDivision.Skill;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.HealthPoint.HealthPoint;

public abstract class Skill
{
    String skillName;
    boolean isActive = false;
    boolean isReady = false;
    int durationTime;
    int durationLeft = 0;
    int cooldownTime;
    int cooldownLeft = 0;

    public void moveOver()
    {
        if ( isActive )
        {
            durationLeft--;
            if ( durationLeft == 0 )
            {
                isActive = false;
                cooldownLeft = cooldownTime;
            }
        }
        else if ( isReady == false )
        {
            cooldownLeft--;
            if ( cooldownLeft == 0 )
            {
                isReady = true;
            }
        }
    }

    public boolean activeSkill()
    {
        if ( isReady == false )
        {
            return false;
        }
        isReady = false;
        isActive = true;
        durationLeft = durationTime;
        return true;
    }

    public DamageModule useSkill( DamageModule damageModule )
    {
        return damageModule;
    }

    public HealthPoint useSkill( HealthPoint healthPoint)
    {
        return healthPoint;
    }

    public abstract StringBuilder skillDescription();
}

package designPatternDivision.Skill;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.HealthPoint.HealthPoint;

public abstract class Skill
{
    String skillName;
    boolean isActive = false;
    boolean isReady = true;
    boolean inComingDamage = false;
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

    public void resetSkill()
    {
        isReady = true;
        isActive = false;
        cooldownLeft = 0;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public boolean isReady()
    {
        return isReady;
    }

    public DamageModule useSkill( DamageModule damageModule )
    {
        return damageModule;
    }

    public HealthPoint useSkill( HealthPoint healthPoint )
    {
        return healthPoint;
    }

    public abstract String skillDescription();

    public void setInComingDamage()
    {
        inComingDamage = true;
    }

    public String getStatus()
    {
        if ( isActive )
        {
            return "Active , " + durationLeft + " move left";
        }
        else if ( isReady == false )
        {
            return "Cooldown , " + cooldownLeft + " move left";
        }
        else
        {
            return skillName;
        }
    }

    @Override
    public String toString()
    {
        return getStatus();
    }
}

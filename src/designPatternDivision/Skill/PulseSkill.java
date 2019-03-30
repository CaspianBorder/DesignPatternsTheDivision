package designPatternDivision.Skill;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Damage.PulseDamageModifier;

public class PulseSkill extends Skill
{
    public PulseSkill()
    {
        skillName = "Pulse";
        durationTime = 5;
        cooldownTime = 6;
    }

    @Override
    public DamageModule useSkill( DamageModule damageModule )
    {
        if ( isActive )
        {
            if ( !inComingDamage )
            {
                return super.useSkill( new PulseDamageModifier( damageModule ) );
            }
        }
        inComingDamage = false;
        return super.useSkill( damageModule );
    }

    @Override
    public String skillDescription()
    {
        String stringBuffer = "";
        stringBuffer += "Pulse. ";
        stringBuffer += System.lineSeparator();
        stringBuffer += "increase 30% of weapon damage on enemy. ";
        stringBuffer += System.lineSeparator();
        stringBuffer += "duration : 4. ";
        stringBuffer += System.lineSeparator();
        stringBuffer += "cooldown : 6. ";
        return stringBuffer;
    }
}

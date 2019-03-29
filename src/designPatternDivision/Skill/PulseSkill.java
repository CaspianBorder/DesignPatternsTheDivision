package designPatternDivision.Skill;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Damage.PulseDamageModifier;

public class PulseSkill extends Skill
{
    public PulseSkill()
    {
        skillName = "Pulse";
        durationTime = 4;
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
    public StringBuilder skillDescription()
    {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append( "Pulse" );
        stringBuffer.append( System.lineSeparator() );
        stringBuffer.append( "increase 30% of weapon damage on enemy" );
        stringBuffer.append( System.lineSeparator() );
        stringBuffer.append( "duration : 4" );
        stringBuffer.append( System.lineSeparator() );
        stringBuffer.append( "cooldown : 6" );
        return stringBuffer;
    }
}

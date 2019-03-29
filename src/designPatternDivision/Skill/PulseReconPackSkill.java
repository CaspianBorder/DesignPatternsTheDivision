package designPatternDivision.Skill;

public class PulseReconPackSkill extends PulseSkill
{
    public PulseReconPackSkill()
    {
        skillName = "Pulse-Recon Pack";
        durationTime = 6;
        cooldownTime = 6;
    }

    @Override
    public StringBuilder skillDescription()
    {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append( "Pulse - Recon Pack Modification" );
        stringBuffer.append( System.lineSeparator() );
        stringBuffer.append( "increase 50% of pulse duration" );
        stringBuffer.append( System.lineSeparator() );
        stringBuffer.append( "duration : 6" );
        stringBuffer.append( System.lineSeparator() );
        stringBuffer.append( "cooldown : 6" );
        return stringBuffer;
    }
}

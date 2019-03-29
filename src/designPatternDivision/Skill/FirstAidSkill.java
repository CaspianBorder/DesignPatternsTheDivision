package designPatternDivision.Skill;

import designPatternDivision.HealthPoint.HealthPoint;

public class FirstAidSkill extends Skill
{
    public FirstAidSkill()
    {
        skillName = "FirstAid";
        durationTime = 3;
        cooldownTime = 5;
    }

    @Override
    public HealthPoint useSkill( HealthPoint healthPoint )
    {
        if ( isActive )
        {
            healthPoint.getHeal( 800 );
        }
        return super.useSkill( healthPoint );
    }

    @Override
    public StringBuilder skillDescription()
    {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append( "First Aid" );
        stringBuffer.append( System.lineSeparator() );
        stringBuffer.append( "Recover 800 point of Health" );
        stringBuffer.append( System.lineSeparator() );
        stringBuffer.append( "duration : 3" );
        stringBuffer.append( System.lineSeparator() );
        stringBuffer.append( "cooldown : 5" );
        return stringBuffer;
    }
}

package designPatternDivision.Skill;

import designPatternDivision.HealthPoint.HealthPoint;
import designPatternDivision.Player;

public class FirstAidSkill extends Skill
{
    public FirstAidSkill()
    {
        skillName = "FirstAid";
        durationTime = 4;
        cooldownTime = 5;
    }

    @Override
    public HealthPoint useSkill( HealthPoint healthPoint )
    {
        if ( isActive && durationLeft == 4 )
        {
//            healthPoint.getHeal( 800 );
            Player player = Player.getPlayerInstance();
            player.getHealthPoint().getHeal( 800 );
        }
        return super.useSkill( healthPoint );
    }

    @Override
    public String skillDescription()
    {
        String stringBuffer = "";
        stringBuffer += "First Aid. ";
        stringBuffer += System.lineSeparator();
        stringBuffer += "Recover 800 point of Health. ";
        stringBuffer += System.lineSeparator();
        stringBuffer += "duration : 3. ";
        stringBuffer += System.lineSeparator();
        stringBuffer += "cooldown : 5. ";
        return stringBuffer;
    }
}

package designPatternDivision.Skill;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Damage.FirstAidDamageBuffer;
import designPatternDivision.Damage.FirstAidDamageDebuffer;
import designPatternDivision.Damage.PulseDamageModifier;
import designPatternDivision.Player;

public class FirstAidBoosterShotSkill extends FirstAidSkill
{
    boolean inComingDamage = false ;
    public FirstAidBoosterShotSkill()
    {
        skillName = "FirstAid - Booster Shot";
        durationTime = 4;
        cooldownTime = 5;
    }

    @Override
    public DamageModule useSkill( DamageModule damageModule )
    {
        if ( isActive )
        {
            if ( durationLeft == 4 )
            {
                Player player = Player.getPlayerInstance();
                player.getHealthPoint().getHeal( 800 );
            }
            if ( !inComingDamage )
            {
                return super.useSkill( new FirstAidDamageBuffer( damageModule ) );
            }
            else
            {
                inComingDamage = false ;
                return super.useSkill( new FirstAidDamageDebuffer( damageModule ) );
            }
        }
        else
        {
            inComingDamage = false ;
            return super.useSkill( damageModule );
        }
    }

    @Override
    public String skillDescription()
    {
        String stringBuffer = "";
        stringBuffer += "First Aid - Booster Shot Modification. ";
        stringBuffer += System.lineSeparator();
        stringBuffer += "Increase 20% of outgoing damage, decrease 20% of incoming damage. ";
        stringBuffer += System.lineSeparator();
        stringBuffer += "duration : 3. ";
        stringBuffer += System.lineSeparator();
        stringBuffer += "cooldown : 5. ";
        return stringBuffer;
    }
}

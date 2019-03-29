package designPatternDivision.Skill;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Damage.FirstAidDamageBuffer;
import designPatternDivision.Damage.FirstAidDamageDebuffer;
import designPatternDivision.Damage.PulseDamageModifier;

public class FirstAidBoosterShotSkill extends FirstAidSkill
{
    boolean inComingDamage = false ;
    public FirstAidBoosterShotSkill()
    {
        skillName = "FirstAid - Booster Shot Modification";
        durationTime = 3;
        cooldownTime = 5;
    }

    @Override
    public DamageModule useSkill( DamageModule damageModule )
    {
        if ( isActive )
        {
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
}

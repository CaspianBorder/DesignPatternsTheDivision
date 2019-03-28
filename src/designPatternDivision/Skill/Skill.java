package designPatternDivision.Skill;

public class Skill
{
    String skillName;
    boolean isActive;
    boolean isReady;
    int durationTime;
    int durationLeft;
    int cooldownTime;
    int cooldownLeft;

    public void moveOver ()
    {
        if ( isActive )
        {
            durationLeft -- ;
            if ( durationLeft == 0 )
            {
                isActive = false ;
                cooldownLeft = cooldownTime;
            }
        }
        else
        {
            cooldownLeft -- ;
            if ( cooldownLeft == 0 )
            {
                isReady = true;
            }
        }
    }

    public boolean activeSkill ()
    {
        if ( isReady == false )
        {
            return false ;
        }
        return true;
    }
}

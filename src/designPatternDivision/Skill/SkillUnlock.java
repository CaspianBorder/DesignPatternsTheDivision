package designPatternDivision.Skill;

public class SkillUnlock
{
    boolean pulseLevel1;
    boolean pulseLevel2;
    boolean firstAidLevel1;
    boolean firstAidLevel2;

    public SkillUnlock()
    {
        pulseLevel1 = false;
        pulseLevel2 = false;
        firstAidLevel1 = false;
        firstAidLevel2 = false;
    }

    public SkillUnlock( boolean input1 , boolean input2 , boolean input3 , boolean input4 )
    {
        pulseLevel1 = input1;
        pulseLevel2 = input2;
        firstAidLevel1 = input3;
        firstAidLevel2 = input4;
    }

    public boolean isPulseLevel1()
    {
        return pulseLevel1;
    }

    public boolean isPulseLevel2()
    {
        return pulseLevel2;
    }

    public boolean isFirstAidLevel1()
    {
        return firstAidLevel1;
    }

    public boolean isFirstAidLevel2()
    {
        return firstAidLevel2;
    }

    public void setPulseLevel1( boolean pulseLevel1 )
    {
        this.pulseLevel1 = pulseLevel1;
    }

    public void setPulseLevel2( boolean pulseLevel2 )
    {
        this.pulseLevel2 = pulseLevel2;
    }

    public void setFirstAidLevel1( boolean firstAidLevel1 )
    {
        this.firstAidLevel1 = firstAidLevel1;
    }

    public void setFirstAidLevel2( boolean firstAidLevel2 )
    {
        this.firstAidLevel2 = firstAidLevel2;
    }

    @Override
    public String toString()
    {
        return pulseLevel1 + "," + pulseLevel2 + "," + firstAidLevel1 + "," + firstAidLevel2 ;
    }
}

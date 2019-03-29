package designPatternDivision.Experience;

public class ExperienceBar
{
    final int EXPERIENCE_CAP = 150;
    int experiencePoint;
    int playerLevel;

    public ExperienceBar()
    {

    }

    public ExperienceBar( int initExp )
    {
        getExperiencePoint( initExp );
    }

    public void getExperiencePoint( int income )
    {
        experiencePoint += income;
        while ( isLevelUp() ) ;
        return;
    }

    private boolean isLevelUp()
    {
        if ( experiencePoint >= EXPERIENCE_CAP )
        {
            playerLevel++;
            experiencePoint -= EXPERIENCE_CAP;
            return true;
        }
        return false;
    }


}

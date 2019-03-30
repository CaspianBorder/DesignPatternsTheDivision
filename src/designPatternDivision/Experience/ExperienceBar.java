package designPatternDivision.Experience;

public class ExperienceBar
{
    final int EXPERIENCE_CAP = 150;
    int experiencePoint;
    int playerLevel;

    public ExperienceBar()
    {
    }

    public ExperienceBar( int initExp , int level )
    {
        playerLevel = level;
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

    public int getCurrentExperiencePoint()
    {
        return experiencePoint;
    }

    public int getPlayerLevel()
    {
        return playerLevel;
    }

    public void reset()
    {
        playerLevel = 0;
        experiencePoint = 0;
    }

    public int getEXPERIENCE_CAP()
    {
        return EXPERIENCE_CAP;
    }
}

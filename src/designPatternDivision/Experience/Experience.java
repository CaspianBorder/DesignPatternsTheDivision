package designPatternDivision.Experience;

public class Experience
{
    private static final int INITIAL_EXPERIENCE_POINT = 30;
    int experiencePoint ;

    public Experience()
    {
        experiencePoint = INITIAL_EXPERIENCE_POINT;
    }

    public int getExperiencePoint()
    {
        return experiencePoint;
    }
}

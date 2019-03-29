package designPatternDivision.Scene;

public class SafeAreaScene extends Scene
{
    @Override
    boolean isSafeArea()
    {
        return true;
    }

    @Override
    void mobCreation()
    {
        return;
    }

    @Override
    public String getInfo()
    {
        return "You are now entering the safe area.";
    }
}

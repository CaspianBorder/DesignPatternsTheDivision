package designPatternDivision.Scene;

import designPatternDivision.Mob.Mob;
import designPatternDivision.Player;

import java.util.ArrayList;

public abstract class Scene
{
    Player player;
    ArrayList<Mob> mobArrayList = null;

    public Scene ()
    {
        player = Player.getPlayerInstance();
//        createScene();
    }

    public void createScene()
    {
        if ( isSafeArea() == false )
        {
            mobCreation();
        }
    }

    abstract void mobCreation();

    abstract boolean isSafeArea();

    public ArrayList<Mob> getMobArrayList()
    {
        return mobArrayList;
    }

    public String getInfo()
    {
        return "";
    }

}

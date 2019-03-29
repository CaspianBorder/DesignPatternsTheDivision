package designPatternDivision.Storage;

import designPatternDivision.Experience.ExperienceBar;
import designPatternDivision.Player;
import designPatternDivision.Weapon.WeaponStash;

import java.io.*;
import java.util.ArrayList;

public class PlayerStatusStore
{
    private static final String PLAYER_STATUS = "save" + File.separator + "player.txt";

    public void saveGame( Player player )
    {
        BufferedWriter bufferedWriter = null;
        StringBuilder stringBuilder = new StringBuilder();
        try
        {
            bufferedWriter = new BufferedWriter( new FileWriter( PLAYER_STATUS ) );
            stringBuilder.append( player.getExperienceBar().getPlayerLevel() );
            stringBuilder.append( System.lineSeparator() );
            stringBuilder.append( player.getExperienceBar().getCurrentExperiencePoint() );
            stringBuilder.append( System.lineSeparator() );
            for ( int i = 0 ; i < player.getWeaponStashCollectionList().size() ; i++ )
            {
                stringBuilder.append( player.getWeaponStashCollectionList().get( i ).toString() );
                stringBuilder.append( System.lineSeparator() );
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }

    public void loadGame()
    {
        BufferedReader bufferedReader = null;
        String input;
        String[] inputSplit;
        Player player = Player.getPlayerInstance();
        try
        {
            bufferedReader = new BufferedReader( new FileReader( PLAYER_STATUS ) );
            int expPoint;
            int level;
            ArrayList<WeaponStash> weaponStashList = new ArrayList<>();
            input = bufferedReader.readLine();
            level = Integer.valueOf( input );
            input = bufferedReader.readLine();
            expPoint = Integer.valueOf( input );
            player.setExperienceBar( new ExperienceBar( expPoint , level ) );
            while ( bufferedReader.ready() )
            {
                input = bufferedReader.readLine();
                inputSplit = input.split( "," );
                player.getWeaponStashCollection().acquireWeapon( inputSplit[0] , Integer.valueOf( inputSplit[1] ) );
            }
            bufferedReader.close();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }
}

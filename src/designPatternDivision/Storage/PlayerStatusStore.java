package designPatternDivision.Storage;

import designPatternDivision.Player;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PlayerStatusStore
{
    private static final String PLAYER_STATUS = "save" + File.separator + "player.txt";
    public void saveGame( Player player )
    {
        BufferedWriter bufferedWriter = null ;
        StringBuilder stringBuilder = new StringBuilder();
        try
        {
            bufferedWriter = new BufferedWriter( new FileWriter( PLAYER_STATUS ) );
            stringBuilder.append( player.getExperienceBar() )  ;
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }
}

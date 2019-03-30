package designPatternDivision.Scene;

import designPatternDivision.GUI.CombatGUI;
import designPatternDivision.Player;

public class SceneControl
{
    int missionStage;
    int missionDifficulty;
    int currentStage;
    BattleScene battleScene = null;
    Player player = Player.getPlayerInstance();

    public SceneControl( int stage , int difficulty )
    {
        missionStage = stage;
        missionDifficulty = difficulty;
    }

    public BattleScene getBattleScene()
    {
        if ( currentStage < missionStage )
        {
            if ( battleScene == null || battleScene.isSceneClear() )
            {
                if ( battleScene != null && battleScene.isSceneClear() )
                {
                    currentStage ++ ;
                    player.resetSkill();
                    player.getPlayerHealthPoint().resetHealthPoint();
//                    battleScene.setPlayerNextMove( -1 , 0 );
                }
                if ( currentStage < missionStage )
                {
                    if (  missionDifficulty < 2 )
                    {
                        battleScene = new NormalBattleScene( 3 + missionDifficulty );
                        if ( currentStage != 0 )
                        {
                            battleScene.setFirstInfo( "Stage Clear , move to next stage" + System.lineSeparator() );
                        }
                        battleScene.setFirstInfo( "Stage " + ( currentStage + 1 ) + " / " + missionStage );
                    }
                    else
                    {
                        battleScene = new HardBattleScene( 4 + missionDifficulty - 2 );
                    }
                    CombatGUI combatGUI = CombatGUI.getCombatGUIInstance();
                    combatGUI.appendMsg( battleScene.getInfo() );
                    combatGUI.perMoveAction();
                }
            }
        }
        else
        {
            CombatGUI combatGUI = CombatGUI.getCombatGUIInstance();
            combatGUI.missionCleared();
            battleScene = null;
        }
        return battleScene;
    }

    public SafeAreaScene getSafeAreaScene()
    {
        player.resetSkill();
        player.getPlayerHealthPoint().resetHealthPoint();
        player.getPlayerHealthPoint().resupplyMedkit();
        return new SafeAreaScene();
    }
}

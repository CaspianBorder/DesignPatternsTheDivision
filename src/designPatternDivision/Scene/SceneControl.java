package designPatternDivision.Scene;

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
                    player.resetSkill();
                    player.getPlayerHealthPoint().resetHealthPoint();
                }
                if ( missionDifficulty < 2 )
                {
                    battleScene = new NormalBattleScene( 3 + missionDifficulty );
                    battleScene.setFirstInfo("Stage");
                }
                else
                {
                    battleScene = new HardBattleScene( 4 + missionDifficulty - 2 );
                }
            }
            return battleScene;
        }
        else
        {
            return null;
        }
    }

    public SafeAreaScene getSafeAreaScene()
    {
        player.resetSkill();
        player.getPlayerHealthPoint().resetHealthPoint();
        player.getPlayerHealthPoint().resupplyMedkit();
        return new SafeAreaScene();
    }
}

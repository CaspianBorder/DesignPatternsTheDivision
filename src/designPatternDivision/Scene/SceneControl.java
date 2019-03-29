package designPatternDivision.Scene;

import designPatternDivision.Player;

public class SceneControl
{
    int missionStage;
    int missionDifficulty;
    BattleScene battleScene = null;
    Player player = Player.getPlayerInstance();

    public SceneControl( int stage , int difficulty )
    {
        missionStage = stage;
        missionDifficulty = difficulty;
    }

    public BattleScene getBattleScene()
    {
        if ( battleScene == null || battleScene.isSceneClear() )
        {
            if ( battleScene != null && battleScene.isSceneClear() )
            {
                player.resetSkill();
            }
            if ( missionDifficulty < 2 )
            {
                battleScene = new NormalBattleScene( 3 + missionDifficulty );
            }
            else
            {
                battleScene = new HardBattleScene( 4 + missionDifficulty - 2 );
            }
        }
        return battleScene;
    }
}

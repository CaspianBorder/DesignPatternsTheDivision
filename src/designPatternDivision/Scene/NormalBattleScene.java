package designPatternDivision.Scene;

import designPatternDivision.Mob.Mob;

public class NormalBattleScene extends BattleScene
{
    final int INITIAL_MOB_NUMBER = 3;
    int mobNumber;

    public NormalBattleScene()
    {
        mobNumber = INITIAL_MOB_NUMBER;
    }

    public NormalBattleScene( int inputMobNumber )
    {
        mobNumber = inputMobNumber;
    }

    @Override
    int getMobNumber()
    {
        return mobNumber;
    }

    @Override
    Mob getAdvancedMob( Mob mobInput )
    {
        return mobInput;
    }
}

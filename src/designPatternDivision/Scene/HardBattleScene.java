package designPatternDivision.Scene;

import designPatternDivision.Mob.Mob;
import designPatternDivision.Mob.VeteranMob;

public class HardBattleScene extends BattleScene
{
    final int INITIAL_MOB_NUMBER = 4;
    int mobNumber;

    public HardBattleScene()
    {
        mobNumber = INITIAL_MOB_NUMBER;
    }

    public HardBattleScene( int inputMobNumber )
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
        mobInput = new VeteranMob( mobInput );
        return mobInput;
    }
}

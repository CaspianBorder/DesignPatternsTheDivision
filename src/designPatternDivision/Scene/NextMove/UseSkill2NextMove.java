package designPatternDivision.Scene.NextMove;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Player;

public class UseSkill2NextMove extends NextMove
{
    public UseSkill2NextMove( Player player )
    {
        super( player );
    }

    @Override
    public DamageModule executeNextMove()
    {
        player.getSkillSlot2().activeSkill();
        return null;
    }
}

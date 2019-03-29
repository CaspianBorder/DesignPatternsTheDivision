package designPatternDivision.Scene.NextMove;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Player;

public class UseSkill1NextMove extends NextMove
{
    public UseSkill1NextMove( Player player )
    {
        super( player );
    }

    @Override
    public DamageModule executeNextMove()
    {
        player.getSkillSlot1().activeSkill();
        return null;
    }
}

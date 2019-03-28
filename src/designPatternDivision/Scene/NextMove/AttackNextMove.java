package designPatternDivision.Scene.NextMove;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Damage.PlayerDamage;
import designPatternDivision.Player;

public class AttackNextMove extends NextMove
{
    public AttackNextMove( Player player )
    {
        super( player );
    }

    @Override
    public PlayerDamage executeNextMove()
    {
        return player.getWeapon().useWeapon();
    }

}

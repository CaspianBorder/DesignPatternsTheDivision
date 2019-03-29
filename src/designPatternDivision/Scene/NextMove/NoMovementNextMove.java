package designPatternDivision.Scene.NextMove;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Damage.PlayerDamage;
import designPatternDivision.Player;

public class NoMovementNextMove extends NextMove
{
    public NoMovementNextMove( Player player )
    {
        super( player );
    }

    @Override
    public DamageModule executeNextMove()
    {
        return null;
    }
}

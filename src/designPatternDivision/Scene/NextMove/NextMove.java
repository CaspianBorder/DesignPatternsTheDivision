package designPatternDivision.Scene.NextMove;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Damage.PlayerDamage;
import designPatternDivision.Player;

public abstract class NextMove
{
    Player player;

    public NextMove( Player player)
    {
        this.player = player;
    }

    public abstract PlayerDamage executeNextMove();
}

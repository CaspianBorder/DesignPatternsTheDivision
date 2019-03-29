package designPatternDivision.Scene.NextMove;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Damage.PlayerDamage;
import designPatternDivision.Player;

public class UseMedkitNextMove extends NextMove
{
    public UseMedkitNextMove( Player player )
    {
        super( player );
    }

    @Override
    public DamageModule executeNextMove()
    {
        player.getPlayerHealthPoint().useMedkit();
        return null;
    }
}

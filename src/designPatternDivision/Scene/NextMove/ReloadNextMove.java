package designPatternDivision.Scene.NextMove;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Damage.PlayerDamage;
import designPatternDivision.Player;

public class ReloadNextMove extends NextMove
{
    public ReloadNextMove( Player player )
    {
        super( player );
    }

    @Override
    public DamageModule executeNextMove()
    {
        player.getWeapon().reloadMagazine();
        return null;
    }
}

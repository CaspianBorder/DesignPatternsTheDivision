package designPatternDivision.Scene;

import designPatternDivision.Damage.PlayerDamage;
import designPatternDivision.Experience.Experience;
import designPatternDivision.Mob.Mob;
import designPatternDivision.Scene.NextMove.*;

import java.util.ArrayList;
import java.util.Random;

public abstract class BattleScene extends Scene
{
    final double PLAYER_SHOOTING_HIT_POSIBILITY = 0.5;
    final double PLAYER_NO_SHOOTING_HIT_POSIBILITY = 0.2;
    final double MOB_SHOOTING_HIT_POSIBILITY = 0.8;
    final double MOB_NO_SHOOTING_HIT_POSIBILITY = 0.5;
    PlayerDamage playerDamage;
    double playerHitPosibility;

    @Override
    void mobCreation()
    {
        int mobNumber = getMobNumber();
        mobArrayList = new ArrayList<>();
        for ( int i = 0 ; i < mobNumber ; i++ )
        {
            Mob mob = new Mob();
            mob = getAdvancedMob( mob );
            mobArrayList.add( mob );
        }
    }

    @Override
    boolean isSafeArea()
    {
        return false;
    }

    abstract int getMobNumber();

    abstract Mob getAdvancedMob( Mob mobInput );

    public boolean setPlayerNextMove( int selectMove , int target )
    {
        NextMove nextMove;
        boolean targetDown = false;

        updateMobShootingState();

        switch ( selectMove )
        {
            case 0:
            {
                nextMove = new AttackNextMove( player );
                break;
            }
            case 1:
            {
                nextMove = new ReloadNextMove( player );
                break;
            }
            case 2:
            {
                nextMove = new UseMedkitNextMove( player );
                break;
            }
            default:
            {
                nextMove = new NoMovementNextMove( player );
            }
        }
        if ( nextMove instanceof AttackNextMove )
        {
            playerHitPosibility = PLAYER_SHOOTING_HIT_POSIBILITY;
            targetDown = player2MobDamage( nextMove.executeNextMove() , target );
        }
        else
        {
            playerHitPosibility = PLAYER_NO_SHOOTING_HIT_POSIBILITY;
            nextMove.executeNextMove();
        }
        return targetDown;
    }

    private boolean player2MobDamage( PlayerDamage playerDamage , int target )
    {
        double hitPosibility = 1;
        int finalDamage = 0;
        Random random = new Random();

        if ( mobArrayList.get( target ).getShootingState() == true )
        {
            hitPosibility = MOB_SHOOTING_HIT_POSIBILITY;
        }
        else
        {
            hitPosibility = MOB_NO_SHOOTING_HIT_POSIBILITY;
        }

        for ( int i = 0 ; i < playerDamage.getShotFire() ; i++ )
        {
            if ( random.nextDouble() <= hitPosibility )
            {
                finalDamage += playerDamage.getDamage();
            }
        }

        if ( mobArrayList.get( target ).getHealthPoint().getDamaged( finalDamage ) == true )
        {
            mobArrayList.remove( target );
            return true;
        }
        else
        {
            return false;
        }
    }

    private void updateMobShootingState()
    {
        for ( int i = 0 ; i < mobArrayList.size() ; i++ )
        {
            mobArrayList.get( i ).setShootingState();
        }
        return;
    }

    public boolean mob2PlayerDamage()
    {
        double hitPosibility;
        int finalDamage = 0;
        Random random = new Random();

        for ( int i = 0 ; i < mobArrayList.size() ; i++ )
        {
            if ( mobArrayList.get( i ).getShootingState() )
            {
                if ( random.nextDouble() < playerHitPosibility )
                {
                    finalDamage += mobArrayList.get( i ).getDamageModule().getDamage();
                }
            }
        }

        return player.getHealthPoint().getDamaged( finalDamage );
    }

    private void addPlayerExp()
    {
        player.getExperienceBar().getExperiencePoint( new Experience().getExperiencePoint() );
        return;
    }
}

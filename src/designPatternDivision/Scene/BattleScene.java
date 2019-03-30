package designPatternDivision.Scene;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Experience.Experience;
import designPatternDivision.GUI.CombatGUI;
import designPatternDivision.Mob.Mob;
import designPatternDivision.Player;
import designPatternDivision.Scene.NextMove.*;

import java.util.ArrayList;
import java.util.Random;

public abstract class BattleScene extends Scene
{
    final double PLAYER_SHOOTING_HIT_POSIBILITY = 0.5;
    final double PLAYER_NO_SHOOTING_HIT_POSIBILITY = 0.2;
    final double MOB_SHOOTING_HIT_POSIBILITY = 0.8;
    final double MOB_NO_SHOOTING_HIT_POSIBILITY = 0.5;
    boolean isFirstInfo = true;
    String firstInfo;
    CombatGUI combatGUI;
    //    Player player = Player.getPlayerInstance();
    double playerHitPosibility;

    public BattleScene()
    {
    }

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
        if ( combatGUI == null )
        {
            combatGUI = CombatGUI.getCombatGUIInstance();
        }

        NextMove nextMove;
        boolean targetDown = false;

        updateMobShootingState();

        switch ( selectMove )
        {
            case 0:
            {
                nextMove = new AttackNextMove( player );
                setFirstInfo( "Attacking " + mobArrayList.get( target ).toString() );
                break;
            }
            case 1:
            {
                nextMove = new ReloadNextMove( player );
                setFirstInfo( "Weapon Reloaded" );
                break;
            }
            case 2:
            {
                nextMove = new UseMedkitNextMove( player );
                setFirstInfo( "Medkit used" );
                break;
            }
            case 3:
            {
                nextMove = new UseSkill1NextMove( player );
                setFirstInfo( "Skill 1 used" + System.lineSeparator() + player.getSkillSlot1().toString() );
                break;
            }
            case 4:
            {
                nextMove = new UseSkill2NextMove( player );
                setFirstInfo( "Skill 2 used" + System.lineSeparator() + player.getSkillSlot2().toString() );
                break;
            }
            default:
            {
                nextMove = new NoMovementNextMove( player );
            }
        }
        if ( selectMove == 0 )
        {
            playerHitPosibility = PLAYER_SHOOTING_HIT_POSIBILITY;
            targetDown = player2MobDamage( nextMove.executeNextMove() , target );
            if ( targetDown == true )
            {
                addPlayerExp();
            }
        }
        else
        {
            playerHitPosibility = PLAYER_NO_SHOOTING_HIT_POSIBILITY;
            nextMove.executeNextMove();
        }
        mob2PlayerDamage();
        combatGUI.perMoveAction();
        combatGUI.appendMsg( getInfo() );
        return targetDown;
    }

    private boolean player2MobDamage( DamageModule damageModule , int target )
    {
        double hitPosibility = 1;
        int finalDamage = 0;
        int hitPoint = 0;
        Random random = new Random();
        double randomValue;

        if ( mobArrayList.get( target ).getShootingState() )
        {
            hitPosibility = MOB_SHOOTING_HIT_POSIBILITY;
        }
        else
        {
            hitPosibility = MOB_NO_SHOOTING_HIT_POSIBILITY;
        }

        for ( int i = 0 ; i < damageModule.getShotFire() ; i++ )
        {
            randomValue = random.nextDouble();
            if ( randomValue <= hitPosibility )
            {
                hitPoint++;
//                finalDamage += damageModule.getDamage();
            }
        }
        finalDamage = (int) ( ( (double) hitPoint / damageModule.getShotFire() ) * damageModule.getDamage() );

        setFirstInfo( "Dealing " + finalDamage + " damage to " + mobArrayList.get( target ).toString() );
        if ( mobArrayList.get( target ).getHealthPoint().getDamaged( finalDamage ) )
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
        double randomValue;

        for ( int i = 0 ; i < mobArrayList.size() ; i++ )
        {
            if ( mobArrayList.get( i ).getShootingState() )
            {
                randomValue = random.nextDouble();
                if ( randomValue < playerHitPosibility )
                {
                    finalDamage += mobArrayList.get( i ).getDamageModule().getDamage();
                }
            }
        }

        return player.playerGetDamaged( new DamageModule( finalDamage ) );
    }

    public boolean isSceneClear()
    {
        return mobArrayList.isEmpty();
    }

    private void addPlayerExp()
    {
        player.getExperienceBar().getExperiencePoint( new Experience().getExperiencePoint() );
        return;
    }

    public void setFirstInfo( String firstInfo )
    {
        isFirstInfo = true;
        this.firstInfo += System.lineSeparator() + firstInfo;
    }

    @Override
    public String getInfo()
    {
        StringBuilder stringBuilder = new StringBuilder();
        if ( isFirstInfo )
        {
            stringBuilder.append( firstInfo );
            stringBuilder.append( System.lineSeparator() );
            firstInfo = "";
            isFirstInfo = false;
        }
        for ( int i = 0 ; i < mobArrayList.size() ; i++ )
        {
            stringBuilder.append( mobArrayList.get( i ).toString() );
            stringBuilder.append( System.lineSeparator() );
        }
        return stringBuilder.toString();
    }

    public ArrayList<String> getMobList()
    {
        ArrayList<String> mobList = new ArrayList<>();
        for ( int i = 0 ; i < mobArrayList.size() ; i++ )
        {
            mobList.add( mobArrayList.get( i ).toString() );
        }
        return mobList;
    }
}

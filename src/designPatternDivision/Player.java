package designPatternDivision;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.Damage.PlayerDamage;
import designPatternDivision.Experience.ExperienceBar;
import designPatternDivision.HealthPoint.HealthPoint;
import designPatternDivision.HealthPoint.PlayerHealthPoint;
import designPatternDivision.Skill.*;
import designPatternDivision.Weapon.Factory.StandardWeaponFactory;
import designPatternDivision.Weapon.LightweightM4;
import designPatternDivision.Weapon.Weapon;
import designPatternDivision.Weapon.WeaponStash;
import designPatternDivision.Weapon.WeaponStashCollection;

import java.util.ArrayList;

public class Player
{
    private static final int PLAYER_INITIAL_FULL_HEALTH = 3000;
    private volatile static Player player;
    private volatile static boolean isInit = false;
    private Weapon weaponSlot1;
    private Weapon weaponSlot2;
    private SkillUnlock skillUnlock;
    private Skill skillSlot1;
    private Skill skillSlot2;
    private int currentSlot;
    private PlayerHealthPoint playerHealthPoint;
    private ExperienceBar experienceBar;
    private WeaponStashCollection weaponStashCollection;

    private Player()
    {
        playerHealthPoint = new PlayerHealthPoint( PLAYER_INITIAL_FULL_HEALTH );
        experienceBar = new ExperienceBar();
        weaponStashCollection = new WeaponStashCollection();
    }

    public static Player getPlayerInstance()
    {
        if ( isInit == false )
        {
            synchronized ( Player.class )
            {
                if ( isInit == false )
                {
                    player = new Player();
                    isInit = true;
                }
            }
        }
        return player;
    }

    public void setExperienceBar( ExperienceBar input )
    {
        experienceBar = input;
        return;
    }

    public Weapon getWeapon()
    {
        if ( currentSlot == 1 )
        {
            return weaponSlot1;
        }
        else if ( currentSlot == 2 )
        {
            return weaponSlot2;
        }
        else
        {
            return null;
        }
    }

    public DamageModule useWeapon()
    {
        DamageModule damageModule = getWeapon().useWeapon();
        if ( skillSlot1 != null && skillSlot1.isActive() )
        {
            damageModule = skillSlot1.useSkill( damageModule );
        }
        if ( skillSlot2 != null && skillSlot2.isActive() )
        {
            damageModule = skillSlot2.useSkill( damageModule );
        }
        return damageModule;
    }

    public Weapon getWeaponSlot1()
    {
        return weaponSlot1;
    }

    public Weapon getWeaponSlot2()
    {
        return weaponSlot2;
    }

    public int getCurrentSlot()
    {
        return currentSlot;
    }

    public void switchWeapon()
    {
        if ( getCurrentSlot() == 1 )
        {
            currentSlot = 2 ;
        }
        else
        {
            currentSlot = 1;
        }
    }

    public Skill getSkillSlot1()
    {
        return skillSlot1;
    }

    public Skill getSkillSlot2()
    {
        return skillSlot2;
    }

    public void skillNextMove()
    {
        if ( skillSlot1 != null )
        {
            skillSlot1.moveOver();
        }
        if ( skillSlot2 != null )
        {
            skillSlot2.moveOver();
        }
    }

    public void resetSkill()
    {
        if ( skillSlot1 != null )
        {
            skillSlot1.resetSkill();
        }
        if ( skillSlot2 != null )
        {
            skillSlot2.resetSkill();
        }
    }

    public HealthPoint getHealthPoint()
    {
        return playerHealthPoint;
    }

    public PlayerHealthPoint getPlayerHealthPoint()
    {
        return playerHealthPoint;
    }

    public ExperienceBar getExperienceBar()
    {
        return experienceBar;
    }

    public WeaponStashCollection getWeaponStashCollection()
    {
        return weaponStashCollection;
    }

    public ArrayList<WeaponStash> getWeaponStashCollectionList()
    {
        return weaponStashCollection.getWeaponStashArrayList();
    }

    public void selectWeaponFromWeaponStash( int pos , int slot )
    {
        setWeapon( weaponStashCollection.selectWeaponFromWeaponStash( pos ) , slot );
        return;
    }

    public boolean playerGetDamaged( DamageModule damageModule )
    {
        if ( skillSlot1.isActive() )
        {
            skillSlot1.setInComingDamage();
            damageModule = skillSlot1.useSkill( damageModule );
        }
        if ( skillSlot2.isActive() )
        {
            skillSlot2.setInComingDamage();
            damageModule = skillSlot2.useSkill( damageModule );
        }
        return playerHealthPoint.getDamaged( damageModule.getDamage() );
    }

    public SkillUnlock getSkillUnlock()
    {
        return skillUnlock;
    }

    public void setSkillUnlock( SkillUnlock skillUnlock )
    {
        this.skillUnlock = skillUnlock;
    }

    public void updateSkillStatus()
    {
        if ( skillUnlock.isPulseLevel1() )
        {
            if ( skillUnlock.isPulseLevel2() )
            {
                skillSlot1 = new PulseReconPackSkill();
            }
            else
            {
                skillSlot1 = new PulseSkill();
            }
        }
        if ( skillUnlock.isFirstAidLevel1() )
        {
            if ( skillUnlock.isFirstAidLevel2() )
            {
                skillSlot2 = new FirstAidBoosterShotSkill();
            }
            else
            {
                skillSlot2 = new FirstAidSkill();
            }
        }
    }

    void setWeapon( Weapon weapon , int slot )
    {
        if ( slot == 1 )
        {
            weaponSlot1 = weapon;
        }
        else if ( slot == 2 )
        {
            weaponSlot2 = weapon;
        }
        return;
    }

    Weapon setInitWeapon()
    {
        return new StandardWeaponFactory().createWeapon( "LightweightM4" , new LightweightM4().getINITIAL_DAMAGE() );
    }

    public void newGameInit ()
    {
        skillUnlock = new SkillUnlock( true , false , true , true );
        weaponSlot1 = new StandardWeaponFactory().createWeapon( "LightweightM4" );
        weaponSlot2 = new StandardWeaponFactory().createWeapon( "FirstWaveM1A" );
        weaponStashCollection.acquireWeapon( weaponSlot1 );
        weaponStashCollection.acquireWeapon( weaponSlot2 );
        currentSlot = 1;
        experienceBar = new ExperienceBar( 30 , 1 );
    }
}


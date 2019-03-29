package designPatternDivision;

import designPatternDivision.Experience.ExperienceBar;
import designPatternDivision.HealthPoint.HealthPoint;
import designPatternDivision.HealthPoint.PlayerHealthPoint;
import designPatternDivision.Weapon.Weapon;

public class Player
{
    private static final int PLAYER_INITIAL_FULL_HEALTH = 3000;
    private volatile static Player player;
    private Weapon weaponSlot1;
    private Weapon weaponSlot2;
    private int currentSlot;
    private PlayerHealthPoint playerHealthPoint;
    private ExperienceBar experienceBar;

    private Player()
    {
        playerHealthPoint = new PlayerHealthPoint( PLAYER_INITIAL_FULL_HEALTH );
        experienceBar = new ExperienceBar();
    }

    public static Player getPlayerInstance()
    {
        if ( player == null )
        {
            synchronized (Player.class) {
                if(player == null) {
                    player = new Player();
                }
            }
        }
        return player;
    }

    public void setWeapon( Weapon weapon , int slot )
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

    public void setWeaponSlot( int input )
    {
        currentSlot = input;
        return;
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
}

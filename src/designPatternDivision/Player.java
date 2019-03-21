package designPatternDivision;

import designPatternDivision.Weapon.Weapon;

public class Player 
{
	private static final int PLAYER_INITIAL_FULL_HEALTH = 1000;
	private static Player player ;
	private Weapon weaponSlot1 ;
	private Weapon weaponSlot2 ;
	private PlayerHealthPoint healthPoint;
	
	private Player ()
	{
		healthPoint = new PlayerHealthPoint( PLAYER_INITIAL_FULL_HEALTH );
	}
	
	public static synchronized Player getPlayerInstance ()
	{
		if ( player == null )
		{
			player = new Player() ;
		}
		return player ;
	}
	
	public void setWeapon ( Weapon weapon , int slot )
	{
		if ( slot == 1 )
		{
			weaponSlot1 = weapon ;
		}
		else if ( slot == 2 )
		{
			weaponSlot2 = weapon ;
		}
		return ;
	}
	
	public Weapon getWeapon ( int slot )
	{
		if ( slot == 1 )
		{
			return weaponSlot1 ;
		}
		else if ( slot == 2 )
		{
			return weaponSlot2 ;
		}
		else
		{
			return null ;
		}
	}
}

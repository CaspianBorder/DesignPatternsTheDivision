package designPatternDivision;

import designPatternDivision.Weapon.Weapon;

public class Player 
{
	private static Player player ;
	private Weapon weaponSlot1 ;
	private Weapon weaponSlot2 ;
	
	private Player ()
	{
		
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

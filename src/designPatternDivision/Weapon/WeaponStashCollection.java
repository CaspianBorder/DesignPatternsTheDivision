package designPatternDivision.Weapon;

import designPatternDivision.Weapon.Factory.StandardWeaponFactory;

import java.util.ArrayList;

public class WeaponStashCollection
{
    ArrayList<WeaponStash> weaponStashArrayList = new ArrayList<>();

    public boolean acquireWeapon( Weapon weapon )
    {
        for ( int i = 0 ; i < weaponStashArrayList.size() ; i++ )
        {
            if ( weaponStashArrayList.get( i ).getDamage() == weapon.getSingleShotDamage() && weaponStashArrayList.get( i ).getWeaponType().equals( weapon.getWeaponName() ) )
            {
                return false;
            }
        }
        WeaponStash weaponStash = new WeaponStash();
        weaponStash.setWeaponType( weapon.getWeaponName() );
        weaponStash.setDamage( weapon.getSingleShotDamage() );
        weaponStashArrayList.add( weaponStash );
        return true;
    }

    public boolean acquireWeapon( String weaponType , int weaponDamage )
    {
        for ( int i = 0 ; i < weaponStashArrayList.size() ; i++ )
        {
            if ( weaponStashArrayList.get( i ).getDamage() == weaponDamage && weaponStashArrayList.get( i ).getWeaponType().equals( weaponType ) )
            {
                return false;
            }
        }
        WeaponStash weaponStash = new WeaponStash();
        weaponStash.setWeaponType( weaponType );
        weaponStash.setDamage( weaponDamage );
        weaponStashArrayList.add( weaponStash );
        return true;
    }

    public Weapon selectWeaponFromWeaponStash( int pos )
    {
        return new StandardWeaponFactory().createWeapon( weaponStashArrayList.get( pos ).getWeaponType() , weaponStashArrayList.get( pos ).getDamage() );
    }

    public ArrayList<WeaponStash> getWeaponStashArrayList()
    {
        return weaponStashArrayList;
    }

    public void destroyWeapon( int pos )
    {
        weaponStashArrayList.remove( pos );
    }
}

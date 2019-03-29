package designPatternDivision.Weapon;

public class WeaponStash
{
    String weaponType;
    int damage;

    public String getWeaponType()
    {
        return weaponType;
    }

    public void setWeaponType( String weaponType )
    {
        this.weaponType = weaponType;
    }

    public int getDamage()
    {
        return damage;
    }

    public void setDamage( int damage )
    {
        this.damage = damage;
    }

    @Override
    public String toString()
    {
        return weaponType + "," + damage;
    }
}

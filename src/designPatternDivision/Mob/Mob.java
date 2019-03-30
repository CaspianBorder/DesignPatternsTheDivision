package designPatternDivision.Mob;

import designPatternDivision.Damage.DamageModule;
import designPatternDivision.HealthPoint.HealthPoint;

import java.util.Random;

public class Mob
{
    final int MOB_BASIC_DAMAGE = 200;
    final int MOB_BASIC_HEALTH = 1500;
    final double MOB_BASIC_SHOOT_POSIBILITY = 0.5;
    int basicDamage;
    int basicHealth;
    boolean shootingState;
    double shootPosibility;
    String mobColor;
    String mobType;
//    static Mob mobInstance;

    DamageModule damageModule;
    HealthPoint healthPoint;

    public Mob()
    {
        basicDamage = MOB_BASIC_DAMAGE;
        basicHealth = MOB_BASIC_HEALTH;
        shootPosibility = MOB_BASIC_SHOOT_POSIBILITY;
        mobColor = "RED";
        mobType = "Rifleman";
        setDamageModule();
        setHealthPoint();
    }

//    public static Mob getMobInstance()
//    {
//        Mob mobClone = null;
//        if ( mobInstance == null )
//        {
//            mobInstance = new Mob();
//        }
//        try
//        {
//            mobClone = (Mob) mobInstance.clone();
//        }
//        catch ( CloneNotSupportedException e )
//        {
//            e.printStackTrace();
//        }
//        return mobClone;
//    }

    void setDamageModule()
    {
        damageModule = new DamageModule( basicDamage );
        return;
    }

    void setHealthPoint()
    {
        healthPoint = new HealthPoint( basicHealth );
    }

    public DamageModule getDamageModule()
    {
        return damageModule;
    }

    public HealthPoint getHealthPoint()
    {
        return healthPoint;
    }

    public String getColor()
    {
        return mobColor;
    }

    public void setShootingState()
    {
        Random random = new Random();
        if ( random.nextDouble() < shootPosibility )
        {
            shootingState = true;
        }
        else
        {
            shootingState = false;
        }
    }

    public boolean getShootingState()
    {
        return shootingState;
    }

    public String getMobType()
    {
        return mobType;
    }

    @Override
    public String toString()
    {
        return "------>" + mobType + " , " + healthPoint.getHealthPoint() + " hp" ;
    }
}

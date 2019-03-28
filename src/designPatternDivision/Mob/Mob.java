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

    DamageModule damageModule;
    HealthPoint healthPoint;

    public Mob()
    {
        basicDamage = MOB_BASIC_DAMAGE;
        basicHealth = MOB_BASIC_HEALTH;
        shootPosibility = MOB_BASIC_SHOOT_POSIBILITY;
        mobColor = "RED";
        setDamageModule();
        setHealthPoint();
    }

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
}

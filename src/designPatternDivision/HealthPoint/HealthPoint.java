package designPatternDivision.HealthPoint;

public class HealthPoint
{
    int fullHealthPoint;
    int healthPoint;

    public HealthPoint( int fullHealth )
    {
        fullHealthPoint = fullHealth;
        healthPoint = fullHealthPoint;
    }

    public int getHealthPoint()
    {
        return healthPoint;
    }

    public void getHeal( int heal )
    {
        healthPoint = healthPoint + heal < fullHealthPoint ? healthPoint + heal : fullHealthPoint;
        return;
    }

    public boolean getDamaged( int damage )
    {
        healthPoint = healthPoint - damage > 0 ? healthPoint - damage : 0;
        return isDead();
    }

    public boolean isDead()
    {
        return healthPoint == 0 ? true : false;
    }

    public int getFullHealthPoint()
    {
        return fullHealthPoint;
    }
}

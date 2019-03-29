package designPatternDivision.HealthPoint;

import designPatternDivision.HealthPoint.HealthPoint;

public class PlayerHealthPoint extends HealthPoint
{
    private static final int INITIAL_MAX_MEDKIT = 5;
    private int maxMedkitNumber;
    private int medkitNumber;

    public PlayerHealthPoint( int fullHealth )
    {
        super( fullHealth );
        maxMedkitNumber = INITIAL_MAX_MEDKIT;
        medkitNumber = maxMedkitNumber;
    }

    public void resupplyMedkit()
    {
        medkitNumber = maxMedkitNumber;
    }

    public int getMedkitNumber()
    {
        return medkitNumber;
    }

    public boolean useMedkit()
    {
        if ( hasMedkit() )
        {
            if ( !isFullHealth() )
            {
                medkitNumber--;
                getHeal( healthPoint / 2 );
                return true;
            }
        }
        return false;
    }

    public void resetHealthPoint()
    {
        healthPoint = fullHealthPoint;
    }

    private boolean hasMedkit()
    {
        return medkitNumber > 0 ? true : false;
    }

    private boolean isFullHealth()
    {
        return healthPoint == fullHealthPoint ? true : false;
    }

}

package designPatternDivision.Skill;

public class PulseReconPackSkill extends PulseSkill
{
    public PulseReconPackSkill()
    {
        skillName = "Pulse-Recon Pack";
        durationTime = 7;
        cooldownTime = 6;
    }

    @Override
    public String skillDescription()
    {
        String stringBuffer = "";
        stringBuffer += "Pulse - Recon Pack Modification. ";
        stringBuffer += System.lineSeparator();
        stringBuffer += "increase 50% of pulse duration. ";
        stringBuffer += System.lineSeparator();
        stringBuffer += "duration : 6. ";
        stringBuffer += System.lineSeparator();
        stringBuffer += "cooldown : 6. ";
        return stringBuffer;
    }
}

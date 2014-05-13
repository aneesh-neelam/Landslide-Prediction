/**
 * Created by Aneesh Neelam <neelam.aneesh@gmail.com> on 13/5/14.
 */

public enum Output
{
    very_high(0, "very high"),
    high(1, "high"),
    moderate(2, "Moderate"),
    low(3, "low"),
    very_low(4, "very low");

    public int code;
    public String name;

    public static int length = 5;

    private Output(int code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public static Output fromCode(int code)
    {
        switch (code)
        {
            case 1:
                return very_high;
            case 2:
                return high;
            case 3:
                return moderate;
            case 4:
                return low;
            case 5:
                return very_low;
            default:
                return null;
        }
    }

    public static Output fromName(String name)
    {
        switch (name)
        {
            case "very high":
                return very_high;
            case "high":
                return high;
            case "Moderate":
                return moderate;
            case "low":
                return low;
            case "very low":
                return very_low;
            default:
                return null;
        }
    }
}

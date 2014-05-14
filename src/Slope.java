/**
 * Created by Aneesh Neelam <neelam.aneesh@gmail.com> on 13/5/14.
 */

public enum Slope
{
    s0_1(0, "0-1%"),
    s1_3(1, "1-3%"),
    s3_5(2, "3-5%"),
    s5_8(3, "5-8%"),
    s8_15(4, "8-15%"),
    s15_30(5, "15-30%"),
    s30_60(6, "30-60%"),
    s60(7, ">60%");

    public int code;
    public String name;

    public static int length = 8;

    private Slope(int code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public static Slope fromCode(int code)
    {
        switch (code)
        {
            case 0:
                return s0_1;
            case 1:
                return s1_3;
            case 2:
                return s3_5;
            case 3:
                return s5_8;
            case 4:
                return s8_15;
            case 5:
                return s15_30;
            case 6:
                return s30_60;
            case 7:
                return s60;
            default:
                return null;
        }
    }

    public static Slope fromName(String name)
    {
        switch (name)
        {
            case "0-1%":
                return s0_1;
            case "1-3%":
                return s1_3;
            case "3-5%":
                return s3_5;
            case "5-8%":
                return s5_8;
            case "8-15%":
                return s8_15;
            case "15-30%":
                return s15_30;
            case "30-60%":
                return s30_60;
            case ">60%":
                return s60;
            default:
                return null;
        }
    }
}

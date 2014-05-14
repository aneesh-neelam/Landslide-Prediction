/**
 * Created by Aneesh Neelam <neelam.aneesh@gmail.com> on 13/5/14.
 */

public enum Lineament
{
    l0_557(0, "0-0.000557"),
    l557_1113(1, "0.000557-0.001113"),
    l1113_167(2, "0.001113-0.00167"),
    l167_2226(3, "0.00167-0.002226"),
    l2226_2783(4, "0.002226-0.002783");


    public int code;
    public String name;

    public static int length = 5;

    private Lineament(int code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public static Lineament fromCode(int code)
    {
        switch (code)
        {
            case 0:
                return l0_557;
            case 1:
                return l557_1113;
            case 2:
                return l1113_167;
            case 3:
                return l167_2226;
            case 4:
                return l2226_2783;
            default:
                return null;
        }
    }

    public static Lineament fromName(String name)
    {
        switch (name)
        {
            case "0-0.000557":
                return l0_557;
            case "0.000557-0.001113":
                return l557_1113;
            case "0.001113-0.00167":
                return l1113_167;
            case "0.00167-0.002226":
                return l167_2226;
            case "0.002226-0.002783":
                return l2226_2783;
            default:
                return null;
        }
    }
}

/**
 * Created by Aneesh Neelam <neelam.aneesh@gmail.com> on 13/5/14.
 */

public enum RockName
{
    pen(0, "Peninsular Gneiss,Alkai,Satyamangalam,Charnockite"),
    alk(1, "Alkali,Peninsular,Migmatite,Khondalite,Champion"),
    charo(2, "Charnockite Group"),
    sat(3, "Satyamangalam Group"),
    alkali(4, "Alkali Rocks");


    public int code;
    public String name;

    public static int length = 5;

    private RockName(int code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public static RockName fromCode(int code)
    {
        switch (code)
        {
            case 0:
                return pen;
            case 1:
                return alk;
            case 2:
                return charo;
            case 3:
                return sat;
            case 4:
                return alkali;
            default:
                return null;
        }
    }

    public static RockName fromName(String name)
    {
        switch (name)
        {
            case "Peninsular Gneiss,Alkai,Satyamangalam,Charnockite":
                return pen;
            case "Alkali,Peninsular,Migmatite,Khondalite,Champion":
                return alk;
            case "Charnockite Group":
                return charo;
            case "Satyamangalam Group":
                return sat;
            case "Alkali Rocks":
                return alkali;
            default:
                return null;
        }
    }
}

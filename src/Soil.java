/**
 * Created by Aneesh Neelam <neelam.aneesh@gmail.com> on 13/5/14.
 */

public enum Soil
{
    fine(0, "FINE"),
    fine_loamy(1, "FINE LOAMY"),
    loamy_skeletal(2, "LOAMY SKELETAL"),
    coarse_loamy(3, "COARSE LOAMY"),
    clayey(4, "CLAYEY"),
    loamy(5, "LOAMY"),
    clayey_skeletal(6, "CLAYEY SKELETAL");

    public int code;
    public String name;

    public static int length = 7;

    private Soil(int code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public static Soil fromCode(int code)
    {
        switch (code)
        {
            case 0:
                return fine;
            case 1:
                return fine_loamy;
            case 2:
                return loamy_skeletal;
            case 3:
                return coarse_loamy;
            case 4:
                return clayey;
            case 5:
                return loamy;
            case 6:
                return clayey_skeletal;
            default:
                return null;
        }
    }

    public static Soil fromName(String name)
    {
        switch (name)
        {
            case "FINE":
                return fine;
            case "FINE LOAMY":
                return fine_loamy;
            case "LOAMY SKELETAL":
                return loamy_skeletal;
            case "COARSE LOAMY":
                return coarse_loamy;
            case "CLAYEY":
                return clayey;
            case "LOAMY":
                return loamy;
            case "CLAYEY SKELETAL":
                return clayey_skeletal;
            default:
                return null;
        }
    }
}

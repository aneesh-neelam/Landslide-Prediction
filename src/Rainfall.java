public enum Rainfall
{
    r1000_1200(0, "1000-1200"),
    r1200_1400(1, "1200-1400"),
    r1400_1600(2, "1400-1600"),
    r1600_2000(3, "1600-2000"),
    r2000_2400(4, "2000-2400"),
    r2400_2800(5, "2400-2800");

    public int code;
    public String name;

    public static int length = 6;

    private Rainfall(int code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public static Rainfall fromCode(int code)
    {
        switch (code)
        {
            case 0:
                return r1000_1200;
            case 1:
                return r1200_1400;
            case 2:
                return r1400_1600;
            case 3:
                return r1600_2000;
            case 4:
                return r2000_2400;
            case 5:
                return r2400_2800;
            default:
                return null;
        }
    }

    public static Rainfall fromName(String name)
    {
        switch (name)
        {
            case "1000-1200":
                return r1000_1200;
            case "1200-1400":
                return r1200_1400;
            case "1400-1600":
                return r1400_1600;
            case "1600-2000":
                return r1600_2000;
            case "2000-2400":
                return r2000_2400;
            case "2400-2800":
                return r2400_2800;
            default:
                return null;
        }
    }
}

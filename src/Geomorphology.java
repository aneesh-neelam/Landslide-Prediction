public enum Geomorphology
{
    ridge(0, "Ridge type Structural Hills (Large)"),
    hill(1, "Hilltop Weatered"),
    water(2, "Water Body Mask"),
    habitation(3, "Habitation Mask"),
    upper(4, "Upper Piedmont Slope"),
    valley(5, "Valley Fill/filled in valley"),
    intermontane(6, "Intermontane valley/Structural Valley (Large)"),
    shallow(7, "Shallow Flood Plain"),
    domeres(8, "Dome type Residual Hills"),
    domedenu(9, "Dome type Denudational Hills (Large)");

    public int code;
    public String name;

    public static int length = 10;

    private Geomorphology(int code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public static Geomorphology fromCode(int code)
    {
        switch (code)
        {
            case 0:
                return ridge;
            case 1:
                return hill;
            case 2:
                return water;
            case 3:
                return habitation;
            case 4:
                return upper;
            case 5:
                return valley;
            case 6:
                return intermontane;
            case 7:
                return shallow;
            case 8:
                return domeres;
            case 9:
                return domedenu;
            default:
                return null;
        }
    }

    public static Geomorphology fromName(String name)
    {
        switch (name)
        {
            case "Ridge type Structural Hills (Large)":
                return ridge;
            case "Hilltop Weatered":
                return hill;
            case "Water Body Mask":
                return water;
            case "Habitation Mask":
                return habitation;
            case "Upper Piedmont Slope":
                return upper;
            case "Valley Fill/filled in valley":
                return valley;
            case "Intermontane valley/Structural Valley (Large)":
                return intermontane;
            case "Shallow Flood Plain":
                return shallow;
            case "Dome type Residual Hills":
                return domeres;
            case "Dome type Denudational Hills (Large)":
                return domedenu;
            default:
                return null;
        }
    }
}

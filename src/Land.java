public enum Land
{
    agri(0, "Agriculture"),
    forscrub(1, "Scrub Forest"),
    landscrub(2, "Land with scrub"),
    plant(3, "Plantations"),
    villages(4, "Villages(Rural)"),
    reserv(5, "Reservoirs"),
    forplant(6, "Forest Plantations"),
    everg(7, "Open (Evergreen/Semi evergreen)"),
    resi(8, "Residential"),
    river(9, "River"),
    forblank(10, "Forest Blanks"),
    rabi(11, "Rabi(Crop land)"),
    barren(12, "Barren Rocky/Stony Waste"),
    dense(13, "Dense/Closed"),
    tanks(14, "Tanks"),
    current(15, "Current Fallow"),
    canal(16, "Canal"),
    indust(17, "Industrial"),
    crop(18, "Crop Land in Forest"),
    decid(19, "Open Deciduous (Moist/Dry)"),
    noscrub(20, "Land without scrub"),
    built(21, "Built up land"),
    recre(22, "Recreational"),
    lake(23, "Lakes/Ponds");

    public int code;
    public String name;

    public static int length = 24;

    private Land(int code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public static Land fromCode(int code)
    {
        switch (code)
        {
            case 0:
                return agri;
            case 1:
                return forscrub;
            case 2:
                return landscrub;
            case 3:
                return plant;
            case 4:
                return villages;
            case 5:
                return reserv;
            case 6:
                return forplant;
            case 7:
                return everg;
            case 8:
                return resi;
            case 9:
                return river;
            case 10:
                return forblank;
            case 11:
                return rabi;
            case 12:
                return barren;
            case 13:
                return dense;
            case 14:
                return tanks;
            case 15:
                return current;
            case 16:
                return canal;
            case 17:
                return indust;
            case 18:
                return crop;
            case 19:
                return decid;
            case 20:
                return noscrub;
            case 21:
                return built;
            case 22:
                return recre;
            case 23:
                return lake;
            default:
                return null;
        }
    }

    public static Land fromName(String name)
    {
        switch (name)
        {
            case "Agriculture":
                return agri;
            case "Scrub Forest":
                return forscrub;
            case "Land with scrub":
                return landscrub;
            case "Plantations":
                return plant;
            case "Villages(Rural)":
                return villages;
            case "Reservoirs":
                return reserv;
            case "Forest Plantations":
                return forplant;
            case "Open (Evergreen/Semi evergreen)":
                return everg;
            case "Residential":
                return resi;
            case "River":
                return river;
            case "Forest Blanks":
                return forblank;
            case "Rabi(Crop land)":
                return rabi;
            case "Barren Rocky/Stony Waste":
                return barren;
            case "Dense/Closed":
                return dense;
            case "Tanks":
                return tanks;
            case "Current Fallow":
                return current;
            case "Canal":
                return canal;
            case "Industrial":
                return indust;
            case "Crop Land in Forest":
                return crop;
            case "Open Deciduous (Moist/Dry)":
                return decid;
            case "Land without scrub":
                return noscrub;
            case "Built up land":
                return built;
            case "Recreational":
                return recre;
            case "Lakes/Ponds":
                return lake;
            default:
                return null;
        }
    }
}

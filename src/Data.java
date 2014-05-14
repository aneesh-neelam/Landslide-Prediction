/**
 * Created by Aneesh Neelam <neelam.aneesh@gmail.com> on 13/5/14.
 */

public class Data
{
    public static long total;

    public static int[] output_count = new int[Output.length];
    public static int[][] rainfall_count = new int[Output.length][Rainfall.length];
    public static int[][] soil_count = new int[Output.length][Soil.length];
    public static int[][] lineament_count = new int[Output.length][Lineament.length];
    public static int[][] rockname_count = new int[Output.length][RockName.length];
    public static int[][] slope_count = new int[Output.length][Slope.length];
    public static int[][] geomorphology_count = new int[Output.length][Geomorphology.length];
    public static int[][] land_count = new int[Output.length][Land.length];

    public static double[] output_prob = new double[Output.length];
    public static double[][] rainfall_prob = new double[Output.length][Rainfall.length];
    public static double[][] soil_prob = new double[Output.length][Soil.length];
    public static double[][] lineament_prob = new double[Output.length][Lineament.length];
    public static double[][] rockname_prob = new double[Output.length][RockName.length];
    public static double[][] slope_prob = new double[Output.length][Slope.length];
    public static double[][] geomorphology_prob = new double[Output.length][Geomorphology.length];
    public static double[][] land_prob = new double[Output.length][Land.length];
}

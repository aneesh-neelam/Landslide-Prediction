/**
 * Created by Aneesh Neelam <neelam.aneesh@gmail.com> on 13/5/14.
 */

public class Data
{
    public static int[] output_count = new int[Output.length];
    public static int[][] rainfall_count = new int[Output.length][Rainfall.length];
    public static int[][] soil_count = new int[Output.length][Soil.length];
    public static int[][] lineament_count = new int[Output.length][Lineament.length];
    public static int[][] rockname_count = new int[Output.length][RockName.length];
    public static int[][] slope_count = new int[Output.length][Slope.length];

    public double[] output_prob = new double[Output.length];
    public double[][] attribute_prob = new double[Output.length][];
}

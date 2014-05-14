/**
 * Created by Aneesh Neelam <neelam.aneesh@gmail.com> on 14/5/14.
 */

public class Calc
{
    public void calcTotalProb()
    {
        int total_prediction = 0;
        int total_rainfall = 0;
        int total_soil = 0;
        int total_lineament = 0;
        int total_rockname = 0;
        int total_slope = 0;
        int total_geomorphology = 0;
        int total_land = 0;
        for (int i = 0; i < Output.length; i++)
        {
            total_prediction = total_prediction + Data.output_count[i];
            Data.output_prob[i] = Data.output_count[i] / Data.total;
            for (int j = 0; j < Rainfall.length; j++)
            {
                total_rainfall = total_rainfall + Data.rainfall_count[i][j];
                Data.rainfall_prob[i][j] = Data.rainfall_count[i][j] / Data.output_count[i];
            }
            for (int j = 0; j < Soil.length; j++)
            {
                total_soil = total_soil + Data.soil_count[i][j];
                Data.soil_prob[i][j] = Data.soil_count[i][j] / Data.output_count[i];
            }
            for (int j = 0; j < Lineament.length; j++)
            {
                total_lineament = total_lineament + Data.lineament_count[i][j];
                Data.lineament_prob[i][j] = Data.lineament_count[i][j] / Data.output_count[i];
            }
            for (int j = 0; j < RockName.length; j++)
            {
                total_rockname = total_rockname + Data.rockname_count[i][j];
                Data.rockname_prob[i][j] = Data.rockname_count[i][j] / Data.output_count[i];
            }
            for (int j = 0; j < Slope.length; j++)
            {
                total_slope = total_slope + Data.slope_count[i][j];
                Data.slope_prob[i][j] = Data.slope_count[i][j] / Data.output_count[i];
            }
            for (int j = 0; j < Geomorphology.length; j++)
            {
                total_geomorphology = total_geomorphology + Data.geomorphology_count[i][j];
                Data.geomorphology_prob[i][j] = Data.geomorphology_count[i][j] / Data.output_count[i];
            }
            for (int j = 0; j < Land.length; j++)
            {
                total_land = total_land + Data.land_count[i][j];
                Data.land_prob[i][j] = Data.land_count[i][j] / Data.output_count[i];
            }
        }
        // TODO Prediction
        System.out.println("Total calculated from Output: " + total_prediction);
        System.out.println("Total calculated from Rainfall: " + total_rainfall);
        System.out.println("Total calculated from Soil: " + total_soil);
        System.out.println("Total calculated from Lineament: " + total_lineament);
        System.out.println("Total calculated from Rock Name: " + total_rockname);
        System.out.println("Total calculated from Slope: " + total_slope);
        System.out.println("Total calculated from Geomorphology: " + total_geomorphology);
        System.out.println("Total calculated from Land use/Land Cover: " + total_land);
    }
}

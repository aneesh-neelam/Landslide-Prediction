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
            Data.output_prob[i] = (double) Data.output_count[i] / (double) Data.total;
            for (int j = 0; j < Rainfall.length; j++)
            {
                total_rainfall = total_rainfall + Data.rainfall_count[i][j];
                Data.rainfall_prob[i][j] = (double) Data.rainfall_count[i][j] / (double) Data.output_count[i];
            }
            for (int j = 0; j < Soil.length; j++)
            {
                total_soil = total_soil + Data.soil_count[i][j];
                Data.soil_prob[i][j] = (double) Data.soil_count[i][j] / (double) Data.output_count[i];
            }
            for (int j = 0; j < Lineament.length; j++)
            {
                total_lineament = total_lineament + Data.lineament_count[i][j];
                Data.lineament_prob[i][j] = (double) Data.lineament_count[i][j] / (double) Data.output_count[i];
            }
            for (int j = 0; j < RockName.length; j++)
            {
                total_rockname = total_rockname + Data.rockname_count[i][j];
                Data.rockname_prob[i][j] = (double) Data.rockname_count[i][j] / (double) Data.output_count[i];
            }
            for (int j = 0; j < Slope.length; j++)
            {
                total_slope = total_slope + Data.slope_count[i][j];
                Data.slope_prob[i][j] = (double) Data.slope_count[i][j] / (double) Data.output_count[i];
            }
            for (int j = 0; j < Geomorphology.length; j++)
            {
                total_geomorphology = total_geomorphology + Data.geomorphology_count[i][j];
                Data.geomorphology_prob[i][j] = (double) Data.geomorphology_count[i][j] / (double) Data.output_count[i];
            }
            for (int j = 0; j < Land.length; j++)
            {
                total_land = total_land + Data.land_count[i][j];
                Data.land_prob[i][j] = (double) Data.land_count[i][j] / (double) Data.output_count[i];
            }
        }
    }
}

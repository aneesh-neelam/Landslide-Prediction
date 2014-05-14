import com.mongodb.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.UnknownHostException;

/**
 * Created by Aneesh Neelam <neelam.aneesh@gmail.com> on 21/4/14.
 */

public class GetData
{
    public void getNumber() throws UnknownHostException, ParseException
    {
        MongoClient mongoClient = new MongoClient("localhost"); // Connect to MongoDB
        DB db = mongoClient.getDB("landslide"); // Select DB
        DBCollection coll = db.getCollection("zones"); // Get Collection

        System.out.println("Total of " + coll.getCount() + " documents. \n"); // Get number of documents in collection

        JSONParser parser = new JSONParser();
        try (DBCursor cursor = coll.find())
        {
            while (cursor.hasNext())
            {
                DBObject tmp = cursor.next();

                JSONObject json = (JSONObject) (parser.parse(tmp.toString()));
                String prediction = json.get("Landslide_Prediction_output").toString();
                String rainfall = json.get("Rainfall").toString();
                String soil = json.get("Soil").toString();
                String lineament = json.get("Lineament").toString();
                String rock_name = json.get("Rock_name").toString();
                String slope = json.get("SLOPE").toString();
                // TODO other attributes
                int index = Output.fromName(prediction).code;
                int rainfall_index = Rainfall.fromName(rainfall).code;
                int soil_index = Soil.fromName(soil).code;
                int lineament_index = Lineament.fromName(lineament).code;
                int rockname_index = RockName.fromName(rock_name).code;
                int slope_index = Slope.fromName(slope).code;
                Data.output_count[index]++;
                Data.rainfall_count[index][rainfall_index]++;
                Data.soil_count[index][soil_index]++;
                Data.lineament_count[index][lineament_index]++;
                Data.rockname_count[index][rockname_index]++;
                Data.slope_count[index][slope_index]++;
            }
        }

        int total_prediction = 0;
        int total_rainfall = 0;
        int total_soil = 0;
        int total_lineament = 0;
        int total_rockname = 0;
        int total_slope = 0;
        for (int i = 0; i < Output.length; i++)
        {
            total_prediction = total_prediction + Data.output_count[i];
            for (int j = 0; j < Rainfall.length; j++)
            {
                total_rainfall = total_rainfall + Data.rainfall_count[i][j];

            }
            for (int j = 0; j < Soil.length; j++)
            {
                total_soil = total_soil + Data.soil_count[i][j];
            }
            for (int j = 0; j < Lineament.length; j++)
            {
                total_lineament = total_lineament + Data.lineament_count[i][j];
            }
            for (int j = 0; j < RockName.length; j++)
            {
                total_rockname = total_rockname + Data.rockname_count[i][j];
            }
            for (int j = 0; j < Slope.length; j++)
            {
                total_slope = total_slope + Data.slope_count[i][j];
            }
        }
        // TODO Prediction
        System.out.println("Total calculated from Output: " + total_prediction);
        System.out.println("Total calculated from Rainfall: " + total_rainfall);
        System.out.println("Total calculated from Soil: " + total_soil);
        System.out.println("Total calculated from Lineament: " + total_lineament);
        System.out.println("Total calculated from Rock Name: " + total_rockname);
        System.out.println("Total calculated from Slope: " + total_slope);
    }
}

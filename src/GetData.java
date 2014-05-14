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
    public void getCount() throws UnknownHostException, ParseException
    {
        MongoClient mongoClient = new MongoClient("localhost");
        DB db = mongoClient.getDB("landslide");
        DBCollection coll = db.getCollection("zones");
        Data.total = coll.getCount();
        System.out.println("Total of " + Data.total + " documents in collection. \n");

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
                String geomorphology = json.get("Geomorphology").toString();
                String land = json.get("Land use/land cover").toString();

                int index = Output.fromName(prediction).code;
                int rainfall_index = Rainfall.fromName(rainfall).code;
                int soil_index = Soil.fromName(soil).code;
                int lineament_index = Lineament.fromName(lineament).code;
                int rockname_index = RockName.fromName(rock_name).code;
                int slope_index = Slope.fromName(slope).code;
                int geomorphology_index = Geomorphology.fromName(geomorphology).code;
                int land_index = Land.fromName(land).code;

                Data.output_count[index]++;
                Data.rainfall_count[index][rainfall_index]++;
                Data.soil_count[index][soil_index]++;
                Data.lineament_count[index][lineament_index]++;
                Data.rockname_count[index][rockname_index]++;
                Data.slope_count[index][slope_index]++;
                Data.geomorphology_count[index][geomorphology_index]++;
                Data.land_count[index][land_index]++;
            }
        }

        mongoClient.close();
    }
}

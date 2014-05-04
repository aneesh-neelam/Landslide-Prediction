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

        int r1000_1200 = 0;
        int r1200_1400 = 0;
        int r1400_1600 = 0;
        int r1600_2000 = 0;
        int r2000_2400 = 0;
        int r2400_2800 = 0;

        int moderate = 0;
        int high = 0;
        int very_high = 0;
        int low = 0;
        int very_low = 0;
        try (DBCursor cursor = coll.find())
        {
            while (cursor.hasNext())
            {
                DBObject tmp = cursor.next();

                JSONObject json = (JSONObject) (parser.parse(tmp.toString()));
                String prediction = json.get("Landslide_Prediction_output").toString();
                String rainfall = json.get("Rainfall").toString();
                switch (prediction)
                {
                    case "very high":
                        high++;
                        break;
                    case "high":
                        very_high++;
                        break;
                    case "Moderate":
                        moderate++;
                        break;
                    case "low":
                        low++;
                        break;
                    case "very low":
                        very_low++;
                        break;
                    default:
                        System.out.println(prediction);
                        break;
                }
                switch (rainfall)
                {
                    case "1000-1200":
                        r1000_1200++;
                        break;
                    case "1200-1400":
                        r1200_1400++;
                        break;
                    case "1400-1600":
                        r1400_1600++;
                        break;
                    case "1600-2000":
                        r1600_2000++;
                        break;
                    case "2000-2400":
                        r2000_2400++;
                        break;
                    case "2400-2800":
                        r2400_2800++;
                        break;
                    default:
                        System.out.println(rainfall);
                        break;
                }

            }
        }
        int total_rainfall = r1000_1200 + r1200_1400 + r1400_1600 + r1600_2000 + r2000_2400 + r2400_2800;
        int total_prediction = very_high + high + moderate + low + very_low;
        System.out.println("\nRainfall: ");
        System.out.println("1000-1200: " + r1000_1200);
        System.out.println("1200-1400: " + r1200_1400);
        System.out.println("1400-1600: " + r1400_1600);
        System.out.println("1600-2000: " + r1600_2000);
        System.out.println("2000-2400: " + r2000_2400);
        System.out.println("2400-2800: " + r2400_2800);
        System.out.println("Total calculated: " + total_rainfall);
        System.out.println("\nPredicted Landslide Output: ");
        System.out.println("Very High: " + very_high);
        System.out.println("High: " + high);
        System.out.println("Moderate: " + moderate);
        System.out.println("Low: " + low);
        System.out.println("Very Low: " + very_low);
        System.out.println("Total calculated: " + total_prediction);
    }
}

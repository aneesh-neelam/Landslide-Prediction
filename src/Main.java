/**
 * Created by Aneesh Neelam <neelam.aneesh@gmail.com> on 18/4/14.
 */

import com.mongodb.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.UnknownHostException;

public class Main
{
    public static void main(String args[]) throws UnknownHostException, ParseException
    {
        MongoClient mongoClient = new MongoClient("localhost"); // Connect to MongoDB
        DB db = mongoClient.getDB("landslide"); // Select DB

        DBCollection coll = db.getCollection("zones"); // Get Collection
        System.out.println("Total of " + coll.getCount() + " documents. \n"); // Get number of documents in collection

        JSONParser parser = new JSONParser();

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
            }
        }
        int total = high + very_high + low + moderate;
        System.out.println("Very High: " + very_high);
        System.out.println("High: " + high);
        System.out.println("Moderate: " + moderate);
        System.out.println("Low: " + low);
        System.out.println("Very Low: " + very_low);
        System.out.println("Total calculated: " + total);
    }
}

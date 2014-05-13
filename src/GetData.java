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
                int index = Output.fromName(prediction).code;
                if (index < 0 || index > 5) System.out.println(index);
                Data.output_count[index]++;
            }
        }
        int total_prediction = 0;
        for (int i = 0; i < Output.length; i++)
        {
            total_prediction = total_prediction + Data.output_count[i];
        }
        System.out.println("\nPredicted Landslide Output: ");
        System.out.println("Very High: " + Data.output_count[0]);
        System.out.println("High: " + Data.output_count[1]);
        System.out.println("Moderate: " + Data.output_count[2]);
        System.out.println("Low: " + Data.output_count[3]);
        System.out.println("Very Low: " + Data.output_count[4]);
        System.out.println("Total calculated: " + total_prediction);
    }
}

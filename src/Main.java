import org.json.simple.parser.ParseException;

import java.net.UnknownHostException;

/**
 * Created by Aneesh Neelam <neelam.aneesh@gmail.com> on 18/4/14.
 */

public class Main
{
    public static void main(String args[]) throws UnknownHostException, ParseException
    {
        GetData gData = new GetData();
        gData.getNumber();
    }
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Kishore Narendran on 5/6/14.
 */
public class CsvReader
{
    String file;

    CsvReader(String file)
    {
        this.file = file;
    }

    public String[][] ParseData() throws IOException
    {
        ArrayList<String[]> Collection = new ArrayList<String[]>();
        int TupleLength = 0;
        int CollectionLength = 0;
        int i = 0, k = 1;
        String line;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            line = br.readLine();
            while ((line = br.readLine()) != null)
            {
                k = 1;
                String[] values = line.split(",");
                String[] CondensedValues = new String[10];
                CondensedValues[0] = values[0];
                for (i = 1; i < values.length - 1; i += 4)
                {
                    CondensedValues[k++] = values[i];
                }
                CondensedValues[k++] = values[values.length - 1];
                Collection.add(CondensedValues);
                TupleLength = k;
                CollectionLength++;
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Exception");
        }
        catch (IOException e)
        {
            System.out.println("IO Exception");
        }
        String TupleCollection[][] = new String[CollectionLength][TupleLength];
        Collection.toArray(TupleCollection);
        return TupleCollection;
    }
}

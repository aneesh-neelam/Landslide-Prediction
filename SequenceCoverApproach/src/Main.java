/**
 * Created by kishore on 5/6/14.
 */
import java.io.*;
import java.util.ArrayList;

public class Main {
    //Initializing Data Members
    String data[][], Rainfall[], Slope[], LandUse[], RockName[], Geomorphology[], Lineament[], Soil[], Zone[], PredictionOutput[];

    public void FindUniqueValues(String data[][]){

        ArrayList<String> RainfallTemp = new ArrayList<String>();
        ArrayList<String> SlopeTemp = new ArrayList<String>();
        ArrayList<String> LandUseTemp = new ArrayList<String>();
        ArrayList<String> RockNameTemp = new ArrayList<String>();
        ArrayList<String> GeomorphologyTemp = new ArrayList<String>();
        ArrayList<String> LineamentTemp = new ArrayList<String>();
        ArrayList<String> SoilTemp = new ArrayList<String>();
        ArrayList<String> ZoneTemp = new ArrayList<String>();
        ArrayList<String> PredictionOutputTemp = new ArrayList<String>();

        int m = data.length;
        int n = data[0].length;

        //Finding unique values for all the fields

        for(int i = 0; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                switch(j){
                    case 1:
                        if(!RainfallTemp.contains(data[i][j]))
                            RainfallTemp.add(data[i][j]);
                        break;
                    case 2:
                        if(!SlopeTemp.contains(data[i][j]))
                            SlopeTemp.add(data[i][j]);
                        break;
                    case 3:
                        if(!LandUseTemp.contains(data[i][j]))
                            LandUseTemp.add(data[i][j]);
                        break;
                    case 4:
                        if(!RockNameTemp.contains(data[i][j]))
                            RockNameTemp.add(data[i][j]);
                        break;
                    case 5:
                        if(!GeomorphologyTemp.contains(data[i][j]))
                            GeomorphologyTemp.add(data[i][j]);
                        break;
                    case 6:
                        if(!LineamentTemp.contains(data[i][j]))
                            LineamentTemp.add(data[i][j]);
                        break;
                    case 7:
                        if(!SoilTemp.contains(data[i][j]))
                            SoilTemp.add(data[i][j]);
                        break;
                    case 8:
                        if(!ZoneTemp.contains(data[i][j]))
                            ZoneTemp.add(data[i][j]);
                        break;
                    case 9:
                        if(!PredictionOutputTemp.contains(data[i][j]))
                            PredictionOutputTemp.add(data[i][j]);
                        break;
                }
            }
        }

        //Initializing arrays
        Rainfall = new String[RainfallTemp.size()];
        Slope = new String[SlopeTemp.size()];
        LandUse = new String[LandUseTemp.size()];
        RockName = new String[RockNameTemp.size()];
        Geomorphology = new String[GeomorphologyTemp.size()];
        Lineament = new String[LineamentTemp.size()];
        Soil = new String[SoilTemp.size()];
        Zone = new String[ZoneTemp.size()];
        PredictionOutput = new String[PredictionOutputTemp.size()];

        //Converting Lists to Arrays
        RainfallTemp.toArray(this.Rainfall);
        SlopeTemp.toArray(this.Slope);
        LandUseTemp.toArray(this.LandUse);
        RockNameTemp.toArray(this.RockName);
        GeomorphologyTemp.toArray(this.Geomorphology);
        LineamentTemp.toArray(this.Lineament);
        SoilTemp.toArray(this.Soil);
        ZoneTemp.toArray(this.Zone);
        PredictionOutputTemp.toArray(this.PredictionOutput);
    }
    public void readDataSet(String path)throws IOException{


        //Calling the CsvParser to obtain the required data
        CsvReader ob = new CsvReader("C:\\Users\\kishore\\Documents\\Projects\\LandslideClassificationDataMining\\landslide_zone.csv");
        data = ob.ParseData();

        //Calling the function to find all unique values
        FindUniqueValues(data);

        //Calling the print function
        print();
    }
    public void print(){

        for(String s:Rainfall)
            System.out.print(s+" ");
        System.out.println();
        for(String s:Slope)
            System.out.print(s+" ");
        System.out.println();
        for(String s:LandUse)
            System.out.print(s+" ");
        System.out.println();
        for(String s:RockName)
            System.out.print(s+" ");
        System.out.println();
        for(String s:Geomorphology)
            System.out.print(s+" ");
        System.out.println();
        for(String s:Lineament)
            System.out.print(s+" ");
        System.out.println();
        for(String s:Soil)
            System.out.print(s+" ");
        System.out.println();
        for(String s:Zone)
            System.out.print(s+" ");
        System.out.println();
        for(String s:PredictionOutput)
            System.out.print(s+" ");
        System.out.println();
    }
    public static void main(String args[])throws IOException{
        Main ob = new Main();
        ob.readDataSet("");
    }
}

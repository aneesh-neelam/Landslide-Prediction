import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.net.UnknownHostException;


public class Main
{
    public static void main(String args[]) throws UnknownHostException, ParseException
    {
        GetData getData = new GetData();
        getData.getCount();
        Calc calc = new Calc();
        calc.calcTotalProb();

        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                UI ui = new UI();
                ui.setVisible(true);
            }
        });
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UI extends JFrame
{
    public UI()
    {
        String rainfall[] = new String[Rainfall.length];
        String soil[] = new String[Soil.length];
        String lineament[] = new String[Lineament.length];
        String rock[] = new String[RockName.length];
        String slope[] = new String[Slope.length];
        String geomorphology[] = new String[Geomorphology.length];
        String land[] = new String[Land.length];

        double[] probability = new double[Output.length];

        for (int j = 0; j < Rainfall.length; j++)
        {
            rainfall[j] = Rainfall.fromCode(j).name;
        }
        for (int j = 0; j < Soil.length; j++)
        {
            soil[j] = Soil.fromCode(j).name;
        }
        for (int j = 0; j < Lineament.length; j++)
        {
            lineament[j] = Lineament.fromCode(j).name;
        }
        for (int j = 0; j < RockName.length; j++)
        {
            rock[j] = RockName.fromCode(j).name;
        }
        for (int j = 0; j < Slope.length; j++)
        {
            slope[j] = Slope.fromCode(j).name;
        }
        for (int j = 0; j < Geomorphology.length; j++)
        {
            geomorphology[j] = Geomorphology.fromCode(j).name;
        }
        for (int j = 0; j < Land.length; j++)
        {
            land[j] = Land.fromCode(j).name;
        }

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JComboBox rainfallBox = new JComboBox(rainfall);
        rainfallBox.setBounds(50, 40, 500, 30);
        rainfallBox.setSelectedIndex(0);

        JComboBox soilBox = new JComboBox(soil);
        soilBox.setBounds(50, 80, 500, 30);
        soilBox.setSelectedIndex(0);

        JComboBox lineaBox = new JComboBox(lineament);
        lineaBox.setBounds(50, 120, 500, 30);
        lineaBox.setSelectedIndex(0);

        JComboBox rockBox = new JComboBox(rock);
        rockBox.setBounds(50, 160, 500, 30);
        rockBox.setSelectedIndex(0);

        JComboBox slopeBox = new JComboBox(slope);
        slopeBox.setBounds(50, 200, 500, 30);
        slopeBox.setSelectedIndex(0);

        JComboBox geoBox = new JComboBox(geomorphology);
        geoBox.setBounds(50, 240, 500, 30);
        geoBox.setSelectedIndex(0);

        JComboBox landBox = new JComboBox(land);
        landBox.setBounds(50, 280, 500, 30);
        landBox.setSelectedIndex(0);

        JButton computeButton = new JButton("Predict Chance of Landslide");
        computeButton.setBounds(50, 340, 500, 30);
        computeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                int rai = rainfallBox.getSelectedIndex();
                int soi = soilBox.getSelectedIndex();
                int lin = lineaBox.getSelectedIndex();
                int roc = rockBox.getSelectedIndex();
                int slo = slopeBox.getSelectedIndex();
                int geo = geoBox.getSelectedIndex();
                int lan = landBox.getSelectedIndex();

                for (int i = 0; i < Output.length; i++)
                {
                    probability[i] = Data.rainfall_prob[i][rai] * Data.soil_prob[i][soi] * Data.lineament_prob[i][lin] * Data.rockname_prob[i][roc] * Data.slope_prob[i][slo] * Data.geomorphology_prob[i][geo] * Data.land_prob[i][lan];
                }

                double maxProb = 0;
                int index = 0;
                for (int i = 0; i < Output.length; i++)
                {
                    if (maxProb < probability[i])
                    {
                        maxProb = probability[i];
                        index = i;
                    }
                }

                String msgContent = "Predicted Chance of Landslide is " + Output.fromCode(index).name + ". \nWith a calculated value of " + maxProb + ". ";
                String msgTitle = "Landslide Prediction Output";
                System.out.println(msgContent + "\n");
                JOptionPane.showMessageDialog(panel,
                        msgContent,
                        msgTitle,
                        JOptionPane.PLAIN_MESSAGE);
            }
        });

        panel.add(rainfallBox);
        panel.add(soilBox);
        panel.add(lineaBox);
        panel.add(rockBox);
        panel.add(slopeBox);
        panel.add(geoBox);
        panel.add(landBox);
        panel.add(computeButton);

        setTitle("Bayesian Classification & Prediction");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

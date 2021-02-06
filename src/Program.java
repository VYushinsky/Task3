import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        try {
            String[] fileNames = new String[5];
            fileNames[0] = args[0] + "/Cash1.txt";
            fileNames[1] = args[0] + "/Cash2.txt";
            fileNames[2] = args[0] + "/Cash3.txt";
            fileNames[3] = args[0] + "/Cash4.txt";
            fileNames[4] = args[0] + "/Cash5.txt";

            ArrayList<ArrayList<Double>> cashes = new ArrayList<ArrayList<Double>>();

            for (int i = 0; i < fileNames.length; ++i) {
                File file = new File(fileNames[i]);
                FileReader fr = new FileReader(file);

                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();

                cashes.add(new ArrayList<Double>());

                while (line != null) {
                    String val = line.split(" ")[0];
                    val = val.substring(0, val.length() - 2);

                    cashes.get(i).add(Double.parseDouble(val));
                    line = reader.readLine();
                }
            }

            double[] results = new double[16];

            for (int t = 0; t < results.length; ++t) {
                for (int i = 0; i < cashes.size(); ++i) {
                    results[t] += cashes.get(i).get(t);
                }
            }
            double maxVal = Arrays.stream(results).max().getAsDouble();

            for (int i = 0; i < results.length; ++i) {
                if (results[i] == maxVal) {
                    System.out.println(i + 1);
                    break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
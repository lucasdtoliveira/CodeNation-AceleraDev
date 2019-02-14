import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CSVReader {

    public static void main(String[] args) {

        String csvFile = "/home/casper/codenation/java-3/src/main/resources/data.csv";
        String line = null;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                System.out.println("Country [code= " + country[14] + " , name=" + country[14] + "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
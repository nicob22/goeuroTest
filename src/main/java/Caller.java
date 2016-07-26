import model.City;
import utils.CSVWriter;
import utils.Requestor;

import java.io.IOException;
import java.util.List;

/**
 * Created by nico on 26.07.16.
 */
public class Caller {

    public static void main(String args[]) {

        if (args.length != 1) {
            System.out.println("Sorry only one string: <CITY>");
            System.exit(1);
        }

        String city = args[0];
        System.out.println(city);
        Requestor requestor = new Requestor();
        CSVWriter csvWriter = new CSVWriter();
        List<City> cities;

        try {
            cities = requestor.getObjects(city);
            csvWriter.writeCSV(cities, city);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

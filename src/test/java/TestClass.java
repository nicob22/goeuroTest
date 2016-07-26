import org.junit.Test;
import utils.CSVWriter;
import utils.Requestor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nico on 26.07.16.
 */
public class TestClass {

    @Test
    public void testCaller(){
        Requestor requestor = new Requestor();
        List<City> cities = new ArrayList<>();
        try {
            cities = requestor.getObjects("Berlin");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(cities);

        CSVWriter csvWriter = new CSVWriter();
        try {
            csvWriter.writeCSV(cities,"Berlin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

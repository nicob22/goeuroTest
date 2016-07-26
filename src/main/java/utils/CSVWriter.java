package utils;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import model.City;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


/**
 * Created by nico on 26.07.16.
 */

/**
 * This class writes the list of cities in a .csv file
 */
public class CSVWriter {

    private static CsvMapper mapper = new CsvMapper();

    CsvSchema schema = mapper.schemaFor(City.class).withHeader();

    /**
     * Writes the objects within {filename}.csv
     * @param objects @code List of cities
     * @param fileName name for the file csv
     * @throws IOException
     */
    public void writeCSV(List<City> objects, String fileName) throws IOException {
        if (objects == null) {
            System.out.println("List must not be null");
            System.exit(0);
        }

        CellProcessor[] processors = new CellProcessor[]{
                new NotNull(), // _id
                new NotNull(), // name
                new NotNull(), // type
                new ParseDouble(), // latitude
                new ParseDouble(), // longitude
        };

        ICsvBeanWriter beanWriter = null;
        try {
            beanWriter = new CsvBeanWriter(new FileWriter("target/" + fileName + ".csv"),
                    CsvPreference.STANDARD_PREFERENCE);

            // the header elements are used to map the bean values to each column (names must match)
            //_id, name, type, latitude, longitude
            final String[] header = new String[]{"_id", "name", "type", "latitude", "longitude"};

            // write the header
            beanWriter.writeHeader(header);

            // write the objects
            for (City city : objects) {
                beanWriter.write(city, header, processors);
            }

        } finally {
            if (beanWriter != null) {
                beanWriter.close();
            }
        }
    }
}

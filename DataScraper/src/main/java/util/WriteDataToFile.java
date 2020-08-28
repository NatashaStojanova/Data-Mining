package util;

import dto.CountryDateDTO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Natasha Stojanova
 */
public class WriteDataToFile {
    private final String[] HEADERS = {"COUNTRY", "COUNTRY_CODE", "PROVINCE", "CITY", "CITY_CODE", "LAT", "LON", "CONFIRMED", "DEATHS", "RECOVERED", "ACTIVE", "DATE"};
    private final String outputPath;

    public WriteDataToFile(String outputPath) {
        this.outputPath = outputPath;
    }

    public void writeToFile(List<CountryDateDTO> objects) throws IOException {
        File outputFile = new File(outputPath);
        if (!outputFile.exists() && !outputFile.createNewFile())
            throw new IOException();

        FileWriter out = new FileWriter(outputFile);
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(HEADERS))) {
            objects.forEach(country -> {
                try {
                    printer.printRecord(
                            country.getCountry(),
                            country.getCountryCode(),
                            country.getProvince(),
                            country.getCity(),
                            country.getCityCode(),
                            country.getLat(),
                            country.getLon(),
                            country.getConfirmed(),
                            country.getDeaths(),
                            country.getRecovered(),
                            country.getActive(),
                            country.getDate());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private StringBuilder extractObject(CountryDateDTO object) {
        StringBuilder stringObject = new StringBuilder();

        stringObject.append("\n");
        stringObject.append(object.getCountry())
                .append(";");
        stringObject.append(object.getCountryCode())
                .append(";");
        stringObject.append(object.getProvince())
                .append(";");
        stringObject.append(object.getCity())
                .append(";");
        stringObject.append(object.getCityCode())
                .append(";");
        stringObject.append(object.getLat())
                .append(";");
        stringObject.append(object.getLon())
                .append(";");
        stringObject.append(object.getConfirmed())
                .append(";");
        stringObject.append(object.getDeaths())
                .append(";");
        stringObject.append(object.getRecovered())
                .append(";");
        stringObject.append(object.getActive())
                .append(";");
        stringObject.append(object.getDate())
                .append(";");
        return stringObject;
    }
}

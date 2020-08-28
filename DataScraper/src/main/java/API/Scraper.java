package API;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.CountryDateDTO;
import util.WriteDataToFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Natasha Stojanova
 */
public class Scraper {
    private final String outputFilePath;
    private final WriteDataToFile writer;
    private String worldmeterApi =
            "https://api.covid19api.com/country/";

    public Scraper(String outputFilePath, String country) {
        this.outputFilePath = outputFilePath;
        this.worldmeterApi += country;
        this.writer = new WriteDataToFile(this.outputFilePath);
    }

    public void fetchDataFromTo(ZonedDateTime from, ZonedDateTime to) throws IOException {
        URL url = new URL(worldmeterApi);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        con.addRequestProperty("from", from.toString());
        con.addRequestProperty("to", to.toString());

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            content.append(inputLine);
        in.close();

        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> responseJson =
                mapper
                        .readValue(content.toString(), new TypeReference<List<Map<String, String>>>() {
                        });
        List<CountryDateDTO> countryDateDTOS = new ArrayList<>();
        responseJson.forEach(map -> countryDateDTOS.add(new CountryDateDTO(map)));
        writer.writeToFile(countryDateDTOS);
    }
}

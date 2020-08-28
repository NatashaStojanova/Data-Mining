import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Scanner;

/**
 * @author Natasha Stojanova
 */
public class Wrapper {
    public static void main(String[] args) throws IOException {
        System.out.println("WorldMeter COVID-19 Country Data Scrapper by Natasha Stojanova\n");

        System.out.println("===============================================\n");
        System.out.println("Enter country name: (Example: macedonia | south-africa | . . .");
        Scanner in = new Scanner(System.in);
        String country = in.nextLine();

        System.out.println("===============================================\n");
        System.out.println("Enter output path:");
        String outputPath = in.nextLine();
        DataScraper scraper = new DataScraper(outputPath, country);

        System.out.println("===============================================\n");
        System.out.println("Enter date FROM: (Format YYYY-MM-DD, example: 2020-01-01");
        String dateFrom = in.nextLine();

        System.out.println("===============================================\n");
        System.out.println("Enter date TO: (Format YYYY-MM-DD, example: 2020-02-02");
        String dateTo = in.nextLine();

        scraper.getScraper()
                .fetchDataFromTo(ZonedDateTime.parse(dateFrom + "T00:00:00Z"),
                        ZonedDateTime.parse(dateTo + "T00:00:00Z"));

        System.out.println("===============================================\n");
        System.out.println("Successfully extracted data from WorldMeter, check out your file -> " + outputPath);
    }
}

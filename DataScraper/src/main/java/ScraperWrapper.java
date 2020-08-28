import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Scanner;

/**
 * @author Natasha Stojanova
 */
public class ScraperWrapper {
    public static void main(String[] args) throws IOException {
        System.out.println("\u001b[35;1mWorldMeter COVID-19 Country Data Scrapper by Natasha Stojanova\u001b[0m\n\n");
        System.out.println("\u001b[32;1m[SCRAPER WRAPPER]Initialization complete\u001b[0m");

        System.out.println("===============================================\n");
        System.out.println("Enter country name: (Example: macedonia | south-africa | . . .)");
        Scanner in = new Scanner(System.in);
        String country = in.nextLine();

        System.out.println("===============================================\n");
        System.out.println("Enter output path:");
        String outputPath = in.nextLine();
        DataScraper scraper = new DataScraper(outputPath, country);

        System.out.println("===============================================\n");
        System.out.println("Enter date FROM: (Format YYYY-MM-DD, example: 2020-01-01)");
        String dateFrom = in.nextLine();

        System.out.println("===============================================\n");
        System.out.println("Enter date TO: (Format YYYY-MM-DD, example: 2020-02-02)");
        String dateTo = in.nextLine();

        System.out.println("\u001b[32;1mExecution start\u001b[0m");
        scraper.getScraper()
                .fetchDataFromTo(ZonedDateTime.parse(dateFrom + "T00:00:00Z"),
                        ZonedDateTime.parse(dateTo + "T00:00:00Z"));

        System.out.println("===============================================\n");
        System.out.println("\u001b[32;1m[SCRAPER WRAPPER]Successfully extracted data from WorldMeter, check out your file -> " + outputPath);
        System.out.println("\u001b[32;1mExecution complete\u001b[0m");
    }
}

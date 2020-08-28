import API.Scraper;

/**
 * @author Natasha Stojanova
 */
public class DataScraper {
    private final Scraper scraper;

    public DataScraper(String outputPath, String country) {
        this.scraper = new Scraper(outputPath, country);
    }

    public Scraper getScraper() {
        return scraper;
    }
}

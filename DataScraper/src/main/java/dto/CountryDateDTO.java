package dto;

import java.time.ZonedDateTime;
import java.util.Map;

/**
 * @author Natasha Stojanova
 */
public class CountryDateDTO {
    private String Country;
    private String CountryCode;
    private String Province;
    private String City;
    private String CityCode;
    private String Lat;
    private String Lon;
    private String Confirmed;
    private String Deaths;
    private String Recovered;
    private String Active;
    private String Date;

    public CountryDateDTO(Map<String, String> jsonObject) {
        Country = jsonObject.get("Country");
        CountryCode = jsonObject.get("CountryCode");
        Province = jsonObject.get("Province");
        City = jsonObject.get("City");
        CityCode = jsonObject.get("CityCode");
        Lat = jsonObject.get("Lat");
        Lon = jsonObject.get("Lon");
        Confirmed = jsonObject.get("Confirmed");
        Deaths = jsonObject.get("Deaths");
        Recovered = jsonObject.get("Recovered");
        Active = jsonObject.get("Active");
        Date = ZonedDateTime.parse(jsonObject.get("Date")).toLocalDate().toString();
    }

    public String[] getData() {
        return new String[]{
                this.getCountry(),
                this.getCountryCode(),
                this.getProvince(),
                this.getCity(),
                this.getCityCode(),
                this.getLat(),
                this.getLon(),
                this.getConfirmed(),
                this.getDeaths(),
                this.getRecovered(),
                this.getActive(),
                this.getDate()
        };
    }

    public String getCountry() {
        return Country;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public String getProvince() {
        return Province;
    }

    public String getCity() {
        return City;
    }

    public String getCityCode() {
        return CityCode;
    }

    public String getLat() {
        return Lat;
    }

    public String getLon() {
        return Lon;
    }

    public String getConfirmed() {
        return Confirmed;
    }

    public String getDeaths() {
        return Deaths;
    }

    public String getRecovered() {
        return Recovered;
    }

    public String getActive() {
        return Active;
    }

    public String getDate() {
        return Date;
    }

    @Override
    public String toString() {
        return "CountryDateDTO{" +
                "Country='" + Country + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                ", Province='" + Province + '\'' +
                ", City='" + City + '\'' +
                ", CityCode='" + CityCode + '\'' +
                ", Lat='" + Lat + '\'' +
                ", Lon='" + Lon + '\'' +
                ", Confirmed=" + Confirmed +
                ", Deaths=" + Deaths +
                ", Recovered=" + Recovered +
                ", Active=" + Active +
                ", Date=" + Date +
                "\n\n";
    }
}

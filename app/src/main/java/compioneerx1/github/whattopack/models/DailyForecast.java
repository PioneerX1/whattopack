package compioneerx1.github.whattopack.models;


public class DailyForecast {
    private String mCity;
    private String mCountry;

    private String mDate;  // will need to parse to Double or Long, convert from Unix, then convert to String
    private String mLowTemp;
    private String mHighTemp;
    private String mHumidity;
    private String mConditions;

    // other metrics we can grab, but enough for now

    public DailyForecast(String city, String country, String date, String lowTemp, String highTemp, String humidity, String conditions) {
        this.mCity = city;
        this.mCountry = country;
        this.mDate = date;
        this.mLowTemp = lowTemp;
        this.mHighTemp = highTemp;
        this.mHumidity = humidity;
        this.mConditions = conditions;
    }

    // Getter Methods

    public String getCity() {
        return mCity;
    }

    public String getCountry() {
        return mCountry;
    }

    public String getDate() {
        return mDate;
    }

    public String getLowTemp() {
        return mLowTemp;
    }

    public String getHighTemp() {
        return mHighTemp;
    }

    public String getHumidity() {
        return mHumidity;
    }

    public String getConditions() {
        return mConditions;
    }

}

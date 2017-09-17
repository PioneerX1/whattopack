package compioneerx1.github.whattopack.models;


import compioneerx1.github.whattopack.R;

public class DailyForecast {
    private String mCity;
    private String mCountry;
    private String mDate;  // will need to parse to Double or Long, convert from Unix, then convert to String
    private float mLowTemp;
    private float mHighTemp;
    private int mHumidity;
    private String mConditions;
    private float mWindSpeed;
    private int mCloudiness;

    // member variables that get created after instantiation
    //private String mIconPath;
    private int mIconPath;


    public DailyForecast(String city, String country, String date, String lowTemp, String highTemp,
                         String humidity, String conditions, String windSpeed, String cloudiness) {
        this.mCity = city;
        this.mCountry = country;
        this.mDate = date;
        this.mLowTemp = Float.parseFloat(lowTemp);
        this.mHighTemp = Float.parseFloat(highTemp);
        this.mHumidity = Integer.parseInt(humidity);
        this.mConditions = conditions;
        this.mWindSpeed = Float.parseFloat(windSpeed);
        this.mCloudiness = Integer.parseInt(cloudiness);

        createIconPath();

    }

    public void createIconPath() {
        if (this.mConditions.contains("rain")) {
            mIconPath = R.drawable.rain;
        } else {
            mIconPath = R.drawable.sun;
        }

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

    public float getLowTemp() {
        return mLowTemp;
    }

    public float getHighTemp() {
        return mHighTemp;
    }

    public int getHumidity() {
        return mHumidity;
    }

    public String getConditions() {
        return mConditions;
    }

    public float getWindSpeed() { return mWindSpeed; }

    public int getCloudiness() { return mCloudiness; }


    public int getIconPath() { return mIconPath; }

}

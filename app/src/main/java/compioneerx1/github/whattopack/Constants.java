package compioneerx1.github.whattopack;


public class Constants {

    public static final String API_KEY = BuildConfig.API_KEY;  // actual API key exists in Gradle Properties file
    public static final String API_BASE_URL = "https://api.openweathermap.org/data/2.5/forecast/daily?";
    public static final String LOCATION_QUERY_PARAMETER = "q";  // this is OpenWeather location query key
    public static final String NUMBER_OF_DAYS_PARAMETER = "cnt";  // will set this to the max - 17
    public static final String API_KEY_QUERY_PARAMETER = "appid";

    // working call in Postman:
    // api.openweathermap.org/data/2.5/forecast/daily?q=seattle&cnt=17&appid=c109379d321012346a8b0e6bdea99879
    // NOTE: country parameter is not needed at all

}

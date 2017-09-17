package compioneerx1.github.whattopack.services;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import compioneerx1.github.whattopack.Constants;
import compioneerx1.github.whattopack.models.DailyForecast;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OpenWeatherService {

    public static final String TAG = OpenWeatherService.class.getSimpleName();


    // method processes JSON data results from API
    public ArrayList<DailyForecast> processResults(Response response) {

        ArrayList<DailyForecast> forecasts = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject openWeatherJSON = new JSONObject(jsonData);
                // only need to pull city and country for object ones
                String city = openWeatherJSON.getJSONObject("city").getString("name");
                String country = openWeatherJSON.getJSONObject("city").getString("country");

                // loop through LIST in JSON data and grab info for every daily forecast
                JSONArray forecastsJSON = openWeatherJSON.getJSONArray("list");
                for (int i = 0; i < forecastsJSON.length(); i++) {
                    JSONObject forecastJSON = forecastsJSON.getJSONObject(i);

                    // grab Unix date string, convert to Long, convert to normal format string
                    String date = forecastJSON.getString("dt");
                    String formattedDate = formatDate(date);

                    // other member variables of forecast object
                    String lowTemp = forecastJSON.getJSONObject("temp").getString("min");
                    String highTemp = forecastJSON.getJSONObject("temp").getString("max");
                    String humidity = forecastJSON.getString("humidity");
                    JSONArray weatherDetailsJSON = forecastJSON.getJSONArray("weather");
                    String conditions = weatherDetailsJSON.getJSONObject(0).getString("description");

                    // create new daily forecast object, add it to ArrayList of daily forecasts
                    DailyForecast newForecast = new DailyForecast(city, country, formattedDate, lowTemp, highTemp, humidity, conditions);
                    forecasts.add(newForecast);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.v(TAG, "LOCATION: " + forecasts.get(0).getCity() + ", " + forecasts.get(0).getCountry());
        Log.v(TAG, "--------------");

        for (int k = 0; k < forecasts.size(); k++) {
            Log.v(TAG, "DATE: " + forecasts.get(k).getDate());
            Log.v(TAG, "LOW TEMP: " + forecasts.get(k).getLowTemp());
            Log.v(TAG, "HIGH TEMP: " + forecasts.get(k).getHighTemp());
            Log.v(TAG, "HUMIDITY: " + forecasts.get(k).getHumidity() + "%");
            Log.v(TAG, "CONDITIONS: " + forecasts.get(k).getConditions());
            Log.v(TAG, "----");
        }
        return forecasts;
    }

    // format the date for DailyForecast object
    public String formatDate(String date) {
        long unixDate = Long.parseLong(date);
        Date newDate = new Date(unixDate * 1000);  // convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MM/dd/yyyy");
        sdf.setTimeZone(TimeZone.getDefault());
        String formattedDate = sdf.format(newDate);
        return formattedDate;
    }


    // method that actually pulls data from Open Weather API
    public static void findWeather(String location, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.LOCATION_QUERY_PARAMETER, location);
        urlBuilder.addQueryParameter(Constants.NUMBER_OF_DAYS_PARAMETER, "17");  // max number of days to forecast

        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY);
        String url = urlBuilder.build().toString();

        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }


}

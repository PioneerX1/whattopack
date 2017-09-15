package compioneerx1.github.whattopack.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import compioneerx1.github.whattopack.R;  // imported when R was red, after files were moved

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import compioneerx1.github.whattopack.models.DailyForecast;

public class ForecastListAdapter extends RecyclerView.Adapter<ForecastListAdapter.ForecastViewHolder> {

    private ArrayList<DailyForecast> mForecasts = new ArrayList<>();
    private Context mContext;

    public ForecastListAdapter(Context context, ArrayList<DailyForecast> forecasts) {
        mContext = context;
        mForecasts = forecasts;
    }

    @Override
    public ForecastListAdapter.ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_list_item, parent, false);
        ForecastViewHolder viewHolder = new ForecastViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastListAdapter.ForecastViewHolder holder, int position) {
        holder.bindForecast(mForecasts.get(position));
    }

    @Override
    public int getItemCount() {
        return mForecasts.size();
    }


    public class ForecastViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.weatherImageView) ImageView mWeatherImageView;
        @Bind(R.id.dateTextView) TextView mDateTextView;
        @Bind(R.id.conditionsTextView) TextView mConditionsTextView;
        @Bind(R.id.recommendationTextView) TextView mRecommendationTextView;

        private Context mContext;

        public ForecastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindForecast(DailyForecast forecast) {
            mDateTextView.setText(forecast.getDate());
            mConditionsTextView.setText(forecast.getConditions());
            mRecommendationTextView.setText("This is where the recommendation will go.");
        }

    }

}

package com.softwareit.weather_custom_view.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.softwareit.weather_custom_view.R
import com.softwareit.weather_custom_view.databinding.ViewCityWeatherBinding

class CityWeatherView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding = ViewCityWeatherBinding.inflate(LayoutInflater.from(context), this)

    init {
        setAttrs(attrs, R.styleable.CityWeatherView) {
            binding.degree.text = it.getString(R.styleable.CityWeatherView_temperature) + "°"
            binding.weatherText.text = getPrecipitationType(
                precipitationType = it.getInt(R.styleable.CityWeatherView_precipitationType, 0)
            )
            binding.weatherIcon.setImageResource(
                getResImage(
                    precipitationType = it.getInt(R.styleable.CityWeatherView_precipitationType, 0),
                    isDay = it.getInt(R.styleable.CityWeatherView_dayNight, 0) == 0,
                )
            )
            binding.windy.text = getWindy(
                it.getBoolean(R.styleable.CityWeatherView_windy, false),
            )
            binding.location.text = getLocation(
                city = it.getString(R.styleable.CityWeatherView_cityName),
                country = it.getString(R.styleable.CityWeatherView_country),
            )
        }
    }

    // Вместо снега можно использовать картинки дождя
    private fun getResImage(precipitationType: Int, isDay: Boolean): Int {
        return when {
            precipitationType == 1 && isDay -> R.drawable.ic_rain_day
            precipitationType == 2 && isDay -> R.drawable.ic_rain_day
            precipitationType == 3 && isDay -> R.drawable.ic_rain_day  // should be ic_snow_day
            precipitationType == 4 && isDay -> R.drawable.ic_rain_day  // should be ic_snow_day
            precipitationType == 1 && !isDay -> R.drawable.ic_rain_night
            precipitationType == 2 && !isDay -> R.drawable.ic_rain_night
            precipitationType == 3 && !isDay -> R.drawable.ic_rain_night  // should be ic_snow_night
            precipitationType == 4 && !isDay -> R.drawable.ic_rain_night  // should be ic_snow_night
            else -> -1
        }
    }

    private fun getPrecipitationType(precipitationType: Int): String {
        return when (precipitationType) {
            1 -> "Light Rain"
            2 -> "Heavy Rain"
            3 -> "Light Snow"
            4 -> "Heavy Snow"
            else -> "No precipitation"
        }
    }

    private fun getWindy(isWindy: Boolean) = "Windy: $isWindy"

    private fun getLocation(city: String?, country: String?) = "$city, $country"
}
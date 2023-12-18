This Java project analyzes weather data for various U.S. cities using an OpenWeatherMap API. The project is divided into three classes:

Main Class (Main):

Retrieves weather data for a list of U.S. cities.
Performs various analyses on the weather data, including finding the hottest and coldest stations, identifying stations with consecutive rain, detecting stations with a temperature increase, calculating average statistics by month, and determining the windiest month.
Outputs the results for each city.
Weather API Class (WeatherApi):

Manages the interaction with the OpenWeatherMap API to fetch weather data for a specific city.
Parses the JSON response from the API to extract relevant weather information.
Provides methods for data analysis, such as finding the hottest and coldest stations, stations with consecutive rain, stations with temperature increases, average statistics by month, and the windiest month.
Weather Data Class (WeatherData):

Represents a data structure for storing weather information, including temperature, humidity, precipitation, and wind speed.
The project aims to offer insights into weather patterns, including temperature variations, rain patterns, and wind speeds for different U.S. cities. It uses the OpenWeatherMap API to obtain real-time weather data and performs various analyses to present meaningful information for each city.

package com.my.datastrcture.interview;
/*Use the HTTP Get method to retrieve information from a database of weather records. Query https://jsonmock.hackerrank.com/api/weather/search?name={Keyword} to search all the records where name has a keyword anywhere in its string value. The query result is paginated and can be further accessed by appending to the query string &page=num where num is the page number.

The query response from the API is a json with the following five fields:
*page: the current page
*per_page: the maximum number of results per page
*total: the total number of records in the search result.
*total_pages: the total number of pages to query to get all the result
* data: an array of json objects that contain weather records

The data field in the response contains a list of weather records with the following schema:
*name: the name of the city
*weather: temperature recorded
*status: an array of wind speed and humidity records

Filter records to include a given keyword in the name parameter. Return an array such that each element is a string of comma separated values: City_name, temperature, wind, humidity
for Example
{
  "name": "Adelaide",
  "weather": "15 degree",
  "status": [
    "Wind: 8Kmph",
    "Humidity: 61%"
  ]
}

The JSON record is stored as Adelaide, 15,8,61

Return the list sorted by city name

*/

/*import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;*/

class Delivro {

    /*
     * Complete the 'weatherStation' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING keyword as parameter.
     *
     * Base URL: https://jsonmock.hackerrank.com/api/weather/search?name={keyword}
     *
     */

    /*public static List<String> weatherStation(String keyword) {
        List<String> results = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        JSONParser parser = new JSONParser();
        int currentPage = 1;

        while (true) {
            String url = "https://jsonmock.hackerrank.com/api/weather/search?name=" + keyword + "&page=" + currentPage;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                JSONObject jsonResponse = (JSONObject) parser.parse(response.body());

                long totalPages = (long) jsonResponse.get("total_pages");
                JSONArray data = (JSONArray) jsonResponse.get("data");

                // Process each weather record in the data array
                for (Object obj : data) {
                    JSONObject cityData = (JSONObject) obj;
                    String cityName = (String) cityData.get("name");
                    String weather = (String) cityData.get("weather");
                    JSONArray status = (JSONArray) cityData.get("status");

                    // Extract wind and humidity
                    String wind = "", humidity = "";
                    for (Object stat : status) {
                        String statStr = (String) stat;
                        if (statStr.startsWith("Wind:")) {
                            wind = statStr.replace("Wind:", "").replace("Kmph", "").trim();
                        } else if (statStr.startsWith("Humidity:")) {
                            humidity = statStr.replace("Humidity:", "").replace("%", "").trim();
                        }
                    }

                    // Format the entry without extra spaces
                    String formattedEntry = String.join(",", cityName, weather.replace(" degree", ""), wind, humidity);
                    results.add(formattedEntry);
                }

                // Check if all pages are processed
                if (currentPage >= totalPages) {
                    break;
                }
                currentPage++;
            } catch (IOException | InterruptedException | ParseException e) {
                e.printStackTrace();
            }
        }

        // Sort results by city name
        Collections.sort(results, Comparator.comparing(s -> s.split(",")[0].trim()));

        // Return result list or an empty list if no results
        return results.isEmpty() ? List.of("No data found") : results;
    }*/
}

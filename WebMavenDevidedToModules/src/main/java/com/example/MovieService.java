package com.example;

import org.json.simple.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class MovieService {
    public static List<List<String>> getListOfMovies(String searchContent) throws IOException {

//      Creating URL
        String url =
                "https://api.themoviedb.org/3/search/multi?api_key=61e41749121c5773a09486089736d866&language=en-US&query=" + searchContent;
        URL object = new URL(url);

//      Creating connection
        HttpURLConnection con = (HttpURLConnection) object.openConnection();
        int responseCode = con.getResponseCode();
//      Checking if connection works
        System.out.println("Sending GET request to url: " + url);
        System.out.println("Response code: " + responseCode + ", 200 = good");

        if (responseCode == 200) {
//          Creating Buffered reader from connection
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

//          Closing buffered reader
            in.close();

            System.out.println(response + "\n");
            JSONObject jsonObject = (JSONObject) JSONValue.parse(String.valueOf(response));
            JSONArray searchObjects = (JSONArray) jsonObject.get("results");

            List<List<String>> listOfMovies = new ArrayList<>();

            for (Object searchObject : searchObjects) {
                JSONObject movieName = (JSONObject) searchObject;
                List<String> movieInfo = new ArrayList<>();
                movieInfo.add("https://image.tmdb.org/t/p/original" + movieName.get("poster_path"));
                if (movieName.get("original_title") == null) {
                    movieInfo.add((String) movieName.get("original_name"));
                } else {
                    movieInfo.add((String) movieName.get("original_title"));
                }

                if (movieName.get("release_date") != null) {
                    movieInfo.add((String) movieName.get("release_date"));
                } else {
                    movieInfo.add("");
                }
                movieInfo.add((String) movieName.get("overview"));
                listOfMovies.add(movieInfo);
            }

            for (List<String> listOfMovie : listOfMovies) {
                System.out.println(listOfMovie.get(1));
            }

            return listOfMovies;
        }
        return null;
    }

}


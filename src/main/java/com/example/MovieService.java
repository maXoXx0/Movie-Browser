package com.example;



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MovieService {
        public static List<List<String>> movieListCreator(List<List<String>> movieList, String searchContent) throws IOException {

//          Creating URL
            String url =
                    "https://api.themoviedb.org/3/search/multi?api_key=61e41749121c5773a09486089736d866&language=en-US&query=" + searchContent;
            URL object = new URL(url);

//          Creating connection
            HttpURLConnection con = (HttpURLConnection) object.openConnection();
            int responseCode = con.getResponseCode();
//          Checking if connection works
            System.out.println("Sending GET request to url: " + url);
            System.out.println("Response code: " + responseCode + ", 200 = good");

//          Creating Buffered reader from connection
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
//          Closing buffered reader
            in.close();


            System.out.println(response + "\n");

            JSONObject obj = (JSONObject) JSONValue.parse(String.valueOf(response));
            JSONObject jsonObject = obj;

            JSONArray searchObjects = (JSONArray) jsonObject.get("results");
//        System.out.println(searchObjects.get(0));


            for (int i = 0; i < searchObjects.size(); i++) {
                JSONObject movieName = (JSONObject) searchObjects.get(i);
                List<String> movieInfo = new ArrayList<>();
//                System.out.println(movieName);
//                System.out.println(movieName.get("original_title"));
                movieInfo.add("https://image.tmdb.org/t/p/original" + movieName.get("poster_path"));
                if (movieName.get("original_title") == null){
                    movieInfo.add((String) movieName.get("original_name"));
                }else{
                    movieInfo.add((String) movieName.get("original_title"));
                }

                if (movieName.get("release_date") != null) {
                    movieInfo.add((String) movieName.get("release_date"));
                }else{
                    movieInfo.add("");
                }
                movieInfo.add((String) movieName.get("overview"));


                movieList.add(movieInfo);


            }



            for (int i = 0; i < movieList.size(); i++) {
                System.out.println(movieList.get(i).get(1));
            }



            return movieList;
        }


}

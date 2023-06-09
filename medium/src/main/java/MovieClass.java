package main.java;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.*;

public class MovieClass {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String substr = sc.next();
        sc.close();

        System.out.println(getNumberOfMovies(substr));

    }
    public static int getNumberOfMovies(String substr) throws IOException {
        //Method 1: Using java.net.HttpURLConnection
        int count =0;
        int page = 1;
        int totalPages = 1;
        String _url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr;
        URL url;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        HttpURLConnection connection = null;
        JsonObject jsonResponse;
        JsonArray data;
        String inputLine;
        Gson gson = new Gson();

        try {
            do {
                url = new URL(_url+ "&page="+page);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");// default is GET method

                if(connection.getResponseCode()!=200){return count;}

                inputStreamReader = new InputStreamReader(connection.getInputStream());
                reader = new BufferedReader(inputStreamReader);
                    while ((inputLine = reader.readLine()) != null) {
                        jsonResponse = gson.fromJson(inputLine, JsonObject.class);
                        //System.out.println(jsonResponse);

                        page = jsonResponse.get("page").getAsInt();
                        totalPages = jsonResponse.get("total_pages").getAsInt();

                        data= jsonResponse.getAsJsonArray("data");
                        count+= data.size();
                    }
                page++;
                inputStreamReader.close();
                reader.close();
            }while (page < totalPages);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        return count;
    }
}

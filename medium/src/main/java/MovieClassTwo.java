package main.java;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MovieClassTwo {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String substr = sc.next();
        sc.close();

        System.out.println(getNumberOfMovies(substr));

    }
    public static int getNumberOfMovies(String substr) throws IOException {
        int count =0;
        int page = 1;
        int totalPages = 1;

        do {

            String _url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + page;
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest pageRequest = HttpRequest
                    .newBuilder()
                    .uri(URI.create(_url))
                    .GET()
                    .timeout(Duration.of(5, ChronoUnit.SECONDS))
                    .build();

            String response = httpClient.sendAsync(pageRequest, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .join();

            JsonObject jsonResponse = new Gson().fromJson(response, JsonObject.class);
            page = jsonResponse.get("page").getAsInt();
            totalPages = jsonResponse.get("total_pages").getAsInt();
            JsonArray data= jsonResponse.getAsJsonArray("data");
            count+= data.size();
            page++;
        }while(page<totalPages);

        return count;
    }

}

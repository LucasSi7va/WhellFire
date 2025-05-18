package org.ProjetoBloco.API;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.ProjetoBloco.bikes.Bikes;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ApiDeBikes {

    private final HttpClient client = HttpClient.newHttpClient();

    public List<Bikes> buscarBikes() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/bikes"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            return gson.fromJson(response.body(), new TypeToken<List<Bikes>>(){}.getType());

        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}


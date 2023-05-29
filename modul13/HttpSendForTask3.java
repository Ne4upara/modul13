package ua.goit.sergey.modul13;

import com.google.gson.Gson;
import ua.goit.sergey.modul13.todo.UserForTaskTwo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpSendForTask3 {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    public static void openTaskForUser (int id) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users/" + id + "/todos"))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        UserForTaskTwo[] userOpenTasks = GSON.fromJson(response.body(), UserForTaskTwo[].class);
        int i = 1;
        for (UserForTaskTwo userOpenTask : userOpenTasks){
            if (userOpenTask.getCompleted().equals("false")){
                System.out.println(i + ". " + userOpenTask.getTitle());
                i++;
            }
        }
    }
}

package core;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;

public class Client {

    HttpClient client = HttpClient.newHttpClient();

    public HttpResponse<String> get(String url) throws ExecutionException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get();
    }

    public HttpResponse<String> post(String url, String data) throws ExecutionException, InterruptedException {
        return postOrPutOrPatch("POST", url, data);
    }

    public HttpResponse<String> put(String url, String data) throws ExecutionException, InterruptedException {
        return postOrPutOrPatch("PUT", url, data);
    }

    public HttpResponse<String> patch(String url, String data) throws ExecutionException, InterruptedException {
        return postOrPutOrPatch("PATCH", url, data);
    }

    private HttpResponse<String> postOrPutOrPatch(String method, String url, String data) throws ExecutionException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .method(method, HttpRequest.BodyPublishers.ofString(data))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get();
    }

    public HttpResponse<String> delete(String url) throws ExecutionException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method("DELETE", HttpRequest.BodyPublishers.noBody())
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get();
    }

}

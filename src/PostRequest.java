import java.io.FileNotFoundException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class PostRequest {
    public static final String URL_POST = "http://httpbin.org/forms/post";
    public static final String JSON_POST = "C:\\Java\\Projetos JAVA\\HttpExample\\src\\posts.json";

    public static void main(String[] args) throws FileNotFoundException {

        HttpClient client = HttpClient.newHttpClient(); // cliente http

        HttpRequest request = HttpRequest.newBuilder() // método de criar requisição
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of(JSON_POST)))
                .timeout(Duration.ofSeconds(2))
                .uri(URI.create(URL_POST))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}

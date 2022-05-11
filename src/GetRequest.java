import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class GetRequest {

    //public static final String URL_GET = "http://httpbin.org/get";
    public static final String URL_GET = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();     // Cliente HTTP

        HttpRequest request = HttpRequest.newBuilder()      // Criando a Requisição
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_GET))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // enviando uma solicitação

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}

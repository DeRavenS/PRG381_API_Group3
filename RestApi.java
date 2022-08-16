import java.net.http.*;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpRequest.Builder;



public class RestApi {
    public static void main(String[] args) {

        BrowseBookingRequest BrowseBooking = new BrowseBookingRequest();
        Gson gson = new Gson();

        HttpRequest postRequest = HttpRequest.newBuilder()
        .uri(new URI(" "))
        .header("Authorization", "---")
        .POST(BodyPublishers.ofString("{\"name\":\"John\",\"age\":30}"))
        .build();

        HttpClient httpclient = HttpClient.newHttpClient();

        HttpResponse<String> postResponse = httpclient.send(postRequest, BodyHandlers.ofString());
        System.out.println(postResponse.body());
        
        HttpRequest getRequest = HttpRequest.newBuilder()
        .uri(new URI(""))
        .header("Authorization","---")
        .build();

        HttpResponse<String> getResponse = HttpClient.send(getRequest, BodyHandlers.ofString());
        BrowseBooking = gson.fromJson(getResponse.body(), User.class);
    }
}
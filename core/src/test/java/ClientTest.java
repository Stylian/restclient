import core.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {

    public static final String ITEM_URL = "http://jsonplaceholder.typicode.com/posts/1";
    public static final String COLLECTION_URL = "http://jsonplaceholder.typicode.com/posts";

    @Test
    @DisplayName("get request")
    void testGet() {

        Client client = new Client();
        try {
            HttpResponse<String> response = client.get(ITEM_URL);
            assertEquals(200, response.statusCode());
            assertEquals(
                    """
                            {
                              "userId": 1,
                              "id": 1,
                              "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                              "body": "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"
                            }""",
                    response.body()
                    );

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("post request")
    void testPost() {

        Client client = new Client();
        try {
            HttpResponse<String> response = client.post(COLLECTION_URL,
                    """
                    {
                        "id": 1,
                        "title": "foo",
                        "body": "bar",
                        "userId": 1
                    }
                    """);
            assertEquals(201, response.statusCode());
            assertEquals(
                    """
                    {
                      "id": 101,
                      "title": "foo",
                      "body": "bar",
                      "userId": 1
                    }""", response.body());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("put request")
    void testPut() {

        Client client = new Client();
        try {
            HttpResponse<String> response = client.put(ITEM_URL,
                    """
                    {
                        "id": 1,
                        "title": "foo",
                        "body": "bar",
                        "userId": 1
                    }
                    """);
            assertEquals(200, response.statusCode());
            assertEquals(
                    """
                    {
                      "id": 1,
                      "title": "foo",
                      "body": "bar",
                      "userId": 1
                    }""",
                    response.body());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("patch request")
    void testPatch() {

        Client client = new Client();
        try {
            HttpResponse<String> response = client.patch(ITEM_URL,
                    """
                    {
                        "id": 1,
                        "title": "foo",
                        "userId": 1
                    }
                    """);
            assertEquals(200, response.statusCode());
            assertEquals(
                    """
                            {
                              "userId": 1,
                              "id": 1,
                              "title": "foo",
                              "body": "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"
                            }""",
                    response.body());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("delete request")
    void testDelete() {

        Client client = new Client();
        try {
            HttpResponse<String> response = client.delete(ITEM_URL);
            assertEquals(200, response.statusCode());
            assertEquals(
                    "{}",
                    response.body()
            );

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

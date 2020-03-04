import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunnerTest {

    // TEST FAILURES
    @Test
    @DisplayName("test missing method param")
    void testMissingMethodParam() {
        String[] args = {};
        Assertions.assertThrows(IncorrectNumberOfArgumentsException.class, () -> Runner.test(args));
    }

    @Test
    @DisplayName("test too many params")
    void testTooManyParams() {
        String[] args = {"PUT", "b", "c", "d"};
        Assertions.assertThrows(IncorrectNumberOfArgumentsException.class, () -> Runner.test(args));
    }

    @Test
    @DisplayName("test incorrect method name")
    void testIncorrectMethodName() {
        String[] args = {"PICKUP", "http://www.google.com"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> Runner.test(args));
    }

    @Test
    @DisplayName("test incorrect url")
    void testIncorrectUrl() {
        String[] args = {"GET", "nothttp//:haaha"};
        Assertions.assertThrows(MalformedURLException.class, () -> Runner.test(args));
    }

    @Test
    @DisplayName("test non json body")
    void testNonJsonBody() {
        String[] args = {"POST", "http://jsonplaceholder.typicode.com/posts", "}not json{"};
        Assertions.assertThrows(JSONException.class, () -> Runner.test(args));
    }

    // TEST SUCCESSES
    @Test
    @DisplayName("test get request")
    void testGetRequest() {
        String[] args = {"GET", "http://jsonplaceholder.typicode.com/posts/1"}; // bizarre error!
        Runner.main(args);
    }

}

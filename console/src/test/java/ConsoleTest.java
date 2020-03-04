import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleTest {

    @Test
    @DisplayName("get request")
    void testMissingMethodParam() {
        String[] args = {};
        Assertions.assertThrows(MethodNotFoundException.class, () -> {
            Console console = new Console();
            console.parseMethod(args);
        });
    }

    @Test
    @DisplayName("get request")
    void testIncorrectMethodName() {
        String[] args = {"PICKUP", "", ""};
        Assertions.assertThrows(MethodNotFoundException.class, () -> {
            Console console = new Console();
            console.parseMethod(args);
        });
    }

}

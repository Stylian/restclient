import org.json.JSONException;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Runner {

    public static final List<String> supportedMethods = new ArrayList<>(Arrays.asList(new String[]{
            "GET",
            "POST",
            "PUT",
            "DELETE",
            "PATCH",
    }));

    /**
     * arg[0] : method (eg. GET )
     * arg[1] : url (eg. http://jsonplaceholder.typicode.com/posts/1 )
     * arg[2] : body if any
     * @param args
     */
    public static void main(String[] args) {

        Console console = new Console();

        try {
            console.run(args);
            System.out.println(console.output.toString());
        } catch (IncorrectNumberOfArgumentsException e) {
            System.out.println("arguments are missing or more are specified or are in the wrong order");
            System.out.println("the format of the request has to be as below with body being optional");
            System.out.println("[method] [url] [body]");
        } catch (IllegalArgumentException e) {
            System.out.println("method type requested does not exist or not supported");
            System.out.println("the method types supported are: " + supportedMethods.stream().collect(Collectors.joining(", ")));
        } catch (MalformedURLException e) {
            System.out.println("the url provided is not valid");
        } catch (JSONException e) {
            System.out.println("the body is not of json format. Only json bodies are accepted.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    /**
     * used for junit
     */
    public static void test(String[] args) throws IncorrectNumberOfArgumentsException, MalformedURLException,
            ExecutionException, InterruptedException {
        Console console = new Console();
        console.run(args);
    }
}

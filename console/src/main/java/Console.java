import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Console {

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
            console.parseMethod(args);






        } catch (MethodNotFoundException e) {
            e.printStackTrace();
        }

    }

    private String method;

    public void parseMethod(String[] args) throws MethodNotFoundException {
        if (args.length < 1) {
            System.out.println("method name was not found");
            throw new MethodNotFoundException();
        }

        String candidateMethod = args[0].toUpperCase();
        if(!supportedMethods.contains(candidateMethod)) {
            System.out.println("method requested does not exist or not supported");
            System.out.println("the methods supported are: " + supportedMethods.stream().collect(Collectors.joining(", ")));
            throw new MethodNotFoundException();
        }

        this.method = candidateMethod;
    }
}

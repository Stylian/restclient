import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Console {

    private String method;
    private String url;
    private String body;
    public StringBuilder output;

    public void run(String[] args) throws MalformedURLException, IncorrectNumberOfArgumentsException, JSONException,
            ExecutionException, InterruptedException {
        gatherAndValidateParams(args);
        Client client = new Client();
        HttpResponse<String> response = switch (method) {
            case "GET" -> client.get(url);
            case "POST" -> client.post(url, body);
            case "PUT" -> client.put(url, body);
            case "DELETE" -> client.delete(url);
            case "PATCH" -> client.patch(url, body);
            default -> null; // should never reach this as method are validated above
        };

//        output.append(response.headers().map().toString());
        output.append(" status code: " + response.statusCode());
        output.append(" method: " + response.request().method());
        output.append(" method: " + response.request().headers().map().toString());
        output.append(" body: " + response.body());


    }

    private void gatherAndValidateParams(String[] args) throws IncorrectNumberOfArgumentsException, MalformedURLException {
        if(args.length < 2) {
            throw new IncorrectNumberOfArgumentsException();
        }

        parseMethod(args);

        // check arguments being correct
        if("GET".equals(method)) {
            if(args.length > 2) {
                throw new IncorrectNumberOfArgumentsException();
            }
        }else {
            if(args.length > 3) {
                throw new IncorrectNumberOfArgumentsException();
            }
        }

        parseUrl(args);
        if("POST".equals(method) || "PUT".equals(method) || "PATCH".equals(method)) {
            parseBody(args);
        }
    }

    private void parseMethod(String[] args) throws IllegalArgumentException {

        String candidateMethod = args[0].toUpperCase();
        if(!Runner.supportedMethods.contains(candidateMethod)) {
           throw new IllegalArgumentException();
        }

        this.method = candidateMethod;
    }

    private void parseUrl(String[] args) throws MalformedURLException {
        String candidateUrl = args[1];
        new URL(candidateUrl);
        this.url = candidateUrl;
    }

    private void parseBody(String[] args) throws JSONException {
        String candidateBody = args[2];
        new JSONObject(candidateBody);
        this.body = candidateBody;
    }
}

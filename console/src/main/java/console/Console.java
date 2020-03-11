package console;

import core.Client;
import org.apache.commons.text.TextStringBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

public class Console {

    private String method;
    private String url;
    private String body;
    public TextStringBuilder output = new TextStringBuilder();

    public void run(String[] args) throws MalformedURLException, IncorrectNumberOfArgumentsException, JSONException,
            ExecutionException, InterruptedException {
        System.out.println(args.length);
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
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

        output.appendln("------------ HEADER ------------");
        output.appendln(" method: " + response.request().method());
        output.appendln(" status code: " + response.statusCode());
        output.appendln(" content-type: " + response.headers().map().get("content-type").get(0));
        output.appendln(" date: " + response.headers().map().get("date").get(0));
        output.appendln(" connection: " + response.headers().map().get("connection").get(0));

        output.appendln("------------ BODY ------------");
        output.appendln(response.body());

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

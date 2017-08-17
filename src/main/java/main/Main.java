package main;
import static spark.Spark.*;
import org.apache.log4j.BasicConfigurator;

public class Main {
    public static void main(String[] args) {
    	
    	BasicConfigurator.configure();
    	staticFileLocation("/public");
    	port(5678);
    	enableCORS("*", "*", "*");
        
        post("/stringmodifier", (request, response) -> {
        	ClientMessage clientMessage = new ClientMessage(request.body());
        	String receivedText = clientMessage.getMessageText();
        	clientMessage.reverseMessage();
        	return "You sent: \"" + receivedText + "\"\nIt was received at: " + clientMessage.getTime()
        			+ "\nHere is your message reversed: " + clientMessage.getMessageText();
        });

        get("/", (request, response) -> {
            response.redirect("/index.html");
            return null;
        });

    }    
    
 // Enables CORS on requests. This method is an initialization method and should be called once.
    private static void enableCORS(final String origin, final String methods, final String headers) {

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", origin);
            response.header("Access-Control-Request-Method", methods);
            response.header("Access-Control-Allow-Headers", headers);
            // Note: this may or may not be necessary in your particular application
            response.type("application/json");
        });
    }
}
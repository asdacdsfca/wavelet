import java.io.IOException;
import java.net.URI;
import java.util.*;

class Search implements URLHandler {
    ArrayList<String> result = new ArrayList<>();

    public String handleRequest(URI url){
        if (url.getPath().equals("/")) {
            return result.toString();
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    result.add(parameters[1]);
                    return result.toString();
                }
            }
            else if (url.getPath().contains("/search")) {
                ArrayList<String> output = new ArrayList<>();
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    for (String i: result) {
                        if (i.toUpperCase().contains(parameters[1].toUpperCase())) {
                            output.add(i);
                        }
                    }
                    return output.toString();
                }
            }
            return "404 NOT Found!";
        }
    }
}
class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Search());
    }
}
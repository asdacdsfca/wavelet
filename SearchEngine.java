import java.io.IOException;
import java.net.URI;
import java.util.*;

class newHandler implements URLHandler {
    ArrayList<String> stringSearch = new ArrayList<String>();
    ArrayList<String> searchOutput = new ArrayList<String>();
    if (url.getPath().contains("/add")) {
        String[] parameters = url.getQuery().split("=");
        if (parameters[0].equals("s")) {
            stringSearch.add(paramters[1]);
            return String.format("String has been addded", parameters[1], stringSearch);
        }
    }
    if (url.getPath().contains("/search")) {
        String[] parameters = url.getQuery().split("=");
        if (paramters[0].equals("s")) {
            for (i = 0, i< stringSearch.length, i++){
                if stringSearch[i].contains(parameters[1]){
                    searchOutput.add(parameters[1]);
                    return String.format("Search Result:", parameters[1], searchOutput);
                }
            }
        }
    }

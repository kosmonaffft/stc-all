package university.innopolis.stc.responsibilitychain;

import java.util.HashMap;
import java.util.Map;

public class RequestProcessor {

    public Map<String, String> processRequest(Map<String, String> request) {
        Map<String, String> response = new HashMap<>();

        if (false == request.get("user").equals("root")) {
            throw new RuntimeException("User does not have rights to perform operation...");
        }

        if (false == request.get("password").equals("root")) {
            throw new RuntimeException("Invalid password...");
        }

        if (false == request.containsKey("language")) {
            response.put("language", "RU");
        } else {
            response.put("language", request.get("language"));
        }

        if (false == request.containsKey("value")) {
            throw new RuntimeException("Value should be provided...");
        } else {
            response.put("value", request.get("value"));
        }

        return response;
    }
}

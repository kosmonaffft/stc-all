package university.innopolis.stc.responsibilitychain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestProcessorTest {

    @Test
    void processRequest() {
        final HashMap<String, String> request = new HashMap<String, String>() {{
            put("user", "root");
            put("password", "root");
            put("value", "test");
        }};

        final RequestProcessor requestProcessor = new RequestProcessor();
        final Map<String, String> response = requestProcessor.processRequest(request);

        assertEquals("test", response.get("value"));
        assertEquals("RU", response.get("language"));
    }
}
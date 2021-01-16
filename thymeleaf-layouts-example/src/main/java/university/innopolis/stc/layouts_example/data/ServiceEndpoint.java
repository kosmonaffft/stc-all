package university.innopolis.stc.layouts_example.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ServiceEndpoint {

    public UUID id;

    public String name;

    public String url;

    public String method;
}

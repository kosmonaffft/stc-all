package university.innopolis.stc.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Cleanup;
import net.bytebuddy.utility.RandomString;
import org.bson.Document;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class MongoExample {

    public static void main(String[] args) {
        @Cleanup MongoClient mongoClient = new MongoClient("localhost", 27017);
        List<String> databases = getDatabases(mongoClient);
        System.out.printf("Databases: %s%n", databases);

//        insertRandomObject(mongoClient);

        Collection<Map<String, Object>> byField1 = findBy(mongoClient, "passport.number", "KzT5dWnV");
        System.out.printf("By field1: %s%n", byField1);
    }

    public static List<String> getDatabases(MongoClient mongoClient) {
        return StreamSupport.stream(mongoClient.listDatabaseNames().spliterator(), false)
                .collect(Collectors.toList());
    }

    public static Map<String, Object> insertRandomObject(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("test_objects");

        Document subDocument = new Document();
        subDocument.put("id", UUID.randomUUID().toString());
        subDocument.put("series", RandomString.make());
        subDocument.put("number", RandomString.make());

        Document document = new Document();
        document.put("id", UUID.randomUUID().toString());
        document.put("firstName", RandomString.make());
        document.put("secondName", RandomString.make());
        document.put("passport", subDocument);

        collection.insertOne(document);

        return document;
    }

    public static Collection<Map<String, Object>> findBy(MongoClient mongoClient, String field, String value) {
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("test_objects");

        Document document = new Document();
        document.put(field, value);
        FindIterable<Document> documents = collection.find(document);

        return StreamSupport.stream(documents.spliterator(), false).collect(Collectors.toList());
    }
}

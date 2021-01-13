package university.innopolis.stc.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
        MongoClient mongoClient = new MongoClient("localhost", 27017);
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
        subDocument.put("field1", RandomString.make());
        subDocument.put("field2", RandomString.make());

        Document document = new Document();
        document.put("id", UUID.randomUUID().toString());
        document.put("field1", RandomString.make());
        document.put("field2", RandomString.make());
        document.put("sub", subDocument);

        collection.insertOne(document);

        return document;
    }

    public static Collection<Map<String, Object>> findBy1(MongoClient mongoClient, String field) {
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("test_objects");

        Document document = new Document();
        document.put("field1", field);
        FindIterable<Document> documents = collection.find(document);

        return StreamSupport.stream(documents.spliterator(), false).collect(Collectors.toList());
    }

    public Collection<Map<String, Object>> findByid(MongoClient mongoClient, String id) {
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("test_objects");

        Document document = new Document();
        document.put("id", id);
        FindIterable<Document> documents = collection.find(document);

        return StreamSupport.stream(documents.spliterator(), false).collect(Collectors.toList());
    }
}

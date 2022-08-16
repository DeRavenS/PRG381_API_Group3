import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Connection {

    public void connectDatabase() {
        // Default port number for mongoDB
        String uri = "mongodb://localhost:27017";

        // Try-catch to check if the database already exists
        try {
            // Create a MongoDB Client
            MongoClient mongoClient = MongoClients.create(uri);

            // Get/create a MongoDB database
            MongoDatabase database = mongoClient.getDatabase("CateringDB");

            // Create a MongoDB Collection
            database.createCollection("User");
            MongoCollection<Document> collection = database.getCollection("User");
            insertDummyDocuments(collection);

            System.out.println("Database created Successfully.");
        }catch(Exception ex){
            System.out.println("Database already exists with collections.");
        }
    }
    
    private void insertDummyDocuments(MongoCollection<Document> collection){
        //Try-catch to check if the Document(JSON file) is added to the database
        try {
            //Create an ArrayList for the Document
            List<Document> documents = new ArrayList<Document>();

            //Convert JSON file to a String and Add to the ArrayList
            documents.add(Document.parse(new String(Files.readAllBytes(Paths.get("LayeredArch/DataAccessLayer/dummy/Test1.json")))));
            documents.add(Document.parse(new String(Files.readAllBytes(Paths.get("LayeredArch/DataAccessLayer/dummy/Test2.json")))));

            //Insert documents into MongoDB Collection
            collection.insertMany(documents);

            System.out.println("Dummy data added successfully.");
        } catch (Exception ex) {
            System.out.println("Faled to load json");
        }
    }
}

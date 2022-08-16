import java.io.File;
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
        // Try-catch to check if the Document(JSON file) is added to the database
        try {
            // Create an ArrayList for the Document
            List<Document> documents = new ArrayList<Document>();

            // Cycle through all JSON files in the dummy folder
            for (int i = 1; i <= (new File("LayeredArch/DataAccessLayer/dummy")).list().length; i++) {
                // Load json file as a string and convert it into a Document which can be added to an arrayList of documents
                documents.add(Document.parse(new String(Files.readAllBytes(Paths.get("LayeredArch/DataAccessLayer/dummy/Test"+ i +".json")))));
            }

            // Insert documents into MongoDB Collection
            collection.insertMany(documents);

            System.out.println("Dummy data added successfully.");
        } catch (Exception ex) {
            System.out.println("Failed to load json");
        }
    }
}

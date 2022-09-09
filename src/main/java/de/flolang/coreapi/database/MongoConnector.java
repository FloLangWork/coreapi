package de.flolang.coreapi.database;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import de.flolang.coreapi.bungee.CoreAPI;
import net.md_5.bungee.api.ProxyServer;

public class MongoConnector {

    private MongoDatabase mongoDatabase;
    private Exception connectionError;

    public MongoConnector(String connectionStr, String database) {
        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI(connectionStr));
            this.mongoDatabase = mongoClient.getDatabase(database);
            ProxyServer.getInstance().getConsole().sendMessage(CoreAPI.PREFIX + "§cMongoDB connected!");
        } catch (Exception e) {
            connectionError = e;
            ProxyServer.getInstance().getConsole().sendMessage(CoreAPI.PREFIX + "§cMongoDB connection error!");
        }
    }

    public MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }
}

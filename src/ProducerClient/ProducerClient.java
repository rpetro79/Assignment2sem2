package ProducerClient;

import RecipeReaderAndProxy.ProxyRecipeProvider;
import RecipeReaderAndProxy.RecipeProvider;
import ServerSide.ServerInterface;
import Utilities.Burger;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class ProducerClient implements Remote {
    private ServerInterface server;

    public ProducerClient() throws RemoteException, NotBoundException {
        UnicastRemoteObject.exportObject(this, 0);
        Registry reg = LocateRegistry.getRegistry("localhost", 1099);
        server = (ServerInterface) reg.lookup("burgerServer");
    }

    public void burgerPrepared(Burger burger) throws RemoteException {
        server.burgerPrepared(burger);
    }

    public static void main(String[] args) throws Exception {
        RecipeProvider recipes = new ProxyRecipeProvider();
        ProducerClient producer = new ProducerClient();
        Burger burger;
        Random rand = new Random();

        while(true)
        {
            burger = new Burger(recipes.getRecipeById(("" + (rand.nextInt(3)+1))).getName());
            System.out.println("Burger ready: " + burger.getName());
            producer.burgerPrepared(burger);
            Thread.sleep(rand.nextInt(2000));
        }
    }
}

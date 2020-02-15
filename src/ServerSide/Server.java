package ServerSide;

import BlockingQueueAdapter.BlockingQueueAdapter;
import Utilities.Burger;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import BlockingQueueAdapter.BlockingQueue;

public class Server implements ServerInterface {
    private BlockingQueue<Burger> burgers;

    public Server()  throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        burgers = new BlockingQueueAdapter<Burger>(50);
    }

    @Override
    public Burger eatBurger() {
        return burgers.retrieve();
    }

    @Override
    public void burgerPrepared(Burger burger) {
        burgers.add(burger);
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            ServerInterface server = new Server();
            registry.bind("burgerServer", server);
            System.out.println("Server started");
        }
        catch(RemoteException | AlreadyBoundException e)
        {
            e.printStackTrace();
        }
    }
}


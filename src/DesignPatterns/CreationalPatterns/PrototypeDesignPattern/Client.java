package DesignPatterns.CreationalPatterns.PrototypeDesignPattern;

public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {

        NetworkConnection networkConnection = new NetworkConnection();
        networkConnection.setIp("198.00.00.01");
        networkConnection.loadData();

        System.out.println(networkConnection);


        NetworkConnection networkConnection2 = networkConnection.clone();
        networkConnection2.setData("Meaw");
        System.out.println(networkConnection2);
    }
}

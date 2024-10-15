package DesignPatterns.CreationalPatterns.PrototypeDesignPattern;

public class NetworkConnection implements Cloneable{

    private String ip;
    private String data;


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void loadData(){
        this.data="Data";
    }

    @Override
    public NetworkConnection clone() throws CloneNotSupportedException {
        return  (NetworkConnection) super.clone();
    }
}

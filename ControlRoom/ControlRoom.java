package ControlRoom;

public class ControlRoom {
    public int id;
    public String gateWay;
    public String powerSupply;
    public SmartStreet SS;
    public ControlRoom(int id, String gateWay, String powerSupply)
    {
        this.id=id;
        this.gateWay =gateWay;
        this.powerSupply= powerSupply;
        this.SS = new SmartStreet(1,"AUI",20,100);
    }
    public void Update_Supply(String a)
    {
        this.powerSupply = a;
    }
    public void Update_gateWay(String a)
    {
        this.gateWay = a;
    }
    @Override
    public String toString() {
        return "The control room ID: "+ id+", the power supply: "+ powerSupply+", the gateway: "+ gateWay+"\n\tthe smart street: "+ SS;
    }

}






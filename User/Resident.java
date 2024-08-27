package User;

import SmartAppartment.SmartApartment;

public class Resident extends User
{
    public int Age;
    public String Profession;
    public String Address;
    public Report report;
    public SmartApartment SA;

    public Resident(int ID, String FirstName, String LastName, String Email, String Phone,int Type,  String Login, String Password, int Age, String Profession, String Address, SmartApartment SA) {
        super(ID, FirstName, LastName, Email, Phone,2, Login, Password);
        this.Age = Age;
        this.Profession = Profession;
        this.Address = Address;
        this.SA = SA;
    }
    public String toString() {
        return super.toString()+", age:"+this.Age+" Profession: "+this.Profession+ " Address: "+this.Address;
    }

}

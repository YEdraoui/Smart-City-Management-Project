package User;

import SmartAppartment.SmartApartment;

public class User
{   //Attributes
    private int ID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Phone;
    public int Type;
    public Account account = new Account(" ", " ");
    public Report report = new Report();
    //Constructor
    public User(int ID,
                String FirstName,
                String LastName,
                String Email,
                String Phone,
                int Type,
                String Login,
                String Password)
        {
            this.ID = ID;
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.Email = Email;
            this.Phone = Phone;
            this.Type = Type;
            this.account.setLogIn(Login);
            this.account.setPassword(Password);
        }
    //Getters
    public int getID() {
        return ID;
    }
    public String getFirstName() {
        return FirstName;
    }
    public String getLastName() {
        return LastName;
    }
    public String getEmail() {
        return Email;
    }
    public String getPhone() {
        return Phone;
    }
    //Setters
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    //ToString
    @Override
    public String toString() {
        return "User with the ID: "+ this.ID+", First Name: "+ this.FirstName+", Last Name: "+ this.LastName+", Email: "+ this.Email+", Phone: "+ this.Phone + ", account: "+ this.account.toString();
    }

}

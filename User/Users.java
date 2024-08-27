package User;

import Test.SmartCityManagement;

public class Users {
    public static int UsersNumber = 2;
    public static User[] users;

    public Users() {
        users = new User[100];
        users[0] = new Resident(112143,"Yassir","Edraoui","y.edraoui@aui.ma","0707839443",2,"yedr","123",20,"Student","Marrakech", SmartCityManagement.CM.SS.buildings[0].smartApartments[0]);
        users[1] = new GeneralAdmin(100,"Jane","Doe","j.Doe@aui.ma","1000",1,"yedr","123");

    }
    public static void addUser(User user)
    {
        users[UsersNumber].setID(user.getID());
        users[UsersNumber].setFirstName(user.getFirstName());
        users[UsersNumber].setLastName(user.getLastName());
        users[UsersNumber].setEmail(user.getEmail());
        users[UsersNumber].setPhone(user.getPhone());
        users[UsersNumber].account.setLogIn(user.account.getLogIn());
        users[UsersNumber].account.setPassword(user.account.getPassword());
        UsersNumber++;

    }
    public static int getUser(int ID)
    {
        int index = 0;
        for (User user : users) {
            if (user.getID() == ID)
            {
                return index;
            }
            index++;
        }
        System.out.println("User not found.");
        return 0;
    }
    public static User search(int ID)
    {
        for (User user : users) {
            if (user.getID() == ID)
            {
                return user;
            }
        }
        return null;
    }
    public static void printUsers()
    {
        int i = 1;
        for (User user : users) {
            System.out.println("The user # "+i++ + user.getID());
        }
    }
    public static void deleteUser(int index)
    {
        users[index] = null;
        System.gc();
    }

}

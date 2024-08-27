package User;

import ControlRoom.ControlRoom;
import Test.SmartCityManagement;

import java.util.Scanner;

public class GeneralAdmin extends User
{

    ControlRoom CR;
    public GeneralAdmin(int ID, String FirstName, String LastName, String Email, String Phone,int type,String Login, String Password)
    {
        super(ID, FirstName, LastName, Email, Phone,1, Login, Password);
        CR = SmartCityManagement.CM;
    }

    public void create_profile()
    {
        SmartCityManagement.Sign_Up();
    }
    public void update_profile(User user)
    {
        if(user.Type == 1)
        {
            GeneralAdmin u = (GeneralAdmin) user;

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter your first name: ");
            u.setFirstName(scanner.next());
            System.out.println("Enter your last name: ");
            u.setLastName(scanner.next());
            System.out.println("Enter your Email: ");
            u.setEmail(scanner.next());
            System.out.println("Enter your Phone: ");
            u.setPhone(scanner.next());
            System.out.println("Enter your Login: ");
            u.account.setLogIn(scanner.next());
        }
        if(user.Type == 2)
        {
            Resident u = (Resident) user;
            Scanner scanner = new Scanner(System.in);


            System.out.println("Enter your first name: ");
            u.setFirstName(scanner.next());
            System.out.println("Enter your last name: ");
            u.setLastName(scanner.next());
            System.out.println("Enter your Email: ");
            u.setEmail(scanner.next());
            System.out.println("Enter your Phone: ");
            u.setPhone(scanner.next());
            System.out.println("Enter your Login: ");
            u.account.setLogIn(scanner.next());
        }
    }
    public void delete_profile()
    {
        Scanner scanner = new Scanner(System.in);
        int ID =0,index;
        Users.printUsers();
        System.out.println("Enter the ID of the user that you want to delete:");
        ID = scanner.nextInt();
        index = Users.getUser(ID);
        Users.deleteUser(index);
        System.out.println("The user has been deleted.");
    }
}

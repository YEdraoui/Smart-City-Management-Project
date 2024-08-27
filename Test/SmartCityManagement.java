package Test;

import ControlRoom.ControlRoom;
import User.*;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class SmartCityManagement
{
    public static ControlRoom CM = new ControlRoom(1, " INWI", "Solar Energy");

    public static void main(String[] args)
        {
            new Users();
            new Reports();

            Scanner scanner = new Scanner(System.in);
            int Choice = 0;
            boolean C = true;
            User user;
            System.out.println("Welcome to our Application.");
                do{
                    menu();
                    Choice = scanner.nextInt();
                        if (Choice == 1)
                            {
                                user = Log_In();
                                if(user != null)
                                {
                                    insideUser(user);
                                }
                            }
                        else if (Choice == 2)
                            {
                                Sign_Up();
                            }
                        else if (Choice == 3)
                            {
                                C = false;
                                System.out.println("RE RUN THE PROGRAM.");
                            }
                        else
                            {
                                System.out.println("The wrong choice.");
                            }
                    System.gc();
                }while(C);
        }
    public static void menu()
        {
            System.out.println("""
                    1. Log in\s
                    2. Sign up\s
                    3. Log out(Shut down the program).\s
                    Enter your choice:""");
        }
    public static void GeneralAdminMenu()
        {
            System.out.println("""
                    1. Create a profile.\s
                    2. Update a profile.\s
                    3. Delete a profile.\s
                    4. Handle a report.\s
                    5. Update a report.\s
                    6. View the control room.\s
                    7. Update the control room(with all the components of it such as street/building/apartment.).\s
                    8. Log out.\s
                    Enter your choice:""");

        }
    public static void ResidentMenu()
        {
            System.out.println("""
                    1. View your data.\s
                    2. View apartment data.\s
                    3. Report a problem.\s
                    4. Update a report.\s
                    5. Update the apartment.).\s
                    6. Log Out\s
                    Enter your choice:""");


        }
    public static User Log_In()
        {
            Scanner scanner = new Scanner(System.in);
            int ID;
            boolean success;
            User user_attempt;
                System.out.println("Enter your ID: ");
                ID = scanner.nextInt();
                user_attempt = Users.search(ID);
                    if (user_attempt != null)
                        {
                             success = user_attempt.account.Authenticate();
                                if(success)
                                    return user_attempt;
                                else
                                    {
                                        System.out.println("This Login or password is invalid! Please re-do the log in.");
                                        return null;
                                    }
                        }
                        else
                            {
                                System.out.println("This ID is invalid! Please ");
                                return null;
                            }
        }
    public static void Sign_Up()
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to Sign Up Part! ");
            int ID, Type;
            String Phone;
            String FirstName, LastName, Email, Login, Password;
                System.out.println("Enter your ID: ");
                ID = scanner.nextInt();
                System.out.println("Enter your first name: ");
                FirstName = scanner.next();
                System.out.println("Enter your last name: ");
                LastName = scanner.next();
                System.out.println("Enter your Email: ");
                Email = scanner.next();
                System.out.println("Enter your Phone: ");
                Phone = scanner.next();
                System.out.println("Enter your user type: ");
                Type = scanner.nextInt();
                System.out.println("Enter your Login: ");
                Login = scanner.next();
                System.out.println("Enter your Password: ");
                Password = scanner.next();

            User NewUser;
                if(Type == 1)
                {
                    NewUser = new GeneralAdmin(ID, FirstName, LastName, Email, Phone,Type, Login, Password);
                    Users.addUser(NewUser);
                }
                else if(Type == 2)
                {
                    NewUser = new Resident(ID, FirstName, LastName, Email, Phone, Type, Login, Password,0,"", "", CM.SS.buildings[0].smartApartments[0]);
                    Users.addUser(NewUser);
                    CM.SS.buildings[0].smartApartments[0].ResOfApartment[0]=(Resident) NewUser;
                }


                    System.out.println("The user has been added." +
                            "\n-------------------------------- ");
        }
    public static void insideUser(User u)
        {
            Scanner scanner = new Scanner(System.in);
            int choice =0, ID, index;
            User UserUpdate;
            Resident R;
            GeneralAdmin GA;

                System.out.println("Welcome Mr/Ms. " + u.getFirstName() + " " + u.getLastName());
                if(u.Type == 1)
                    {
                        if (u instanceof GeneralAdmin) {
                            GA = (GeneralAdmin) u;
                                CM.SS.buildings[0].smartApartments[0].ResOfApartment[1] = (Resident) Users.users[0];
                            do {
                            GeneralAdminMenu();
                            choice = scanner.nextInt();
                                if (choice == 1)
                                {
                                    GA.create_profile();
                                }
                                else if (choice == 2)
                                {
                                    Users.printUsers();
                                    System.out.println("Enter the ID of the user that you want to upload:");
                                    ID = scanner.nextInt();
                                    UserUpdate = Users.search(ID);
                                    if(UserUpdate == null)
                                    {
                                        System.out.println("ID is invalid.");
                                    }
                                    else {
                                        GA.update_profile(UserUpdate);
                                    }
                                }
                                else if (choice == 3)
                                {
                                    GA.delete_profile();
                                }
                                else if (choice == 4)
                                {
                                    int c =0;
                                    System.out.println("Choice a report to handle: ");
                                    for (Report report : Reports.reports)
                                    {
                                        int i =1;
                                        if(report == null)
                                        {
                                            break;
                                        }
                                        System.out.println("The report #"+i+":"+report);
                                    }
                                    c = scanner.nextInt();
                                    for (Report report : Reports.reports)
                                    {
                                        int i =1;
                                        if(i == c )
                                        {
                                            GA.report = report;
                                        }
                                    }
                                    GA.report.handle_report();

                                }
                                else if (choice == 5)
                                {
                                    int c =0;
                                    System.out.println("Choice a report to Update: ");
                                    for (Report report : Reports.reports)
                                    {
                                        int i =1;
                                        if(report == null)
                                        {
                                            break;
                                        }
                                        System.out.println("The report #"+i+":"+report);
                                    }
                                    c = scanner.nextInt();
                                    for (Report report : Reports.reports)
                                    {
                                        int i =1;
                                        if(i == c )
                                        {
                                            GA.report = report;
                                        }
                                    }
                                    GA.report.update_report();
                                }
                                else if (choice == 6)
                                {
                                    System.out.println(SmartCityManagement.CM);
                                }
                                else if (choice == 7)
                                {
                                    int j =0;
                                    String newthing;
                                    System.out.println("1. for the gateway." +
                                                        "2. for the power supply." +
                                                        "3. for the street.");
                                    j = scanner.nextInt();
                                    if(j == 1)
                                    {
                                        System.out.println("Enter the new supply: ");
                                        newthing = scanner.next();
                                        CM.Update_Supply(newthing);
                                    }
                                    else if(j == 2)
                                    {
                                        System.out.println("Enter the new supply: ");
                                        newthing = scanner.next();
                                        CM.Update_gateWay(newthing);
                                    }
                                    else if(j == 3)
                                    {
                                        CM.SS.update_street();
                                    }

                                }
                                else if (choice == 8)
                                {
                                    return;
                                }
                                System.gc();
                            }while (true);
                        }
                    }

                else if(u.Type == 2) {

                    if (u instanceof Resident) {
                        R = (Resident) u;
                        if(R.SA == null)
                            CM.SS.buildings[0].smartApartments[0].ResOfApartment[1] = (Resident) Users.users[0];

                        R.SA.SNode.warning();
                        if (R.Address == null && R.Age == 0 && R.Profession == null) {
                            System.out.println("Enter your age:");
                            R.Age = scanner.nextInt();
                            System.out.println("Enter your professor:");
                            R.Profession = scanner.next();
                            System.out.println("Enter your address:");
                            R.Address = scanner.next();
                        }
                        do {
                            ResidentMenu();
                            choice = scanner.nextInt();
                            if (choice == 1)
                            {
                                System.out.println(R);
                            }
                            else if (choice == 2)
                            {
                                double En = + R.SA.SMs[0].consumptionTime(20);
                                System.out.println("the energy consumption is : "+En);
                                System.out.println(R.SA);
                            }
                            else if (choice == 3)
                            {
                                Report r = new Report();
                                System.out.println("Enter your ID:");
                                r.ID = scanner.nextInt();
                                            /* Creating an object of
                                            GregorianCalendar Class */
                                GregorianCalendar gcal = new GregorianCalendar();
                                //report.date
                                r.date = String.valueOf(gcal.getTime());
                                System.out.println("Enter The time:");
                                r.time = scanner.next();
                                System.out.println("Enter your problem:");
                                r.content = scanner.next();
                                r.processed = false;
                                Reports.reports[Reports.ReportIndex] = r;
                            }
                            else if (choice == 4)
                            {
                                int c =0;
                                System.out.println("Choice a report to Update: ");
                                for (Report report : Reports.reports)
                                {
                                    int i =1;
                                    if(report == null)
                                    {
                                        break;
                                    }
                                    System.out.println("The report #"+i+":"+report);
                                }
                                c = scanner.nextInt();
                                for (Report report : Reports.reports)
                                {
                                    int i =1;
                                    if(i == c )
                                    {
                                        R.report = report;
                                    }
                                }
                                R.report.update_report();
                            }
                            else if (choice == 5)
                            {
                                R.SA.update_apartment();
                            }
                            else if (choice == 6)
                            {
                                return;
                            }
                        System.out.println("--------------------------------");
                        }while (true);
                    }
                }
        }
}
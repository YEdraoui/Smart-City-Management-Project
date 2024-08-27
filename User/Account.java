package User;

import java.util.Scanner;

public class Account {
    private String logIn;
    private String password;


    public Account(String logIn, String password) {
        this.logIn = logIn;
        this.password = password;
    }


    public String getLogIn() {
        return logIn;
    }
    public String getPassword() {
        return password;
    }


    public void setLogIn(String logIn) {
        this.logIn = logIn;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean Authenticate() {
        Scanner scanner = new Scanner(System.in);
        String LoginAttempt, PasswordAttempt;

        System.out.println("Enter the LogIn: ");
        LoginAttempt = scanner.next();
        System.out.println("Enter the Password: ");
        PasswordAttempt = scanner.next();

        if (!LoginAttempt.equals(this.logIn) || !PasswordAttempt.equals(this.password)) {
            System.out.println("The Login or Password are not correct.");
            System.out.println(this.logIn);
            System.out.println(this.password);
            System.out.println(LoginAttempt);
            System.out.println(PasswordAttempt);
            return false;
        }
        return true;
    }
    public void setPassword()
    {
        String OldPassword,NewPassword;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the old password: ");
        OldPassword = scanner.next();

        if (OldPassword.equals(this.password))
        {
            System.out.println("Enter the New password: ");
            NewPassword = scanner.next();
            this.password = NewPassword;
            return;
        }
        System.out.println("The password that was entered was incorrect.");

    }
    @Override
    public String toString()
    {
        return "The Login:" + this.logIn+ " and Password: "+this.password ;
    }
}

package User;

import java.util.Date;
import java.util.Scanner;

public class Report {

    public int ID;
    public String date;
    public String time;
    public String content;
    public boolean processed;


    public Report(int ID, Date date, String time, String content, boolean processed) {
        this.ID = ID;
        this.date = String.valueOf(date);
        this.time = time;
        this.content = content;
        this.processed = processed;
    }
    public Report()
    {

    }

    public void update_report()
    {
        System.out.println("Write here the new content: ");
        Scanner scanner = new Scanner(System.in);
        this.content = scanner.next();
        System.out.println("Everything has been updated.");
    }
    public void handle_report()
    {
        processed = true;
    }
    public String toString()
    {
        return "The id: " + ID + " date: " + date + " time: "+ time+" processed: " + processed;
    }
}

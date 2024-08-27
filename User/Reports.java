package User;


import java.util.GregorianCalendar;

public class Reports {

    public static Report[] reports;
    public static int ReportIndex = 1;

    public Reports()
    {
        /* Creating an object of
             GregorianCalendar Class */
        GregorianCalendar gcal = new GregorianCalendar();
        reports = new Report[100];
        reports[0] = new Report(112143, gcal.getTime()," "," ",false);
    }

}

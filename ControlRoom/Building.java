package ControlRoom;

import SmartAppartment.SmartApartment;

import java.util.Arrays;
import java.util.Scanner;

public class Building
{
    public int id;
    public Type T;
    public String REType;
    public SmartApartment[] smartApartments;
    public int numberOfResidents;
    public int numberOfFloors;

    public Building(int id, int type, String REType,int numberOfResidents, int numberOfFloors)
    {
        this.id=id;
        setType(type);
        this.REType=REType;
        smartApartments = new SmartApartment[30];
        smartApartments[0] = new SmartApartment(201, 2, 3, 4.0);
        this.numberOfResidents = numberOfResidents;
        this.numberOfFloors = numberOfFloors;
    }
    private void setType(int type)
    {
        if(type == 1)
        {
            this.T = Type.residential;
        }
        else if(type == 2)
        {
            this.T = Type.institutional;
        }
        else if(type == 3)
        {
            this.T = Type.industrial;
        }
        else if(type == 4)
        {
            this.T = Type.business;
        }
    }

    @Override
    public String toString()
    {
        return "The Building with the ID: "+ id+ ",type: "+ T+"\n\tsmart apartment: "+ Arrays.toString(smartApartments) +"\n\tthe number of residents: "+ numberOfResidents+"\n\tthe number of floors: "+ numberOfFloors;
    }

    public static void BuildingUpdateMenu()
    {
        System.out.println("1. change the type." +
                "2. change the number of floors." +
                "3. change the number of residents."+
                "4. change RE type." +
                "5. change the apartment.");
    }
    public void update_building()
    {
        BuildingUpdateMenu();
        int c = 0;
        Scanner scanner = new Scanner(System.in);
        c = scanner.nextInt();
        if(c == 1)
        {
            System.out.println("Enter the new type: ");
            setType(scanner.nextInt());
        }
        else if(c == 2)
        {
            System.out.println("Enter the new number of floors: ");
            this.numberOfFloors = scanner.nextInt();
        }
        else if(c == 3)
        {
            System.out.println("Enter the new number of residents: ");
            this.numberOfResidents = scanner.nextInt();
        }
        else if(c == 4)
        {
            System.out.println("Enter the new RE type: ");
            this.REType = scanner.next();
        }
        else if(c == 5)
        {
            smartApartments[0].update_apartment();
        }


    }
}

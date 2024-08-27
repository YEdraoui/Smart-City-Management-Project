package ControlRoom;

import java.util.Arrays;
import java.util.Scanner;


public class SmartStreet
{
    public int id;
    public String name;
    public double latitude;
    public double longitude;
    public Building[] buildings;
    public SmartStreet(int id, String name, double latitude, double longitude)
    {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        buildings = new Building[20];
        buildings[0] = new Building(2, 4, " ", 20,3);
    }
    public String toString() {
        return "The id is: "+id+",  latitude is: "+latitude+", the longitude is: "+longitude+"\n\t\tthe building is: "+ Arrays.toString(buildings);
    }

    public static void StreetUpdateMenu()
    {
        System.out.println("1. change the latitude." +
                "2. change the longitude." +
                "3. change the buildings");
    }
    public void update_street()
    {
        StreetUpdateMenu();
        int c =0;
        Scanner scanner = new Scanner(System.in);
        c = scanner.nextInt();
        if(c == 1)
        {
            System.out.println("Enter the new latitude: ");
            latitude = scanner.nextDouble();
        }
        else if(c == 2)
        {
            System.out.println("Enter the new longitude: ");
            longitude = scanner.nextDouble();
        }
        else if(c == 3)
        {
            buildings[0].update_building();
        }

    }

}
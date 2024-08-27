package SmartAppartment;

import User.Resident;
import java.util.Arrays;
import java.util.Scanner;

public class SmartApartment
{
        public int id;
        public int floorNumber;
        public int numberOfRooms;
        public double size;
        public SensorNode SNode;
        public SmartAppliance[] SMs;
        public Resident[] ResOfApartment;

        public SmartApartment(int id, int floorNumber, int numberOfRooms, double size)
            {
                this.id = id;
                this.floorNumber = floorNumber;
                this.numberOfRooms = numberOfRooms;
                this.size = size;
                this.SNode = new SensorNode(1, " ", " ", " ", "micro", 34, 76);
                SMs = new SmartAppliance[5];
                SMs[0] = new SmartAppliance(2,"Fridge",5.0);
                ResOfApartment = new Resident[4];
            }
    @Override
    public String toString()
        {

                return "\t\tThe Smart Apartment ID:  "+ id+",floorNumber: "+ floorNumber+",numberOfRooms: "+ numberOfRooms+",size: "+ size+ " \n\t\t\tSensor Node: "+ SNode.toString()+ "\n\t\t\tSmartAppliance: "+ Arrays.toString(SMs) +"\n\t\t\t\tResident: "+ Arrays.toString(ResOfApartment);
        }
    public static void ApartmentUpdateMenu()
    {
        System.out.println("1. change the id." +
                "2. change the floor number." +
                "3. change the number of rooms."+
                "4. change size.");
    }
    public void update_apartment()
    {
        ApartmentUpdateMenu();
        int c;
        Scanner scanner = new Scanner(System.in);
        c = scanner.nextInt();
        if(c == 1)
        {
            System.out.println("Enter the new id: ");
            id = scanner.nextInt();
        }
        else if(c == 2)
        {
            System.out.println("Enter the new floor number: ");
            floorNumber = scanner.nextInt();
        }
        else if(c == 3)
        {
            System.out.println("Enter the new number of rooms: ");
            numberOfRooms = scanner.nextInt();
        }
        else if(c == 4)
        {
            System.out.println("Enter the new size: ");
            size = scanner.nextDouble();
        }
    }
}
package SmartAppartment;

public class SmartAppliance {
    public int id;
    public String type;
    public double powerConsumption;


    public SmartAppliance(int id, String type, double powerConsumption) {
        this.id = id;
        this.type = type;
        this.powerConsumption = powerConsumption;
    }
    public double consumptionTime(double energyConsumed)
    {
        return energyConsumed / powerConsumption;
    }

    @Override
    public String toString() {
        return "The Smart appliance id: "+ id+",type: "+ type+",Power consumption:"+ powerConsumption;
    }
}

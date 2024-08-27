package SmartAppartment;

public class SensorNode {
    public int id;
    public String temp;
    public String hum;
    public String motion;
    public String micro;
    public double tempValue;
    public double humValue;
    public SensorNode(int id, String temp, String hum, String motion, String micro, double tempValue, double humValue)
        {
            this.id = id;
            this.temp = temp;
            this.hum = hum;
            this.motion = motion;
            this.micro = micro;
            this.tempValue = tempValue;
            this.humValue = humValue;
        }
    public void warning()
        {
            String message = "";
                if (tempValue > 35)
                    {
                        message += "Temperature is too high! ";
                        System.out.println(message);
                    }
                if (humValue > 80)
                    {
                        message += "Humidity is too high!";
                        System.out.println(message);
                    }
        }
    @Override
    public String toString() {
        return "The sensor node id: " + id+",temp: " + temp+",hum: " + hum+",motion: " +motion+",micro: " + micro+",tempValue: " +tempValue+",humValue: " +humValue;
    }
}
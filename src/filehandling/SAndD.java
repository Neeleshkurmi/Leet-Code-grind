package filehandling;

import java.io.*;

public class SAndD {
    public static void main(String[] args) throws Exception{
        Car car = new Car(80, "tata siera");
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("car.ser"));
        os.writeObject(car);
        os.flush();
        System.out.println("s done");


        ObjectInputStream oi = new ObjectInputStream(new FileInputStream("car.ser"));
        Car c =  (Car)(oi.readObject());
        System.out.println(c);
    }
}
class Car implements Serializable {
    int speed;
    String name;

    Car(int speed, String name){
        this.speed = speed;
        this.name = name;
    }
}

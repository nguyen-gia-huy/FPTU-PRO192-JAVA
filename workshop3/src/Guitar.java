/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguye
 */
public class Guitar {
    private String serialNumber;
    private int price;
    private String buider;
    private String model;
    private String backWood;
    private String topWood;
    
    public Guitar(){
        this.serialNumber = "null";
        this.price = 0;
        this.buider="null";
        this.model="null";
        this.backWood="null";
        this.topWood="null";
    }

    public Guitar(String serialNumber, int price, String buider, String model, String backWood, String topWood) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.buider = buider;
        this.model = model;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
         if (serialNumber != null && !serialNumber.isEmpty()) {
            this.serialNumber = serialNumber;
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBuider() {
        return buider;
    }

    public void setBuider(String buider) {
        this.buider = buider;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBackWood() {
        return backWood;
    }

    public void setBackWood(String backWood) {
        this.backWood = backWood;
    }

    public String getTopWood() {
        return topWood;
    }

    public void setTopWood(String topWood) {
        this.topWood = topWood;
    }
    public void createSound(){
        System.out.println("Serial Number: "+ getSerialNumber());
        System.out.println("Price: "+ getPrice());
        System.out.println("Builder: "+ getBuider());
        System.out.println("Model: "+ getModel());
        System.out.println("Back Wood: "+ getBackWood());
        System.out.println("Top Wood: "+ getTopWood());
    }
}

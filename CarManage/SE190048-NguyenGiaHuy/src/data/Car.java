package data;

public class Car implements Comparable<Car>{
    
    private String carID;
    private Brand Brand;
    private String color;
    private String frameID;
    private String engineID;

    public Car(String carID, Brand BrandID, String color, String frameID, String engineID) {
        this.carID = carID;
        this.Brand = BrandID;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    public Car() {
    }

    public String getCarID() {
        return carID;
    }

    public Brand getBrand() {
        return Brand;
    }

    public String getColor() {
        return color;
    }

    public String getFrameID() {
        return frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public void setBrand(Brand BrandID) {
        this.Brand = BrandID;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }
    //toString:

    @Override
    public String toString() {
        String str = String.format("%s, %s, %s, %s, %s",
                                    carID, Brand.getBrandID(), color, frameID, engineID);
        return str;
    }
    
    public String screenString(){
        String str = String.format("%s, %s, %s, %s, %s",
                                    Brand, carID , color, frameID, engineID);
        return str;
    }

    @Override
    public int compareTo(Car that) {
        String thisBrandName = this.Brand.getBrandName();
        String thatBrandName = that.Brand.getBrandName();
        if(thisBrandName.compareTo(thatBrandName) > 0){
            return 1;
        }else if (thisBrandName.compareTo(thatBrandName) == 0){
            
            return this.getCarID().compareTo(that.getCarID());
        }
        return -1;
    }
    
}


package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;
import sun.util.locale.StringTokenIterator;
import utils.Inputter;


public class CarList {
    ArrayList<Car> carList = new ArrayList<>();//ds
    BrandList brandList;
    public CarList(BrandList brandList) {
        this.brandList = brandList;
    }
    
    
    public boolean loadFromFile (String url){
        File f = new File(url);
        try{
            
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while(line != null){
                
                StringTokenizer st = new StringTokenizer(line, ",");
                String cid = st.nextToken().trim();
                String bid = st.nextToken().trim();
                String color = st.nextToken().trim();
                String fid = st.nextToken().trim();
                String eid = st.nextToken().trim();
                
                int pos = brandList.searchID(bid);
                Brand brand = brandList.brandList.get(pos);
                //tao
                Car nCar = new Car(cid, brand, color, fid, eid);
                carList.add(nCar);
                line = reader.readLine();
            }
            
            return true;
        }catch(Exception e){
            System.out.println("Car file Error: " + e);
            return false;
        }
    }
    
    public void listCars(){
        if(carList.isEmpty()){
            System.out.println("CarList has nothing to print");
            return;
        }
        Collections.sort(carList);
        System.out.println("___CarList___");
        for (Car car : carList) {
            System.out.println(car.screenString());
        }
    }
    
    
    public int searchID ( String carID){
        for(int i = 0; i <= carList.size() - 1; i++){
            if(carList.get(i).getCarID().equals(carID)){
                return i;
            }
        }
        return -1;
    }
    
    public int searchEngine (String engineID){
        for(int i = 0; i <= carList.size(); i++){
            if(carList.get(i).getEngineID().equals(engineID)) return i;
        }
        return -1;
    }
    
    
    public int searchFarmeID (String FrameID){
        for(int i = 0; i <= carList.size(); i++){
            if(carList.get(i).getFrameID().equals(FrameID)) return i;
        }
        return -1;
    }
    
    public void addCar(){
        
        boolean isDup;
        String carID;
        do{
            isDup = false;
            carID = Inputter.getString("Input carID: ", "That field is required");
            
            int pos = searchID(carID);
            if(pos != -1){
                System.out.println("CarID has been used");
                isDup = true;
            }
        }while(isDup);
         Brand brand = brandList.getUserChoice();
         
         String color = Inputter.getString("Input Color: ", "That field is required");
         
         String frameID;
         do{
             isDup = false;
             frameID = Inputter.getString("Input frameID: ", "That field is required");
             int pos = searchFarmeID(frameID);
             if(pos != -1){
                 System.out.println("FrameID has been used");
                 isDup = true;
             }
         }while(isDup);
         
         
         String engineID;
         do{
             isDup = false;
             engineID = Inputter.getString("Input engineID: ", "That field is required");
             int pos = searchFarmeID(frameID);
             if(pos != -1){
                 System.out.println("FrameID has been used");
                 isDup = true;
             }
         }while(isDup);
         Car nCar = new Car(carID, brand, color, frameID, engineID);
         carList.add(nCar);
         System.out.println("Car adding is successful");
    }
    
    public void printBasedBrandName(){
       
        String key = Inputter.getString("Input a part of BrandName", "That field is required!");
        
        int count = 0;
        for (Car car : carList) {
            if(car.getBrand().getBrandName().contains(key)){
                System.out.println(car.screenString());
                count++;
            }
        }
        if(count == 0){
            System.out.println("No car is detected");
        }
    }
    public boolean removeCar(){
        String keyId = Inputter.getString("Input CarId u wanna remove", "That field is required");
        
        int pos = searchID(keyId);
        Car car = pos == -1 ? null : carList.get(pos);
        if(car == null){
            System.out.println("Not Found");
            return false;
        }else{
            System.out.println("Car Imformation: ");
            System.out.println(car.screenString());
            carList.remove(pos);
            System.out.println("Car removing is successful");
            return true;
        }
    }
    public boolean updateCar(){
        String keyId = Inputter.getString("Input CarId u wanna update", "That field is required");
        
        int pos = searchID(keyId);
        Car car = pos == -1 ? null : carList.get(pos);
        if(car == null){
            System.out.println("Not Found");
            return false;
        }else{
            System.out.println("Car Imformation befor updating: ");
            System.out.println(car.screenString());
            
            Brand brand = brandList.getUserChoice();
            
            String color = Inputter.getString("Input Color: ", "That field is required");
            
            boolean isDup;
            String frameID;
            do{
                isDup = false;
                frameID = Inputter.getString("Input frameID: ", "That field is required");
                pos = searchFarmeID(frameID);
                if(pos != -1){
                    System.out.println("FrameID has been used");
                    isDup = true;
                }
            }while(isDup);

            
            String engineID;
            do{
                isDup = false;
                engineID = Inputter.getString("Input engineID: ", "That field is required");
                pos = searchFarmeID(frameID);
                if(pos != -1){
                    System.out.println("FrameID has been used");
                    isDup = true;
                }
            }while(isDup);
            
            car.setBrand(brand);
            car.setColor(color);
            car.setFrameID(frameID);
            car.setEngineID(engineID);
            System.out.println("Car updating is successful");
            return true;
        }
    }
        public boolean saveToFile(String url){
         File f = new File(url);
         try{
             
             OutputStreamWriter writer  = new OutputStreamWriter(new FileOutputStream(f));
             for (Car car : carList) {
                 writer.write(car.toString());
                 writer.write("\n");
             }
             writer.flush();
             
             return true;
         }catch(Exception e){
             System.out.println("Save Brand File Error "+ e);
             return false;
         }
     }
}

package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import ui.Menu;
import utils.Inputter;

public class BrandList {
    ArrayList<Brand> brandList = new ArrayList<>();
    
   
    public boolean loadFromFile(String url){
        File f = new File(url);
        try{
           
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while(line != null){
                StringTokenizer st = new StringTokenizer(line, ",");
                String brandId = st.nextToken().trim();
                String brandName = st.nextToken().trim();
                String str = st.nextToken().trim();
                st = new StringTokenizer(str, ":");
                String soundBrand = st.nextToken().trim();
                double price = Double.parseDouble(st.nextToken().trim());
                
                Brand nBrand = new Brand(brandId, brandName, soundBrand, price);
                brandList.add(nBrand);
                line = reader.readLine();
            }
            
            return true;
        }catch(Exception e){
            System.out.println("File brands error: "+ e);
            return false;
        }
    }
    
    
    public void listBrands(){
        if(brandList.isEmpty()){
            System.out.println("BrandList nothing to print");
            return;
        }
        System.out.println("____BrandList____");
        for (Brand brand : brandList) {
            System.out.println(brand);
        }
    }
    
    
    public int searchID (String bID){
        for(int i = 0; i<= brandList.size() - 1; i++){
            if(brandList.get(i).getBrandID().equals(bID)){
                return i;
            }
        }
        return -1;
    }
    
    
    public void addBrand(){
        
        boolean isDup;
        String id;
        do{
            isDup = false;
            id = Inputter.getString("Input brand id: ", "that field is required");
            
            int pos = searchID(id);
            if(pos != -1){
                System.out.println("This brand is has been used");
                isDup = true;
            }
        }while(isDup);
       
        String name = Inputter.getString("Input BrandName: ", "that field is required");
        String sound = Inputter.getString("Input SoundBrand: ", "that field is required");
        
        
        double price = Inputter.getADouble("Input price: ", "price must to positive number", 0, Math.pow(2, 53) - 1);
       
        Brand nBrand = new Brand(id, name, sound, price);
        brandList.add(nBrand);
        System.out.println("Brand adding is successful");
    }
    public void updateBrand(){
        
        String keyId = Inputter.getString("Input Brand id you wanna update: ", "That field is required");
        
        int pos = searchID(keyId);
        Brand brand = pos == -1 ? null : brandList.get(pos);
        
        if(brand == null){
            System.out.println("Not Found");
        }else{
            System.out.println("Brand Information before updating");
            System.out.println(brand);
            System.out.println("updating");
            
        
        String name = Inputter.getString("Input BrandName: ", "that field is required");
        String sound = Inputter.getString("Input SoundBrand: ", "that field is required");
        
        double price = Inputter.getADouble("Input price: ", "price must to positive number", 0, Math.pow(2, 53) -1);
        
        brand.setBrandName(name);
        brand.setSoundBrand(sound);
        brand.setPrice(price);
       
            System.out.println("Updating is Successful");
        }
    }
    
    public Brand getUserChoice(){
        
        int count =1;
        System.out.println("____BrandList____");
        for (Brand brand : brandList) {
            System.out.println(count + "." + brand);
            count++;
        }
        
        Menu<Brand> brandMenu = new Menu ("brandListMenu");
        
        return brandMenu.ref_getChoice(brandList);
    }
    
     public void searchBrand(){
        
        String keyId = Inputter.getString("Input Brand id you wanna find: ", "That field is required");
        
        int pos = searchID(keyId);
        Brand brand = pos == -1 ? null : brandList.get(pos); 
        
        if(brand == null){
            System.out.println("Not Found");
        }else{
            System.out.println("Brand Information");
            System.out.println(brand);
        }
    }
     
     public boolean saveToFile(String url){
         File f = new File(url);
         try{
            
             OutputStreamWriter writer  = new OutputStreamWriter(new FileOutputStream(f));
             for (Brand brand : brandList) {
                 writer.write(brand.toString());
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

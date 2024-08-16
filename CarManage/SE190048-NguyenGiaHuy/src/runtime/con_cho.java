package runtime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class con_cho {
    public static void main(String[] args) throws IOException {
        
    
    try{       
            File file = new File("C:\\Users\\nguye\\OneDrive\\Documents\\NetBeansProjects\\f5.txt");
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            
            File file2 = new File("C:\\Users\\nguye\\OneDrive\\Documents\\NetBeansProjects\\f6.txt");
            FileWriter fw = new FileWriter(file2);
            PrintWriter pw = new PrintWriter(fw);
            
            pw.println("heloo Dung");
            
            String line = bf.readLine();
            
            while(line != null){
                System.out.println(line);
                line = line.replace('$', '*');
                pw.println(line);
                
                line = bf.readLine();
            }
            
            bf.close();
            fr.close();
            pw.close();
            fw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(con_cho.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(con_cho.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
       
       
}

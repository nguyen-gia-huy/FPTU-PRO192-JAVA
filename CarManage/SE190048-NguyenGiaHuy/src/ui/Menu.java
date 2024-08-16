
package ui;
import java.lang.reflect.Array;
import java.util.ArrayList;
import utils.Inputter;



public class Menu<T> {

    public Menu() {
    }
    public ArrayList<String> optionList = new ArrayList<>();
    public String title;

    public Menu(String title) {
        this.title = title;
    }
    
    public void addNewoption(String newOption){
        optionList.add(newOption);
    }
    public void print(){
        int count = 1;
        System.out.println("____" + title + "____");
        for (String op : optionList) {
            System.out.println(count + "." + op);     
            count++;
        }
    }
    
    public int getChoice(){
        int choice = Inputter.getAnIteger("Input your Choice: ", "Only 1 to"+ optionList.size(), 1, optionList.size());
        return choice;
    }
    
    public T ref_getChoice(ArrayList<T> options){
        
        int choice = Inputter.getAnIteger("Input SEQ of Brand", "SQE must be between 1 and "+ options.size(), 1, options.size());
        return options.get(choice - 1);
    }
}

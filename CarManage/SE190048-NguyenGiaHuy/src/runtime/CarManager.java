package runtime;

import data.Brand;
import data.BrandList;
import data.CarList;
import ui.Menu;

public class CarManager {

    public static void main(String[] args) {
       BrandList bl = new BrandList();
       String brandUrl = "\"C:\\Users\\nguye\\OneDrive\\Documents\\NetBeansProjects\\17-Van-PE-17-2-2022\\17-Van-PE-17-2-2022\\brands.txt\"";
       String carUrl = "\"C:\\Users\\nguye\\OneDrive\\Documents\\NetBeansProjects\\17-Van-PE-17-2-2022\\17-Van-PE-17-2-2022\\cars.txt\"";
       bl.loadFromFile(brandUrl);
       CarList cl = new CarList(bl);
       cl.loadFromFile(carUrl);
       Menu menu = new Menu("menu he thong quan ly xe");
        menu.addNewoption("danh sach tat ca cac xe");
        menu.addNewoption("them hang moi");
        menu.addNewoption("tim hang xe theo ID");
        menu.addNewoption("them hang xe");
        menu.addNewoption("luu hang xe vao file, ten la brands.txt");
        menu.addNewoption("Liet ke tat ca cac xe theo thu tu tang dan cua ten thuong hieu");
        menu.addNewoption("liet ke loai xe dua tren cac du lieu nhap vao");
        menu.addNewoption("them vao xe");
        menu.addNewoption("xoa xe dua tren id");
        menu.addNewoption("them xe dua tren ID");
        menu.addNewoption("luu cac xe vao file, ten la cars.tx");
        
        while(true){
            menu.print();
            int choice = menu.getChoice();
            switch(choice){
                case 1:{
                    bl.listBrands();
                    break;
                }
                case 2:{
                    bl.addBrand();
                    break;
                }
                case 3:{
                    bl.searchBrand();
                    break;
                }
                case 4:{
                    bl.updateBrand();
                    break;
                }
                case 5:{
                    bl.saveToFile(brandUrl);
                    break;
                }
                case 6:{
                    cl.listCars();
                    break;
                }
                case 7:{
                    cl.printBasedBrandName();
                    break;
                }
                case 8:{
                    cl.addCar();
                    break;
                }
                case 9:{
                    cl.removeCar();
                    break;
                }
                case 10:{
                    cl.updateCar();
                    break;
                }
                case 11:{
                    cl.saveToFile(carUrl);
                    break;
                }
            }
        }
    }
}

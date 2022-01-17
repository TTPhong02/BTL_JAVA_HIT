package Controller;

import Basic.Shoes;
import Basic.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopController {
    private Shoes shoes = new Shoes();
    private FileController fileController = new FileController();

    public ShopController() {
    }

    public ShopController(Shoes shoes, FileController fileController) {
        this.shoes = shoes;
        this.fileController = fileController;
    }
    public List<Shoes> readShop(String namefile) {
        fileController.OpenFileToRead(namefile);
        List<Shoes> shoes = new ArrayList<>();
        while(fileController.getScanner().hasNext()){
            String information = fileController.getScanner().nextLine();
            String[] data = information.split("\\|");
            shoes.add(new Shoes(data[0],data[1],data[2],data[3],data[4],data[5],Double.parseDouble(data[6]),data[7],Integer.parseInt(data[8]) ));
        }
        fileController.CloseFileAfterRead();
        return shoes;
    }
    public List<Shoes> writeShop(List<Shoes> shoes, String namefile){
        fileController.OpenFileToWrite(namefile);
        for(Shoes shoes1 : shoes){
            fileController.getPrintWriter().println(shoes1.getIdShoes()+"|"+shoes1.getNameShoes()+"|"+shoes1.getIdType()+"|"+shoes1.getNameType()+"|"+shoes1.getColor()+"|"+shoes1.getSize()+"|"+shoes1.getPrice()+"|"+shoes1.getOrigin()+"|"+shoes1.getQuantity());
        }
        fileController.CloseFileAfterWrite();
        return shoes;
    }
}

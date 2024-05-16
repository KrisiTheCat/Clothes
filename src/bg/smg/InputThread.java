package bg.smg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Float.parseFloat;

public class InputThread implements Runnable {
    String filename;
    InputThread(){
        this.filename = "";
    }
    InputThread(String fn){
        this.filename = fn;
    }
    @Override
    public void run() {
        File file = new File(filename);
        Scanner input = null;

        try {
            input = new Scanner(file);
            while (input.hasNext()) {
                String name = input.next();
                String type = input.next();
                String priceS = input.next();
                priceS = priceS.replace(',', '.');
                float price = parseFloat(priceS);

                Clothes cloth = new Clothes(name, type, price);

                Main.addCloth(cloth);
            }
            input.close();
            Main.threadFinished();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}


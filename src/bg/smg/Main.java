package bg.smg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    private static PriorityQueue<Clothes> clothes = new PriorityQueue<>();
    private static int finished = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new InputThread("guess.txt"));
        thread1.start();
        Thread thread2 = new Thread(new InputThread("calvin_klein.txt"));
        thread2.start();
        Thread thread3 = new Thread(new InputThread("trussardi.txt"));
        thread3.start();

    }

    public static void threadFinished() {
        finished ++;
        if(finished == 3){



            
            File file = new File("output.txt");
            if (file.exists()) {
                file.delete();
                file = new File("output.txt");
            }
            PrintWriter output = null;
            try {
                output = new PrintWriter(file);

                output.println("Дрехи с най-ниски цени: ");
                for (int i = 0 ; i < Math.min(10, clothes.size()); i++){
                    Clothes cloth = clothes.poll();
                    output.println(cloth.toString());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }finally {
                // Close the file
                output.close();
            }
        }

    }
    public static void addCloth(Clothes cloth){
        clothes.add(cloth);
    }
}
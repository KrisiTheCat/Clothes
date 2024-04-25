package bg.smg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    private static List consideredCities = List.of("София", "Варна", "Бургас");

    public static void main(String[] args) {
        File file = new File("test_data.txt");

        Scanner input = null;
        List<Apartment> allAp = new ArrayList<>();

        //city, app-s
        Map<String, Integer> cityApCounter = new HashMap<>();

        try {
            input = new Scanner(file);
            while (input.hasNext()) {
                String city = input.next();
                int rooms = input.nextInt();
                int area = input.nextInt();
                int price = input.nextInt();
                String phone = input.next();
                Apartment apartment = new Apartment(city, rooms, area, price, phone);

                if(area>100 && consideredCities.contains(city) && rooms == 3 && !allAp.contains(apartment))
                    allAp.add(apartment);

                if(!cityApCounter.containsKey(city))
                    cityApCounter.put(city, 0);

                cityApCounter.put(city, cityApCounter.get(city)+1);

            }
            if(allAp.size() == 0) {
                throw new UnsuitableApartmentsException();
            }
            input.close();
        } catch (FileNotFoundException | UnsuitableApartmentsException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(cityApCounter.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.sort(allAp);

        List brockers = new ArrayList();
        for (int i = 0 ; i < Math.min(5, allAp.size()); i++)
            if (!brockers.contains(allAp.get(i).getPhone()))
                brockers.add(allAp.get(i).getPhone());

        File file2 = new File("output.txt");
        if (file2.exists()) {
            System.out.println("File already exists");
            System.exit(1);
        }
        PrintWriter output = null;
        try {
            output = new PrintWriter(file2);

            output.println("Брокери с най-ниски цени: ");
            for (Object br : brockers)
                output.println(br);

            output.print("Най-много възможности: ");
            for (int i = list.size()-1 ; i >=0 && list.get(i).getValue()==list.get(list.size()-1).getValue(); i--)
                output.print(list.get(i).getKey());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            // Close the file
            output.close();
        }


    }

    private static int compareDates(String date1, String date2){
        String[] d1 = date1.split("\\.");
        String[] d2 = date2.split("\\.");
        return (d1[2]).compareTo(d2[2]);
    }
}
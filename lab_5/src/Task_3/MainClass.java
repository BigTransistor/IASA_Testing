package Task_3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MainClass {

    public static void main(String[] args) throws IOException {

//        ArrayList<HourSalaryWorker> hourSalaryWorkers = initialiseWorkersRandomly("HourSalaryWorker",15);
//        writeHourSalaryWorkerstoList(hourSalaryWorkers,"HourSalaryWorker.txt","HourSalaryWorker");
//
//        ArrayList<FixedSalaryWorker> fixedSalaryWorkers = initialiseWorkersRandomly("FixedSalaryWorker",15);
//        writeFixedSalaryWorkerstoList(fixedSalaryWorkers,"FixedSalaryWorker.txt","FixedSalaryWorker");

        ArrayList<HourSalaryWorker> hourSalaryWorkers = initialiseWorkersFromList("HourSalaryWorker.txt","HourSalaryWorker");
        ArrayList<FixedSalaryWorker> fixedSalaryWorkers = initialiseWorkersFromList("FixedSalaryWorker.txt","FixedSalaryWorker");

        Collections.sort(hourSalaryWorkers);
        Collections.sort(fixedSalaryWorkers);

        System.out.println("First 5 name");

        System.out.println("\n" + "fixedSalaryWorkers");
        for (int i=0; i<5; i=i+1) System.out.println(fixedSalaryWorkers.get(i).getNameAndSurname());
        System.out.println("\n" + "hourSalaryWorkers");
        for (int i=0; i<5; i=i+1) System.out.println(hourSalaryWorkers.get(i).getNameAndSurname());

        System.out.println("\n" + "Last 3 ids");

        System.out.println("\n" + "fixedSalaryWorkers");
        for (int i=fixedSalaryWorkers.size()-1; i>=fixedSalaryWorkers.size()-4; i=i-1) System.out.println("id: " + Long.toString(fixedSalaryWorkers.get(i).getId()));
        System.out.println("\n" +   "hourSalaryWorkers");
        for (int i=hourSalaryWorkers.size()-1; i>=hourSalaryWorkers.size()-4; i=i-1) System.out.println("id: " + Long.toString(hourSalaryWorkers.get(i).getId()));
    }

    public static ArrayList initialiseWorkersFromList(String filename, String workerType)throws IOException{

        File file = new File(filename);
        Scanner scanner = new Scanner(file);


        if (workerType.equals("HourSalaryWorker")) {

            ArrayList<HourSalaryWorker> workersList = new ArrayList<HourSalaryWorker>();
            while (scanner.hasNextLine()) workersList.add(getHourSalaryWorkerFromScanner(scanner));
            return workersList;

        } else {

            ArrayList<FixedSalaryWorker> workersList = new ArrayList<FixedSalaryWorker>();
            while (scanner.hasNextLine()) workersList.add(getFixedSalaryWorkerFromScanner(scanner));
            return workersList;

        }

    }

    public static  HourSalaryWorker getHourSalaryWorkerFromScanner(Scanner scanner){

        if (!scanner.nextLine().equals("Worker")) throw new IllegalArgumentException("Wrong file format");

        String surname = getNextLineOfFile(":","Surname",scanner);
        String name = getNextLineOfFile(":","Name",scanner);
        long id = Long.parseLong(getNextLineOfFile(":","id",scanner));
        double salary = Double.parseDouble(getNextLineOfFile(":","salary",scanner));

        return new HourSalaryWorker(name,surname,salary,id);
    }

    public static  FixedSalaryWorker getFixedSalaryWorkerFromScanner(Scanner scanner){

        if (!scanner.nextLine().equals("Worker")) throw new IllegalArgumentException("Wrong file format");

        String surname = getNextLineOfFile(":","Surname",scanner);
        String name = getNextLineOfFile(":","Name",scanner);
        long id = Long.parseLong(getNextLineOfFile(":","id",scanner));
        double salary = Double.parseDouble(getNextLineOfFile(":","salary",scanner));

        return new FixedSalaryWorker(name,surname,salary,id);
    }

    public static String getNextLineOfFile(String separator, String varName, Scanner scanner){

        String[] nextLine = scanner.nextLine().split(separator);
        if (!nextLine[0].equals(varName)) throw new IllegalArgumentException("Wrong file format");
        return nextLine[1].replaceAll("\\s+","");
    }

    public static ArrayList initialiseWorkersRandomly(String workerType, int workersAmount) {

        String name = "name";
        String surname = "surname";
        long id = 0;
        double salary = 0;

        Random rand = new Random();

        if (workerType.equals("HourSalaryWorker")) {

            ArrayList<HourSalaryWorker> workersList = new ArrayList<HourSalaryWorker>();
            for (int i = 0; i < workersAmount; i = i + 1)
                workersList.add(new HourSalaryWorker(name + Integer.toString(i), surname + Integer.toString(i), rand.nextGaussian(), i));
            return workersList;

        } else {

            ArrayList<FixedSalaryWorker> workersList = new ArrayList<FixedSalaryWorker>();
            for (int i = 0; i < workersAmount; i = i + 1)
                workersList.add(new FixedSalaryWorker(name + Integer.toString(i), surname + Integer.toString(i), rand.nextGaussian(), i));
            return workersList;

        }
    }

    public static void writeHourSalaryWorkerstoList(ArrayList<HourSalaryWorker> workers, String filename, String workerType) throws IOException{
        FileWriter fileWriter = new FileWriter(filename);
        for (HourSalaryWorker worker: workers) worker.writeObjectToFile(fileWriter);
        fileWriter.close();
    }

    public static void writeFixedSalaryWorkerstoList(ArrayList<FixedSalaryWorker> workers, String filename, String workerType) throws IOException{
        FileWriter fileWriter = new FileWriter(filename);
        for (FixedSalaryWorker worker: workers) worker.writeObjectToFile(fileWriter);
        fileWriter.close();
    }
}

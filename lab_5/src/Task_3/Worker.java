package Task_3;

import java.lang.Math;
import java.io.IOException;
import java.io.FileWriter;

public abstract class Worker implements Comparable<Worker>{
    private double averageMonthSalary;
    private String name;
    private String surname;
    private long id;
    private double epselon = 0.00001;

    public Worker(String nameArg, String surnameArg, double salaryArg, long idArg){
        name = nameArg;
        surname = surnameArg;
        id = idArg;
        averageMonthSalary = countaverageMonthSalary(salaryArg);

    }

    abstract double countaverageMonthSalary(double salary);

    public String getNameAndSurname(){
        return "surname: " + surname + "\n" + "name: " + name;
    }

    public  long getId(){
        return id;
    }

    public double getAverageMonthSalary(){
        return averageMonthSalary;
    }

    public void writeObjectToFile(FileWriter fileWriter )throws IOException{
        fileWriter.write("Worker" + "\n");
        fileWriter.write("Surname: " + surname + "\n");
        fileWriter.write("Name: " + name + "\n");
        fileWriter.write("id: " + Long.toString(id) + "\n");
        fileWriter.write("Month average salary: " + Double.toString(averageMonthSalary) + "\n");
    }

    @Override
    public int compareTo(Worker other){

        if (Math.abs(this.averageMonthSalary - other.averageMonthSalary) > epselon) return this.averageMonthSalary > other.averageMonthSalary ?  1 : -1;
        else return this.name.compareTo(other.name);
    }
}

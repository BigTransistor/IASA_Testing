package Task_3;

public class HourSalaryWorker extends Worker {

    private double hourSalary;

    public HourSalaryWorker(String nameArg, String surnameArg, double salaryArg, long idArg) {
        super(nameArg, surnameArg, salaryArg,idArg);
        hourSalary = salaryArg;
    }

    @Override
    double countaverageMonthSalary(double salary) {
        return 20.8 * 8 * salary;
    }
}

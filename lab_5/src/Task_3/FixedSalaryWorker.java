package Task_3;

public class FixedSalaryWorker extends Worker {

    private double fixedSalary;

    public FixedSalaryWorker(String nameArg, String surnameArg, double salaryArg, long idArg) {
        super(nameArg, surnameArg, salaryArg,idArg);
        fixedSalary = salaryArg;
    }

    @Override
    double countaverageMonthSalary(double salary) {
        return salary;
    }
}

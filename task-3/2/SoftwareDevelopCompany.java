import java.util.ArrayList;
import java.util.List;

public class SoftwareDevelopCompany extends Company {

    public SoftwareDevelopCompany() {
        this.employees = new ArrayList<>();
    }

    @Override
    public int totalSalaryCalculation() {
        int totalSalary = 0;
        for (int i = 0; i < this.employees.size(); i++) {
            totalSalary += this.employees.get(i).salary;
        }
        return totalSalary;
    }
}

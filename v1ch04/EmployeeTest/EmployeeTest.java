import java.time.*;

/**
 * This program tests the Employee class.
 * @version 1.13 2018-04-10
 * @author Cay Horstmann
 */
public class EmployeeTest
{
   public static void main(String[] args)
   {
      // fill the staff array with three Employee objects
      EmployeeV2[] staff = new EmployeeV2[3];

      staff[0] = new EmployeeV2("Carl Cracker", 75000, 1987, 12, 15);
      staff[1] = new EmployeeV2("Harry Hacker", 50000, 1989, 10, 1);
      staff[2] = new EmployeeV2("Tony Tester", 40000, 1990, 3, 15);

      // raise everyone's salary by 5%
      for (EmployeeV2 e : staff)
         e.raiseSalary(5);

      // print out information about all Employee objects
      for (EmployeeV2 e : staff)
         System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay=" 
            + e.getHireDay());
   }
}

class EmployeeV2
{
   private String name;
   private double salary;
   private LocalDate hireDay;

   public EmployeeV2(String n, double s, int year, int month, int day)
   {
      name = n;
      salary = s;
      hireDay = LocalDate.of(year, month, day);
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public LocalDate getHireDay()
   {
      return hireDay;
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }
}

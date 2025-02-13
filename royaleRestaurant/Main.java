package royaleRestaurant;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        Employee employee2 = new Employee("fdsf","dss", "dsd",20.3, new GregorianCalendar(2025, Calendar.FEBRUARY, 13));
        System.out.println(employee2.toString());
    }
}

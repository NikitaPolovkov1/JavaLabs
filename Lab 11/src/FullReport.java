import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class FullReport {

    public static String Printinfo(Employee a, String language, String country) {

        Locale current = new Locale(language, country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("report", current);

        System.out.println(resourceBundle.getString("locale"));


        String str_salary = String.format("%.2f", a.getSalary());
        String str_fullname = a.getFullname().substring(0, 15);
        return String.format("%-15s  \t%150s", str_fullname, str_salary);
    }
}



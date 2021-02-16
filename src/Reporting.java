import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Reporting {
    public Reporting(String opt, List<Incident> incidentList) {
        AtomicInteger max_value = new AtomicInteger();
        if (opt.equals("highestValue")) {
            incidentList.forEach(distName ->{
                String value = distName.getValue();
                int intValue = Integer.parseInt(value);
                if (max_value.get() < intValue) {
                    max_value.set(intValue);
                }
            });
            System.out.println("Max Value: £" + max_value);
        }

        if (opt.equals("averageValue")) {
            System.out.println(opt);
        }
    }
}

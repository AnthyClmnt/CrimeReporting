import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Reporting {
    public Reporting(String opt, List<Incident> incidentList) {
        /* if (opt.equals("highestValue")) {
            AtomicInteger max_value = new AtomicInteger();
            incidentList.forEach(distName ->{
                String value = distName.getValue();
                int intValue = Integer.parseInt(value);
                if (max_value.get() < intValue) {
                    max_value.set(intValue);
                }
            });
            System.out.println("Max Value: £" + max_value);
        }

        if (opt.equals("incident>£x")) {
            Scanner s = new Scanner(System.in);
            System.out.println("--- Enter Value ---");
            System.out.print("Minimum Value: £");
            String inpValue = s.nextLine();

            System.out.println("List of Incidents: ");
            incidentList.forEach(distName ->{
                if (Integer.parseInt(inpValue) < Integer.parseInt(distName.getValue())) {
                    System.out.println("\n Postcode:" + distName.getPostcode() + "\n Value: " + distName.getValue() + "\n Date: " + distName.getMonth() + "/" + distName.getYear());
                    System.out.println(" ");
                }
            });
        }

        if (opt.equals("averageIncidentInYear")) {
            ArrayList<Integer> totalValues = new ArrayList<>();

            Scanner s = new Scanner(System.in);
            System.out.println("--- Enter Year ---");
            System.out.print("Crime Year: ");
            String inpYear = s.nextLine();

            incidentList.forEach(distName ->{
                String dateInfo = distName.getYear();
                if (inpYear.equals(dateInfo)){
                    totalValues.add(Integer.parseInt(distName.getValue()));
                }
            });
            int totalSum = 0;
            for (int value : totalValues) {
                totalSum += value;
            }
            System.out.println("Average value for year " + inpYear + " is: £" + totalSum);
        }

         */
    }
}

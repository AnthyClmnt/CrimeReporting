import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Reporting {
    public Reporting(String opt, List<Incident> incidentList, List<District> districtList) {
        if (opt.equals("highestValue")) {
            List<Incident> maxIncEachDist = new ArrayList<>();
            districtList.forEach(name -> {
                maxIncEachDist.add(name.maxIncidentVal());
            });
            List<Double> maxIncEachDistVal = new ArrayList<>();
            maxIncEachDist.forEach(name -> {
                maxIncEachDistVal.add(name.getValue());
            });
            double maxVal = Collections.max(maxIncEachDistVal);
            int maxInc = maxIncEachDistVal.indexOf(maxVal);
            Incident maxIncObj = maxIncEachDist.get(maxInc);
            System.out.println("-- Largest Incident on Record --" + "\n Postcode: " + maxIncObj.getPostcode()+
                    "\n Value: £" + maxIncObj.getValue() + "\n Date (mm/yyyy): " + maxIncObj.getMonth() +"/"+ maxIncObj.getYear());
        }

        if (opt.equals("incident>£x")) {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter Amount: £");
            String optAmount = s.nextLine();
            System.out.println("-- Incident Values Greater than £" + optAmount + " --");

            incidentList.forEach(name -> {
                int val = (int)name.getValue();
                if (val > Integer.parseInt(optAmount)) {
                    System.out.println("\n Postcode: " + name.getPostcode()+
                            "\n Value: £" + name.getValue() + "\n Date (mm/yyyy): " + name.getMonth() +"/"+ name.getYear());
                }
            });
        }

        if (opt.equals("averageIncidentInYear")) {
            List<Integer> avgIncValueEachDist = new ArrayList<>();
            Scanner s = new Scanner(System.in);
            System.out.println("Enter Year (yyyy): ");
            String optYear = s.nextLine();

            districtList.forEach(name -> {
                int distAvg = name.avgIncValueInYear(Integer.parseInt(optYear));
                avgIncValueEachDist.add(distAvg);
            });

            int maxAvgInc = Collections.max(avgIncValueEachDist);
            int avgInc = avgIncValueEachDist.indexOf(maxAvgInc);
            District avgIncDist = districtList.get(avgInc);
            System.out.println("District with highest average value: " + avgIncDist.getDistrictName());

        }
    }
}

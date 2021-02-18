import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This is a special class for representing a main object. This
 *
 *
 * @author Anthony Clermont
 *
 */


public class ReportingIO {
    public static void main(String[] args) throws FileNotFoundException {
        District newDist1 = new District("Newcastle", 1);
        District newDist2 = new District("Durham", 2);
        District newDist3 = new District("Sunderland", 1);

        Incident newInc1 = new Incident("NE4 5SN", "100", "02", "2020");
        Incident newInc2 = new Incident("NE4 9SN", "6700", "03", "2021");
        Incident newInc3 = new Incident("TS18 2SY", "12500", "11", "2021");

        /*testing erroneous data to see if compile error occurs.
        District errorDist = new District("Sunderland", "requires int value");
        Incident errorInc = new Incident("TS18 2SY", 1234, "27/11/2020");
         */

        List<District> districtList = new ArrayList<>();
        districtList.add(newDist1);
        districtList.add(newDist2);
        districtList.add(newDist3);

        List<Incident> incidentList = new ArrayList<>();
        incidentList.add(newInc1);
        incidentList.add(newInc2);
        incidentList.add(newInc3);

        Scanner s = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            Scanner input = new Scanner(new File("C:\\Users\\Anthony\\IdeaProjects\\HelloWorldExample\\src\\menu_text.txt"));
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
            String option = s.nextLine();
            switch (option) {
                case "1" -> enterDistrictInfo(districtList);
                case "2" -> enterIncidentInfo(incidentList);
                case "3" -> statistics(incidentList);
                case "5" -> test(districtList);
                case "4" -> {
                    System.out.println("You chose to quit");
                    quit = true;
                }
                default -> System.out.println("Invalid Option!!");
            }
        }
    }

    /**
     * This function is called, as a test, allowing me to test the system.
     * @param districtList, the function takes a list containing all the district objects
     */

    private static void test(List<District> districtList) {
        districtList.forEach(name -> System.out.println(name.getDistrictName() +": "+ name.getIncident()));
    }

    /**
     * This function is called when user wants to enter district information.
     * @param districtList, the function takes a list containing all the district objects
     */

    private static void enterDistrictInfo(List<District> districtList) {
        Scanner s = new Scanner(System.in);
        System.out.println("--- Enter District Info ---");
        System.out.print("District Name: ");
        String distName = s.nextLine();

        AtomicBoolean distFound = new AtomicBoolean(false);
        districtList.forEach(name -> {
            if (distName.equals(name.getDistrictName())) {
                name.addIncident();
                distFound.set(true);
            }
        });

        String distFoundString = String.valueOf(distFound);
        if (distFoundString.equals("false")) {
            District newDistrict = new District(distName, 1);
            districtList.add(newDistrict);
        }
    }

    /**
     * This function is called when a user wants to enter incident information
     * @param incidentList, the function takes a list containing all the incident objects
     */

    private static void enterIncidentInfo(List<Incident> incidentList) {
        Scanner s = new Scanner(System.in);
        System.out.println("--- Enter Incident Info ---");
        System.out.print("Postcode: ");
        String postcode = s.nextLine();
        System.out.print("Value of Stolen Goods: £");
        String value = s.nextLine();
        System.out.print("Month of Incident (mm): ");
        String month = s.nextLine();
        System.out.print("Year of Incident (mm): ");
        String year = s.nextLine();


        Incident newIncident = new Incident(postcode, value, month, year);
        incidentList.add(newIncident);
    }

    /**
     * The function is called when the user wants to see statical analysis of the data
     * @param incidentList, the function takes a list containing all the incident objects
     */

    private static void statistics(List<Incident> incidentList) {
        Scanner s = new Scanner(System.in);
        boolean returnToMenu = false;
        while (!returnToMenu) {
            System.out.println("""
                    ------Menu------
                    1: Highest Value Crime
                    2: Average Value Crime
                    3: All crimes > than £x
                    4: Return to main menu
                    ----------------""");

            String option = s.nextLine();
            switch (option) {
                case "1" -> new Reporting("highestValue", incidentList);
                case "2" -> new Reporting("averageIncidentInYear", incidentList);
                case "3" -> new Reporting("incident>£x", incidentList);
                case "4" -> returnToMenu = true;
                default -> System.out.println("Invalid Option!!");
            }
        }
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This is a special class for representing a main object. This
 *
 * @author Anthony Clermont
 *
 */

public class ReportingIO {
    public static void main(String[] args) throws FileNotFoundException {
        Incident newInc1 = new Incident("NE4", 10.50, "February", 2021);
        Incident newInc2 = new Incident("NE4", 6750.50, "March", 2021);
        Incident newInc3 = new Incident("TS18", 12500.00, "November", 2020);
        Incident newInc4 = new Incident("DH1", 35.47, "November", 2021);

        District newDist1 = new District("Newcastle", newInc1);
        newDist1.addIncident(newInc2);
        District newDist2 = new District("Durham",  newInc4);
        District newDist3 = new District("Teesside",  newInc3);

        HashMap<String, String> districtPostcode = new HashMap<>();
        districtPostcode.put("Newcastle", "NE4");
        districtPostcode.put("Durham", "DH1");
        districtPostcode.put("Sunderland", "SR1");
        districtPostcode.put("Teesside", "TS18");
        districtPostcode.put("NE4", "Newcastle");
        districtPostcode.put("DH1", "Durham");
        districtPostcode.put("SR1", "Sunderland");
        districtPostcode.put("TS18", "Teesside");

        List<District> districtList = new ArrayList<>();
        districtList.add(newDist1);
        districtList.add(newDist2);
        districtList.add(newDist3);

        List<Incident> incidentList = new ArrayList<>();
        incidentList.add(newInc1);
        incidentList.add(newInc2);
        incidentList.add(newInc3);
        incidentList.add(newInc4);

        Scanner s = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            Scanner input = new Scanner(new File("C:\\Users\\Anthony\\IdeaProjects\\HelloWorldExample\\src\\menu_text.txt"));
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
            String option = s.nextLine();
            switch (option) {
                case "1" -> enterDistrictInfo(districtList, districtPostcode, incidentList);
                case "2" -> enterIncidentInfo(incidentList, districtPostcode, districtList);
                case "3" -> statistics(incidentList, districtList);
                case "5" -> test(districtList, incidentList);
                case "4" -> {
                    System.out.println("You chose to quit");
                    quit = true;
                }
                default -> System.out.println("Invalid Option!!");
            }
        }
    }

    /**
     *
     * This function is called, as a test, allowing me to test the system easily.
     * @param districtList, the function takes a list containing all the district objects
     * @param incidentList the function takes a list containing all the incident objects
     */

    private static void test(List<District> districtList, List<Incident> incidentList) {
        //test function is called when user inputs option 5, this is not visible on the menu.

        //Testing to see if hard coded data is stored correctly
        districtList.forEach(name -> System.out.println(name.getDistrictName() +": "+ name.getIncident()));
        incidentList.forEach(name -> System.out.println(name.getPostcode() +" "+ name.getYear() +" "+ name.getMonth() +" "+ name.getValue()));

        //Testing to see if the function which retrieves the average incident value of a given year works correctly
        int testInc = districtList.get(0).avgIncValueInYear(2021);
        System.out.println(testInc);

        //Testing to see if the function which retrieves all incidents over a given amount works correctly
        List<Incident> incOverAmount = districtList.get(0).incWithValGtrThan(5);
        System.out.println(incOverAmount.get(0));
        Incident testing = incOverAmount.get(0);
        System.out.println(testing.getPostcode());
    }

    /**
     *
     * This function is called when user wants to enter district information.
     * @param districtList, this function takes a list containing all the district objects
     * @param districtPostcode, this function takes a hashmap, which connects postcodes with district names
     * @param incidentList this function takes a list containing all the incident objects
     */

    private static void enterDistrictInfo(List<District> districtList, HashMap<String, String> districtPostcode, List<Incident> incidentList) {
        Scanner s = new Scanner(System.in);
        System.out.println("--- Enter District Info ---");
        System.out.print("District Name: ");
        String distName = s.nextLine();

        AtomicBoolean distFound = new AtomicBoolean(false);
        districtList.forEach(name -> {
            if (distName.equals(name.getDistrictName())) {
                String postcode = districtPostcode.get(name.getDistrictName());
                System.out.print("Value of Stolen Goods: £");
                String value = s.nextLine();
                System.out.print("Month of Incident: ");
                String month = s.nextLine();
                System.out.print("Year of Incident (yyyy): ");
                String year = s.nextLine();

                Incident newIncident = new Incident(postcode, Double.parseDouble(value), month, Integer.parseInt(year));
                incidentList.add(newIncident);
                name.addIncident(newIncident);
                distFound.set(true);
            }
        });

        String distFoundString = String.valueOf(distFound);
        if (distFoundString.equals("false")) {
            System.out.print("District Postcode: ");
            String newDistPostcode = s.nextLine();
            System.out.print("Value of Stolen Goods: £");
            String newValue = s.nextLine();
            System.out.print("Month of Incident (mm): ");
            String newMonth = s.nextLine();
            System.out.print("Year of Incident (yyyy): ");
            String newYear = s.nextLine();

            districtPostcode.put(distName, newDistPostcode);
            districtPostcode.put(newDistPostcode, distName);

            Incident newIncident = new Incident(newDistPostcode, Double.parseDouble(newValue), newMonth, Integer.parseInt(newYear));
            incidentList.add(newIncident);

            District newDistrict = new District(distName, newIncident);
            districtList.add(newDistrict);
        }
    }

    /**
     *
     * This function is called when a user wants to enter incident information
     * @param incidentList, the function takes a list containing all the incident objects
     * @param districtPostcode this function takes a hashmap, which connects postcodes with district names
     * @param districtList this function takes a list containing all the district objects
     */

    private static void enterIncidentInfo(List<Incident> incidentList, HashMap<String, String> districtPostcode, List<District> districtList) {
        Scanner s = new Scanner(System.in);
        System.out.println("--- Enter Incident Info ---");
        System.out.print("Postcode: ");
        String postcode = s.nextLine();

        if (districtPostcode.containsValue(postcode)) {
            String distName = districtPostcode.get(postcode);
            System.out.print("Value of Stolen Goods: £");
            String value = s.nextLine();
            System.out.print("Month of Incident: ");
            String month = s.nextLine();
            System.out.print("Year of Incident (yyyy): ");
            String year = s.nextLine();

            Incident newIncident = new Incident(postcode, Double.parseDouble(value), month, Integer.parseInt(year));
            incidentList.add(newIncident);

            districtList.forEach(name -> {
                if (distName.equals(name.getDistrictName())) {
                    name.addIncident(newIncident);
                }
            });
        }
        else {
            System.out.print("District Name: ");
            String newDistName = s.nextLine();
            System.out.print("Value of Stolen Goods: £");
            String value = s.nextLine();
            System.out.print("Month of Incident: ");
            String month = s.nextLine();
            System.out.print("Year of Incident (yyyy): ");
            String year = s.nextLine();

            districtPostcode.put(newDistName, postcode);
            districtPostcode.put(postcode, newDistName);

            Incident newIncident = new Incident(postcode, Double.parseDouble(value), month, Integer.parseInt(year));
            incidentList.add(newIncident);

            District newDistrict = new District(newDistName, newIncident);
            districtList.add(newDistrict);
        }
    }

    /**
     *
     * The function is called when the user wants to see statical analysis of the data
     * @param incidentList, the function takes a list containing all the incident objects
     * @param districtList this function takes a list containing all the district objects
     */

    private static void statistics(List<Incident> incidentList, List<District> districtList) {
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
                case "1" -> new Reporting("highestValue", incidentList, districtList);
                case "2" -> new Reporting("averageIncidentInYear", incidentList, districtList);
                case "3" -> new Reporting("incident>£x", incidentList, districtList);
                case "4" -> returnToMenu = true;
                default -> System.out.println("Invalid Option!!");
            }
        }
    }
}

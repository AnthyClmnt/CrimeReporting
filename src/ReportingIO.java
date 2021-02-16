import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportingIO {
    public static void main(String[] args) throws FileNotFoundException {
        District newDist1 = new District("Newcastle", "Murder");
        District newDist2 = new District("Durham", "Robbery");
        District newDist3 = new District("Durham", "Robbery");

        Incident newInc1 = new Incident("NE4 5SN", "100", "10/02/21");
        Incident newInc2 = new Incident("NE4 9SN", "6700", "03/01/21");
        Incident newInc3 = new Incident("TS18 2SY", "12500", "27/11/20");

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
                case "3" -> search(districtList, incidentList);
                case "4" -> {
                    System.out.println("You chose to quit");
                    quit = true;
                }
                default -> System.out.println("Invalid Option!!");
            }
        }
    }

    private static void enterDistrictInfo(List<District> districtList) {
        Scanner s = new Scanner(System.in);
        System.out.println("--- Enter District Info ---");
        System.out.print("District Name: ");
        String distName = s.nextLine();
        System.out.print("Crime Type: ");
        String crimeType = s.nextLine();

        District newDistrict = new District(distName, crimeType);
        districtList.add(newDistrict);
    }

    private static void enterIncidentInfo(List<Incident> incidentList) {
        Scanner s = new Scanner(System.in);
        System.out.println("--- Enter Incident Info ---");
        System.out.print("Postcode: ");
        String postcode = s.nextLine();
        System.out.print("Value of Stolen Goods: £");
        String value = s.nextLine();
        System.out.print("Date of Incident: ");
        String date = s.nextLine();

        Incident newIncident = new Incident(postcode, value, date);
        incidentList.add(newIncident);
    }

    private static void search(List<District> districtList, List<Incident> incidentList) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        boolean returnToMenu = false;
        while (!returnToMenu) {
            System.out.println("------Menu------\n" +
                    "1: Highest Value Crime\n" +
                    "2: Average Value Crime\n" +
                    "3: Return to main menu\n" +
                    "----------------");

            String option = s.nextLine();
            switch (option) {
                case "1" -> new Reporting("highestValue", incidentList);
                case "2" -> new Reporting("averageValue", incidentList);
                case "3" -> { returnToMenu = true;
                }
                default -> System.out.println("Invalid Option!!");
            }
        }

        /*System.out.println("--- Enter District Name ---");
        System.out.print("District Name: ");
        String disAsked = s.nextLine();

        districtList.forEach(distName ->{
            if (disAsked.equals(distName.getDistrictName())){
                System.out.println(distName.getIncident());
            }
        });

         */
    }
}

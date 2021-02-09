import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReportingIO {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("hello");

        Scanner s = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            Scanner input = new Scanner(new File("C:\\Users\\Anthony\\IdeaProjects\\HelloWorldExample\\src\\menu_text.txt"));
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
            String option = s.nextLine();
            switch (option) {
                case "1" -> enterDistrictInfo();
                case "2" -> enterIncidentInfo();
                case "3" -> System.out.println("You chose option 3");
                case "4" -> {
                    System.out.println("You chose to quit");
                    quit = true;
                }
                default -> System.out.println("Invalid Option!!");
            }
        }
    }

    private static void enterDistrictInfo() {
        Scanner s = new Scanner(System.in);
        System.out.println("--- Enter District Info ---");
        System.out.print("District Name: ");
        String distName = s.nextLine();
        System.out.print("Crime Type: ");
        String crimeType = s.nextLine();

        //District newDistrict = new District(distName, crimeType);
        //test
        //System.out.println(newDistrict.getDistrictName());
    }

    private static void enterIncidentInfo() {
        Scanner s = new Scanner(System.in);
        System.out.println("--- Enter Incident Info ---");
        System.out.print("Postcode: ");
        String postcode = s.nextLine();
        System.out.print("Value of Stolen Goods: £");
        String value = s.nextLine();
        System.out.print("Date of Incident: ");
        String date = s.nextLine();

        //District newDistrict = new District(distName, crimeType);
        //test
        //System.out.println(newDistrict.getDistrictName());
    }
}

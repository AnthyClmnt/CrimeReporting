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
                case "1":
                    //enterDistrictInfo();
                    break;
                case "2":
                    //enterIncidentInfo();
                    break;
                case "3":
                    System.out.println("You chose option 3");
                    break;
                case "4":
                    System.out.println("You chose to quit");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid Option!!");
            }
        }
    }
}

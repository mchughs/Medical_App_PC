import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;
import java.util.Scanner;

public class AppTest {

    public static void main(String args[]) {
      /* Create a blank volunteer */
      LocalDate today = LocalDate.now();
      ArrayList<Medicine> blankMeds = new ArrayList<Medicine>();
      Volunteer myVolunteer = new Volunteer("blank", "blank", "blank", "blank",
      "blank", "blank", today, blankMeds);

      Scanner scanner = new Scanner(System.in);

      System.out.print("Enter your first name: ");
      myVolunteer.first = scanner.nextLine();

      System.out.print("Enter your last name: ");
      myVolunteer.last = scanner.nextLine();

      System.out.print("Enter your email: ");
      myVolunteer.email = scanner.nextLine();

      System.out.print("Enter your banking town: ");
      myVolunteer.banking_town = scanner.nextLine();

      System.out.print("Select your sector/year then press enter: ");
      System.out.print("\n (1) Extendee \n (2) H/Ag'16 \n (3) Ed'16 " +
      "\n (4) H/Ag'17 \n (5) Ed'17 \n (6) H/Ag'18 \n");
      int i = scanner.nextInt();
      switch(i) { // Add in a while loop to choose from a list of next contact dates
        case 1:
          myVolunteer.sector_year = "Extendee";
          break;
        case 2:
          myVolunteer.sector_year = "H/Ag'16";
          break;
        case 3:
          myVolunteer.sector_year = "Ed'16";
          break;
        case 4:
          myVolunteer.sector_year = "H/Ag'17";
          break;
        case 5:
          myVolunteer.sector_year = "Ed'17";
          int k = 0;
          LocalDate date1 = LocalDate.of(2017, 07, 12);
          LocalDate date2 = LocalDate.of(2017, 11, 27);
          LocalDate date3 = LocalDate.of(2019, 10, 01);
          List<LocalDate> dates_ED17 = asList(date1, date2, date3);
          while(today.compareTo(dates_ED17.get(k)) > 0) {
            k++;
          }
          myVolunteer.next_contact = dates_ED17.get(k);
          break;
        case 6:
          myVolunteer.sector_year = "H/Ag'18";
          break;
      }

      System.out.print("Select your region then press enter: ");

      System.out.print("\n (1) Arusha \n (2) DSM \n (3) Dodoma \n (4) Geita \n" +
      " (5) Iringa \n (6) Kagera \n (7) Katavi \n (8) Kigoma \n (9) Kilimanjaro \n" +
      " (10) Lindi \n (11) Manyara \n (12) Mara \n (13) Mbeya \n (14) Morogoro \n" +
      " (15) Mtwara \n (16) Mwanza \n (17) Njombe \n (18) Pemba \n (19) Pwani \n" +
      " (20) Rukwa \n (21) Ruvuma \n (22) Shinyanga \n (23) Simiyu \n (24) Singida" +
      "\n (25) Songwe \n (26) Tabora \n (27) Tanga \n (28) Unguja \n");

      List<String> regionsList = asList("Arusha", "DSM", "Dodoma", "Geita", "Iringa",
      "Kagera", "Katavi", "Kigoma", "Kilimanjaro", "Lindi", "Manyara", "Mara", "Mbeya",
      "Morogoro", "Mtwara", "Mwanza", "Njombe", "Pemba", "Pwani", "Rukwa", "Ruvuma",
      "Shinyanga", "Simiyu", "Singida", "Songwe", "Tabora", "Tanga", "Unguja");
      int j = scanner.nextInt();
      myVolunteer.region = regionsList.get(j-1);

      System.out.print("\n");

      myVolunteer.printVolunteer();
    }
}

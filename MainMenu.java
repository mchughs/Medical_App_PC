/* Main Menu Class */
import java.util.Scanner;
import java.util.List;
import static java.util.Arrays.asList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;

public class MainMenu {
  Volunteer myVolunteer;
  Scanner   scanner;

  public MainMenu(Volunteer myVolunteer) {
    this.scanner = new Scanner(System.in);
    this.myVolunteer = myVolunteer;
  }

  public void editVolunteer() {
    System.out.println("Select field to edit: ");
    List<String> optionsList = asList("First name", "Last name", "Email",
    "Banking Town", "Region", "Sector/Year");
    for(int j = 0; j < optionsList.size(); j++) {
      System.out.println(" (" + (j+1) + ") " + optionsList.get(j));
    }
    int i = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter new " + optionsList.get(i-1) + ": ");
    switch(i) {
      case 1:
        myVolunteer.first = scanner.nextLine();
        break;
      case 2:
        myVolunteer.last = scanner.nextLine();
        break;
      case 3:
        myVolunteer.email = scanner.nextLine();
        break;
      case 4:
        myVolunteer.banking_town = scanner.nextLine();
        break;
      case 5:
        List<String> regionsList = asList("Arusha", "DSM", "Dodoma", "Geita", "Iringa",
        "Kagera", "Katavi", "Kigoma", "Kilimanjaro", "Lindi", "Manyara", "Mara", "Mbeya",
        "Morogoro", "Mtwara", "Mwanza", "Njombe", "Pemba", "Pwani", "Rukwa", "Ruvuma",
        "Shinyanga", "Simiyu", "Singida", "Songwe", "Tabora", "Tanga", "Unguja");

        for(int k = 0; k < regionsList.size(); k++) {
          System.out.println(" (" + (k+1) + ") " + regionsList.get(k));
        }

        int a = scanner.nextInt();
        scanner.nextLine();
        myVolunteer.region = regionsList.get(a-1);
        break;
      case 6:
        List<String> sc_yrList = asList("Extendee", "H/Ag'16", "Ed'16", "H/Ag'17",
        "Ed'17", "H/Ag'18");

        for(int k = 0; k < sc_yrList.size(); k++) {
          System.out.println(" (" + (k+1) + ") " + sc_yrList.get(k));
        }

        int b = scanner.nextInt();
        scanner.nextLine();
        myVolunteer.sector_year = sc_yrList.get(b-1);
        break;
    }

    System.out.print("\n");
  }

  public void editMedicine() {
    System.out.println("Select a medicine to edit: ");

    for(int i = 0; i < myVolunteer.myMedicine.size(); i++) {
      System.out.println(" (" + (i+1) + ") " +
      myVolunteer.myMedicine.get(i).name);
    }

    int j = scanner.nextInt();
    Medicine editMed = myVolunteer.myMedicine.get(j-1);
    editMed.printMedicineComplete();

    System.out.println("Select a field to edit: ");
    System.out.println(" (1) Name \n (2) Count \n (3) Frequency \n (4) Expiration Date \n" +
    " (5) Received Date \n");

    int k = scanner.nextInt();
    scanner.nextLine();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    switch(k) {
      case 1:
        System.out.print("Enter new name: ");
        String str = scanner.nextLine();
        editMed.name = str.substring(0, 1).toUpperCase() + str.substring(1);
        break;
      case 2:
        System.out.print("Enter new count: ");
        editMed.count = scanner.nextInt();
        break;
      case 3:
        System.out.print("Enter new frequency: ");
        editMed.frequency = scanner.nextInt();
        break;
      case 4:
        System.out.print("Please enter the new expiration date in yyyy/mm/dd format: ");
        String expStr = scanner.nextLine();
        editMed.expiration = LocalDate.parse(expStr, format);
        break;
      case 5:
        System.out.print("Please enter the new received date in yyyy/mm/dd format: ");
        String rcvdStr = scanner.nextLine();
        editMed.received_date = LocalDate.parse(rcvdStr, format);
        break;
    }

    myVolunteer.myMedicine.get(j-1).printMedicineComplete();

  }

  public void addMedicine() {
    System.out.print("Please enter the name of the medicine: ");
    String name = scanner.nextLine();
    System.out.print("Please enter the number of doses: ");
    int count = scanner.nextInt();
    System.out.print("Please enter the number of doses taken over the course of a week: ");
    int frequency = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Please enter the expiration date in yyyy/mm/dd format: ");
    String expStr = scanner.nextLine();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate expiration = LocalDate.parse(expStr, formatter);

    System.out.print("Please enter the received date in yyyy/mm/dd format: ");
    String rcvdStr = scanner.nextLine();
    LocalDate received = LocalDate.parse(rcvdStr, formatter);

    Medicine newMedicine = new Medicine(name, count, frequency,
    expiration, received);

    myVolunteer.myMedicine.add(newMedicine);
  }

  public void sortMedicine() {
    System.out.print("Sort by: \n (1) name \n (2) expiration \n");
    int x = scanner.nextInt();
    switch(x) {
      case 1:
        Collections.sort(myVolunteer.myMedicine, new AlphaComparator());
        break;
      case 2:
        Collections.sort(myVolunteer.myMedicine, new ExpComparator());
        break;
    }

  }

}

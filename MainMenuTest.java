/* MainMenu Test */
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;
import java.util.Scanner;

public class MainMenuTest {

  public static void main(String args[]) {

    LocalDate ExpDateOne = LocalDate.of(2018, 03, 01);
    LocalDate ExpDateTwo = LocalDate.of(2019, 03, 01);
    LocalDate ExpDateThree = LocalDate.of(2017, 01, 01);
    LocalDate RcvDateOne = LocalDate.of(2017, 10, 01);
    LocalDate RcvDateTwo = LocalDate.of(2017, 10, 03);
    LocalDate RcvDateThree = LocalDate.of(2017, 11, 01);
    Medicine  medOne = new Medicine("Axilzone", 10, 2, ExpDateOne, RcvDateOne);
    Medicine  medTwo = new Medicine("Zileano", 30, 0, ExpDateTwo, RcvDateTwo);
    Medicine  medThree = new Medicine("botamin", 49, 7, ExpDateThree, RcvDateThree);

    LocalDate today = LocalDate.now();
    ArrayList<Medicine> blankMeds = new ArrayList<Medicine>();
    blankMeds.add(medOne);
    blankMeds.add(medTwo);
    blankMeds.add(medThree);
    Volunteer myVolunteer = new Volunteer("blank", "blank", "blank", "blank",
    "blank", "blank", today, blankMeds);

    myVolunteer.printVolunteer();

    MainMenu myMenu = new MainMenu(myVolunteer);
    Scanner scanner = new Scanner(System.in);
    boolean status = false; //NOTE get a better name
    while(!status) {
      System.out.println("Select menu option: ");
      System.out.print(" (1) Edit volunteer info \n (2) Edit existing medicine \n" +
       " (3) Add new medicine \n (4) Sort medicine \n");
      int i = scanner.nextInt();
      switch(i) {
        case 1:
          myMenu.editVolunteer();
          break;
        case 2:
          myMenu.editMedicine();
          break;
        case 3:
          myMenu.addMedicine();
          break;
        case 4:
          myMenu.sortMedicine();
      }

      myVolunteer.printVolunteer();
      System.out.print("Are you finished? \n (1) yes \n (2) no \n");
      int j = scanner.nextInt();
      if (j == 1) {
        status = true;
      }
    }
  }
}

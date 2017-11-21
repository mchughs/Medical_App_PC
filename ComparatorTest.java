/* Sorting Tester */
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;
import java.util.Scanner;

public class ComparatorTest {

    public static void main(String args[]) {
      /* Create a volunteer with a Medicine List*/

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

      MainMenu myMenu = new MainMenu(myVolunteer);

      myVolunteer.printVolunteer();

      myMenu.sortMedicine();

      System.out.print("\n");

      myVolunteer.printVolunteer();

    }
}

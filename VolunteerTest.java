import java.time.LocalDate;
import java.util.ArrayList;

// VolunteerTest object
public class VolunteerTest {

    public static void main(String args[]) {
      /* Create two volunteers using constructor */
      LocalDate ESTDate = LocalDate.of(2017, 11, 27); // Nov. 27th, 2017
      ArrayList<Medicine> medsOne = new ArrayList<Medicine>();
      ArrayList<Medicine> medsTwo = new ArrayList<Medicine>();
      ArrayList<Medicine> medsThree = new ArrayList<Medicine>();

      LocalDate ExpDateOne = LocalDate.of(2018, 03, 01);
      LocalDate ExpDateTwo = LocalDate.of(2017, 03, 01);
      LocalDate ExpDateThree = LocalDate.of(2018, 01, 01);
      LocalDate RcvDateOne = LocalDate.of(2017, 10, 01);
      LocalDate RcvDateTwo = LocalDate.of(2017, 10, 03);
      LocalDate RcvDateThree = LocalDate.of(2017, 11, 01);
      Medicine  medOne = new Medicine("Malarone", 21, 7, ExpDateOne, RcvDateOne);
      Medicine  medTwo = new Medicine("Diotane", 40, 0, ExpDateTwo, RcvDateTwo);
      Medicine  medThree = new Medicine("Calagel", 29, 7, ExpDateThree, RcvDateThree);

      medsOne.add(medOne);
      medsOne.add(medTwo);

      medsTwo.add(medThree);

      Volunteer volOne = new Volunteer("Sam", "McHugh", "smchugh230395@gmail.com",
      "Ed'17", "Iringa", "Makambako", ESTDate, medsOne);
      Volunteer volTwo = new Volunteer("Kristin", "Charbonnier", "kcharb@gmail.com",
      "Ed'17", "Kilimanjaro", "Moshi", ESTDate, medsTwo);
      Volunteer volThree = new Volunteer("David", "Gilmore", "DJDude@gmail.com",
      "H/Ag'16", "Njombe", "Makambako", ESTDate, medsThree);

      // Invoke methods for testing
      volOne.printVolunteer();
      volTwo.printVolunteer();
      volThree.printVolunteer();

      volOne.printVolunteerMeds();
      volThree.printVolunteerMeds();

      volOne.updateSendQueue();
      volOne.printVolunteer();

      volTwo.updateSendQueue();
      volTwo.printVolunteer();
    }
}

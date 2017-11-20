import java.time.LocalDate;

// MedicineTest object
public class MedicineTest {

    public static void main(String args[]) {
      /* Create two medicines using constructor */
      LocalDate ExpDateOne = LocalDate.of(2018, 03, 01);
      LocalDate ExpDateTwo = LocalDate.of(2017, 03, 01);
      LocalDate ExpDateThree = LocalDate.of(2018, 01, 01);
      LocalDate RcvDateOne = LocalDate.of(2017, 10, 01);
      LocalDate RcvDateTwo = LocalDate.of(2017, 10, 03);
      LocalDate RcvDateThree = LocalDate.of(2017, 11, 01);
      Medicine  medOne = new Medicine("Malarone", 21, 7, ExpDateOne, RcvDateOne);
      Medicine  medTwo = new Medicine("Diotane", 40, 0, ExpDateTwo, RcvDateTwo);
      Medicine  medThree = new Medicine("Calagel", 29, 7, ExpDateThree, RcvDateThree);

      // Invoke methods for testing
      medOne.printMedicine();
      medTwo.printMedicine();
      medThree.printMedicine();
    }
}

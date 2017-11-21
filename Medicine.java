import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Medicine object
public class Medicine {
    public String name; // name of medicine
    public int count; // the amount of doses
    public int frequency; // usage per week NOTE if 0 assume it is of situational use
    public LocalDate expiration; // expiration date - YYYY/MM/DD
    public LocalDate received_date;
    public Boolean replace; // recommendation on replacement

    LocalDate currDate = LocalDate.now();

    // construct a new volunteer with given fields
    public Medicine(String name, int count, int frequency,
    LocalDate expiration, LocalDate received_date) {
        this.name          = name.substring(0, 1).toUpperCase() + name.substring(1);
        this.count         = count;
        this.frequency     = frequency;
        this.expiration    = expiration;
        this.received_date = received_date;
        this.replace       = false;
    }

    public void printMedicine() {
      System.out.print(name);
    }

    // return a string representation of the invoking object
    public void printMedicineComplete() {
        System.out.println("Name: " + name);
        System.out.println("Count: " + count);
        System.out.println("Frequency: " + frequency);
        System.out.println("Expiration:   " + expiration.toString());
        System.out.println("Current Date: " + currDate.toString());
        System.out.println("received:     " + received_date.toString());
        checkReplace();
    }

    public void checkReplace() {
      if(currDate.compareTo(expiration) > 0) { // Expired
        replace = true;
        System.out.println(name + " has expired.\n");
      } else if(count - (ChronoUnit.WEEKS.between(received_date, currDate)*frequency) <= 0) { // Out of
        replace = true;
        System.out.println("You are out of " + name + ".\n");
      } else {
        replace = false;
        System.out.println("No need to replace " + name + ".");
        System.out.println(name + " will expire in about " + Long.toString(ChronoUnit.WEEKS.between(currDate, expiration)) + " weeks.");
        if(frequency == 0) {
          System.out.println("Non-frequent item.\n");
        } else {
          LocalDate outDate;
          if(count % frequency == 0) {
            outDate = received_date.plus((count/frequency), ChronoUnit.WEEKS);
          } else {
            outDate = received_date.plus(1 + (count/frequency), ChronoUnit.WEEKS);
          }
          System.out.println(name + " will be out by " + outDate.getMonth().toString() + ", " + outDate.getDayOfMonth() + ".\n");
        }
      }
    }
}

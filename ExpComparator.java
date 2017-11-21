/* Expiration Date Comparator */
import java.util.Comparator;

public class ExpComparator implements Comparator<Medicine> {
    public int compare(Medicine med1, Medicine med2) {
      return(med1.expiration.compareTo(med2.expiration));
    }
}

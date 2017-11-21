/* Alphabetical Comparator */
import java.util.Comparator;

public class AlphaComparator implements Comparator<Medicine> {
    public int compare(Medicine med1, Medicine med2) {
      return(med1.name.compareTo(med2.name));
    }
}

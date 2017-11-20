/* Menu Tester */
import java.util.List;
import java.util.function.Function;
import static java.util.Arrays.asList;

public class MenuTest {

    public static void main(String args[]) {
      /* Create a menu using constructor */

      List<Function> myFuncList = asList(/* place functions here */);

      Menu myMenu = new Menu(myFuncList);

      // Invoke methods for testing
      myMenu.printMenu();
    }
}

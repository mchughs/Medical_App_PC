/* Menu Class */
import java.util.List;
import java.util.function.Function;

public class Menu {

  List<Function> funcList;

  public Menu(List<Function> funcList) {
    this.funcList = funcList;
  }

  public void printMenu() {
    System.out.println("Please select menu choice: ");
    for(int i = 0; i < funcList.size(); i++) {
      // NOTE the toString function may not work for functions.
      System.out.println("(" + i + ") " + funcList.get(i).toString());
    }
  }

}

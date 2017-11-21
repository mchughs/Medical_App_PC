import java.time.LocalDate;
import java.util.ArrayList;

// Volunteer object
public class Volunteer {
    public String first;       // first name
    public String last;        // last name
    public String email;       // email address
    public String sector_year; // sector and year
    public String region;      // region of site
    public String banking_town;// nearest banking town
    public LocalDate next_contact;  // next contact point with PC
    public ArrayList<Medicine> myMedicine; // list of all volunteer medicine
    public ArrayList<Medicine> sendQueue;

    // construct a new volunteer with given fields
    public Volunteer(String first, String last, String email,
    String sector_year, String region, String banking_town,
    LocalDate next_contact, ArrayList<Medicine> myMedicine) {
        this.first        = first.substring(0, 1).toUpperCase() + first.substring(1);
        this.last         = last.substring(0, 1).toUpperCase() + last.substring(1);
        this.email        = email;
        this.sector_year  = sector_year;
        this.region       = region;
        this.banking_town = banking_town.substring(0, 1).toUpperCase() + banking_town.substring(1);
        this.next_contact = next_contact;
        this.myMedicine   = myMedicine;
        this.sendQueue    = new ArrayList<Medicine>();
    }

    public void printVolunteerMeds() {
      System.out.println(first + " " + last + ": \n");
      for(int i = 0; i < myMedicine.size(); i++) {
        myMedicine.get(i).printMedicineComplete();
      }
    }

    public void updateSendQueue() {
      for(int i = 0; i < myMedicine.size(); i++) {
        Medicine myMed = myMedicine.get(i);
        if(myMed.replace == true && !sendQueue.contains(myMed)) {
          sendQueue.add(myMed);
        }
      }
    }

    // return a string representation of the invoking object
    public void printVolunteer() {
        System.out.println("Name: " + first + " " + last);
        System.out.println("Email: " + email);
        System.out.println("Sector/Year: " + sector_year);
        System.out.println("Address: " + region + ", " + banking_town);
        System.out.println("Coming up contact date: " + next_contact.toString());

        System.out.print("Has medicine: ");
        if(myMedicine.size() > 0) {
          myMedicine.get(0).printMedicine();
        } else {
          System.out.print("None");
        }
        for(int i = 1; i < myMedicine.size(); i++) {
          System.out.print(", ");
          myMedicine.get(i).printMedicine();
        }
        System.out.println("");

        System.out.print("Medicine in sendQueue: ");
        if(sendQueue.size() > 0) {
          sendQueue.get(0).printMedicine();
        } else {
          System.out.print("None");
        }
        for(int i = 1; i < sendQueue.size(); i++) {
          System.out.print(", ");
          sendQueue.get(i).printMedicine();
        }
        System.out.println("\n");
    }
}

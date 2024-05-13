package utility;
import objects.Shelter;
import java.util.Scanner;
import java.util.ArrayList;

import objects.Pet;

public class Ink {
  private Scanner input = new Scanner(System.in);
  private int choice;
    public static String ANSI_RESET = "\u001B[0m";
    public static String ANSI_RED = "\u001B[31m";
    public static String ANSI_GREEN = "\u001B[32m";
    public static String ANSI_YELLOW = "\u001B[33m";
    public static String ANSI_BLUE = "\u001B[34m";
    public static String ANSI_PURPLE = "\u001B[35m";
    public static String ANSI_CYAN = "\u001B[36m";
    public static String ANSI_WHITE = "\u001B[37m";
  
  public void printWelcome() {
    // do nothing yet...
  } // printWelcome()

  public void printGoodday() {
    System.out.println("Have a great day pet lover");
  } // printGoodday()

  public int validateMainMenu() {
    boolean valid = false;

    while(!valid) {
        System.out.println(ANSI_GREEN + " MAIN MENU ");
        System.out.println(ANSI_PURPLE + "╔════════════════════╗");
        System.out.println("(1) View Pets\n(2) Shelter Details\n(3) Book Appointment\n(4) Exit");
        //System.out.println(ANSI_PURPLE + "║" + ANSI_BLUE + "(1) View Pets       " + ANSI_PURPLE + "║" );
        //System.out.println(ANSI_PURPLE + "║" + ANSI_BLUE + "(2) Shelter Details " + ANSI_PURPLE + "║" );
        //System.out.println(ANSI_PURPLE + "║" + ANSI_BLUE + "(3) Book Appointment" + ANSI_PURPLE + "║" );
        //System.out.println(ANSI_PURPLE + "║" + ANSI_BLUE + "(4) EXIT            " + ANSI_PURPLE + "║" );
        System.out.println(ANSI_PURPLE + "╚════════════════════╝" + ANSI_RED);
      try {
        choice = input.nextInt();
        if(choice >= 1 && choice <=2) {
          valid = true; // escapes loop only if choice is correct dt and range
        }
        else {
          System.out.println("Please enter a 1 - 4");
        }
      } 
      catch (Exception e) { // runs on exception
        System.out.println("That's not a number!");
      } 
      finally { // always runs!
        input.nextLine();
      }
    } // while
    return choice;
  } // printMenu()

  public void printPetDetails(Pet pet) {
    System.out.printf("Name: %s\n", pet.getName());
    System.out.printf("Age: %d\n", pet.getAge());
    System.out.printf("Breed: %s\n", pet.getBreed());
    System.out.printf("Color: %s\n", pet.getColor());
    System.out.printf("Owner: %s\n", pet.getOwner());
    System.out.printf("Is Adopted: %b\n", pet.getIsAdopted());
    System.out.println("Adopt this pet? Y/N");
  } // printPetDetails()
  
  public void printAvailablePets(ArrayList<Pet> pets) {
    for(int i = 0; i < pets.size(); i++) {
      if(!pets.get(i).getIsAdopted()) {
        System.out.println(ANSI_PURPLE + "╔═══════════════════════════════════════╗" + ANSI_BLUE);
        System.out.printf(ANSI_PURPLE + "║" + ANSI_YELLOW + "(%d)"+ANSI_GREEN+" Name: " + ANSI_BLUE+"%s" + ANSI_GREEN + " Type: " + ANSI_BLUE+" %s " + ANSI_GREEN + " Age: " + ANSI_BLUE+" %d\n",i + 1,
           pets.get(i).getName(), pets.get(i).getType(), pets.get(i).getAge());
        System.out.println(ANSI_PURPLE + "╚═══════════════════════════════════════╝" + ANSI_RED);
        
      }

    } // for
    System.out.println("Enter 0 to go back");
  } // printAvailablePets()

  public void printShelterDetails(Shelter shelter) {
    System.out.println(ANSI_PURPLE + "╔═══════════════════════════════════════╗" + ANSI_BLUE);
    System.out.printf(ANSI_PURPLE +  "║" + ANSI_GREEN + "Shelter Address: %s\n",shelter.getAddress() + ANSI_PURPLE +"     ║");
    System.out.println(ANSI_PURPLE + "╚═══════════════════════════════════════╝" + ANSI_RED);
    String[] hours = shelter.getHours();
    for(int i = 0; i < hours.length; i++) {
        System.out.println(ANSI_PURPLE + "╔════════════════════╗" );
      System.out.println(ANSI_PURPLE + "║" + ANSI_BLUE + hours[i]+ ANSI_PURPLE+ "     ║");
      System.out.println(ANSI_PURPLE + "╚════════════════════╝" + ANSI_RED);
    } // for
    System.out.println("hit any key to go back");
  } // printShelterDetails

} // class
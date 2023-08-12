


package clinic;

import java.util.Scanner;

class Messages {
    // Displays a welcome message to the user
    static void welcomeText() {
        System.out.println("Welcome to Local Clinic (Carlangas)!\n" + "\n"
                + "Your satisfaction is our top priority. We're here to serve you and exceed your expectations.");
    }

    // Displays a goodbye message to the user
    static void goodbyeText() {
        System.out.println("Goodbye and take care!" + "\n" + "Wishing you all the best.");
    }
}

class Person {
    static Scanner sc = new Scanner(System.in);
    static String firstName;
    static String lastName;

    // Gets personal information from the user (first name and last name)
    static void getPersonalInformation() {
        System.out.println("Please Input your first name: ");
        firstName = sc.nextLine();

        System.out.println("Please Input your last name: ");
        lastName = sc.nextLine();
    }
}

class BloodTypes {
	//this is our bloodTypeMap where the magic start by and is organized as a map 
	// it is basically a oneArray-dimsensionalArray
    public static String[][][] bloodTypeMap = 
								    	      {
									            {      {"A+",                 "O+",                 "B+",                "AB+", 
									                     "A-",                "O-",                 "B-",                "AB-"}},
									            
									            {    {"A+, AB+"},     {"O+, A+, B+, AB+"},      {"B+, AB+"},             {"AB+"},
									            {"A+, A-, AB+, AB-"},     {"Everyone"},     {"B+, B-, AB+, AB-"},      {"AB+, AB-"}},
									            
									            {{"A+, A-, O+, O-"},       {"O+, O-"},         {"B+, B-, O+, O-"},      {"Everyone"}, 
									                 {"A-, O-"},             {"O-"},               {"B-, O-"},       {"AB-, A-, B-, O-"}}
										       };   
            
    // Gets the blood type based on the given position
    public static String getBloodType(int position) {
        return bloodTypeMap[0][0][position];
    }
}

public class BloodTypeCompatibility {

    static Scanner sc = new Scanner(System.in);

    static String bloodType;
    static String bloodTypeResult;
    static int choice;
    static int position;

    public static void main(String[] args) {
        Messages.welcomeText();
        Person.getPersonalInformation();
        getChoice();
        getBloodType();
        setValues();
        Messages.goodbyeText();
    }

    // Gets the user's choice (Donor or Receiver)
    private static int getChoice() {
        do {
            System.out.println("Are you a donor or receiver (1 for Donor, 2 for Receiver): ");
            choice = sc.nextInt();

            if (choice != 1 && choice != 2) {
                System.out.println("Choice doesn't exist, please try again!");
            }
        } while (choice != 1 && choice != 2);

        return choice;
    }

    // Gets the user's blood type
    private static String getBloodType() {
        do {
            System.out.println("Please provide your blood type (A+, O+, B+, AB+, A-, O-, B-, AB-): ");
            bloodType = sc.next().toUpperCase();

            if (!validBloodType()) {
                System.out.println("Invalid blood type, please try again!");
            }
        } while (!validBloodType());

        return bloodType;
    }

    // Checks if the entered blood type is valid
    private static boolean validBloodType() {
        for (int i = 0; i < BloodTypes.bloodTypeMap[0][0].length; i++) {
            if (BloodTypes.getBloodType(i).equalsIgnoreCase(bloodType)) {
                position = i;
                return true;
            }
        }
        return false;
    }

    // Gets the blood types that a receiver can receive from a donor
    private static String getBloodTypesReceivedByReceiver() {
        for (int i = 0; i < BloodTypes.bloodTypeMap[choice][position].length; i++) {
            bloodTypeResult = BloodTypes.bloodTypeMap[choice][position][i];
        }
        return bloodTypeResult;
    }

    // Sets the values based on the user's choice (Donor or Receiver) and updates the blood bank quantities
    public static void setValues() {
        if (choice == 1) {
            String donorBloodTypes = getBloodTypesReceivedByReceiver();
            System.out.println(Person.firstName + " " + Person.lastName + ", as a donor, can give blood to: "
                    + donorBloodTypes + "\n");

            
            //        this part is not icluded because i wanted to implement to my code the posiblitiy of showing the quanities of each bloodType
            //        but it is still in process
            
            // *** Donor: Increase blood type quantities ***
            // Increase blood type quantities for each type the donor can give
          
            /*  for (int i = 0; i < BloodTypes.bloodTypeMap[choice][position].length; i++) {
                String bloodTypeGiven = BloodTypes.bloodTypeMap[choice][position][i];
                int bloodTypePosition = findBloodTypePosition(bloodTypeGiven);
                bloodBank.increaseBloodTypeQuantity(bloodTypePosition);
            }*/
        } else {
            String receiverBloodTypes = getBloodTypesReceivedByReceiver();
            System.out.println(Person.firstName + " " + Person.lastName + ", as a receiver, can receive blood from: "
                    + receiverBloodTypes + "\n");

           
            //        this part is not icluded because i wanted to implement to my code the posiblitiy of showing the quanities of each bloodType
            //        but it is still in process
            
            // *** Receiver: Decrease blood type quantities ***
            // Decrease blood type quantities for each type the receiver can receive
        
            /* for (int i = 0; i < BloodTypes.bloodTypeMap[choice][position].length; i++) {
                String bloodTypeReceived = BloodTypes.bloodTypeMap[choice][position][i];
                int bloodTypePosition = findBloodTypePosition(bloodTypeReceived);
                bloodBank.decreaseBloodTypeQuantity(bloodTypePosition);
            }*/
        }
    }

    
    
    //        this part is not icluded because i wanted to implement to my code the posiblitiy of showing the quanities of each bloodType
    //        but it is still in process
    
    
    // Finds the position of a blood type in the blood type map
    private static int findBloodTypePosition(String bloodType) {
        for (int i = 0; i < BloodTypes.bloodTypeMap[0][0].length; i++) {
            if (BloodTypes.getBloodType(i).equalsIgnoreCase(bloodType)) {
                return i;
            }
        }
        return -1;
    }
    
    // *** BloodBank class that manages blood type quantities ***
    static class bloodBank {
        private static int[] bloodTypeQuantities = new int[8];

        // Initialize the blood type quantities to 1
        static {
            for (int i = 0; i < bloodTypeQuantities.length; i++) {
                bloodTypeQuantities[i] = 1;
            }
        }

        // Increases the quantity of a specific blood type
        public static void increaseBloodTypeQuantity(int position) {
            bloodTypeQuantities[position]++;
            System.out.println("The quantity of blood type " + BloodTypes.getBloodType(position) + " has increased to "
                    + bloodTypeQuantities[position] + ".");
        }

        // Decreases the quantity of a specific blood type
        public static void decreaseBloodTypeQuantity(int position) {
            if (bloodTypeQuantities[position] > 0) {
                bloodTypeQuantities[position]--;
                System.out.println("The quantity of blood type " + BloodTypes.getBloodType(position)
                + " has decreased to " + bloodTypeQuantities[position] + ".");
            } else {
                System.out.println("Warning: The quantity of blood type " + BloodTypes.getBloodType(position)
                        + " is already 0.");
            }
        }

        // Gets the quantity of a specific blood type
        public static int getBloodTypeQuantity(int position) {
            return bloodTypeQuantities[position];
        }
    }
}

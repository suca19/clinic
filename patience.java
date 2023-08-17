 package clinic;

import java.util.Scanner;

public class patience {

		static int choice;
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
	    static int getChoice() {
	        do {
	            System.out.println("Are you a donor or receiver (1 for Donor, 2 for Receiver): ");
	            choice = sc.nextInt();

	            if (choice != 1 && choice != 2) {
	                System.out.println("Choice doesn't exist, please try again!");
	            }
	        } while (choice != 1 && choice != 2);

	        return choice;
	    }
	    static String getBloodType(String bloodType) {
	        do {
	            System.out.println("Please provide your blood type (A+, O+, B+, AB+, A-, O-, B-, AB-): ");
	            bloodType = sc.next().toUpperCase();

	            if (!Blood.validBloodType(BloodTypeCompatibility.position)) {
	                System.out.println("Invalid blood type, please try again!");
	            }
	        } while (!Blood.validBloodType(BloodTypeCompatibility.position));

	        return bloodType;
	    }
		
	    
	}


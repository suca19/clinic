package clinic;

import java.util.Scanner;

public class BloodTypeCompatibility {
    static Scanner sc = new Scanner(System.in);
    static String bloodType;
    static String bloodTypeResult;
  
    static int position;

    public static void main(String[] args) {
        messages.welcomeText();
        patience.getPersonalInformation();
        patience.getChoice();
        patience.getBloodType(bloodType);
        setValues();
        messages.goodbyeText();
        BloodBank.displayBloodBankQuantities();
    }


    

    

    private static void setValues() {
        if (patience.choice == 1) {
            String donorBloodTypes = Blood.getBloodTypesReceivedByReceiver(patience.choice, position);
            System.out.println(patience.firstName + " " + patience.lastName + ", as a donor, can give blood to: "
                    + donorBloodTypes + "\n");

            for (int i = 0; i < Blood.types[patience.choice].length; i++) {
                String bloodTypeGiven = Blood.types[patience.choice][i];
                int bloodTypePosition = Blood.find(bloodTypeGiven);
                BloodBank.increaseBloodTypeQuantity(bloodTypePosition);
            }
        } else {
            String receiverBloodTypes = Blood.getBloodTypesReceivedByReceiver(patience.choice, position);
            System.out.println(patience.firstName + " " + patience.lastName + ", as a receiver, can receive blood from: "
                    + receiverBloodTypes + "\n");

            for (int i = 0; i < Blood.types[patience.choice].length; i++) {
                String bloodTypeReceived = Blood.types[patience.choice][i];
                int bloodTypePosition = Blood.find(bloodTypeReceived);
                BloodBank.decreaseBloodTypeQuantity(bloodTypePosition);
            }
        }
    }

    
}
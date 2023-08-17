 package clinic;

class BloodBank {
    
	private static int[] bloodTypeQuantities = new int[8];

    static {
        for (int i = 0; i < bloodTypeQuantities.length; i++) {
            bloodTypeQuantities[i] = 1;
        }
    }

    static void increaseBloodTypeQuantity(int position) {
        bloodTypeQuantities[position]++;
        System.out.println("The quantity of blood type " + Blood.getBloodType(position) +
                " has increased to " + bloodTypeQuantities[position] + ".");
    }

    static void decreaseBloodTypeQuantity(int position) {
        if (bloodTypeQuantities[position] > 0) {
            bloodTypeQuantities[position]--;
            System.out.println("The quantity of blood type " + Blood.getBloodType(position) +
                    " has decreased to " + bloodTypeQuantities[position] + ".");
        } else {
            System.out.println("Warning: The quantity of blood type " + Blood.getBloodType(position) +
                    " is already 0.");
        }
    }

    static int getBloodTypeQuantity(int position) {
        return bloodTypeQuantities[position];
    }

    static void displayBloodBankQuantities() {
        System.out.println("Blood Bank Quantities:");
        for (int i = 0; i < bloodTypeQuantities.length; i++) {
            System.out.println(Blood.getBloodType(i) + ": " + bloodTypeQuantities[i]);
        }
    }
}
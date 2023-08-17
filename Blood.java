package clinic;


	public class Blood {
		
		/*enum Selection{
			DONOR,
			RECEIVER
		}*/
		
	    public static  String[][] types =
	            
	    	{{"A+", "O+", "B+", "AB+", "A-", "O-", "B-", "AB-"},

	                    {"A+, AB+", "O+, A+, B+, AB+", "B+, AB+", "AB+",
	                            "A+, A-, AB+, AB-", "Everyone", "B+, B-, AB+, AB-", "AB+, AB-"},

	                    {"A+, A-, O+, O-", "O+, O-", "B+, B-, O+, O-", "Everyone",
	                            "A-, O-", "O-", "B-, O-", "AB-, A-, B-, O-"}}
	                    ;

	    static boolean validBloodType(int position) {
	        for (int i = 0; i < types[0].length; i++) {
	            if (getBloodType(i).equalsIgnoreCase(BloodTypeCompatibility.bloodType)) {
	                position = i;
	                return true;
	            }
	        }
	        return false;
	    }

	    static String getBloodTypesReceivedByReceiver(int choice, int position) {
	        for (int i = 0; i <types[choice][position].length(); i++) {
	        	BloodTypeCompatibility.bloodTypeResult = types[choice][i];
	        }
	        return BloodTypeCompatibility.bloodTypeResult;
	    }
	    
	    public static String getBloodType(int position) {
	      
	    	return types[0][position];
	    }
	    
	    public static int find(String type) {
	    	
	        for (int i = 0; i < types[0].length; i++) {
	            if (Blood.getBloodType(i).equalsIgnoreCase(type)) {
	                return i;
	            }
	        }
	        return -1;
	    }
	}


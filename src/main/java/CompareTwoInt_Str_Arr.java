import java.util.*;

/**
 * @since June 2020
 * @author Akansh
 * 
 * Compare the Integers, Strings or Array of Integers. Choices are 1, 2 and 3 respectively.
 *
 */

class CompareTwoInt_Str_Arr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Comparator comp = new Comparator();
        
        int testCases = Integer.parseInt(scan.nextLine());
        while(testCases-- > 0){
            int condition = Integer.parseInt(scan.nextLine());
            switch(condition){
                case 1:
                    String s1=scan.nextLine().trim();
                    String s2=scan.nextLine().trim();
                    
                    System.out.println( (comp.compare(s1,s2)) ? "Same" : "Different" );
                    break;
                case 2:
                    int num1 = scan.nextInt();
                    int num2 = scan.nextInt();
                    
                    System.out.println( (comp.compare(num1,num2)) ? "Same" : "Different");
                    if(scan.hasNext()){ // avoid exception if this last test case
                        scan.nextLine(); // eat space until next line
                    }
                    break;
                case 3:
                    // create and fill arrays
                    int[] array1 = new int[scan.nextInt()];
                    int[] array2 = new int[scan.nextInt()];
                    for(int i = 0; i < array1.length; i++){
                        array1[i] = scan.nextInt();
                    }
                    for(int i = 0; i < array2.length; i++){
                        array2[i] = scan.nextInt();
                    }
                    
                    System.out.println( comp.compare(array1, array2) ? "Same" : "Different");
                    if(scan.hasNext()){ // avoid exception if this last test case
                        scan.nextLine(); // eat space until next line
                    }
                    break;
                default:
                    System.err.println("Invalid input.");
            }// end switch
        }// end while
        scan.close();
    }
}

class Comparator{
	boolean compare(int a, int b) {
		return a==b;
	}
	boolean compare(String s1, String s2) {
		return s1.equals(s2);
	}
	boolean compare(int[] a1, int[] a2) {
		boolean result = false;
		List<Integer> arList1 = null;
		List<Integer> arList2 = null;
		
		if(a1.length != a2.length) {
			result = false;
			return result;
		}
		else {
			arList1 = convertArrayToList(a1);
			arList2 = convertArrayToList(a2);
			arList1.removeAll(arList2);
			if(arList1.size() > 0) {
				result = false;
			}
			else {
				result = true;
			}
		}
		
		return result;
	}
	
	List<Integer> convertArrayToList(int[] test) {
		List<Integer> a = new ArrayList<Integer>();
		
		for(int val :  test) {
			a.add(val);
		}
		
		return a;
	}
}
package nov13;
import java.util.*;
public class bit {

	public static boolean check(int x, int k) {
		x=x>>>k;
		return x==0?false:true;
	}
	
	public static int onToOFF(int x, int k) {
		int twoLeftShiftK=1<<k;
		if(check(x, k)) {
			x=x^twoLeftShiftK;
		}
	
		return x;
	}
	
	public static int offToON(int x, int k) {
		int twoLeftShiftK=1<<k;
		if(!check(x, k)) {
			x=x^twoLeftShiftK;
		}
	
		return x;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int x=s.nextInt(), k=s.nextInt();
		System.out.println("On to off: "+onToOFF(x, k));
		System.out.println("Off to on: "+offToON(x, k));
	}

}

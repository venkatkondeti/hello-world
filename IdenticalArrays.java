package identicalarrays;

import java.util.HashMap;
import java.util.Map;

public class IdenticalArrays {
	
	public static boolean isIdentical(int[] a,int[] b){
		if(a.length!=b.length)
			return false;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int num : a) {
			if (!map.containsKey(num))
				map.put(num, 1);
			else{
				int value = map.get(num);
				map.put(num, ++value);
			}
		}
		
		for (int num : b) {
			if (!map.containsKey(num))
				return false;
			else{
				int value = map.get(num);
				if(value>1){
					value--;
					map.put(num, value);
				}else{
					map.remove(num);
				}
			}
		}
		
		System.out.println(map.toString());
		return true;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] { 12, 45, 23, 67, 12, 12, 45, 90 };
		int[] b = new int[] { 12, 45, 23, 67, 12, 12, 90, 90 };

		System.out.println(isIdentical(a, b));
	}
}

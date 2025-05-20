import java.util.HashMap;

public class PracticeProblem {

	public static void main(String args[]) {

	}
public static int fib(int num) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		return fibHelper(num, map);
	}

	public static int fibHelper(int num, HashMap<Integer, Integer> map) {
		int sum;
		if(num == 0){
			return 0;
		}
		if(num == 1){
			return 1;
		}

		if(map.containsKey(num)){
			return map.get(num);
		}

		sum = fibHelper(num-1, map) + fibHelper(num-2, map);
		map.put(num, sum);
		return sum;
	}
	
	public static int minCostClimbingStairs(int[] stairs){
		if(stairs.length == 1){
			return stairs[0];
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int cost = 0;
		int index = 0;

		return Math.min(minCostClimbingStairsHelper(stairs, cost, index, map),minCostClimbingStairsHelper(stairs, cost, 1, map) );
	}

	public static int minCostClimbingStairsHelper(int[] stairs, int cost, int index, HashMap<Integer, Integer> map){
		if(index >= stairs.length){
			return cost;
		}
		if(map.containsKey(index)){
			return map.get(index);
		}

		map.put(index, stairs[index] + Math.min(minCostClimbingStairsHelper(stairs, cost, index+1, map), minCostClimbingStairsHelper(stairs, cost, index+2, map)));
		return map.get(index);

	}
}

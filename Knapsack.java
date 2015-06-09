package knapsack;

public class Knapsack {
	
	int[] v = {7,2,1,6,12};
	int[] w = {3,1,2,4,6};
	
	int ks(int c, int i,int n){
		if(i>n)
			return 0;
		if(c<w[i])
			return ks(c,i+1,n);
		else 
			return Math.max(ks(c,i+1,n), v[i]+ks(c-w[i],i+1,n));
	}
	
	int[][] table = new int[10+1][5+1];
	
	
	int kst(int c,int i,int n){
		if(i>n)
			return table[c][i];
		if(table[c][i+1]==0)
			return table[c][i+1]=kst(c,i+1,n);
		//return table[c][i+1];
		
		if(table[c-w[i]][i+1]==0)
			table[c-w[i]][i+1]=kst(c,i+1,n);
		
		return Math.max(table[c][i+1], v[i]+table[c-w[i]][i+1]);
			
	}
	
	public static void main(String[] args) {
		Knapsack  knapsack = new Knapsack();
		System.out.println(knapsack.kst(3, 0, 4));
	}
}

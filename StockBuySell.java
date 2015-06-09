package com.kondeti.arrays;

public class StockBuySell {

	public static int maxProfit(int price[]){
	
		int[] profitUntil = new int[price.length];
		int[] profitFrom = new int[price.length];
		int minValue=price[0];
		for(int i=1;i<price.length;i++){
			minValue = Math.min(minValue, price[i]);
			profitUntil[i]=Math.max(profitUntil[i-1], price[i]-minValue);
		}
		int maxValue=price[price.length-1];
		for(int i=price.length-2;i>-1;i--){
			maxValue=Math.max(maxValue, price[i]);
			profitFrom[i]=Math.max(profitFrom[i+1], maxValue-price[i]);
		}
		int max=0;
		for(int i=0;i<price.length;i++){
			max=Math.max(max, profitFrom[i]+profitUntil[i]);
		}
		return max;
	}
	public static void main(String[] args) {
		int[] a={10,22,5,75,65,80};
		int[] b={2,30,15,10,8,25,80};
		System.out.println(StockBuySell.maxProfit(a));
		System.out.println(StockBuySell.maxProfit(b));
	}
}

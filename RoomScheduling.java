package com.kondeti.arrays;

import java.util.Arrays;

public class RoomScheduling {

	public static int maxRoomsNeeded(Intervals[] intervals){
		int[] startTimes = new int[intervals.length];
		int[] endTimes = new int[intervals.length];
		for(int i=0;i<intervals.length;i++){
			startTimes[i]=intervals[i].getStartTime();
			endTimes[i]=intervals[i].getEndTime();
		}
		Arrays.sort(startTimes);
		Arrays.sort(endTimes);
		int i=0,j=0,count=0,max=0;
		while(i<intervals.length){
			if(startTimes[i]<endTimes[j]){
				count++;
				i++;
				max=Math.max(count, max);
			}else if(startTimes[i]>endTimes[j]){
				count--;
				j++;
			}else{
				i++;
				j++;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		Intervals[] intervals = new Intervals[8];
		intervals[0]= new Intervals(3, 4);
		intervals[1] = new Intervals(1, 5);
		intervals[2] = new Intervals(2,6);
		intervals[3] = new Intervals(3,6);
		intervals[4]= new Intervals(5,8);
		intervals[5] = new Intervals(7,8);
		intervals[6] = new Intervals(6,9);
		intervals[7] = new Intervals(8,10);
		
		System.out.println(RoomScheduling.maxRoomsNeeded(intervals));
		
	}
}
class Intervals{
	int startTime;
	int endTime;
	public Intervals(final int startTime, final int endTime){
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public int getStartTime() {
		return startTime;
	}
	public int getEndTime() {
		return endTime;
	}
}

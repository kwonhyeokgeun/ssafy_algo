package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;



public class Test {
	
	static double getTheta(float x1, float y1, float x2, float y2) {
		double dx = x2 - x1;
		double dy = y2 - y1;
		return Math.atan2(dx, dy);
		//return Math.toDegrees(Math.atan2(dx, dy));
	}
    public static void main(String[] args) {
    	double h=1.0;
    	double w=Math.sqrt(3);
    	System.out.println(Math.atan(h/w)/3.14*180);
	}
    
    
}
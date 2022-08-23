package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;



public class Test {
    public static void main(String[] args) {
    	List<List<String>> datas = new ArrayList<>();
    	//List<List<String>> datas = new ArrayList<List<String>>(); 이거도 가능
    	
    	List<String> data1 = new ArrayList<>(); //1차
    	data1.add("1");
    	data1.add("2");
    	data1.add("3");		
    	List<String> data2 = new ArrayList<>(); //1차
    	data2.add("11");
    	data2.add("22");
    	data2.add("33");

    	//2차에 1차 넣기
    	datas.add(data1);
    	datas.add(data2);
    	System.out.println(datas.toString());  //[[1, 2, 3], [11, 22, 33]]
	}
    
    
}
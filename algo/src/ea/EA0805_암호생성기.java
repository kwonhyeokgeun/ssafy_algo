package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class EA0805_암호생성기 {

	public static Deque<Integer> deque;
    public static int minus;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn;
        int tc;
        for(int __=0; __<10; __++) {
            tc = Integer.parseInt(br.readLine());
            stn= new StringTokenizer(br.readLine());
            deque=new ArrayDeque<>();
             
            for(int ___=0; ___<8; ___++) {
                deque.add(Integer.parseInt(stn.nextToken()));
            }
            //System.out.println(deque);
            int num,num2;
            minus=1;
            while(true) {
                num=deque.pollFirst();
                num2=num-minus;
                if(num2<=0) {
                    deque.add(0);
                    break;
                }else {
                    deque.add(num2);
                    if(minus==5) {
                        minus=1;
                    }else {
                        minus++;
                    }
                }
            }
            System.out.print("#"+tc+" ");
            for(int i=0; i<8;i++) {
                System.out.print(deque.pollFirst()+" ");
            }System.out.println();
             
        }
    }
}

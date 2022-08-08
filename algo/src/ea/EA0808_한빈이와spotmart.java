package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EA0808_한빈이와spotmart {

	
	public static int N,M;
	public static int[] lst; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        StringTokenizer stn;
        for(int tc=1; tc<=T; tc++) {
        	stn=new StringTokenizer(br.readLine());
        	N=Integer.parseInt(stn.nextToken());
        	M=Integer.parseInt(stn.nextToken());
        	stn=new StringTokenizer(br.readLine());
        	lst=new int[N];
        	for(int i=0;i<N;i++) {
        		lst[i]=Integer.parseInt(stn.nextToken());
        	}
        	Arrays.sort(lst);
        	//System.out.println(Arrays.toString(lst));
        	int answer=-1;
        	int i=0, j=N-1,sum;
        	while(i<j) {
        		sum=lst[i]+lst[j];
        		if(sum>M) {
        			j--;
        		}else if(sum<M) {
        			answer=Math.max(answer, sum);
        			i++;
        		}else {
        			answer=sum;
        			break;
        		}
        	}
        	System.out.printf("#%d %d\n",tc,answer);
        }

	}

}

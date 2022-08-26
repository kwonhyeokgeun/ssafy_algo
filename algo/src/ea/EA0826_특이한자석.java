package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA0826_특이한자석 {
	
	static void turn(int s, int lr) {
		int[] turnlst = new int[4];
		turnlst[s]=lr;
		for(int i=s-1; i>=0; i--) {
			if(jss[i].tf[2]!=jss[i+1].tf[6]) {
				turnlst[i]=-turnlst[i+1];
			}else {
				break;
			}
		}
		for(int i=s+1; i<4; i++) {
			if(jss[i].tf[6]!=jss[i-1].tf[2]) {
				turnlst[i]=-turnlst[i-1];
			}else {
				break;
			}
		}
		
		for(int i=0; i<4; i++) {
			if(turnlst[i]==1) {
				jss[i].right();
			}else if(turnlst[i]==-1) {
				jss[i].left();
			}
			
		}
	}

	static int K;
	static JS[] jss;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		StringBuffer sb = new StringBuffer();
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			jss=new JS[4];
			K=Integer.parseInt(br.readLine());
			for(int i=0; i<4; i++) {
				stn=new StringTokenizer(br.readLine());
				int lst[]=new int[8];
				for(int x=0; x<8; x++) {
					lst[x]=Integer.parseInt(stn.nextToken());
				}
				jss[i]=new JS(lst);
			}
			int answer=0;
			sb.append("#"+tc+" ");
			for(int __=0; __<K; __++) {
				stn=new StringTokenizer(br.readLine());
				int s=Integer.parseInt(stn.nextToken())-1;
				int lr=Integer.parseInt(stn.nextToken());
				turn(s,lr);
			}
			for(int i=0; i<4; i++) {
				if(jss[i].tf[0]==1)
					answer+=(int)(Math.pow(2, i));
			}
			sb.append(answer+"\n");
		}
		System.out.println(sb);

	}
	
	static class JS{
		int[] tf=new int[8];
		JS(int[] tf) {
			this.tf=tf.clone();
		}
		void right() {
			int temp=tf[7];
			tf[7]=tf[6];
			tf[6]=tf[5];
			tf[5]=tf[4];
			tf[4]=tf[3];
			tf[3]=tf[2];
			tf[2]=tf[1];
			tf[1]=tf[0];
			tf[0]=temp;
		}
		void left() {
			int temp=tf[0];
			tf[0]=tf[1];
			tf[1]=tf[2];
			tf[2]=tf[3];
			tf[3]=tf[4];
			tf[4]=tf[5];
			tf[5]=tf[6];
			tf[6]=tf[7];
			tf[7]=temp;
		}
	}

}

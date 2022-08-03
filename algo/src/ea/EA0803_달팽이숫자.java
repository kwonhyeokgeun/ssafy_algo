package ea;

import java.util.Scanner;

//https://swexpertacademy.com/main/code/problem/problemDetail.do

public class EA0803_달팽이숫자 {

	public static void marking() {
        int d=1; //1:증가, -1:감소
        int nx,ny, x=-1,y=0;
        int count=N;
        
        int n=1;
        while(n<=N*N) { 
            for(int i=0; i<count; i++) {//우좌우좌...
            	x+=d;
            	mat[y][x]=n++;
            }
        	
        	count--;
        	for(int i=0; i<count; i++) { //하상하상..
        		y+=d;
        		mat[y][x]=n++;
        	}
        	d=d*(-1); //방향전환
        }
    }
 
    public static int N;
    public static int[][] mat;
    public static int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int tc=0; tc<T;tc++) {
            N=sc.nextInt();
            mat=new int[N][N];
            marking();
            System.out.println("#"+(tc+1));
            for(int y=0; y<N; y++) {
                for(int x=0; x<N; x++) {
                    System.out.print(mat[y][x]+" ");
                }
                System.out.println();
            }
        }
    }


}

package ea;

import java.util.Scanner;

//https://swexpertacademy.com/main/code/problem/problemDetail.do

public class EA0802_달팽이숫자 {

	public static void marking() {
        int dr=0, x=0,y=0;
        int nx,ny;
        for(int i=1; i<=N*N;i++) {
            mat[y][x]=i;
            nx=x+dirs[dr][0];
            ny=y+dirs[dr][1];
            if(nx<0 || nx>=N || ny<0 || ny>=N || mat[ny][nx]!=0) {
                dr=(dr+1)%4;
                x=x+dirs[dr][0];
                y=y+dirs[dr][1];
                continue;
            }
            x=nx;
            y=ny;
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

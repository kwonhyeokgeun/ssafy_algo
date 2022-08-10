package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
 
public class EA0810_정사각형방 {
     
    public static void go(int x, int y) {
        visited[y][x]=true;
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {x,y,1});
        int cx,cy,n,nx,ny;
        int cnt=1, minr=mat[y][x];
        while(!que.isEmpty()) {
            int[] xy=que.pollLast();
            cx=xy[0]; cy=xy[1]; n=xy[2];
            for(int dr=0;dr<4;dr++) {
                nx=cx+dirs[dr][0];
                ny=cy+dirs[dr][1];
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(visited[ny][nx]) continue;
                if(Math.abs(mat[ny][nx]-mat[cy][cx])==1) {
                    visited[ny][nx]=true;
                    que.add(new int[] {nx,ny,n+1});
                    cnt++;
                    minr=Math.min(minr, mat[ny][nx]);
                }
            }
            if(cnt>movecnt) {
                movecnt=cnt;
                room=minr;
            }else if(cnt==movecnt) 
                room=Math.min(room, minr);
             
        }
         
    }
 
    public static int N,movecnt,room;
    public static int[][] mat;
    public static boolean [][]visited;
    public static int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer stn;
        for(int tc=1; tc<=T; tc++) {
            room=0;
            movecnt=0;
            N=Integer.parseInt(br.readLine());
            mat=new int[N][N];
            for(int y=0; y<N; y++) {
                stn=new StringTokenizer(br.readLine());
                for(int x=0; x<N;x++) {
                    mat[y][x]=Integer.parseInt(stn.nextToken());
                }
            }
            visited=new boolean[N][N];
             
            for(int y=0; y<N; y++) {
                for(int x=0; x<N;x++) {
                    if(visited[y][x]) continue;
                    go(x,y);
                }
            }
            System.out.printf("#%d %d %d\n",tc,room,movecnt);
        }
    }
 
}


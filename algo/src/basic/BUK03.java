package basic;

import java.net.*;
import java.util.Arrays;
import java.io.*;

public class BUK03 {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "BUK03_KWONHYEOKGEUN";
	
	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 1, 1 }, { 127, 1 }, { 253, 1 }, { 1, 126 }, { 127, 126 }, { 253, 126 } };
	static float ball_r=(float)(5.73/2.0);
	
	static float getDist(float x1, float y1, float x2, float y2) {
		float dx = x2 - x1;
		float dy = y2 - y1;
		return (float) Math.sqrt(dx * dx + dy * dy);
	}
	
	static float getPow(float x1, float y1, float x2, float y2) {
		float dx = x2 - x1;
		float dy = y2 - y1;
		return dx * dx + dy * dy;
	}
	static double getTheta(float x1, float y1, float x2, float y2) {
		double dx = Math.abs(x2 - x1);
		double dy = Math.abs(y2 - y1);

		return Math.atan2(dx, dy);
	}

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		float[][] balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int)balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				float power = 0.0f;

				//////////////////////////////
				// 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
				//
				// 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
				//   - order: 1인 경우 선공, 2인 경우 후공을 의미
				//   - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				//     예) balls[0][0]: 흰 공의 X좌표
				//         balls[0][1]: 흰 공의 Y좌표
				//         balls[1][0]: 1번 공의 X좌표
				//         balls[4][0]: 4번 공의 X좌표
				//         balls[5][0]: 마지막 번호(8번) 공의 X좌표
				
				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.
				





				// whiteBall_x, whiteBall_y: 흰 공의 X, Y좌표를 나타내기 위해 사용한 변수
				float whiteBall_x = balls[0][0];
				float whiteBall_y = balls[0][1];
				System.out.println("흰공좌표 :" +Arrays.toString(balls[0]));
				for(int ti =1; ti<6; ti++) {
					
					// targetBall_x, targetBall_y: 목적구의 X, Y좌표를 나타내기 위해 사용한 변수
					float targetBall_x = balls[ti][0];
					float targetBall_y = balls[ti][1];
					if (targetBall_x<=-1.0f) continue;
					
				
					for(int hi=0; hi<6; hi++) {
						float hole_x=HOLES[hi][0];
						float hole_y=HOLES[hi][1];
			
						float target_hole_h=Math.abs(hole_y-targetBall_y);
						float target_hole_w=Math.abs(hole_x-targetBall_x);
						float target_hole_d=(float)Math.hypot((double)target_hole_h, (double)target_hole_w); //빗변
						
						
						float pow1=getPow(whiteBall_x, whiteBall_y, targetBall_x, targetBall_y);
						float pow2=getPow(targetBall_x, targetBall_y, hole_x, hole_y);
						float pow3=getPow(whiteBall_x, whiteBall_y, hole_x, hole_y); 
						
						if(pow3<=pow1+pow2) continue; //예각
						System.out.println("목표 구멍");
						System.out.println(Arrays.toString(HOLES[hi]));
						
						float go_x=-1.0f, go_y=-1.0f;
						
						//공을 보낼 위치 찾기
						if (hole_x == targetBall_x)
						{
							if (hole_y < targetBall_y)
							{
								go_x=targetBall_x;
								go_y=targetBall_y+ball_r*2;
							}
							else
							{
								go_x=targetBall_x;
								go_y=targetBall_y-ball_r*2;
							}
						}
						else if (hole_y ==targetBall_y)
						{
							if (hole_x < targetBall_x)
							{
								go_x=targetBall_x+ball_r*2;
								go_y=targetBall_y;
							}
							else
							{
								go_x=targetBall_x+ball_r*2;
								go_y=targetBall_y;
							}
						}
						double theta=getTheta(targetBall_x, targetBall_y, hole_x, hole_y);
						if (hole_x > targetBall_x && hole_y > targetBall_y) //1사분면
						{
							
							go_x= targetBall_x- 2*ball_r*(float)Math.cos(theta);
							go_y= targetBall_y- 2*ball_r*(float)Math.sin(theta);
							
						}
						else if (hole_x > targetBall_x && hole_y < targetBall_y) //2사분면
						{
							
							go_x= targetBall_x- 2*ball_r*(float)Math.cos(theta);
							go_y= targetBall_y+ 2*ball_r*(float)Math.sin(theta);
						}
						else if (hole_x < targetBall_x && hole_y < targetBall_y) //3사분면
						{
							
							go_x= targetBall_x+ 2*ball_r*(float)Math.cos(theta);
							go_y= targetBall_y+ 2*ball_r*(float)Math.sin(theta);
						}
						else {
							go_x= targetBall_x+ 2*ball_r*(float)Math.cos(theta);
							go_y= targetBall_y- 2*ball_r*(float)Math.sin(theta);
						}
						System.out.println("타겟 좌표"+targetBall_x +" , "+targetBall_y);
						System.out.println("보낼 좌표"+go_x +" , "+go_y);
						
						
						//칠 각 구하기
						if (whiteBall_x == go_x)
						{
							if (whiteBall_y < go_y)
							{
								angle=0;
							}
							else
							{
								angle=180;
							}
						}
						else if (whiteBall_y ==go_y)
						{
							if (whiteBall_x < go_x)
							{
								angle=90;
							}
							else
							{
								angle=270;
							}
						}
						
						double w=Math.abs(whiteBall_x-go_x);
						double h=Math.abs(whiteBall_y-go_y);
						if (whiteBall_x < go_x && whiteBall_y < go_y) //1사분면
						{
							double radian = Math.atan(h / w);
							angle = (float) ( 90 - ((180.0 / Math.PI) * radian));
						}
						else if (whiteBall_x < go_x && whiteBall_y > go_y) //2사분면
						{
							double radian = Math.atan(h / w);
							angle = (float) ( 90 + ((180.0 / Math.PI) * radian));
						}
						else if (whiteBall_x > go_x && whiteBall_y > go_y) //3사분면
						{
							double radian = Math.atan(h / w);
							angle = (float) ( 270 - ((180.0 / Math.PI) * radian));
						}
						else {
							double radian = Math.atan(h / w);
							angle = (float) ( 270 + ((180.0 / Math.PI) * radian));
						}
						System.out.println("angle : "+angle);
						power = (float) (Math.sqrt((w * w) + (h * h))/3.0)+15.0f;
						break;
						
					}
					break;
					
				}
				
				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);

			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

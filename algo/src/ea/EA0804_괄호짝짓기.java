package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class EA0804_괄호짝짓기 {
	
	//public static Stack<Character> stack;
	public static Deque<Character> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1; tc<=10; tc++) {
			stack = new ArrayDeque<>();
			int len = Integer.parseInt(br.readLine());
			String row= br.readLine();
			
			int answer=1;
			for(int i=0; i<len; i++) {
				char c = row.charAt(i);
				if(c=='(' || c=='[' || c=='{' || c=='<' ) {
					stack.add(c);
				}else {
					if(stack.isEmpty()) {
						answer=0;
						break;
					}
					if(c==')') {
						if(stack.pop()!='(') {
							answer=0;
							break;
						}
					}else if(c==']') {
						if(stack.pop()!='[') {
							answer=0;
							break;
						}
					}else if(c=='}') {
						if(stack.pop()!='{') {
							answer=0;
							break;
						}
					}else if(c=='>') {
						if(stack.pop()!='<') {
							answer=0;
							break;
						}
					}
				}
			}
			System.out.printf("#%d %d\n",tc,answer);
		}

	}

}

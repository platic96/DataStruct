package example4;

import example1.MyLinkedStack;
//import example3.MyLinkedQueue;

public class Reverse {
	 static String ReverseString(String str) {

		MyLinkedStack st = new MyLinkedStack();
		for(int i=0;i<str.length();i++) {
			st.Push(str.charAt(i));
		}
		String tmp = new String("");
		for(int i=0;i<str.length();i++) {
			tmp +=st.Pop();
		}
		return tmp;
	}
	
	 //2진수만드는 함수
	static void dectobinary(int data) {
		MyLinkedStack st = new MyLinkedStack();
		
		while (data>1) {
			st.Push(data%2);
			data = data/2;
		}
		st.Push(data);
		
		while(!st.IsEmpty()) {
			System.out.print(st.Pop());
		}
		System.out.println();
	}
	
	//2진수를 문자열로 만드는 함수
	static String dectobinaryString(int data) {
		MyLinkedStack st = new MyLinkedStack();
		
		while (data>1) {
			st.Push(data%2);
			data = data/2;
		}
		st.Push(data);
		String tmp = new String("");
		while(!st.IsEmpty()) {
			tmp+=st.Pop();
		}
		return tmp;
	}

	// 후위 연산 표기법
	static void postfix(String str) {
		//1. 스텍 생성
		/*2. 순환(전달된 문자열의 끝까지)
		 * 2.1'(' 무시
		 * 2.2 피연산자('A' ~ 'Z')
		 * 2.3 연산자 라면 스텍에 push
		 * 2.4 ')'연산자 라면 pop
		 * 		pop 결과를 출력
		 */
		
		MyLinkedStack st = new MyLinkedStack();
		for(int i = 0;i<str.length();i++) {
//			switch (str.charAt(i)) {
//				case '(':continue;
//				case 'A'
//			
			if(str.charAt(i)=='(')
				continue;
			else if(str.charAt(i)>='A' && str.charAt(i)<='Z')
				System.out.print(str.charAt(i)+" ");
			else if(str.charAt(i)=='+' || str.charAt(i)=='-' ||str.charAt(i)=='/' ||str.charAt(i)=='*') 
				st.Push(str.charAt(i));
			else if(str.charAt(i)==')') {
				System.out.print(st.Pop()+" ");
			}
			else {
				System.out.println("잘못된 입력이 들어왔습니다.");
				return;
			}
		}
		System.out.println();
	}
	
	//후위연산 표기법 숫자로
	static String postfix1(String str) {
		//1. 스텍 생성
				/*2. 순환(전달된 문자열의 끝까지)
				 * 2.1'(' 무시
				 * 2.2 피연산자('A' ~ 'Z')
				 * 2.3 연산자 라면 스텍에 push
				 * 2.4 ')'연산자 라면 pop
				 * 		pop 결과를 출력
				 */
				
		MyLinkedStack st = new MyLinkedStack();
		String tmp = new String("");
		for(int i = 0;i<str.length();i++) {
			if(str.charAt(i)=='(')
				continue;
			else if(str.charAt(i)>='0' && str.charAt(i)<='9') {
//						System.out.print(str.charAt(i)+" ");
				tmp +=str.charAt(i)+" ";
			}
			else if(str.charAt(i)=='+' || str.charAt(i)=='-' ||str.charAt(i)=='/' ||str.charAt(i)=='*') 
			{
					st.Push(str.charAt(i));
			}
			else if(str.charAt(i)==')') {
//						System.out.print(st.Pop()+" ");
				tmp += st.Pop() + " ";
			}
			else {
				System.out.println("잘못된 입력이 들어왔습니다.");
				return null;
			}
		}
		return tmp;
	}
	
	// 십의 자리 이상 후위연산 표기법 문자열 반환
	static String postfix2(String str) {
		//1. 스텍 생성
				/*2. 순환(전달된 문자열의 끝까지)
				 * 2.1'(' 무시
				 * 2.2 피연산자('A' ~ 'Z')
				 * 2.3 연산자 라면 스텍에 push
				 * 2.4 ')'연산자 라면 pop
				 * 		pop 결과를 출력
				 */
				
		MyLinkedStack st = new MyLinkedStack();
		//MyLinkedQueue qu = new MyLinkedQueue();
		
		String tmp = new String("");
		String result = new String("");
		for(int i = 0;i<str.length();i++) {
			if(str.charAt(i)=='(')
				continue;
			else if(str.charAt(i)>='0' && str.charAt(i)<='9') {
////						System.out.print(str.charAt(i)+" ");
				do{
					result += str.charAt(i++);
				}while(str.charAt(i)>='0' && str.charAt(i)<='9');
				i--;
				tmp += result +" ";
				result = "";
			}
			else if(str.charAt(i)=='+' || str.charAt(i)=='-' ||str.charAt(i)=='/' ||str.charAt(i)=='*') 
			{
					st.Push(str.charAt(i));
			}
			else if(str.charAt(i)==')') {
//						System.out.print(st.Pop()+" ");
				tmp += st.Pop() + " ";
			}
			else {
				System.out.println("잘못된 입력이 들어왔습니다.");
				return null;
			}
		}
		if(!st.IsEmpty())
			tmp += st.Pop();
		return tmp;
	}
	
	// 후위 표기법에 대한 연산 수행
	static int postfix_cal(String str) {
		MyLinkedStack st = new MyLinkedStack();
		
		char[] tmp = str.toCharArray();
		int sum = 0;
		int right,left;
		
		for(int i =0;i<str.length();i++) {
			if(tmp[i] >= '0' && tmp[i] <= '9' )
				st.Push(tmp[i]-'0');
			else if(tmp[i] == '+') {
				right = (int)st.Pop();
				left = (int)st.Pop();
				sum = left + right;
				st.Push(sum);
			}
			else if(tmp[i] == '-') {
				right = (int)st.Pop();
				left = (int)st.Pop();
				sum = left - right;
				st.Push(sum);
			}
			else if(tmp[i] == '*') {
				right = (int)st.Pop();
				left = (int)st.Pop();
				sum = left * right;
				st.Push(sum);
			}
			else if(tmp[i] == '/') {
				right = (int)st.Pop();
				left = (int)st.Pop();
				sum = left / right;
				st.Push(sum);
			}
		}
		return (int)st.Pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "abcdefg";
//		String rstr = ReverseString(str);
//		
//		System.out.println(str);
//		System.out.println(rstr);
//		
//		dectobinary(23);
//		System.out.println(dectobinaryString(23));
//		postfix("(A+(B*C))");
//		System.out.println( postfix2("123+(24*34)"));
		System.out.println( postfix_cal("1 2 3 * 4 5 - - 6 + +"));
		
	}

}

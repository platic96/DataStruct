package test;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int max= -1;
		System.out.println("문제 갯수를 입력하시오.");
		int cnt = sc.nextInt();
		App app = new App(cnt);
		app.print_All();
		BitArray answer = new BitArray(cnt);
		try{
			for(int i=0;i<cnt;i++) {

				int value = (int)(Math.random()*5+1);
				answer.Insert(value);
			}
		}catch(Exception ex) {
			
		}
		person[] ps = new person[4];
		ps = app.solution(answer);
		System.out.println("채점 결과입니다.");
		for(int i=0;i<ps.length;i++) {
			System.out.print("수포자 "+(i+1)+"[ 정답 : "+ps[i].ok+", 오답 :"+ps[i].no+"개]");
			System.out.println();
			if(ps[i].ok>max) {
				max = ps[i].ok;
			}
		}
		System.out.println("가장 높은 점수는 " + max +"입니다.");
	}

}

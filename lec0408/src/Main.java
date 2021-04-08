

import java.util.Scanner;

import com.javalec.inheritance.DmbCellPhone;

public class Main {
	
	public static void main(String[] args) {
		runClass rc = new runClass();
		rc.base_1();
	}

}

class runClass{
	Scanner sc = new Scanner(System.in);
	
	void base_1() {
		DmbCellPhone dcp = new DmbCellPhone("자바폰", "색상", 10);
		System.out.println("모델 : " + dcp.model);
		System.out.println("색상 : " + dcp.color);
		System.out.println("채널 : " + dcp.channel);
		dcp.powerOn();
		dcp.bell();
		dcp.sendVoice("여보세요");
		dcp.receiveVoice("안녕하세요! 저는 홍길동인데요");
		dcp.sendVoice("아! 반갑습니다. 그럼 안녕히~~~");
		dcp.turnOnDmb();
		dcp.changeChannelDmb(12);
		dcp.turnOffDmb();
	}
}
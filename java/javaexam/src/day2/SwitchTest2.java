package day2;

public class SwitchTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int month = (int) (Math.random() * 12) + 1;

		switch (month) { // ���� �� �� �ִ�. �� : ����, �����, ���� ���� �ִ� �ż����� ȣ���(int,String)
		case 12:
		case 1:
		case 2:
			System.out.print(month + " : �ܿ�");
			break;
		case 3:
		case 4:
		case 5:
			System.out.print(month + " : ��");
			break;
		case 6:
		case 7:
		case 8:
			System.out.print(month + " : ����");
			break;
		case 9:
		case 10:
		case 11:
			System.out.print(month + " : ����");
			break;
		}
	}
}
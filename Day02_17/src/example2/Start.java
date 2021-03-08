package example2;

public class Start {
	public static int search(char[] str, char key) {
		int mid;
		
		//������ �ʱ� ����
		int left = 0;
		int right = str.length-1;
		
		while(right >= left ) {
			mid = (right + left) /2; //������ �߰����� ȹ���Ѵ�.
			
			if( key == str[mid])	//ã�Ҵٸ�!
				return mid;
			else if( key < str[mid])  //���ʿ� ã���� �ϴ� ���� �ִ�.
				right = mid-1;
			else if( key > str[mid]) //�����ʿ� ã���� �ϴ� ���� �ִ�.
				left = mid+1;			
		}
		return -1; //��ã�� ���
	}

	public static void main(String[] args) {
		String str = "abcdefghij";
		
		int idx = search(str.toCharArray(),'a');
	}

}

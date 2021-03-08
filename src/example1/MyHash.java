package example1;

enum STATE{
	DELETE,
	EMPTY 
}

public class MyHash {
	//�ɹ� �ʵ�
	private Object[] arr;	//�迭 ������ max������ 120%ũ��� ����ڴ�.
	private int bucket_max; //�迭�� ���� ũ��[�迭�� ������ ��, �ؽ� �Լ����ο���, �����̵�]
	private int max;		//������ �ִ� ũ��[Overflow ���� �˻�]
	private int size;		//���� ����� ����
	
	//������
	public MyHash(int max) {
		this.max = max;
		this.size = 0;
		this.bucket_max = (int)(max*1.2);
		
		//�迭 ���� �� �ʱ�ȭ!
		arr = new Object[bucket_max];
		for(int i=0; i< arr.length; i++)
			arr[i] = -1;
	}
	
	//get & set �޼���
	public Object getData(int idx) {
		return arr[idx];
	}
	
	//��� �޼���
	/*
	 * 0. �ߺ��� üũ
	 * 1. �����÷ο� ���� �˻�(���� ����)
	 * 2. �ؽ� �� ȹ��(�ؽ� �Լ��� Ȱ��)
	 * 3. ���� �˰���
	 *    ������̳� or ������ ������ ã��(�ݺ���, ������: �ؽ����� ��ġ����)
	 *     - �̵��� �����̵� �ʿ�! 
	 *    ã�� ������ ��ġ�� ����
	 *    size ����
	 */
	private boolean IsOverflow() {
		if( max <= size)
			return true;
		else
			return false;
	}
	
	private boolean IsUniq(Object key) {
		for(int i=0; i<arr.length; i++) {
			if( (int)arr[i] == (int)key)
				return false;
		}
		return true;
	}
	
	public boolean Insert(Object key) {
		if(IsUniq(key) == false)
			return false;
		
		if(IsOverflow() == true)
			return false;
		
		int hvalue = HashFunction(key);
		
		while((int)arr[hvalue] != -1 && (int)arr[hvalue] != -2)
			hvalue = (hvalue+1)% bucket_max;
		
		arr[hvalue] = key;
		size++;
		
		return true;
	}
	
	/*
	 * 1. �ؽ��� ��´�(�ؽ� ���̺�)
	 * 2. �ݺ���Ȱ��˻�([�ؽ���, �ش��Ŷ�� ���������(-1)], �����̵�!
	 *    if(����� ���� Ű���� ��)
	 * [�����] ��Ŷ�� �ε��� ��ȯ(���н� -1)   
	 */
	public int Select(Object key) {
		int hvalue = HashFunction(key);
		for(int i = hvalue; (int)arr[i] != -1; i = (i+1)%bucket_max) {
			if( (int)arr[i] == (int)key)
				return i;
		}			
		return -1;
	}
	
	/*
	 * 1. key���� ����� ������ �ε��� ���� ȹ��(SelectȰ��)
	 * 2.1 ���°��(Select�� ��ȯ���� -1)  return false
	 * 2.2 ã�� ���
	 *     �ش� ������ ���� -2�� ����
	 *     size����
	 *     return true     
	 */
	public boolean Delete(Object key) {
		int idx = Select(key);
		if( idx == -1)
			return false;
		
		arr[idx] = -2;
		size--;			
		return true;
	}
	
	public void Clear() {
		this.size = 0;
		
		for(int i=0; i< arr.length; i++)
			arr[i] = -1;
	}
	
	public void PrintAll() {
		System.out.println("\n--------------------------------------------------------------------------------------");
		for(int i=0; i< arr.length; i++) {
			System.out.print(i + "\t");
		}
		System.out.println("\n--------------------------------------------------------------------------------------");
		for(int i=0; i< arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("\n--------------------------------------------------------------------------------------");
	}
	
	//�ؽ� �Լ�
	private int HashFunction(Object key) {	
		return ((int)key % bucket_max);
	}	
}

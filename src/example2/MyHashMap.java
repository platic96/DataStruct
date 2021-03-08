package example2;

/*
 * MAP :pair������ �����ڷᱸ�� 
 *      [KEY, VALUE]
 *      KEY : �˻��� Ȱ��!, �ߺ����ȵ�!
 *      VALUE : ���嵥����, �ߺ����
 */

//Pair���·� ������ ������ Ÿ��!
class PairData{
	int key;	//ȸ����ȣ
	Member mem; //���尪
	
	public PairData(Member mem) {
		this.key = mem.getNumber();
		this.mem = mem;
	}
}

/*
 * ���� ������ �ϰ���
 * �ڹ� Collection Ŭ����
 * 1.  Object ����(�ʱ⿡�� JDK�� ���ø� ���� X)
 *      �ϳ��� ����ҿ� ����, ��ü ��� �����ص� ������ ����! ������.
 * 2.  ���ø� ��� ����( JDK 1.2?)
 * 
 * ==> Object�� �����ϴ� ���·� ����!!!!!!!! null(������� ��)
 */
public class MyHashMap {
	//�ɹ� �ʵ�
	private Object[] arr;	//�迭 ������ max������ 120%ũ��� ����ڴ�.
	private int bucket_max; //�迭�� ���� ũ��[�迭�� ������ ��, �ؽ� �Լ����ο���, �����̵�]
	private int max;		//������ �ִ� ũ��[Overflow ���� �˻�]
	private int size;		//���� ����� ����
	
	//������
	public MyHashMap(int max) {
		this.max = max;
		this.size = 0;
		this.bucket_max = (int)(max*1.2);
		
		//�迭 ���� �� �ʱ�ȭ!
		arr = new Object[bucket_max];
		for(int i=0; i< arr.length; i++)
			arr[i] = null; //<========================= -1 -> null (����1)
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
				Member mem = (Member)arr[i];	
				if(mem != null && mem.getNumber() == (int)key)  //<------(����2)
					return false;
		}
		return true;		
	}
	
	public boolean Insert(int key, Object value) {
		if(IsUniq(key) == false)
			return false;
		
		if(IsOverflow() == true)
			return false;
		
		int hvalue = HashFunction(key);
		
		//while((int)arr[hvalue] != -1 && (int)arr[hvalue] != -2)
		while(arr[hvalue] != null && ((Member)arr[hvalue]).getNumber()!=-2)	//<============================����3)
			hvalue = (hvalue+1)% bucket_max;
		
		arr[hvalue] = value;  //<-------------------------------
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

		for(int i = hvalue; arr[i] != null; i = (i+1)%bucket_max) {
			Member mem = (Member)arr[i];	
			if( mem!= null && mem.getNumber() == (int)key)  //<========= 4)����
				return i;
		}			
		return -1;
	}
	
	public Object KeyToValue(int key) {
		int idx = Select(key);
		if( idx == -1)
			return null;
		
		return arr[idx];
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
		
		((Member)arr[idx]).setNumber(-2);		//<==================== ����2)
		size--;			
		return true;
	}
	
	public void Clear() {
		this.size = 0;
		
		for(int i=0; i< arr.length; i++)
			arr[i] = null;						//<========================== ����
	}
	
	public void PrintAll() {
		System.out.println("\n--------------------------------------------------------------------------------------");
		for(int i=0; i< arr.length; i++) {
			System.out.print(i + "\t");
		}
		System.out.println("\n--------------------------------------------------------------------------------------");
		for(int i=0; i< arr.length; i++) {
			if( arr[i] == null)								//<======= null��
				System.out.print("-1" + "\t");
			else
				System.out.print(((Member)arr[i]).getNumber() + "\t");				
		}
		System.out.println("\n--------------------------------------------------------------------------------------");
	}
	
	//�ؽ� �Լ�
	private int HashFunction(Object key) {	
		return ((int)key % bucket_max);
	}	
}

package sort;
/**
 * 冒泡排序
 * 按顺序 进行2个数比较，并进行位置替换
 * 
 * @author ZEVUN-ZY
 * @param <T>
 *
 */
public class test1{
	public  void Sort(int[] array){
		int out,in;
		int length = array.length;
		System.out.println("length:"+length*length);
		int count = 0;
		for(out = length;out >1;out--){
			for(in = 1;in < out;in++){
				if(array[in] > array[in-1]){
					int min = array[in-1];
					array[in-1] = array[in];
					array[in] = min;
					count++;
				}
			}
		}
		for(int i = 0 ; i < array.length;i++){
			System.out.println(array[i]);
		}
		System.out.println("循环次数："+count);
	}
	public static void main(String[] args) {
		int[] array = {1,44,25,53,12,6,25,66,25,77,44,68};
		test1 t = new test1();
		t.Sort(array);
	}
}

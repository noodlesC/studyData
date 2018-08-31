package others;

/**
 * @author leichao
 * @description:
 */
public class Test2 {

	static final int s = 100; //自定义的台阶数

	static int compute(int stair){
		if ( stair <= 0){
			return 0;
		}
		if (stair == 1){
			return 1;
		}
		if (stair == 2){
			return 2;
		}
		return compute(stair-1) + compute(stair-2);
	}

	public static void main(String args[]) {
		System.out.println("共有" + compute(s) + "种走法");
	}

}

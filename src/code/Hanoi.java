package code;
/**
 *@author : gaoweibupt@gmail.com
 *
 * ����ʱ�䣺 2015��10��26������8:41:14
 */
public class Hanoi {
	
	public static void main(String[] args){
		Tower[] tower = new Tower[3];
		for (int i = 0; i < 3; i++){
			tower[i] = new Tower(i);
		}
		int n = 5;
		for (int i = n; i > 0; i --){
			tower[0].add(i);
		}
		tower[0].moveDisks(n, tower[2], tower[1]);
		tower[2].print();
	}
}

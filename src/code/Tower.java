package code;

import java.util.Stack;

/**
 *@author : gaoweibupt@gmail.com
 *
 * ����ʱ�䣺 2015��10��26������8:16:01
 */
public class Tower {
	private Stack<Integer> disks;
	
	private int index;
	
	Tower(int index){
		this.index = index;
		disks = new Stack<Integer>();
	}
	
	public int getIndex(){
		return index;
	}
	
	public void add(int data){
		if (!disks.isEmpty() && disks.peek() < data){
			System.out.println("��������");
		}
		else{
			disks.push(data);
		}
		
	}
	
	public void moveTopTo(Tower t){
		int top = disks.pop();
		t.add(top);
		System.out.println("������" + top + "����" + this.index + "�ƶ���" + t.getIndex());
	}
	
	
	public void moveDisks(int n, Tower destination, Tower buffer){
		if (n > 0){
			moveDisks(n-1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n-1, destination, this);
		}
	}
	
	
	public void print(){
		while(!disks.isEmpty()){
			System.out.println("Tower"+ index + "is:  " + disks.pop());
		}
	}
}

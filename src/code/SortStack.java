package code;

import java.util.Stack;

/**
 *@author : gaoweibupt@gmail.com
 *
 * ����ʱ�䣺 2015��10��26������10:03:28
 * 
 * �ڰ���ϰ��3.6
 * �������ջ����������� ֻ��ʹ��һ�������ջ�����ʱ
 */
public class SortStack {
	Stack<Integer> stack = null;
	public SortStack(){
		stack = new Stack<Integer>();
	}
	
	public void push(int data){
		stack.push(data);
	}
	
	public void sort(){
		Stack<Integer> temp = new Stack<Integer>();
		while(!stack.isEmpty()){
			int tmp = stack.pop();
			while(!temp.isEmpty() && tmp > temp.peek()){
				stack.push(temp.pop());
			}
			temp.push(tmp);
		}
		this.stack = temp;
	}
	
	public int pop(){
		return stack.pop();
	}
	
	public int peek(){
		return stack.peek();
	}
	
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	
	
}

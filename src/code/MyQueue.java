package code;

import java.util.Stack;

/**
 *@author : gaoweibupt@gmail.com
 *
 * ����ʱ�䣺 2015��10��26������9:10:03
 * 
 * �ڰ���ϰ��3.5
 * 
 */
public class MyQueue {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	MyQueue(){
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	private void rotate(Stack<Integer> s1, Stack<Integer> s2){
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
	}
	
	public void push(int data){
		rotate(stack2, stack1);
		stack1.push(data);
		rotate(stack1, stack2);
	}
	
	public int pop(){
		if (stack2.isEmpty()){
			throw new NullPointerException("ջΪ��");
		}
		return stack2.pop();
	}
}

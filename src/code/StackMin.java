package code;

import java.util.Stack;

/**
 *@author : gaoweibupt@gmail.com
 *
 * ����ʱ�䣺 2015��10��26������10:37:23
 * 
 * Ҳ����ʹ��Stack<Integer, Integer>  ����¼��Сֵ��������������������ܴ�ʱ���Կռ���˵��һ���˷�
 * 
 */
public class StackMin {
	Stack<Integer> stack;
	Stack<Integer> stackMin;
	
	public int pop(){
		if (stack.peek() == stackMin.peek()){
			stackMin.pop();
			return stack.pop();
		}else
			return stack.pop();
	}
	
	public void push(int x){
		if (x <= stackMin.peek()){
			stackMin.push(x);
		}
		stack.push(x);
	}
	
	/**
	 * �ڰ���ϰ��3.3
	 * 
	 * �����˿���ջΪ�յ����
	 * 
	 * */
	public int min(){
		if (stackMin.size() != 0)
			return stackMin.peek();
		else
			return Integer.MAX_VALUE;
	}
	
}

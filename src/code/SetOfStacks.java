package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *@author : gaoweibupt@gmail.com
 *
 * ����ʱ�䣺 2015��10��26������10:55:42
 * 
 * ����Ա���Խ�� �ڰ���ϰ��3.3
 * 
 */
public class SetOfStacks {
	private List<Stack<Integer>> listStack = null;
	private int length = 10;
	
	/**
	 * ���캯��
	 * */
	SetOfStacks() {
		// TODO Auto-generated constructor stub
		this.listStack = new ArrayList<Stack<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		listStack.add(stack);
	}
	
	/**
	 * ����Length�� ÿ��ջ�ĳ���
	 * */
	public void setLength(int length){
		this.length = length;
	}
	
	/**
	 * pop���ݣ�����������ݺ�ջ�Ĵ�СΪ�գ������ٴ�ջ
	 * */
	public int pop(){
		int result = listStack.get(listStack.size() - 1).pop();
		if (listStack.get(listStack.size() - 1).size() == 0){
			listStack.remove(listStack.size() - 1);
		}
		return result;
	}
	
	/**
	 * push���ݣ�������һ��ջ�������½�һ��ջ
	 * */
	public void push(int x){
		if (listStack.get(listStack.size()-1).size() < length){
			listStack.get(listStack.size()-1).push(x);
		}
		else{
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(x);
			listStack.add(stack);
		}
	}
	
	/**
	 * ����ָ��ջ�ϵ����ݣ�Ӧ������һ��ջ����������ջ
	 * �����뷨���ý���һ��ջ���������룬���������Ȼ��������һ��ջ
	 * */
	public int popAt(int index){
		int result =  listStack.get(index).pop();
		if (listStack.get(index).size() == 0){
			listStack.remove(index);
		}
		return result;
	}
	
}

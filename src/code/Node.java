package code;
/**
 *@author : gaoweibupt@gmail.com
 *
 * ����ʱ�䣺 2015��10��19������10:07:23
 */
public class Node {
	
	public int data;
	
	public Node next = null;
	
	public Node(int data){
		this.data = data;
	}
	
	public Node(){
		
	}
	/**
	 * ���뵽����β��
	 * */
	public void appendToTail(int data){
		Node end = new Node(data);
		Node n = this;
		while (n.next != null){
			n = n.next;
		}
		n.next = end;
	}
	
	/**
	 * ���뵽����ͷ��
	 * */
	public void appendToHead(int data){
		Node head = new Node(data);
		Node n = this;
		head.next = n;
	}
}

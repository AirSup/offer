package code;

import java.util.HashMap;

/**
 *@author : gaoweibupt@gmail.com
 *
 * ����ʱ�䣺 2015��10��19������10:05:43
 *
 */
public class LinkList {
	
	/**
	 * �ڰ���  ϰ��2.1
	 * <p> ɾ��δ���������е��ظ��ڵ�<br>
	 * ʹ��HashMap���ݽṹ,ʹ���˻�������ʱ�临�Ӷ�ΪO��N��
	 * 
	 * ���ʹ������ָ��ѭ������Ļ���ʱ�临�Ӷ�ΪO��N*N��
	 * @param Node head ͷ�ڵ�
	 * @return ��
	 * */
	public void deleteRepeatNode(Node head){
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		Node ptr = head;
		map.put(ptr.data, true);
		while(ptr.next != null){
			if (map.containsKey(ptr.next.data)){
				ptr.next = ptr.next.next;
			}
			else{
				map.put(ptr.next.data, true);
				ptr = ptr.next;
			}
		}
	}
	
	/**
	 * �ڰ���  ϰ��2.2
	 * <p> �ҳ����������еĵ�����k���ڵ�<br>
	 * ��������ʱ�临�Ӷ�ΪO(N), �ռ临�Ӷ�ΪO(1)
	 * @param Node head ͷ�ڵ�
	 * @return Node kNode������k���ڵ�
	 * */
	public Node bachKNode(Node head, int k){
		int i = 1;
		Node end = head, kNode = head;
		while(end.next != null){
			if(i >= k){
				kNode = kNode.next;
			}
			end = end.next; 
			i++;
		}
		return kNode;
	}
	
	/**
	 * �ڰ���  ϰ��2.3
	 * <p> ɾ�����������еĽڵ㣬ֻ�ܷ��ʵ���ɾ���Ľڵ�<br>
	 * 
	 * ע�⣺ �����ɾ���Ľڵ�Ϊβ�ڵ㣬�˷�����Ч�����Խ�β�ڵ���Ϊ��Ч
	 * 
	 * @param Node node��ɾ���Ľڵ�
	 * @return boolean true ��ʾɾ���ɹ�
	 * */
	public boolean deleteSpecificNode(Node node){
		if (node == null || node.next == null){
			return false;
		}
		node.data = node.next.data;
		node.next = node.next.next;
		return true;
	}
	
	/**
	 * �ڰ���  ϰ��2.4
	 * <p> ������׼x��С��x�Ľڵ����ڴ��ڻ����x�Ľڵ�֮ǰ<br>
	 * @param Node head, int x ����ͷ�ڵ�head ����׼x
	 * @return Node head 
	 * */
	public Node separateByReference(Node head, int x){
		Node large = null;
		Node little = null;
		Node end = head;
		while(end != null){
			if (end.data > x){
				Node tmp = end;
				end = end.next;
				tmp.next = large;
				large = tmp;
			}else{
				Node tmp = end;
				end = end.next;
				tmp.next = little;
				little = tmp;
			}
		}
		head = little;
		while (little.next != null){
			little = little.next;
		}
		little.next = large;
		return head;
		
	}
	
	/**
	 * �ڰ��� ϰ��2.5
	 * <p> ���������������ʾ�����֣��������ǵĺ�<br>
	 * ��������������Ϊ����洢�����֣�����617��Ϊ7->1->6
	 * �ݹ�ʵ��
	 * @param Node n1, Node n2 Ϊ��������
	 * @return Node result Ϊ��Ӻ�Ľ��
	 * */
	public Node listReversePlus(Node n1, Node n2, int carry){
		if (n1 == null && n2 == null && carry == 0){
			return null;
		}
		Node result =  new Node();
		int value = carry;
		if (n1 != null){
			value += n1.data;
		}
		if (n2 != null){
			value += n2.data;
		}
		result.data = value % 10;
		carry = value / 10;
		
		Node more = listReversePlus(n1 == null? null:n1.next, n2 == null? null:n2.next, carry);
		result.next = more;
		return result;
	}
	
	/**
	 * �ڰ��� ϰ��2.5
	 * <p> ���������������ʾ�����֣��������ǵĺ�<br>
	 * ��������������Ϊ����洢�����֣�����617��Ϊ6->1->7
	 * @param Node n1, Node n2 Ϊ��������
	 * @return Node result Ϊ��Ӻ�Ľ��
	 * */
	public Node listPositivePlus(Node n1, Node n2){
		//TODO
		int n1length = Node.getListLength(n1);
		int n2length = Node.getListLength(n2);
		if (n1length == n2length){
			int result = LinkList.listPositivePlusEqual(n1, n2);
			if (result == 0)return n1;
			else{
				Node head = new Node(result);
				head.next = n1;
				return head;
			}
		}
		else{
		
			if (n1length > n2length){}
			else{
				Node hh = n1;
				n1 = n2;
				n2 = hh;
			}
			Node n1head = Node.getNode(n1, n1length - n2length + 1);
			int result = LinkList.listPositivePlusEqual(n1head, n2);
			if (result == 0){
				return n1;
			}
			else{
				Node.getNode(n1, n1length - n2length).data = Node.getNode(n1, n1length - n2length).data + result;
			}
			return n1;
		}
	}
	
	public static int listPositivePlusEqual(Node n1, Node n2){
		if (n1 == null && n2 == null)return 0;
		int result = n1.data + n2.data + LinkList.listPositivePlusEqual(n1.next, n2.next);
		n1.data = result % 10;
		return result / 10;
	}


	/**
	 * �ڰ��� ϰ��2.6
	 * <p> �����л������ͷ�ڵ� <br>
	 * @param Node node  �л������еĽڵ�
	 * @return Node end �л������е�ͷ�ڵ�
	 * */
	public Node getHeadNode(Node node){
		Node head = node;
		Node end = node.next;
		while(end != null){
			if (head == end){
				return end;
			}
			else{
				head = head.next;
				end = end.next.next;
			}
		}
		return end;
	}
	
	
	/**
	 * �ڰ��� ϰ��2.7
	 * <p> ��������Ƿ����<br>
	 * @param Node head  ���������
	 * @return boolean true Ϊ���� ��false���ǻ���
	 * */
	public boolean isPalindrome(Node head){
		int length = Node.getListLength(head);
		for (int i = 0; i < length / 2; i++){
			if (Node.getNode(head, i + 1).data == Node.getNode(head, length - i).data){	
			}
			else{
				return false;
			}
		}
		return true;
	}
}

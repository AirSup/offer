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
	 * ʹ��HashMap���ݽṹ
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
	 * 
	 * @param Node head ͷ�ڵ�
	 * @return Node kNode������k���ڵ�
	 * */
	public Node bachKNode(Node head, int k){
		int i = 1;
		Node end = head, kNode = head;
		while(end.next != null){
			if(i > k){
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
	public boolean separateByReference(Node head, int x){
		Node Large = null;
		Node end = head;
		if (head == null || head.next == null){
			return false;
		}
		while (end.next != null){
			if (end.next.data >= x){
				Node tem = end.next;
				end.next = end.next.next;
				tem.next = Large;
				Large = tem;
			}
			else{
				end = end.next;
			}
		}
		end.next = Large;
		return true;
	}
	
	/**
	 * �ڰ��� ϰ��2.5
	 * <p> ���������������ʾ�����֣��������ǵĺ�<br>
	 * ��������������Ϊ����洢�����֣�����617��Ϊ7->1->6
	 * @param Node n1, Node n2 Ϊ��������
	 * @return Node result Ϊ��Ӻ�Ľ��
	 * */
	public Node listReversePlus(Node n1, Node n2){
		Node result = new Node(), end = result;
		int flag = 0;
		while(n1 != null && n2 != null){
			end.data = (n1.data + n2.data + flag) % 10;
			flag = (n1.data + n2.data + flag) / 10;
			n1 = n1.next;
			n2 = n2.next;
			end.next = new Node();
			end = end.next;
		}
		while(n1 != null){
			end.data = n1.data;
			end.next = new Node();
			if (n1.next != null){
				end.next = new Node();
				end = end.next;
			}
			n1 = n1.next;
		}
		while(n2 != null){
			end.data = n2.data;
			if(n2.next != null){
				end.next = new Node();
				end = end.next;
			}
			n2 = n2.next;
		}
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
			
		return null;
	}
	
	
	
	
	
}

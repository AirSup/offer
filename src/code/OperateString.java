package code;

import java.util.HashMap;

/**
 *@auther : gaoweibupt@gmail.com
 *
 * ����ʱ�䣺 2015��10��16������4:16:08
 */
public class OperateString {
	
	/**
	 * �ڰ���  ϰ��1.1
	 * <p> ȷ��һ���ַ����������ַ�ȫ����ͬ<br>
	 * ʹ��HashMap���ݽṹ
	 * @param String s �����ַ���
	 * @return true Ϊȫ��ͬ��falseΪ����ͬ���ַ�
	 * */
	public static boolean isDifferentChar(String s){
		if (s == null || s.equals("")){
			return true;
		}
		HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
		for (int i = 0; i < s.length(); i++){
			if (map.containsKey(s.charAt(i))){
				return false;
			}
			else{
				map.put(s.charAt(i), true);
			}
		}
		return true;
	}
	
	
	/**
	 * �ڰ���  ϰ��1.1
	 * <p> ȷ��һ���ַ����������ַ�ȫ����ͬ<br>
	 * �����ö�������ݽṹ
	 * @param String s �����ַ���
	 * @return true Ϊȫ��ͬ��falseΪ����ͬ���ַ�
	 * */
	public static boolean isDifferentChar2(String s){
		if (s == null || s.equals("")){
			return true;
		}
		for (int i = 0; i < s.length() - 1; i++){
			for (int j = i + 1; j < s.length(); j++){
				if (s.charAt(i) == s.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
	
	
}

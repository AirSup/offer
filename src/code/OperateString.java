package code;

import java.util.HashMap;

/**
 *@author : gaoweibupt@gmail.com
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
	 * 
	 * �Ľ������String ��ASCII�ַ�����s.length()>256 �Ϳ��Է���false
	 * */
	public static boolean isDifferentChar(String s){
		if (s == null || s.equals("")){
			return true;
		}
//		if (s.length() > 256)return false;
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
	
	/**
	 * �ڰ���  ϰ��1.3
	 * <p> ���������ַ������жϾ��������ܷ����<br>
	 * @param s1 �����ַ���1�� s2 �����ַ���2
	 * @return true Ϊ���ԣ�falseΪ������
	 * */
	public static boolean isResetEqual(String s1, String s2){
		if (s1.length() != s2.length()){
			return false;
		}
		int[] map = new int[256];
		for (int i = 0; i < s1.length(); i++){
			map[s1.charAt(i)]++;
		}
		for (int i = 0; i < s2.length(); i++){
			map[s2.charAt(i)]--;
		}
		for (int i = 0; i < 256; i++){
			if (map[i] != 0)return false;
		}
		return true;
	}
	
	/**
	 * �ڰ���  ϰ��1.4
	 * <p> ���ַ����еĿո��滻��%20<br>
	 * @param String s Ҫ�滻���ַ���
	 * @return String result �滻����ַ���
	 * */
	public static String spaceReplace(String s){
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < s.length(); i++){
			if (s.charAt(i) == ' '){
				stringBuffer.append("%20");
			}else{
				stringBuffer.append(s.charAt(i));
			}
		}
		return stringBuffer.toString();	
	}
	
	/**
	 * �ڰ���  ϰ��1.5
	 * <p> ʵ�ֻ������ַ���ѹ��<br>
	 * @param String s Ҫѹ�����ַ���
	 * @return String result ѹ������ַ���
	 * */
	public static String stringCompress(String s){
		StringBuffer stringBuffer = new StringBuffer();
		char flag = s.charAt(0);
		int num = 1;
		for (int i = 1; i < s.length(); i++){
			if (flag == s.charAt(i)){
				num++;
			}else{
				stringBuffer.append(flag);
				stringBuffer.append(new Integer(num).toString());
				num = 1;
				flag = s.charAt(i);
			}
		}
		stringBuffer.append(flag);
		stringBuffer.append(new Integer(num).toString());
		if (stringBuffer.length() < s.length()){
			return stringBuffer.toString();
		}
		else{
			return s;
		}
	}
	
	/**
	 * �ڰ���  ϰ��1.6
	 * <p> ��N*N���������ʾ��ͼ����ת90��<br>
	 * @param int[][]  imageҪ�����ľ���ͼ��, int n ��ʾ�����ά��N*N
	 * @return int[][] result ��ת��ľ���ͼ������
	 * */
	public static int[][] iamgeRotate(int[][] image, int n){
		if (n == 1)return image;
		int length = n / 2 + n % 2;
		for (int i = 0; i < length; i++){
			for (int j = 0; j < n / 2; j++){
				int tmp = image[i][j];
				image[i][j] = image[n-1-j][i];
				image[n-1-j][i] = image[n-1-i][n-1-j];
				image[n-1-i][n-1-j] = image[j][n-1-i];
				image[j][n-1-i] = tmp;
			}
		}
		return image;
	}
	
	/**
	 * �ڰ���  ϰ��1.7
	 * <p> ���Ԫ��Ϊ0 ʱ�������ڵ�����<br>
	 * @param int[][]  arr �����m*n����
	 * @return int[][] result ���ص�����
	 * */
	public static int[][] arrayEmpty(int[][] arr){
		boolean[] row = new boolean[arr.length];
		boolean[] column = new boolean[arr[0].length];
		for (int i = 0; i < row.length; i++){
			for (int j = 0; j < column.length; j++){
				if (arr[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		for (int i = 0; i < row.length; i++){
			for (int j = 0; j < column.length; j++){
				if (row[i] == true || column[j] == true){
					arr[i][j] = 0;
				}
			}
		}
		return arr;
	}
	
	/**
	 * �ڰ���  ϰ��1.8
	 * <p> ����ַ���1�Ƿ�Ϊ�ַ���2��ת����<br>
	 * @param String s1 Ϊ�ַ���1, String s2�ַ���2
	 * @return Boolean resultΪtrueʱ��ȷ��Ϊfalseʱ����
	 * */
	public static boolean isRotateString(String s1, String s2){
		if (s1.length() == s2.length()){
			String s = s1 + s1;
			if (s.contains(s2)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	
}

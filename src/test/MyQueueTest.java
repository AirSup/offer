package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import code.SortStack;

/**
 *@author : gaoweibupt@gmail.com
 *
 * ����ʱ�䣺 2015��10��26������10:24:33
 */
public class MyQueueTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testSort(){
		SortStack ss = new SortStack();
		ss.push(5);
		ss.push(3);
		ss.push(1);
		ss.push(4);
		ss.push(6);
		ss.push(7);
		ss.push(0);
		ss.sort();
		while(!ss.isEmpty()){
			System.out.println(ss.pop());
		}
	}
}

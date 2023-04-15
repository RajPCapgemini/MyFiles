package Testing1;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.prac.client.TestMain;

public class EmployeeTesting {
	
	@Test
	public void testBonus() {
		TestMain obj=new TestMain();
		String res[]=obj.getResult();
		String expected[]={"yes","yes","yes","no","yes"};
		String actual[]=obj.getResult();
		assertArrayEquals(expected,actual);
	}
}

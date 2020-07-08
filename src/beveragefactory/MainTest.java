package beveragefactory;

/*
 * author : Mayur Yadav
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MainTest {

	@Test
	public void validateOrderTest() {
		Main obj = new Main();
		boolean result = obj.validateOrder("bananasmoothie");
		assertEquals(true, result);
	}

	@Test
	public void calculateBillAmountTest() {
		Main obj = new Main();
		Double result = obj.calculateBillAmount("chai, -sugar");
		assertEquals(Double.valueOf(3.5), result);
	}



}

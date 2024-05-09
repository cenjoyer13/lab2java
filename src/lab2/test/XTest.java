package lab2.test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.text.NumberFormat;
import lab2.main.*;

class XTest {

	@Test
	void CalculateSimple(){
		Function f = X.x();
		assertTrue(f.calculate(-2) == -2);
	}

	@Test
	void CalculateSimple2(){
		Function f = X.x();
		assertTrue(f.calculate(100) == 100);
	}

	@Test
	void DeriviateSimple(){
		Function f = X.x();
		Function fder = Const.of(1);
		assertTrue(f.derivative().equals(fder));
	}


	@Test
	void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = X.x();
		assertTrue(f.toPrettyString(nf).equals("x"));
	}

}

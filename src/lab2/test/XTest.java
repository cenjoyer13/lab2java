package lab2.test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.text.NumberFormat;
import lab2.main.*;

public class XTest {

	@Test
	public void CalculateSimple(){
		Function f = X.x();
		assertTrue(f.calculate(-2) == -2);
	}

	@Test
	public void CalculateSimple2(){
		Function f = X.x();
		assertTrue(f.calculate(100) == 100);
	}

	@Test
	public void DeriviateSimple(){
		Function f = X.x();
		Function fder = Const.of(1);
		assertTrue(f.derivative().equals(fder));
	}

	@Test
	public void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = X.x();
		assertTrue(f.toPrettyString(nf).equals("x"));
	}

}

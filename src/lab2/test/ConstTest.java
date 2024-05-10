package lab2.test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.text.NumberFormat;
import lab2.main.*;

public class ConstTest {

	@Test
	public void CalculateSimple(){
		Function f = Const.of(2);
		assertTrue(f.calculate(-2) == 2);
	}

	@Test
	public void CalculateSimple2(){
		Function f = Const.of(2);
		assertTrue(f.calculate(100) == 2);
	}

	@Test
	public void DeriviateSimple(){
		Function f = Const.of(2);
		Function fder = Const.ZERO;
		assertTrue(f.derivative().equals(fder));
	}


	@Test
	public void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Const.of(2);
		assertTrue(f.toPrettyString(nf).equals("2"));
	}

}

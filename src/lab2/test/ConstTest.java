package lab2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.NumberFormat;

import org.junit.jupiter.api.Test;

import lab2.main.Abs;
import lab2.main.Const;
import lab2.main.Exponential;
import lab2.main.Function;
import lab2.main.Multiplication;
import lab2.main.Sin;
import lab2.main.X;

class ConstTest {

	@Test
	void CalculateSimple(){
		Function f = Const.of(2);
		assertTrue(f.calculate(-2) == 2);
	}
	
	@Test
	void CalculateSimple2(){
		Function f = Const.of(2);
		assertTrue(f.calculate(100) == 2);
	}
	
	@Test
	void DeriviateSimple(){
		Function f = Const.of(2);
		Function fder = Const.ZERO;
		assertTrue(f.derivative().equals(fder));
	}

	
	@Test
	void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Const.of(2);
		assertTrue(f.toPrettyString(nf).equals("2"));
	}

}

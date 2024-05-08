package lab2.test;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.*;

import java.text.NumberFormat;

import org.junit.jupiter.api.Test;

import lab2.main.*;

class ExponentialTest {

	@Test
	void CalculateSimple(){
		Function f = Exponential.of(X.x(),3);
		assertTrue(f.calculate(-2) == -8);
	}
	
	@Test
	void CalculateComplex(){
		Function f = Exponential.of(Abs.of(X.x()),3);
		assertTrue(f.calculate(-2) == 8);
	}
	
	@Test
	void DeriviateSimple(){
		Function f = Exponential.of(X.x(),3);
		Function fder = Multiplication.of(Const.of(3), Exponential.of(X.x(), 2), X.x().derivative());
		assertTrue(f.derivative().equals(fder));
	}
	
	@Test
	void DeriviateComplex(){
		Function f = Exponential.of(Sin.of(X.x()),3);
		Function fder = Multiplication.of(Const.of(3), Exponential.of(Sin.of(X.x()), 2), Sin.of(X.x()).derivative());
		assertTrue(f.derivative().equals(fder));
	}
	
	@Test
	void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Exponential.of(X.x(),2);
		assertTrue(f.toPrettyString(nf).equals("x^2"));
	}

	@Test
	void StringComplex(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Exponential.of(Sin.of(X.x()),2);
		assertTrue(f.toPrettyString(nf).equals("sin(x)^2"));
	}
}

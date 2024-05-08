package lab2.test;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.*;

import java.text.NumberFormat;

import org.junit.jupiter.api.Test;

import lab2.main.*;

class CoshTest {
	
	@Test
	void CalculateSimple(){
		Function f = Cosh.of(X.x());
		assertTrue(f.calculate(2) == cosh(2));
	}
	
	@Test
	void CalculateComplex(){
		Function f = Cosh.of(Exponential.of(X.x(),3));
		assertTrue(f.calculate(2)==cosh(8));
	}
	
	@Test
	void DeriviateSimple(){
		Function f = Cosh.of(X.x());
		Function fder = Multiplication.of(Sinh.of(X.x()), X.x().derivative());
		assertTrue(f.derivative().equals(fder));
	}
	
	@Test
	void DeriviateComplex(){
		Function f = Cosh.of(Sin.of(X.x()));
		Function fder = Multiplication.of(Sinh.of(Sin.of(X.x())), Sin.of(X.x()).derivative());
		assertTrue(f.derivative().equals(fder));
	}
	
	@Test
	void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Cosh.of(X.x());
		assertTrue(f.toPrettyString(nf).equals("cosh(x)"));
	}

	@Test
	void StringComplex(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Cosh.of(Sin.of(X.x()));
		assertTrue(f.toPrettyString(nf).equals("cosh(sin(x))"));
	}

}

package lab2.test;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.*;

import java.text.NumberFormat;

import org.junit.jupiter.api.Test;

import lab2.main.*;

import org.junit.jupiter.api.Test;

class SinhTest {

	@Test
	void CalculateSimple(){
		Function f = Sinh.of(X.x());
		assertTrue(f.calculate(2) == sinh(2));
	}
	
	@Test
	void CalculateComplex(){
		Function f = Sinh.of(Exponential.of(X.x(),3));
		assertTrue(f.calculate(2)==sinh(8));
	}
	
	@Test
	void DeriviateSimple(){
		Function f = Sinh.of(X.x());
		Function fder = Multiplication.of(Cosh.of(X.x()), X.x().derivative()); 
		assertTrue(f.derivative().equals(fder));
	}
	
	@Test
	void DeriviateComplex(){
		Function f = Sinh.of(Sin.of(X.x()));
		Function fder = Multiplication.of(Cosh.of(Sin.of(X.x())), Sin.of(X.x()).derivative()); 
		assertTrue(f.derivative().equals(fder));
	}
	
	@Test
	void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Sinh.of(X.x());
		assertTrue(f.toPrettyString(nf).equals("sinh(x)"));
	}

	@Test
	void StringComplex(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Sinh.of(Sin.of(X.x()));
		assertTrue(f.toPrettyString(nf).equals("sinh(sin(x))"));
	}

}

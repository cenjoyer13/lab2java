package lab2.test;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.*;

import java.text.NumberFormat;

import org.junit.jupiter.api.Test;

import lab2.main.*;

import org.junit.jupiter.api.Test;

class SinTest {

	@Test
	void CalculateSimple(){
		Function f = Sin.of(X.x());
		assertTrue(f.calculate(2) == sin(2));
	}
	
	@Test
	void CalculateComplex(){
		Function f = Sin.of(Exponential.of(X.x(),3));
		assertTrue(f.calculate(2)==sin(8));
	}
	
	@Test
	void DeriviateSimple(){
		Function f = Sin.of(X.x());
		Function fder = Multiplication.of(Cos.of(X.x()), X.x().derivative()); 
		assertTrue(f.derivative().equals(fder));
	}
	
	@Test
	void DeriviateComplex(){
		Function f = Sin.of(Sin.of(X.x()));
		Function fder = Multiplication.of(Cos.of(Sin.of(X.x())), Sin.of(X.x()).derivative()); 
		assertTrue(f.derivative().equals(fder));
	}
	
	@Test
	void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Sin.of(X.x());
		assertTrue(f.toPrettyString(nf).equals("sin(x)"));
	}

	@Test
	void StringComplex(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Sin.of(Sin.of(X.x()));
		assertTrue(f.toPrettyString(nf).equals("sin(sin(x))"));
	}

}

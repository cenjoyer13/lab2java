package lab2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.NumberFormat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import lab2.main.*;

class SumTest {

	@Test
	void EqualsDifClassTest() {
		Function f1 = Sum.of(X.x(),X.x());
		Function f2 = Multiplication.of(X.x(),X.x());
		assertFalse(f1.equals(f2));
	}
	@Test
	void EqualsDifFunctions() {
		Function f1 = Sum.of(X.x(),X.x());
		Function f2 = Sum.of(Const.of(1),X.x());
		assertFalse(f1.equals(f2));
	}
	@Test
	void EqualsSimilarFunctions() {
		Function f1 = Sum.of(Const.of(1),X.x(),Cos.of(X.x()));
		Function f2 = Sum.of(X.x(),Cos.of(X.x()),Const.of(1));
		assertTrue(f1.equals(f2));
	}
	
	@Test
	void CalculateSimple(){
		Function f = Sum.of(Const.of(1),X.x());
		assertTrue(f.calculate(2)==3);
	}
	
	@Test
	void CalculateComplex(){
		Function f = Sum.of(Const.of(1),X.x(),Abs.of(X.x()));
		assertTrue(f.calculate(-1)==1);
	}
	
	@Test
	void DeriviateSimple(){
		Function f = Sum.of(Const.of(1),X.x());
		Function fder = Sum.of(Const.ZERO,Const.of(1));
		assertTrue(f.derivative().equals(fder));
	}
	
	@Test
	void DeriviateComplex(){
		Function f = Sum.of(X.x(),Exponential.of(X.x(), 2));
		Function fder = Sum.of(Const.of(1),Multiplication.of(Const.of(2),X.x(),Const.of(1)));
		assertTrue(f.derivative().equals(fder));
	}
	
	@Test
	void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Sum.of(Const.of(1),X.x());
		assertTrue(f.toPrettyString(nf).equals("(1+x)"));
	}

	@Test
	void StringComplex(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Sum.of(X.x(),Exponential.of(X.x(), 2));
		assertTrue(f.toPrettyString(nf).equals("(x+x^2)"));
	}
}

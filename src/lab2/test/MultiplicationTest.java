package lab2.test;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.*;

import java.text.NumberFormat;

import org.junit.jupiter.api.Test;

import lab2.main.*;

class MultiplicationTest {

	@Test
	void EqualsDifClassTest() {
		Function f1 = Sum.of(X.x(),X.x());
		Function f2 = Multiplication.of(X.x(),X.x());
		assertFalse(f1.equals(f2));
	}
	@Test
	void EqualsDifFunctions() {
		Function f1 = Multiplication.of(X.x(),X.x());
		Function f2 = Multiplication.of(Const.of(1),X.x());
		assertFalse(f1.equals(f2));
	}
	@Test
	void EqualsSimilarFunctions() {
		Function f1 = Multiplication.of(Const.of(1),X.x(),Cos.of(X.x()));
		Function f2 = Multiplication.of(X.x(),Cos.of(X.x()),Const.of(1));
		assertTrue(f1.equals(f2));
	}
	
	@Test
	void CalculateSimple(){
		Function f = Multiplication.of(Const.of(1),X.x());
		assertTrue(f.calculate(2)==2);
	}
	
	@Test
	void CalculateComplex(){
		Function f = Multiplication.of(Const.of(1),X.x(),Abs.of(X.x()));
		assertTrue(f.calculate(-1)==-1);
	}
	
	@Test
	void DeriviateSimple(){
		Function f = Multiplication.of(Const.of(1),X.x());
		Function fder = Sum.of(Multiplication.of(Const.of(1),Const.of(1)));
		assertTrue(f.derivative().equals(fder));
	}
	
	@Test
	void DeriviateComplex(){
		Function f = Multiplication.of(X.x(),Exponential.of(X.x(), 2));
		Function fder = Sum.of(
				
				Multiplication.of(
						Multiplication.of(
								Const.of(2),
								X.x(),
								Const.of(1)
								)
						,
						X.x()),
						
				Multiplication.of
						(Exponential.of(X.x(), 2)
								, 
						Const.of(1)));
		assertTrue(f.derivative().equals(fder));
	}
	
	@Test
	void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Multiplication.of(Const.of(1),X.x());
		assertTrue(f.toPrettyString(nf).equals("(1*x)"));
	}

	@Test
	void StringComplex(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Multiplication.of(X.x(),Exponential.of(X.x(), 2));
		assertTrue(f.toPrettyString(nf).equals("(x*x^2)"));
	}

}

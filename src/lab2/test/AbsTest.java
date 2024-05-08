package lab2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.NumberFormat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import lab2.main.*;

class AbsTest {

	@Test
	void EqualsDifClassTest() {
		Function f1 = Abs.of(Const.of(1));
		Function f2 = Cos.of(Const.of(1));
		assertFalse(f1.equals(f2));
	}
	@Test
	void EqualsSimFunctions() {
		Function f1 = Abs.of(Const.of(1));
		Function f2 = Abs.of(Const.of(1));
		assertTrue(f1.equals(f2));
	}
	@Test
	void EqualsSimilarFunctions() {
		Function f1 = Abs.of(Cos.of(Const.of(1)));
		Function f2 = Abs.of(Cos.of(Const.of(1)));
		assertTrue(f1.equals(f2));
	}
	
	@Test
	void CalculateSimple(){
		Function f = Abs.of(X.x());
		assertTrue(f.calculate(-2)==2);
	}
	
	@Test
	void CalculateComplex(){
		Function f = Abs.of(Exponential.of(X.x(),3));
		assertTrue(f.calculate(-2)==8);
	}
	
	@Test
	void DeriviateSimple(){
		Function f = Abs.of(X.x());
		Function fder = Multiplication.of(X.x(), Exponential.of(Abs.of(X.x()), -1), Const.of(1));
		assertTrue(f.derivative().equals(fder));
	}
	
	@Test
	void DeriviateComplex(){
		Function f = Abs.of(Sin.of(X.x()));
		Function fder = Multiplication.of(Sin.of(X.x()), Exponential.of(Abs.of(Sin.of(X.x())), -1), Multiplication.of(Cos.of(X.x()), Const.of(1)));
		assertTrue(f.derivative().equals(fder));
	}
	
	@Test
	void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Abs.of(X.x());
		assertTrue(f.toPrettyString(nf).equals("|x|"));
	}

	@Test
	void StringComplex(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Abs.of(Sin.of(X.x()));
		assertTrue(f.toPrettyString(nf).equals("|sin(x)|"));
	}

}

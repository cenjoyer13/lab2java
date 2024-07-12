package lab2.test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.text.NumberFormat;
import lab2.main.*;

public class MultiplicationTest {

	@Test
	public void EqualsDifClassTest() {
		Function f1 = Sum.of(X.x(),X.x());
		Function f2 = Multiplication.of(X.x(),X.x());
		assertFalse(f1.equals(f2));
	}
	@Test
	public void EqualsDifFunctions() {
		Function f1 = Multiplication.of(X.x(),X.x());
		Function f2 = Multiplication.of(Const.of(1),X.x());
		assertFalse(f1.equals(f2));
	}
	@Test
	public void EqualsSimilarFunctions() {
		Function f1 = Multiplication.of(Const.of(1),X.x(),Cos.of(X.x()));
		Function f2 = Multiplication.of(X.x(),Cos.of(X.x()),Const.of(1));
		assertTrue(f1.equals(f2));
	}

	@Test
	public void CalculateSimple(){
		Function f = Multiplication.of(Const.of(1),X.x());
		assertTrue(f.calculate(2)==2);
	}

	@Test
	public void CalculateComplex(){
		Function f = Multiplication.of(Const.of(1),X.x(),Abs.of(X.x()));
		assertTrue(f.calculate(-1)==-1);
	}

	@Test
	public void DeriviateSimple(){
		Function f = Multiplication.of(Const.of(1),X.x());
		Function fder = Const.of(1);
		assertTrue(f.derivative().equals(fder));
	}

	@Test
	public void DeriviateComplex(){
		Function f = Multiplication.of(X.x(),Exponential.of(X.x(), 2));
		Function fder = Multiplication.of(Const.of(3), Exponential.of(X.x(), 2));;
		assertTrue(f.derivative().equals(fder));
	}
	
	@Test
	public void Simlify(){
		Function f = Multiplication.of(Const.of(1));
		Function fder = Const.of(0);
		assertTrue(f.derivative().equals(fder));
	}

	@Test
	public void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Multiplication.of(Const.of(1),X.x());
		assertTrue(f.toPrettyString(nf).equals("x"));
	}

	@Test
	public void StringComplex(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Multiplication.of(X.x(),Exponential.of(X.x(), 2));
		assertTrue(f.toPrettyString(nf).equals("x^3"));
	}
	
	@Test
	public void simplifyConst(){
		Function f1 = Multiplication.of(Const.of(2), Const.of(2), X.x(), Exponential.of(X.x(), 2));
		Function f2 = Multiplication.of(Const.of(4),Exponential.of(X.x(), 3));
		assertTrue(f1.equals(f2));
	}

}

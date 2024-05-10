package lab2.test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.text.NumberFormat;
import lab2.main.*;

public class SumTest {

	@Test
	public void EqualsDifClassTest() {
		Function f1 = Sum.of(X.x(),X.x());
		Function f2 = Multiplication.of(X.x(),X.x());
		assertFalse(f1.equals(f2));
	}
	@Test
	public void EqualsDifFunctions() {
		Function f1 = Sum.of(X.x(),X.x());
		Function f2 = Sum.of(Const.of(1),X.x());
		assertFalse(f1.equals(f2));
	}
	@Test
	public void EqualsSimilarFunctions() {
		Function f1 = Sum.of(Const.of(1),X.x(),Cos.of(X.x()));
		Function f2 = Sum.of(X.x(),Cos.of(X.x()),Const.of(1));
		assertTrue(f1.equals(f2));
	}

	@Test
	public void CalculateSimple(){
		Function f = Sum.of(Const.of(1),X.x());
		assertTrue(f.calculate(2)==3);
	}

	@Test
	public void CalculateComplex(){
		Function f = Sum.of(Const.of(1),X.x(),Abs.of(X.x()));
		assertTrue(f.calculate(-1)==1);
	}

	@Test
	public void DeriviateSimple(){
		Function f = Sum.of(Const.of(1),X.x());
		Function fder = Sum.of(Const.of(1));
		assertTrue(f.derivative().equals(fder));
	}

	@Test
	public void DeriviateComplex(){
		Function f = Sum.of(X.x(),Exponential.of(X.x(), 2));
		Function fder = Sum.of(Const.of(1),Multiplication.of(Const.of(2),X.x(),Const.of(1)));
		assertTrue(f.derivative().equals(fder));
	}

	@Test
	public void Simplify(){
		Function f = Sum.of(Const.of(2));
		Function res = Const.ZERO;
		assertTrue(f.derivative().equals(res));
	}

	@Test
	public void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Sum.of(Const.of(1),X.x());
		assertTrue(f.toPrettyString(nf).equals("(1+x)"));
	}

	@Test
	public void StringComplex(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Sum.of(X.x(),Exponential.of(X.x(), 2));
		assertTrue(f.toPrettyString(nf).equals("(x+x^2)"));
	}
}

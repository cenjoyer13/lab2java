package lab2.test;

import static org.junit.Assert.*;
import java.text.NumberFormat;
import org.junit.Test;
import lab2.main.*;

public class AbsTest {

	@Test
	public void EqualsDifClassTest() {
		Function f1 = Abs.of(Const.of(1));
		Function f2 = Cos.of(Const.of(1));
		assertFalse(f1.equals(f2));
	}
	@Test
	public void EqualsSimFunctions() {
		Function f1 = Abs.of(Const.of(1));
		Function f2 = Abs.of(Const.of(1));
		assertTrue(f1.equals(f2));
	}
	@Test
	public void EqualsSimilarFunctions() {
		Function f1 = Abs.of(Cos.of(Const.of(1)));
		Function f2 = Abs.of(Cos.of(Const.of(1)));
		assertTrue(f1.equals(f2));
	}

	@Test
	public void CalculateSimple(){
		Function f = Abs.of(X.x());
		assertTrue(f.calculate(-2)==2);
	}

	@Test
	public void CalculateComplex(){
		Function f = Abs.of(Exponential.of(X.x(),3));
		assertTrue(f.calculate(-2)==8);
	}

	@Test
	public void DeriviateSimple(){
		Function f = Abs.of(X.x());
		Function fder = Multiplication.of(X.x(), Exponential.of(Abs.of(X.x()), -1), Const.of(1));
		assertTrue(f.derivative().equals(fder));
	}

	@Test
	public void DeriviateComplex(){
		Function f = Abs.of(Sin.of(X.x()));
		Function fder = Multiplication.of(Sin.of(X.x()), Exponential.of(Abs.of(Sin.of(X.x())), -1), Multiplication.of(Cos.of(X.x()), Const.of(1)));
		assertTrue(f.derivative().equals(fder));
	}

	@Test
	public void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Abs.of(X.x());
		assertTrue(f.toPrettyString(nf).equals("|x|"));
	}

	@Test
	public void StringComplex(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Abs.of(Sin.of(X.x()));
		assertTrue(f.toPrettyString(nf).equals("|sin(x)|"));
	}

}

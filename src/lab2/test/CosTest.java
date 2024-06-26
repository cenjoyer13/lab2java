package lab2.test;

import static java.lang.Math.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.text.NumberFormat;
import lab2.main.*;

public class CosTest {

	@Test
	public void CalculateSimple(){
		Function f = Cos.of(X.x());
		assertTrue(f.calculate(2) == cos(2));
	}

	@Test
	public void CalculateComplex(){
		Function f = Cos.of(Exponential.of(X.x(),3));
		assertTrue(f.calculate(2)==cos(8));
	}

	@Test
	public void DeriviateSimple(){
		Function f = Cos.of(X.x());
		Function fder = Multiplication.of(Const.of(-1), Sin.of(X.x()), X.x().derivative());
		assertTrue(f.derivative().equals(fder));
	}

	@Test
	public void DeriviateComplex(){
		Function f = Cos.of(Sin.of(X.x()));
		Function fder = Multiplication.of(Const.of(-1), Sin.of(Sin.of(X.x())), Sin.of(X.x()).derivative());
		assertTrue(f.derivative().equals(fder));
	}

	@Test
	public void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Cos.of(X.x());
		assertTrue(f.toPrettyString(nf).equals("cos(x)"));
	}

	@Test
	public void StringComplex(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Cos.of(Sin.of(X.x()));
		assertTrue(f.toPrettyString(nf).equals("cos(sin(x))"));
	}

}

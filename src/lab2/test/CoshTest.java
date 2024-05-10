package lab2.test;

import static java.lang.Math.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.text.NumberFormat;
import lab2.main.*;

public class CoshTest {

	@Test
	public void CalculateSimple(){
		Function f = Cosh.of(X.x());
		assertTrue(f.calculate(2) == cosh(2));
	}

	@Test
	public void CalculateComplex(){
		Function f = Cosh.of(Exponential.of(X.x(),3));
		assertTrue(f.calculate(2)==cosh(8));
	}

	@Test
	public void DeriviateSimple(){
		Function f = Cosh.of(X.x());
		Function fder = Multiplication.of(Sinh.of(X.x()), X.x().derivative());
		assertTrue(f.derivative().equals(fder));
	}

	@Test
	public void DeriviateComplex(){
		Function f = Cosh.of(Sin.of(X.x()));
		Function fder = Multiplication.of(Sinh.of(Sin.of(X.x())), Sin.of(X.x()).derivative());
		assertTrue(f.derivative().equals(fder));
	}

	@Test
	public void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Cosh.of(X.x());
		assertTrue(f.toPrettyString(nf).equals("cosh(x)"));
	}

	@Test
	public void StringComplex(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Cosh.of(Sin.of(X.x()));
		assertTrue(f.toPrettyString(nf).equals("cosh(sin(x))"));
	}

}

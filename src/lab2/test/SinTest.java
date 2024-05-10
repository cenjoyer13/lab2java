package lab2.test;

import static java.lang.Math.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.text.NumberFormat;
import lab2.main.*;

public class SinTest {

	@Test
	public void CalculateSimple(){
		Function f = Sin.of(X.x());
		assertTrue(f.calculate(2) == sin(2));
	}

	@Test
	public void CalculateComplex(){
		Function f = Sin.of(Exponential.of(X.x(),3));
		assertTrue(f.calculate(2)==sin(8));
	}

	@Test
	public void DeriviateSimple(){
		Function f = Sin.of(X.x());
		Function fder = Multiplication.of(Cos.of(X.x()), X.x().derivative());
		assertTrue(f.derivative().equals(fder));
	}

	@Test
	public void DeriviateComplex(){
		Function f = Sin.of(Sin.of(X.x()));
		Function fder = Multiplication.of(Cos.of(Sin.of(X.x())), Sin.of(X.x()).derivative());
		assertTrue(f.derivative().equals(fder));
	}

	@Test
	public void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Sin.of(X.x());
		assertTrue(f.toPrettyString(nf).equals("sin(x)"));
	}

	@Test
	public void StringComplex(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Sin.of(Sin.of(X.x()));
		assertTrue(f.toPrettyString(nf).equals("sin(sin(x))"));
	}

}

package lab2.test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.text.NumberFormat;
import lab2.main.*;

public class ExponentialTest {

	@Test
	public void CalculateSimple(){
		Function f = Exponential.of(X.x(),3);
		assertTrue(f.calculate(-2) == -8);
	}

	@Test
	public void CalculateComplex(){
		Function f = Exponential.of(Abs.of(X.x()),3);
		assertTrue(f.calculate(-2) == 8);
	}

	@Test
	public void DeriviateSimple(){
		Function f = Exponential.of(X.x(),3);
		Function fder = Multiplication.of(Const.of(3), Exponential.of(X.x(), 2), X.x().derivative());
		assertTrue(f.derivative().equals(fder));
	}

	@Test
	public void DeriviateComplex(){
		Function f = Exponential.of(Sin.of(X.x()),3);
		Function fder = Multiplication.of(Const.of(3), Exponential.of(Sin.of(X.x()), 2), Sin.of(X.x()).derivative());
		assertTrue(f.derivative().equals(fder));
	}

	@Test
	public void StringSimple(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Exponential.of(X.x(),2);
		assertTrue(f.toPrettyString(nf).equals("x^2"));
	}

	@Test
	public void StringComplex(){
		final NumberFormat nf = NumberFormat.getInstance();
		Function f = Exponential.of(Sin.of(X.x()),2);
		assertTrue(f.toPrettyString(nf).equals("sin(x)^2"));
	}
}

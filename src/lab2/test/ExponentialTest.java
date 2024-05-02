package lab2.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lab2.main.Exponential;
import lab2.main.Function;
import lab2.main.X;

class ExponentialTest {

	@Test
	void test() {
		Function f1 = Exponential.of(X.x(), 2);
		Function f2 = Exponential.of(X.x(), 2);
		Function f3 = X.x();
		Assertions.assertTrue(f1.equals(f3));
	}
}

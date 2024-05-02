package lab2.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import lab2.main.*;

class SumTest {

	@Test
	void test1() {
		Function f1 = Sum.of(X.x(),X.x());
		Function f2 = Multiplication.of(X.x(),X.x());
		assertFalse(f1.equals(f2));
	}
	@Test
	void test2() {
		Function f1 = Sum.of(X.x(),X.x());
		Function f2 = Sum.of(Const.of(1),X.x());
		assertFalse(f1.equals(f2));
	}
	@Test
	void test3() {
		Function f1 = Sum.of(Const.of(1),X.x());
		Function f2 = Sum.of(X.x(),Const.of(1));
		assertTrue(f1.equals(f2));
	}
	@Test
	void test4() {
		Function f1 = Sum.of(X.x(),X.x());
		Function f2 = Sum.of(X.x(),X.x());
		assertTrue(f1.equals(f2));
	}
}

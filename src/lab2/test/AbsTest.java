package lab2.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import lab2.main.*;



import lab2.main.Sum;
import lab2.main.X;

class AbsTest {

	@Test
	void test() {
		Function f1 = Sum.of(X.x(),X.x());
	}

}

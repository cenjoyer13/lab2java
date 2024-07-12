package lab2.main;

import java.text.*;
import java.util.*;

public class FindDerivative {

	public static void main(String[] args) {
		
		double a = -0.7;
		double b = 0.3;
		double x = 2;
		
		final Function expression2 = Multiplication.of(
				X.x(),Exponential.of(Cos.of(Exponential.of(Abs.of(Sum.of(Multiplication.of(Const.of(a),X.x()), Const.of(b))), 3)), 2));
		final Function expression1 = Sum.of(Multiplication.of(Exponential.of(
				Sinh.of(X.x()),3), Const.of(b)), Multiplication.of(Const.of(-1),Abs.of(Cosh.of(Exponential.of(Sum.of(X.x(), Const.of(a)), 2.5)))));
		
		

		final NumberFormat nf = NumberFormat.getInstance();
		
		Function f1 = Multiplication.of(X.x(), Exponential.of(X.x(), 2));
		
		System.out.format("ftest:").println(); 
		System.out.format("ftest(x) = %s", 
		        f1.toPrettyString(nf)
		).println(); 
		
		System.out.format("f1:").println(); 
		System.out.format("f1(x) = %s", 
		        expression1.toPrettyString(nf)
		).println(); 
		System.out.format("f1'(x) = %s", 
		        expression1.derivative().toPrettyString(nf) 
		).println(); 
		System.out.format("f1(%f) = %f", x, 
		        expression1.calculate(x) 
		).println(); 
		System.out.format("f1'(%f) = %f", x,
		        expression1.derivative().calculate(x) 
		).println();
		
		System.out.format("f2:").println(); 
		System.out.format("f2(x) = %s", 
		        expression2.toPrettyString(nf)
		).println(); 
		System.out.format("f2'(x) = %s", 
		        expression2.derivative().toPrettyString(nf) 
		).println(); 
		System.out.format("f2 (%f) = %f", x, 
		        expression2.calculate(x) 
		).println(); 
		System.out.format("f2'(%f) = %f", x, 
		        expression2.derivative().calculate(x) 
		).println();
	}

}



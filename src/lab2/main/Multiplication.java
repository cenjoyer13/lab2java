package lab2.main;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Multiplication extends Composite{
	public Multiplication() {
        super();
    }
    public Multiplication(Function... terms) {
        super(terms);
    }
    public Multiplication(ArrayList<Function> terms) {
        super(terms);
    }
    @Override
    public double calculate(double x) {
        double result = 1;
        for (Function function : terms()) {
            result *= function.calculate(x);
        }
        return result;
    }
    @Override
    public Function derivative() {
    	int counter = 0;
    	final ArrayList<Function> derivativeTerms = new ArrayList<>(terms().size());
        for (int i = 0; i < terms().size(); i++) {
        	ArrayList<Function> temp = new ArrayList<>(terms().size());
        	int j = 0;
        	boolean isZero = false;
        	for (Function function : terms()) {
        		if(counter == j) temp.add(function.derivative());
        		else temp.add(function);
        		if (temp.get(j++) == Const.ZERO) isZero = true;
        	}
        	if(!isZero) derivativeTerms.add(Multiplication.of(temp));
        	counter++;
        }
        if (derivativeTerms.isEmpty()) return Const.ZERO;
        return new Sum(derivativeTerms);
    }
    @Override
    public String toPrettyString(NumberFormat nf) {
        final StringJoiner joiner = new StringJoiner("*");
        for (Function function : terms()) {
            joiner.add(function.toPrettyString(nf));
        }
        return String.format("(%s)",joiner.toString());
    }
    public static Multiplication of(Function... terms) {
        return new Multiplication(terms);
    }

    public static Multiplication of(ArrayList<Function> terms) {
        return new Multiplication(terms);
    }
}

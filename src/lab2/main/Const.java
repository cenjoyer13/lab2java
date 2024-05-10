package lab2.main;

import java.text.NumberFormat;

/* клас функцій виду f(x) = const */ 
public class Const implements Function { 
    public static final Const ZERO = new Const(0); 

    private final double value; 

    public Const(double value) { 
        this.value = value; 
    } 
    @Override
    public boolean equals(Function f) {
    	if (this.getClass() == f.getClass()) {
    		Const f1 = (Const) f;
    		return (this.value == f1.value);
    	}
    	else return false;
    }
    @Override 
    public double calculate(double x) { 
        return value; 
    } 
    @Override 
    public Function derivative() { 
        return ZERO; 
    } 
    @Override 
    public String toPrettyString(NumberFormat nf) { 
        return nf.format(value); 
    } 
    
    public static Const of(double value) { 
        return new Const(value); 
    } 
} 

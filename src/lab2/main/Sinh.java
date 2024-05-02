package lab2.main;

import java.text.NumberFormat;
import static java.lang.Math.*;

public class Sinh implements Function { 
    public static final Const ZERO = new Const(0); 

    private final Function InnerF; 

    public Sinh(Function InnerF) { 
        this.InnerF = InnerF;
    } 
    @Override
    public boolean equals(Function f) {
    	Sinh f1 = (Sinh) f;
        return (InnerF.equals(f1.InnerF));
    }
    @Override 
    public double calculate(double x) { 
        return sinh(InnerF.calculate(x)); 
    } 
    @Override 
    public Function derivative() { 
        return Multiplication.of(Cosh.of(InnerF), InnerF.derivative()); 
    } 
    @Override 
    public String toPrettyString(NumberFormat nf) { 
    	return String.format("sinh(%s)", InnerF.toPrettyString(nf)); 
    } 
    
    public static Sinh of(Function InnerF) { 
        return new Sinh(InnerF); 
    } 
}

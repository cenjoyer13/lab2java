package lab2.main;

import java.text.NumberFormat;
import static java.lang.Math.*;

public class Cosh implements Function { 
    public static final Const ZERO = new Const(0); 

    private final Function InnerF; 

    public Cosh(Function InnerF) { 
        this.InnerF = InnerF;
    } 
    @Override
    public boolean equals(Function f) {
    	Cosh f1 = (Cosh) f;
        return (InnerF.equals(f1.InnerF));
    }
    
    @Override 
    public double calculate(double x) { 
        return cosh(InnerF.calculate(x)); 
    } 
    @Override 
    public Function derivative() { 
        return Multiplication.of(Sinh.of(InnerF), InnerF.derivative()); 
    } 
    @Override 
    public String toPrettyString(NumberFormat nf) { 
    	return String.format("cosh(%s)", InnerF.toPrettyString(nf)); 
    } 
    
    public static Cosh of(Function InnerF) { 
        return new Cosh(InnerF); 
    } 
}

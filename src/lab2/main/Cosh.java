package lab2.main;

import java.text.NumberFormat;
import static java.lang.Math.*;

public class Cosh extends Nested {

    public Cosh(Function InnerF) { 
    	super(InnerF);
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

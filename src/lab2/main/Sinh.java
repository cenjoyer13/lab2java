package lab2.main;

import java.text.NumberFormat;
import static java.lang.Math.*;

public class Sinh extends Nested {

    public Sinh(Function InnerF) { 
    	super(InnerF);
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

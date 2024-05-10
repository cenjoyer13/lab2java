package lab2.main;

import java.text.NumberFormat;

import static java.lang.Math.*;

public class Abs extends Nested {
    
    public Abs(Function InnerF) {
    	super(InnerF);
    }
    
    @Override 
    public double calculate(double x) { 
        return abs(InnerF.calculate(x)); 
    } 
    @Override 
    public Function derivative() { 
    	
    	return Multiplication.of(InnerF, Exponential.of(Abs.of(InnerF), -1), InnerF.derivative());
    } 
    @Override 
    public String toPrettyString(NumberFormat nf) {
        return String.format("|%s|", InnerF.toPrettyString(nf)); 
    } 
    public static Abs of(Function InnerF) { 
        return new Abs(InnerF); 
    } 
}

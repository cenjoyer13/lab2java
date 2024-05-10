package lab2.main;

import java.text.NumberFormat;
import static java.lang.Math.*;

public class Sin extends Nested {  

    public Sin(Function InnerF) { 
        super(InnerF);
    } 

    @Override 
    public double calculate(double x) { 
        return sin(InnerF.calculate(x)); 
    } 
    @Override 
    public Function derivative() { 
    	return Multiplication.of(Cos.of(InnerF), InnerF.derivative()); 
    } 
    @Override 
    public String toPrettyString(NumberFormat nf) { 
    	return String.format("sin(%s)", InnerF.toPrettyString(nf)); 
    } 
    
    public static Sin of(Function InnerF) { 
        return new Sin(InnerF); 
    } 
} 

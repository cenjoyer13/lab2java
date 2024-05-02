package lab2.main;

import java.text.NumberFormat;
import static java.lang.Math.*;

public class Sin implements Function {  

    private final Function InnerF; 

    public Sin(Function InnerF) { 
        this.InnerF = InnerF;
    } 
    @Override
    public boolean equals(Function f) {
    	Sin f1 = (Sin) f;
        return (InnerF.equals(f1.InnerF));
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

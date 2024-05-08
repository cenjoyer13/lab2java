package lab2.main;

import java.text.NumberFormat;
import static java.lang.Math.*;

public class Cos extends Nested {

    public Cos(Function InnerF) { 
    	super(InnerF);
    } 

    @Override 
    public double calculate(double x) { 
        return cos(InnerF.calculate(x)); 
    } 
    @Override 
    public Function derivative() { 
        return Multiplication.of(Const.of(-1), Sin.of(InnerF), InnerF.derivative()); 
    } 
    @Override 
    public String toPrettyString(NumberFormat nf) { 
    	return String.format("cos(%s)", InnerF.toPrettyString(nf)); 
    } 
    
    public static Cos of(Function InnerF) { 
        return new Cos(InnerF); 
    } 
}

package lab2.main;
import java.text.NumberFormat;

import static java.lang.Math.*;

public class Exponential implements Function {
 
    private final double power;
    private final Function InnerF;
 
    public Exponential(Function InnerF, double power) { 
        this.power = power;
        this.InnerF = InnerF;
    }
    
    @Override
    public boolean equals(Function f) {
    	if (this.getClass() == f.getClass()) {
    		Exponential f1 = (Exponential) f;
    		return (InnerF.equals(f1.InnerF) && (this.power == f1.power));
    	}
    	else return false;
    }
    @Override 
    public double calculate(double x) { 
        return pow(InnerF.calculate(x),power); 
    } 
    @Override 
    public Function derivative() { 
    	if (power - 1 == 1) return Multiplication.of(Const.of(power), InnerF, InnerF.derivative());
    	if (power - 1 == 0) return InnerF.derivative();
    	return Multiplication.of(Const.of(power), Exponential.of(InnerF, power-1), InnerF.derivative());
    } 
    @Override 
    public String toPrettyString(NumberFormat nf) {
        return String.format("%s^%s", InnerF.toPrettyString(nf), nf.format(power)); 
    } 
    public static Exponential of(Function InnerF, double power) { 
        return new Exponential(InnerF, power); 
    } 
}

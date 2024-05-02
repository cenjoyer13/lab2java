package lab2.main;

import java.text.NumberFormat;

public class X implements Function {
	
	public X() {
		
	}
	
	@Override
    public boolean equals(Function f) {
        return (this.getClass() == f.getClass());
    }
	@Override
	public double calculate(double x) { 
        return x; 
    }
    @Override 
    public String toPrettyString(NumberFormat nf) { 
        return "x"; 
    }
    @Override 
    public Function derivative() { 
        return new Const(1); 
    }
    
    public static X x() {
    	return new X();
    }
}

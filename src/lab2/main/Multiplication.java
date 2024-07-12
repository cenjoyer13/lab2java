package lab2.main;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Multiplication extends Composite{
	
	public Multiplication() {
        super();
    }
    public Multiplication(Function... terms) {
        super(terms);
    }
    public Multiplication(ArrayList<Function> terms) {
        super(terms);
    }
    public Multiplication(Multiplication template) {
        super(template);
    }
    
    private static void simplifyConst(Multiplication obj)
    {
    	double res = 1;
    	for (int i = 0; i < obj.terms().size(); i++) {
    		if (obj.terms().get(i).getClass() == Const.class) {
    			res *= obj.terms().get(i).calculate(0);
    			obj.terms().remove(i--);
    		}
    	}
    	if (obj.terms().size() == 0 || res != 1) {
    		obj.terms().add(Const.of(res));
    	}
    }
    
    private static void simplifyMulti(Multiplication obj)
    {
    	for (int i = 0; i < obj.terms().size(); i++)
    	{
    		if (obj.terms().get(i).getClass() == Multiplication.class) {
    			Multiplication temp = (Multiplication) obj.terms().get(i);
    			for (Function func : temp.terms())
    			{
    				obj.terms().add(func);
    			}
    			obj.terms().remove(i--);
    		}
    	}

    }
    
    private static void simplifySimilars(Multiplication obj)
    {
    	for (int i = 0; i < obj.terms().size(); i++)
    	{
    		Function current;
    		double power = 0;
    		if (obj.terms().get(i).getClass() == Exponential.class) {
    			Exponential temp = (Exponential) obj.terms().get(i);
    			current = temp.getInnerF();		
    		}
    		else {
    			current = obj.terms().get(i);
    		}
    		for (int j = i; j < obj.terms().size(); j++)
    		{
    			if (obj.terms().get(j).getClass() == Exponential.class)
    			{
    				Exponential temp = (Exponential) obj.terms().get(j);
    				if (temp.getInnerF().equals(current))
    				{
    					power += power = temp.getPower();
    					obj.terms().remove(j--);
    				}
    			}
    			else if (obj.terms().get(j).equals(current))
    			{
    				power++;
    				obj.terms().remove(j--);
    			}
    		}
    		obj.terms().add(0, Exponential.of(current, power));
    	}

    }
    
    private static void simplifyToZero(Multiplication obj)
    {
    	for (Function function : obj.terms()) {
    		if (function.equals(Const.ZERO))
    			{
    				obj.terms().clear();
    				obj.terms().add(Const.ZERO);
    				return;
    			}
    	}
    }
    
    @Override
    public double calculate(double x) {
        double result = 1;
        for (Function function : terms()) {
            result *= function.calculate(x);
        }
        return result;
    }
    @Override
    public Function derivative() {
    	final ArrayList<Function> derivativeTerms = new ArrayList<>(terms().size());
        for (int i = 0; i < terms().size(); i++) {
        	ArrayList<Function> temp = new ArrayList<>(terms().size());
        	for (int j = 0; j < terms().size(); j++) {
        		if(i == j) temp.add(terms().get(j).derivative());
        		else temp.add(terms().get(j));
        	}
        	derivativeTerms.add(Multiplication.of(temp));
        }
        return Sum.of(derivativeTerms);
    }
    @Override
    public String toPrettyString(NumberFormat nf) {
        final StringJoiner joiner = new StringJoiner("*");
        for (Function function : terms()) {
            joiner.add(function.toPrettyString(nf));
        }
        return String.format("(%s)",joiner.toString());
    }
       
    public static Function of(Function... terms) {
    	Multiplication result = new Multiplication(terms);
    	simplifyToZero(result);
    	simplifyMulti(result);
    	simplifySimilars(result);
    	simplifyConst(result);
    	if (result.terms().size() == 1) return result.terms().get(0);
    	return result;
    }

    public static Function of(ArrayList<Function> terms) {
    	Multiplication result = new Multiplication(terms);
    	simplifyToZero(result);
    	simplifyMulti(result);
    	simplifySimilars(result);
    	simplifyConst(result);
    	if (result.terms().size() == 1) return result.terms().get(0);
    	return result;
    }
}

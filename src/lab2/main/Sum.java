package lab2.main;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringJoiner;

/* клас функцій суми */
public class Sum extends Composite {

    public Sum() {
        super();
    }
    public Sum(Function... terms) {
        super(terms);
    }
    public Sum(ArrayList<Function> terms) {
        super(terms);
    }
    public Sum(Sum template) {
        super(template);
    }
    
    private static void simplifySum(Sum obj)
    {
    	for (int i = 0; i < obj.terms().size(); i++)
    	{
    		if (obj.terms().get(i).getClass() == Sum.class) {
    			Sum temp = (Sum) obj.terms().get(i);
    			for (Function func : temp.terms())
    			{
    				obj.terms().add(func);
    			}
    			obj.terms().remove(i--);
    		}
    	}

    }
    
    private static void simplifySimilars(Sum obj)
    {
    	for (int i = 0; i < obj.terms().size(); i++)
    	{
    		Function current;
    		double lin = 0;
    		if (obj.terms().get(i).getClass() == Multiplication.class)
    		{
    			 Multiplication temp = new Multiplication((Multiplication) obj.terms().get(i));
    			 for (int k = 0; k < temp.terms().size(); k++)
    			 {
    				 if (temp.terms().get(k).getClass() == Const.class) {
    					 temp.terms().remove(k--);
    				 }
    			 }   			 
    			 current = temp;
    		}
    		else {
    			current = obj.terms().get(i);
    		}
    		for (int j = i; j < obj.terms().size(); j++)
    		{
    			if (obj.terms().get(j).getClass() == Multiplication.class)
        		{
    				 Multiplication temp = new Multiplication((Multiplication) obj.terms().get(i));
        			 double temp2 = 1;
        			 for (int k = 0; k < temp.terms().size(); k++)
        			 {
        				 if (temp.terms().get(k).getClass() == Const.class) {
        					 temp2 = temp.terms().get(k).calculate(0);
        					 temp.terms().remove(k--);
        				 }
        			 }
        			 if (temp.equals(current)) {
        				 lin += temp2;
        				 obj.terms().remove(j--);
        			 }
        		}
        		else {
        			if (obj.terms().get(j).equals(current)) {
        				lin++;
        				obj.terms().remove(j--);
        			}
        		}
    		}
    		if (lin != 1) obj.terms().add(0, Multiplication.of(current, new Const(lin)));
    		else obj.terms().add(0, current);
    	}

    }
    
    private static void simplifyZeros(Sum obj)
    {
    	for (int i = 0; i < obj.terms().size(); i++) {
    		if (obj.terms().get(i).equals(Const.ZERO))
    			{
    				obj.terms().remove(i--);
    			}
    	}
    	if (obj.terms().size() == 0) {
    		obj.terms().add(Const.ZERO);
    	}
    }
    
    @Override
    public double calculate(double x) {
        double result = 0.0;
        for (Function function : terms()) {
            result += function.calculate(x);
        }
        return result;
    }
    @Override
    public Function derivative() {
        final ArrayList<Function> derivativeTerms = new
         ArrayList<>(terms().size());
        for (Function function : terms()) {
        	derivativeTerms.add(function.derivative());
        }
        return Sum.of(derivativeTerms);
    }
    @Override
    public String toPrettyString(NumberFormat nf) {
    	final StringJoiner joiner = new StringJoiner("+");
        for (Function function : terms()) {
            joiner.add(function.toPrettyString(nf));
        }
        return String.format("(%s)",joiner.toString()).replace("+-", "-");
    }
    public static Function of(Function... terms) {
    	Sum result = new Sum(terms);  	
    	simplifySum(result);    	   	
    	simplifySimilars(result);
    	simplifyZeros(result);
    	if (result.terms().size() == 1) return result.terms().get(0);
    	return result;
    }
    
    public static Function of(ArrayList<Function> terms) {
    	Sum result = new Sum(terms);   	
    	simplifySum(result);    	   	
    	simplifySimilars(result);
    	simplifyZeros(result);
    	if (result.terms().size() == 1) return result.terms().get(0);
    	return result;
    }
}

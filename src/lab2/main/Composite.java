package lab2.main;

import java.util.ArrayList;
import java.util.Arrays;

/* абстрактний клас композитних функцій */ 
public abstract class Composite implements Function { 
 
    private final ArrayList<Function> terms; 
 
    @Override
    public boolean equals(Function f) {
    	if (this.getClass() == f.getClass()) {
    	Composite f1 = (Composite) f;
    	if (terms().size() == f1.terms().size()) { 	
    	ArrayList<Integer> IDs = new ArrayList<>();
    	for (int i = 0; i < terms().size(); i++) {
    		boolean isE = false;   		
    		for (int j = 0; j < f1.terms().size(); j++) { 
                if (terms().get(i).equals(f1.terms().get(j)) && !IDs.contains(j)) {
                	IDs.add(j);
                	isE = true;
                	break;
                }
            }
    		if (!isE) {
    			return false;
    		}
        } 
    	return true;
    	}
    	else return false;
    	}
    	else return false;
    }
    public ArrayList<Function> terms() { 
        return terms; 
    } 
    public Composite() { 
        terms = new ArrayList<>(); 
    } 
    public Composite(Function... terms) { 
        this.terms = new ArrayList<>(Arrays.asList(terms)); 
    } 
    public Composite(ArrayList<Function> terms) { 
        this.terms = terms; 
    } 
} 

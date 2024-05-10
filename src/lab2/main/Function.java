package lab2.main;
import java.text.*;

/* інтерфейс функції */ 
public interface Function {
	double calculate(double x); 
	 
    Function derivative(); 
 
    String toPrettyString(NumberFormat nf);
    
    boolean equals(Function f);
}

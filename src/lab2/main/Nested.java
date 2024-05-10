package lab2.main;

public abstract class Nested implements Function{
	protected final Function InnerF;
	
	public Nested(Function InnerF) {
        this.InnerF = InnerF;
    }
	@Override
    public boolean equals(Function f) {
		if (this.getClass() == f.getClass()) {
			Nested f1 = (Nested) f;
			return (InnerF.equals(f1.InnerF));
		}
		else return false;
    }
	
}

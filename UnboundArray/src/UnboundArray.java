public class UnboundArray {
	
	private int alpha=4;
	private int beta=2;
	private int n=0;
	private int w=1;
	private Object[] innerArray=new Object[1];

	public void pushBack(Object o) {
		if (n==w) 
			reallocate(beta*n);		
		innerArray[n++]=o;		
	}
	
	private void reallocate(int size) {
		if (size==0) size++;
		Object[] tmp=new Object[size];
		w=size;
		for (int i=0;i<n;i++)
			tmp[i]=innerArray[i];
		innerArray=tmp;			
	}
	
	public Object popBack() {
		Object ret=null;	
		if (n>0) {
			n--;			
			ret=innerArray[n];			
			innerArray[n]=null;			
			if (alpha*n<=w)
				reallocate(beta*n);
		}
		return ret;
	}
	
	public Object get(int i) {
		Object ret=null;
		if (i<w)
			ret=innerArray[i];
		return ret;
	}
	
	public int size() {
		return n;
	}
	
	// zur Ausgabe des Inhalts
	private void print() {
		System.out.println();
		for (Object o : innerArray)
			System.out.print(o+" ");
		System.out.println();		
	}
	
	// zur Ausgabe des Inhalts
	private void printSizes() {
		System.out.println("n=:"+n+"w="+w);
	}

	
	public static void main(String[] args) {
		UnboundArray ua=new UnboundArray();
		for (int i=0;i<11;i++) {		
			ua.pushBack(i);
			ua.printSizes();			
		}
		for (int i=0;i<11;i++) {		
			ua.popBack();
			ua.printSizes();			
		}			
	}
}
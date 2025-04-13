package datastr;

//stack nodes class
public class MyNodeS<T> {
	
	private T element;
	private MyNodeS<T> next = null;
	
	
	public MyNodeS(T element) {
        this.element = element;
        this.next = null;
    }
	
	public T getElement() {
		return element;
	}
	public void setElement(T inputElement) {
		if(inputElement != null) {
			this.element = inputElement;
		}
		else {
			element = (T) new Object();
		}
	}
	
	public MyNodeS getNext() {
		return next;
	}
	public void setNext(MyNodeS next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return element + "";
	}

	
	
	
	

}

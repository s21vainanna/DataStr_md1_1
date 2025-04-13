package datastr;

public class MyStack<T> {
	
    private MyNodeS<T> topNode; //reference uz augšējo mezglu
    private int length;// steka lielums

    
    public MyStack() {
        this.topNode = null;
        this.length = 0;
    }
    /*
    public boolean isFull() {
        try {
            new MyNodeS<>(null); //The line new MyNodeS<>(null) attempts to create a new instance of MyNodeS with a null value.
            return false; 
        } catch (OutOfMemoryError e) {//It occurs when the Java Virtual Machine (JVM) cannot allocate enough memory for the application.
            return true; 
        }
    }*/

    // Check if stack is empty
    public boolean isEmpty() {
        return topNode == null;
    }

    // Get the number of elements in the stack
    public int size() {
        return length;
    }

    // Push an element onto the stack
    public void push(T element) {
       /* if (isFull()) {
            throw new OutOfMemoryError("Stack is full");
        }*/
        MyNodeS<T> newNode = new MyNodeS<>(element);//Tiek izveidots jaunais mezgls ar elementa vērtību;
        newNode.setNext(topNode); //jaunajam mezglam norāda saiti uz esošo top elementu (šo var apvienot ar 1. punkta darbību);
        topNode = newNode;//top referenci nomainam uz jauno mezglu.
        length++;
    }

    // Pop an element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T element = topNode.getElement();//varam izdzēst tikai nesen pievienoto jeb augšējo mezglu(node) LIFO
        topNode = topNode.getNext();//top norādi pārbīdam uz to mezglu, uz kuru norāda esošais top mezgls
        length--;
        
        System.gc();
        
        return element;
    }
   
    public T top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return topNode.getElement();
    }

    // Print all elements in the stack
    public void print() {
        MyNodeS<T> temp = topNode;
        while (temp != null) {
            System.out.print(temp.getElement() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public void makeEmpty() {
        topNode = null;
        length = 0;
    }
}

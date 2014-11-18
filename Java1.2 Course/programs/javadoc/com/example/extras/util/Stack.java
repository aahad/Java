// Filename: Stack.java
package com.example.extras.util;

/**
 *  This class implements a <i>generic stack</i>. An array is
 *  used to implement the stack.
 *  @author K.A.M.
 *  @version 1.1
 */
public class Stack {

    /** The array that implements the stack. */
    private Object[] stackArray;

    /** The top of the stack. */
    private int topOfStack;

    /**
     *  Initialize the stack.
     *  @param capacity Length of the stack.
     */
    public Stack (int capacity) {
        stackArray = new Object[capacity];
        topOfStack = -1;
    }

    /**
     *  Push a value on the stack.
     *  @param element The object to push on the stack.
     *  @exception FullStackException The stack is full.
     *  @see #pop()
     */
    public synchronized void push(Object element) throws FullStackException {
        if (isFull()) throw new FullStackException();
        stackArray[++topOfStack] = element;
    }

    /**
     *  Insert a value on the stack.
     *  @param element The object to insert on the stack.
     *  @exception FullStackException The stack is full.
     *  @deprecated As of version 1.1,
     *  replaced by the {@link #push(Object) <i>push</i>} method. The insert name
     *  was misleading.
     */
    public synchronized void insert(Object element) throws FullStackException {
        push(element);
    }

    /**
     *  Pop the value from top of the stack.
     *  @return The object on top of the stack.
     *  @exception EmptyStackException The stack is empty.
     *  @see #push(Object)
     */
    public synchronized Object pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        Object obj = stackArray[topOfStack];
        stackArray[topOfStack] = null;
        topOfStack--;
        return obj;
    }

    /**
     *  Peek at the object on top of the stack. The stack is
     *  not popped.
     *  @return The object on top of the stack.
     *  @exception EmptyStackException The stack is empty.
     */
    public synchronized Object peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return stackArray[topOfStack];
    }

    /**
     *  Check if the stack is empty.
     *  @return <code>true</code>, if stack is empty.
     */
    public boolean isEmpty() { return topOfStack < 0; }

    /**
     *  Check if the stack is full.
     *  @return <code>true</code>, if stack is full.
     */
    public boolean isFull() {return topOfStack == stackArray.length - 1; }
}

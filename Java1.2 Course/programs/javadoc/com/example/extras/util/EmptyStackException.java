// Filename: EmptyStackException.java
package com.example.extras.util;
/**
 *  This exception indicates that the stack is empty.
 */
public class EmptyStackException extends Exception {
    public EmptyStackException() {
        super("Empty Stack");
    }
}

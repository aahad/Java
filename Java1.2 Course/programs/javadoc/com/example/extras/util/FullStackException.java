// Filename: FullStackException.java
package com.example.extras.util;
/**
 *  This exception indicates that the stack is full.
 */
public class FullStackException extends Exception {
    public FullStackException() {
        super("Full Stack");
    }
}

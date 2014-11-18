[Java 1.2 Course for Beginners]

================================================================================================================================
It covers almost all language essentials and core concepts like threads, exception handling, collections, File IO, databases, AWT/Swing, RMI, Sockets , JSP, Servlets etc.

================================================================================================================================

JAVA Notes Index
========
Thursday, Feb 22nd, 2001
Java Terms: 
	PIE - Polymorphism, Inheritence, Encapsulation 
	methods, attributes, behaviors, class, instance 

Java Syntax:
	package, import, javac - java compiler
	case-sensitive, java MyClass.class	First Java Program: 
	public static void main (String args[]) 
	import java.lang.* 
	System.out.println 

Primitives types:
	Boolean, character, integer, floating 
	Wrapper classes


Saturday, Feb 24th, 2001
	Primitives: 
	non-floating, floating, character, boolean 
	BASE 10, BASE 8 (0144), BASE 16 (0x144) 


Comments:
	Single Line, Double line, HTML Document	Basic Rules: 
	';', Unicode - 16 bit naming 
	'-', '_', '$', Keywords vs Identifiers 
	Reserved keywords, goto, const 
	concatenate, overloading 

Misc:
	Literals, Casting (float) 
	Character Literals (char, concatenate) 
	Boolean Literals 
	Escape Sequence (\t \u \d \n \f)



Tuesday, Feb 27th, 2001
	Variables: 
	Static, non-static 
	Field or member variable 
	automatic or local variable 

Defaults:
	0 zero, null	Arrays: 
	Declaration, Construction, Initialization 
	int i[] = new int[10]; 
	int i[] = {10,20,30,40}; array length 


Misc:
	Implicit Conversion - Automatic Promotion 
	Explicit Conversion - Conversion Casting 
	(Boolean is never casted) 
	Priority Table


Thursday, March 1st, 2001
Operators: 
	Priority Unary, Arithmatic, Shift, Comparision, Bitwise 
	short-circuit, Ternary, Assignment 
	~ bit inversion, ! negation, () casting 
	% modulus/remainder 

	Increment / Decrement Operators: 
	i++, ++i, i-- 
	b=b+1 vs b++	Wrapper Classes: 
	2+2 vs 2+"2" 
	Converting a primitive to object 

Misc:
	2 Dimensional Arrays (2D) 
	Arithmatic Error handling, eg. -16/0, float vs non-float
	Bitwise Operators, & | ^ , boolean case


Saturday, March 3rd, 2001
	Shift Operators: 
	LSB - Least Significant Bit 
	MSB - Most Significant Bit 
	<< Left shift, >> Right signed Shift 
	>>> Right unsigned shift (zero filled shift) 

Misc:
	Short-Circuit Operator, ||, && 
	Equal to Operator, ==, 2 objects have same address 
	instanceof Operator, vector vs array


Saturday , March 10th, 2001
Headings: 
	Ternary Operator, x = a ? b : c 
	Assignment Operator '=' 
	Operator Precedence (order) 
	Variables, Local/automatic, field/member 
	Constructor 
	this and super (parent vs child) NOTE: never used in main method
	Method Definition 
	Static vs Non-Static


Tuesday, March 13th, 2001
Java Test 1 


Thursday, March 15th, 2001
Headings: 
	method definition, method signature 
	Creating an object, static vs non-static 
	Method arguments, passing values to a method 


Saturday , March 17th, 2001
Modifiers: 
	Access: public, protected, package/friendly, private 
	Additional: abstract, native, syncronized, static, 
	non-static, transient 

Misc:
	Object sent as method argument, o.a *= 2; 
	abstract: class and method 
	value passed to an abstract class 
	Intro to interface


Tuesday , March 20th, 2001
Headings: 
	final: last class in the hierarchy, child, abstract 
	native: Java Native Inteface (JNI), talk to other languages 
	transient: Not serialized, stream, applied to variables 
	syncronized: multi-threading, lock


Thursday, March 22nd, 2001
Headings: 
	Selection, Iteration (loops) and jumping statements 
	if-else statement/ladder 
	Case-Switch, multiple cases 
	while loops 
	do-while loops 
	for loops, multiple iterations 
	break jump


Saturday, March 24th, 2001
Headings: 
	nested loops 
	continue and break jump 
	labels (flow controls), nested labels, break labels


Tuesday, March 27th, 2001
Headings: 
	Exception handling 
	try and catch blocks, multiple catch statements 
	Exception Hirarchy 
	Nested Exception handlers 
	Method called from a try block


Thursday, March 29th, 2001
Headings: 
	throw keyword - throwing exceptions 
	throws keyword - class definition 
	finally keyword, try/catch/finally block


Saturday, March 31st, 2001
Headings: 
	checked and unchecked exceptions 
	user-defined exceptions, taking input from user 
	System.out.flush 
	Conversion and Casting


Tuesday, April 3rd, 2001
Headings: 
	Hirarchy rules for objects, serializable 
	Conversion relating objects, interfaces and arrays 
	Object <--> Interface <--> Array Table 
	First Conversion example


Saturday, April 7th, 2001
Headings: 
	Casting relating to objects 
	extends vs implements 
	casting to fool compiler 
	Garbage Collector (GC), thread 
	main 2 threads - main method thread and GC thread


Tuesday, April 10th, 2001
Headings: 
	Garbage Collector (continued) 
	Polymorphism, Inheritance, Overloading 
	Constructor Overloading Introduction
	this and super in constructors 
	Recursion in constructors 
	Converting words to code (like Math word problems)


Thursday, April 12th, 2001
Headings: 
	Taking user input 
	Constructor Overloading 
	Method Over-riding - access modifiers
	Exception handling with overriding 


Saturday, April 14th, 2001
Headings: 
	Method Recursion (Fibonacci Series)
	Inner Classes 
	Types of Inner Classes 
	Non-Static - Outer$Inner.class 
	Static Local - Outer$1$Local.class
	Anonymous 

Tuesday, April 17th, 2001
Headings: 
	Introduction to Threading 
	Creating Threads - Min/Max/Norm priorities, OS/Daemon threads 
	Extends Thread 
	Implements Runnable Interface 
	Creating multiple threads 
	Thread Status


Thursday, April 19th, 2001
Headings: 
	Thread States - Ready/Start, Running, Waiting, Dead; Yielding 
	Scheduling - Priemptive, Time-slicing 
	synchronized keyword 


Saturday, April 21st, 2001
Headings: 
	Interthread Communication - wait(), notify(), notifyAll(), implements Runnable
	Deadlock 
	Introduction to lang package 
	A look at Java API


Tuesday, April 24th, 2001
Headings: 
	Wrapper Classes
	Math Class


Thursday, April 26th, 2001
Headings: 
	String and StringBuffer 
	String Methods 
	A look at the API


Saturday, April 28th, 2001
Headings: 
	Modifying a String - subString(), concat(), trim() 
	StringBuffer class methods - append()
	Math class example


Thursday, May 3rd, 2001
Headings: 
	Introduction to Applets - appletviewer, browser
	Applet Methods - init(), destroy() 
	Applet Skeleton Structure


Saturday, May 5th, 2001
Headings: 
	Applet Threads - Simple Applet Banner
	Applet parameters - passing attribute values to applet 
	Event Handling - Source, Event, Listener 
	Event Handling Models - Inheritance, Delegation 
	Using AWT
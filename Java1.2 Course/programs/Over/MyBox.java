import java.awt.Color;

public class Box {
 double x, y, width, height;
 public Box(double x, double y, double width, double height) {
  this.x = x;
  this.y = y;
  this.width = width;
  this.height = height;
 }
 public Box(double x, double y) {
  this(x,y,10,10);
 }
 public Box() {
  this(1,1);
 }
}

public class MyBox extends Box {
 Color outerColor;
 Color innerColor;
 public MyBox(double x, double y, double width, double height, 
    Color outer, Color inner) {
  super(x,y,width,height);
  outerColor = outer;
  innerColor = inner;
 }
 public MyBox(Color outer, Color inner) {
  super(10,10,100,100);
  outerColor = outer;
  innerColor = inner;  
 }
 public MyBox() {
  super();
  outerColor = Color.black;
  innerColor = Color.white;
 }
}

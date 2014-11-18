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

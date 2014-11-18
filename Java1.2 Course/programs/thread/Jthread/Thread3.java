class Thread3 extends Thread {
 static String message[] = {"Java","is","hot,","aromatic,","and",
  "invigorating."};
 public static void main(String args[]) {
  Thread3 thread1 = new Thread3("thread1: ");
  Thread3 thread2 = new Thread3("thread2: ");
  thread1.start();
  thread2.start();
  boolean thread1IsAlive = true;
  boolean thread2IsAlive = true;
  do {
   if(thread1IsAlive && !thread1.isAlive()){
    thread1IsAlive = false;
    System.out.println("Thread 1 is dead.");
   }
   if(thread2IsAlive && !thread2.isAlive()){
    thread2IsAlive = false;
    System.out.println("Thread 2 is dead.");
   }
  }while(thread1IsAlive || thread2IsAlive);
 }
 public Thread3(String id) {
  super(id);
 }
 public void run() {
  SynchronizedOutput.displayList(getName(),message);
 }
 void randomWait(){
  try {
   sleep((long)(3000*Math.random()));
  }catch (InterruptedException x){
   System.out.println("Interrupted!");
  }
 }
}
class SynchronizedOutput {
 public static synchronized void 
  displayList(String name,String list[]) {
  for(int i=0;i<list.length;++i) {
   Thread3 t = (Thread3) Thread.currentThread();
   t.randomWait();
   System.out.println(name+list[i]);
  }
 }
}

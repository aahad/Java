class Thread4 extends Thread {
 static String message[] = {"Java","is","hot,","aromatic,","and",
  "invigorating."};
 public static void main(String args[]) {
  Thread4 thread1 = new Thread4("thread1: ");
  Thread4 thread2 = new Thread4("thread2: ");
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
 public Thread4(String id) {
  super(id);
 }
 public void run() {
  synchronized(System.out) {
   for(int i=0;i<message.length;++i) {
    randomWait();
    System.out.println(getName()+message[i]);
   }
  }
 }
 void randomWait(){
  try {
   sleep((long)(3000*Math.random()));
  }catch (InterruptedException x){
   System.out.println("Interrupted!");
  }
 }
}

class Thread5 {
 public static void main(String args[]) {
  Resource resource = new Resource();
  Thread controller = new Thread(new Controller(resource));
  Thread[] user = new Thread[3];
  for(int i=0;i<user.length;++i)
   user[i] = new Thread(new User(i,resource));
  controller.start();
  for(int i=0;i<user.length;++i)
   user[i].start();
  boolean alive;
  out: do {
   alive = false;
   for(int i=0;i<user.length;++i)
    alive |= user[i].isAlive();
   Thread.currentThread().yield();
  } while(alive);
  controller.interrupt();
 }
}
class Resource {
 boolean okToSend = false;
 public synchronized void displayOutput(int id,String[] message) {
  try{
   while(!okToSend) {
    wait();
   }
   okToSend = false;
   for(int i=0;i<message.length;++i) {
    Thread.currentThread().sleep((long)1000);
     System.out.println(id+": "+message[i]);
   }
  }catch(InterruptedException ex){
  }
 }
 public synchronized void allowOutput() {
  okToSend = true;
  notify();
 }
}
class Controller implements Runnable {
 Resource resource;
 public Controller(Resource resource) {
  this.resource = resource;
 }
 public void run() {
  try{
   while(true) {
    Thread.currentThread().sleep((long)10000);
    resource.allowOutput();
   }
  }catch(InterruptedException ex){
  }
 }
}
class User implements Runnable {
 static String message[] = {"Java","is","hot,","aromatic,","and",
  "invigorating."};
 int id;
 Resource resource;
 public User(int id,Resource resource) {
  this.id = id;
  this.resource = resource;
 }
 public void run() {
  resource.displayOutput(id,message);
 }
}

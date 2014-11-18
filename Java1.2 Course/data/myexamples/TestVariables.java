
public class TestVariables {
    
    static int  a[][] = { {1,2,3}, {4,5,6}, {6,7,8} };
    
    public static void main(String[] args) {
       
       // TestVariables obj = new TestVariables();
        for( int lop=0; lop < a.length; lop++ ) {
           for (int lop2=0; lop2< a[0].length; lop2++) {
                System.out.print( " " +a[lop][lop2]  );
           }               
            System.out.println();
    
        }
    
    }
}


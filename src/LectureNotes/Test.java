package LectureNotes;

public class Test {
    public static int []doubleA(int []A) {
        int []B = new int[A.length];
    
        for (int i = 0; i < A.length; i++) {
          B[i] = A[i] * 2;
        }
        return B;
      }
    
      public static void main(String []args) {
        int []A = {10, 20, 30};
        int []B = {5, 10, 15};
    
        B = doubleA(B);
    
        if (A == B) {
          System.out.println("same");
        } else {
          System.out.println("different");
        }
      }
}

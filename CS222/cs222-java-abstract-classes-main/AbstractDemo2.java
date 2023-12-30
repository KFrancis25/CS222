/* File name : AbstractDemo2.java */
public class AbstractDemo2 {

   public static void main(String [] args) {
      Salaried s = new Salaried("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
      Employee e = new Salaried("John Adams", "Boston, MA", 2, 2400.00);
      System.out.println();

      System.out.println("Call mailCheck using Salaried reference --");
      s.mailCheck();
      System.out.println();

      System.out.println("Call mailCheck using Employee reference--");
      e.mailCheck();
   }
}
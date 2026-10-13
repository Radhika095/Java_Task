import java.util.Scanner;

class Demo {
    public void greet() {
           System.out.println("Good Evening Interns ");
    }


    public void sum (int a , int b ) {
     System.out.println("The addition is : " + (a+b));
    }
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);

        System.out.println("Enter the value of a :");
        int a = sc.nextInt();
        
        System.out.println("Enter the value of b :");
        int b = sc.nextInt();

       
        System.out.println("The addition is : " + (a+b));
        System.out.println("The Difference is : " + (a-b));
        System.out.println("The Division is : " + (a/b));
        System.out.println("The Modulus  is : " + (a%b));

        Demo d = new Demo();
        d.greet();
        d.sum(a,b);
    }
}
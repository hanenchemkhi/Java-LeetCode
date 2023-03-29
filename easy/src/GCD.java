import java.util.Scanner;

public class GCD {

    public static void main(String [] args){
//        int a = Integer.parseInt(args[0]);
//        int b = Integer.parseInt(args[1]);

        int a= 12;
        int b=20;

        Scanner scanner = new Scanner(System.in);

//        System.out.println("Enter first integer : ");
//        int a = scanner.nextInt();
//        System.out.println("Enter second integer : ");
//        int b = scanner.nextInt();

        System.out.println("GCD("+a+" , "+b+ ") = "+ gdc(a,b));

        int[] array = {12,15,18,21};
        System.out.println("GCD of {12,15,18,21} =  "+ gdcArray(array));



        System.out.println("LCM("+a+", "+b+")="+lcm(a,b));

    }
    public static int gdcArray(int[]array){

        int result=array[0];
        for (int j : array) {
            result = gdc(result, j);
        }
        return result;
    }
    public static int lcm(int a , int b){
        return (a*b)/gdc(a,b);
    }
    public static int gdc(int a , int b){
        if(a==b){
            return a;
        }

//        if(a<b){
//            int temp = a;
//            a = b;
//            b = temp;
//        }
//
//        int r = b;
//        while(b != 0){
//            r= a%b;
//            a = b;
//            b =r;
//        }
//        return a;

        if (b == 0)
            return a;
        return gdc(b, a % b);

    }
}

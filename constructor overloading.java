
public class HelloWorld {
    public static void main(String[] args) {
        Cal c;//=new Cal();
        c=new Cal(4);
         System.out.println(c.one+" "+c.two+" "+c.op);
        c=new Cal(8,5);
         System.out.println(c.one+" "+c.two+" "+c.op);
          c=new Cal(3,7,"REST API");
       System.out.println(c.one+" "+c.two+" "+c.op);
    }
}
class Cal {
    int one;
    int two;
    String op;
    public Cal() {
        one=0;
        two=0;
        op="NAN";
    }
    public Cal(int a) {
        one=a;
        two=0;
        op="NAN";
    }
    public Cal(int a,int b) {
        one=a;
        two=b;
        op="NAN";
    }
     public Cal(int a,int b,String str) {
        one=a;
        two=b;
        op=str;
    }
}

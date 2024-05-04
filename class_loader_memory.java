// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class HelloWorld {
    public static void main(String[] args) {
        Emp usr=new Emp();
        usr.eid=2;
        usr.salary=5000000;
        usr.ceo="Ram";
        Emp arun=new Emp();
        arun.eid=3;
        arun.salary=6000000;
        arun.ceo="Ram";
        arun.show();
        usr.show();

    }
}

//class loader memory will load the class

class Emp {
    int eid;
    int salary;
    String ceo;
    public void show(){
           System.out.println(eid+" "+salary+" "+ceo);
    }

}

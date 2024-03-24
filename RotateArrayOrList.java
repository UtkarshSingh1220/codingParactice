import java.util.*;
import java.util.stream.*;
class HelloWorld {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1,4,5,6,7,3,8);
        System.out.println(num);
        System.out.println(rightRotationTC(3,num));
    }
    
    // left rotation with tc = O(n)  sc = O(n) 
    public static List<Integer> leftRotationTC(int n,List<Integer> num){
        List<Integer> numx = new ArrayList<>(num);
        int size=num.size();
        if(num.size() == 0) return numx;
        for(int i=size-1,j=size-1-n;i>=0+n && j>=0;i--,j--){
            num.set(i,num.get(j));
        }
        for(int i=0,j=size-n;i<n;i++,j++){
            num.set(i,numx.get(j));
        }
        return num;
    }
   
   // left rotation with tc = O(n)^2  sc = O(1) 
    public static List<Integer> leftRotation(int n,List<Integer> num){
         if(num.size() == 0) return num;
        while(n>0){
            int temp=num.get(num.size()-1);
            for(int i=num.size()-1;i>0;i--){
                num.set(i,num.get(i-1));            
            }
             num.set(0,temp);
             n--;
            
        }

        return num;
    }
    
     // right rotation with tc = O(n)  sc = O(n) 
    public static List<Integer> rightRotationTC(int n,List<Integer> num){
        List<Integer> numx = new ArrayList<>(num);
        int size=num.size();
        if(num.size() == 0) return numx;
        for(int i=0,j=n;j<=size-1;i++,j++){
            num.set(i,numx.get(j));
        }
        for(int i=0,j=size-n;j<=size-1;i++,j++){
            num.set(j,numx.get(i));
        }
        return num;
    }
   
   // right rotation with tc = O(n)^2  sc = O(1) 
    public static List<Integer> rightRotation(int n,List<Integer> num){
         if(num.size() == 0) return num;
        while(n>0){
            int temp=num.get(0);
            System.out.println("temp : "+temp);
            for(int i=0;i<num.size()-1;i++){
                num.set(i,num.get(i+1));            
            }
             num.set(num.size()-1,temp);
             n--;
        }
        return num;
    }
}
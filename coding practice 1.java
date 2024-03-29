atoi

class HelloWorld {
    public static void main(String[] args) {
        System.out.println(atoi("")-1);
    }
     public static int atoi(String str) {
        if(str.length()==0){
            return -1;
        }
         int multiplier= 1;
         int sumResult=0;
        // char[] chrArray = str.toCharArray()
        for(int i=str.length()-1;i>=0;i--){
            char tempChar = str.charAt(i);
            int tempInt = tempChar-'0';
            tempInt=tempInt*multiplier;
            
            sumResult=sumResult+tempInt;
            multiplier=multiplier*10;
        }
        return sumResult;
       
    }
      public static int ctoi(char ch) {
             return ch-'0';
        }
}


    public static int findMin(int[] arr1) {
        int res=-1;
        if(arr1.length==0){
                res =-1;
            }
        for(int i=0 ;i<arr1.length-1; i++){
            if(arr1[i]>arr1[i+1]){
                res= arr1[i+1];
                break;
            }
        }
        return res;
    }
	
	########################################################################################
	match dict words with str
	tc = O(o)^3 sc =  o(n)
	     public static String findLargestWord(String[] dictionary, String inputString) {
         String str ="";
         int maxLength = 0;
         for(String strr : dictionary){
             char[] tempStr= inputString.toCharArray();
             int tempCount = 0;
             for(int i=0;i<strr.length();i++){
                 for(int j=0;j<tempStr.length;j++){
                     if(tempStr[j]==strr.charAt(i)){
                         tempCount++;
                         tempStr[j]='0';
                     }
                 }
             }
             if(tempCount == strr.length() && maxLength<tempCount){
                         maxLength=tempCount;
                         str=strr;
                 }
         }
         return str;
     }
--------------------------------------------------------------------------------------------------------	 
	 tc = O(N)^2 sc= O(n)
	 import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
               String[] dictionary = {"to", "banana", "toe", "dogs", "ababcd", "elephant"};
        String inputString = "pahtelen";
        // Find and print the largest word that can be formed using the characters of inputString
        System.out.println(findLargestWord(dictionary, inputString));
    }
     public static String findLargestWord(String[] dictionary, String inputString) {
         String str ="";
         int maxLength = 0;
         for(String strr : dictionary){
             //char[] tempStr= inputString.toCharArray();
             int tempCount = 0;
             Map<Character, Integer> inputStringMap = new HashMap<>();
             Map<Character, Integer> strrMap = new HashMap<>();
             for(Character ch : strr.toCharArray()){
                 strrMap.put(ch,strrMap.getOrDefault(ch,0)+1);
             }
             for(Character ch : inputString.toCharArray()){
                 inputStringMap.put(ch,inputStringMap.getOrDefault(ch,0)+1);
             }
              for(Map.Entry<Character, Integer> etr: strrMap.entrySet()){
                 if(etr.getValue()==inputStringMap.get(etr.getKey())){
                     tempCount++;
                 }
             }
            //  for(int i=0;i<strr.length();i++){
            //      for(int j=0;j<tempStr.length;j++){
            //          if(tempStr[j]==strr.charAt(i)){
            //              tempCount++;
            //              tempStr[j]='0';
            //          }
            //      }
            //  }
             if(tempCount==strrMap.size() && maxLength<strr.length()){
                         maxLength=tempCount;
                         str=strr;
                 }
         }
         return str;
     }
}
	 
	
	
	################################################################################
	 tc = O(n) sc= O(1)
	smallest missing number 
	   public static int findSmallestMissingInteger(int[] arr){
         int res=0;
         if(arr[0]!=0){
             return 0;
         }
         for(int i=0;i<arr.length-1;i++){
             if(arr[i]+1!=arr[i+1]){
                 return arr[i]+1;
             }
             if(i+1==arr.length-1){
                 res =  arr[i+1]+1;
             }
         }
         return res;
     }
	 
###########################################################################################

     public static int[] LongestSameCharacterSubstring(String str) {
         if(str.length()==0){
             return new int[]{0,0};
         }
         int maxSize=0,index=0,tempCount=1;
         
         for(int i=1;i<str.length();i++){
             if(str.charAt(i)==str.charAt(i-1)){
                 tempCount++;
             }else{ 
                 if(tempCount>maxSize){
                     maxSize=tempCount;
                     index = i-maxSize;
                 }
                 tempCount=1;
             }
         }
         return new int[]{index,maxSize};
     }
	 
	 
###############################################################################################


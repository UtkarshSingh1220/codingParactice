############################################################
reverse a string in place i.e. without using extra memory.

a ^=b = = a XOR b  = 
a = a^b
b ^= a (a^b) b^a ^ b^b = b^a
a^=b (a^b)^(b^a)  = (a^b) ^ b^b a^a ^ b^a (b^=a) b=a

    public static String reverseString(char[] str){
        try{
            for(int i=0,j=str.length-1;i<str.length/2;i++,j--){
                // swap ith to jth element
                // str[i]=(char)((int)str[i] + (int)str[j]);
                // str[j]=(char)((int)str[i] - (int)str[j]);
                // str[i]=(char)((int)str[i] - (int)str[j]);
                 // swap ith to jth element
                str[i] ^= str[j];
                System.out.println("@@@@@"+str[i]);
                str[j] ^= str[i];
                System.out.println("####"+str[j]);
                str[i] ^= str[j];
                System.out.println("$$$$"+str[i]);
            }
            return String.valueOf(str);
        }catch(Exception e){
             return e.getMessage();
        }
    }

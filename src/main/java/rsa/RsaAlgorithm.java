package rsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RsaAlgorithm {
    public static int modInverse(int a, int m){
        for(int i = 1; i < m; i++){
            if((a * i) % m == 1){
                return i;
            }
        }
        return -1;
    }
    
    public static int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static int modExp(int a, int b, int m){
        int result = 1;
        a = a % m;
        while(b > 0){
            if(b % 2 != 0){
                result = (result * a) % m;
            }
            b = b / 2;
            a = (a * a) % m;
        }
        return result;
    }
    public static void main(String[] args) {
        Random random = new Random();
        int p = 61, q = 53;
        int n = p * q;
        int pN = (p - 1) * (q - 1);
        int e = random.nextInt(2, pN);
        while(gcd(e, pN) != 1){
            e = random.nextInt(2, pN);
        }
        int d = modInverse(e, pN);
        if(d <= 1 || d >= pN){
            System.out.println("Key hasn't been created.");
            return;
        }
        String m = "-=+/*-!@#$%^&*><?;;;??{}[]\\||||";
        
        //Encode
        byte[] originalBytes = m.getBytes();
        
        List<Integer> encodedList = new ArrayList<>();
        for(byte b : originalBytes){
            encodedList.add(modExp(b & 0xFF, e, n));
        }
        
        //Decode
        List<Byte> decodedList = new ArrayList<>();
        for(int b : encodedList){
            decodedList.add((byte)modExp(b, d, n));
        }
        
        byte[] decodedBytes = new byte[decodedList.size()];
        for(int i = 0; i < decodedBytes.length; i++){
            decodedBytes[i] = decodedList.get(i);
        }
        String originalText = new String(decodedBytes);
        
        //Result
        System.out.print("\nOriginal text: ");
        for(byte b : originalBytes){
            System.out.print(b + " ");
        }
        System.out.print("\nEncoded text: ");
        for(int b : encodedList){
            System.out.print(b + " ");
        }
        System.out.print("\nDecoded text: ");
        for(byte b : decodedBytes){
            System.out.print(b + " ");
        }
        System.out.print("\nOriginal text: " + originalText);
    }
}

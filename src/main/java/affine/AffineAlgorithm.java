/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package affine;

import java.util.ArrayList;
import java.util.List;


public class AffineAlgorithm {
    public static int modInverse(int a, int m){
        for(int i = 1; i < m; i++){
            if((a * i) % m == 1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int a = 7, b = 7;
        int n = 61 * 53;
        String m = "Chào các bạn.";
        int ax = modInverse(a, n);
        //Encode
        byte[] originalBytes = m.getBytes();
        List<Integer> encodedList = new ArrayList<>();
        for(byte x : originalBytes){
            encodedList.add((a * (x & 0xFF) + b) % n);
        }
        //Decode
        List<Byte> decodedList = new ArrayList<>();
        for(int y : encodedList){
            int x = (ax * ((y - b) % n)) % n;
            decodedList.add((byte)x);
        }
        byte[] decodedBytes = new byte[decodedList.size()];
        for(int i = 0; i < decodedBytes.length; i++){
            decodedBytes[i] = decodedList.get(i);
        }
        String originalText = new String(decodedBytes);
        //Result
        System.out.print("\nOriginal text: ");
        for(byte x : originalBytes){
            System.out.print(x + " ");
        }
        System.out.print("\nEncoded text: ");
        for(int x : encodedList){
            System.out.print(x + " ");
        }
        System.out.print("\nDecoded text: ");
        for(byte x : decodedBytes){
            System.out.print(x + " ");
        }
        System.out.println("\nOriginal text: " + originalText);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caeser;

import java.util.ArrayList;
import java.util.List;

public class CaeserAlgorithm {
    public static void main(String[] args) {
        int n = 53 * 61;
        int k = 15;
        String m = "Chào các bạn.";
        //Encode
        byte[] originalBytes = m.getBytes();
        List<Integer> encodedList = new ArrayList<>();
        for(byte b : originalBytes){
            encodedList.add(((b & 0xFF) + k) % n);
        }
        
        //Decode
        List<Byte> decodedList = new ArrayList<>();
        for(int b : encodedList){
            decodedList.add((byte)((b - k) % n));
        }
        
        byte[] decodedBytes = new byte[decodedList.size()];
        for(int i = 0; i < decodedBytes.length; i++){
            decodedBytes[i] = decodedList.get(i);
        }
        
        //Result
        String originalText = new String(decodedBytes);
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

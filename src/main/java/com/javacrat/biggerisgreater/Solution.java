package com.javacrat.biggerisgreater;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */
    public static String biggerIsGreater(String w) {
        // Write your code here
        char[] stringArray = w.toCharArray();
        String output = new String();
        boolean found = false;
        int position = 0;
        if (w.length() <=1 || !w.matches("[a-z]+")) return "";
        if(w.length() >= 1) {
            for(int i=w.length()-2; i>=0; i--) {
                char originalCharacter = w.charAt(i);
                for (int j = w.length() -1; j>i; j--) {
                    if (w.charAt(i) < w.charAt(j)) {
                        if (!found) {
                            found = true;
                            stringArray[i] = w.charAt(j);
                            stringArray[j] = w.charAt(i);
                        } else {
                            if (originalCharacter < w.charAt(j) && stringArray[i] > stringArray[j]) {
                                char temp = stringArray[j];
                                stringArray[j] = stringArray[i];
                                stringArray[i] = stringArray[j];
                            }
                        }
                    }
                }
                if (found) {
                    position = i;
                    break;
                }
            }
            String s = String.valueOf(stringArray);
            char[] a = s.substring(position + 1, w.length()).toCharArray();
            Arrays.sort(a);
            output = s.substring(0, position+1) + String.valueOf(a);
            if(found) return output;
            else return "no answer";
        }
        return "";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(Result.biggerIsGreater("100000"));
        System.out.println(Result.biggerIsGreater("zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgmw"));
        System.out.println(Result.biggerIsGreater("zyyxwwtrrnmlggfeb"));
        System.out.println(Result.biggerIsGreater("ocsmerkgidvddsazqxjbqlrrxcotrnfvtnlutlfcafdlwiismslaytqdbvlmcpapfbmzxmftrkkqvkpflxpezzapllerxyzlcf"));
        System.out.println(Result.biggerIsGreater("biehzcmjckznhwrfgglverxsezxuqpj"));
        System.out.println(Result.biggerIsGreater("rebjvsszebhehuojrkkhszxltyqfdvayusylgmgkdivzlpmmtvbsavxvydldmsym"));
        System.out.println(Result.biggerIsGreater("unpzhmbgrrs"));
        System.out.println(Result.biggerIsGreater("jprfovzkdlmdcesdcpdchcwoedjchcovklhrhlzfeeptoewcqpxg"));
        System.out.println(Result.biggerIsGreater("ywsfmynmiylcjgrfrrmtyeeykffzkuphpajndwxjteyjba"));
        System.out.println(Result.biggerIsGreater("dkuashjzsdq"));
        System.out.println(Result.biggerIsGreater("gwakhcpkolybihkmxyecrdhsvycjrljajlmlqgpcnmvvkjlkvdowzdfikh"));
        System.out.println(Result.biggerIsGreater("nebsajjbbuifimjpdcqfygeitief"));
        System.out.println(Result.biggerIsGreater("qetpicxagjkydehfnvfxrtigljlheulcsfidjjozbsnomygqbcmpffwswptbgkzrbgqwnczrcfynjmhebfbgseuhckbtuynvbo"));
        System.out.println(Result.biggerIsGreater("xuqfobndhsnsztifmqpnencxkllnpmbfqihtgdgxjhsvitlgtodhcydfb"));
        System.out.println(Result.biggerIsGreater("xqdwkjpkmrvkfnztozzlqtuxzxyxwowf"));
        System.out.println(Result.biggerIsGreater("yewluyxiwiprnajrtkeilolkmqidazhiar"));
        System.out.println(Result.biggerIsGreater("zzyyxxxxxwwwwwvvvvutttttsssssrrrrqqqppponnnnmmmmllkkjjjjiiggffffffeedddddbbbbbba"));
        System.out.println(Result.biggerIsGreater("hlvpzsfwnzsazeyaxaczkkrstiilkldupsqmzjnnsyoao"));
        System.out.println(Result.biggerIsGreater("zxvuutttrrrpoookiihhgggfdca"));
        System.out.println(Result.biggerIsGreater("zzyxxxxwwwvvuuuutsrrrrrqppppoooonnnnnnmmmlllllkkkjjjihgeeedddddcbaaa{-truncated-}"));
    }
}


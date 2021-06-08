package com.company;

public class MorseCodeDecoder {

    public static String decodeBits(String bits) {
        int count = 1;
        String morseCode = "";
        String normS = "";
        while (bits.charAt(count - 1) == bits.charAt(count)) {
            count++;
        }
        int a = count;
        for (int i = 0; i < bits.length(); i++) {
            if (a == count) {
                normS = normS + bits.charAt(i);
            }
            count--;
            if (count == 0) {
                count = a;
            }
        }
        for (int i = 0; i < normS.length(); i++) {
            if (normS.charAt(i) == '1' && i != normS.length() - 1 && normS.charAt(i + 1) == '1'
                        && i + 1 != normS.length() - 1 && normS.charAt(i + 2) == '1') {
                morseCode = morseCode + "-";
                i++;
                i++;
                i++;
            } else if (normS.charAt(i) == '1') {
                morseCode = morseCode + ".";
            } else if (normS.charAt(i) == '0' && i != normS.length() - 1 && normS.charAt(i + 1) == '0') {
                morseCode = morseCode + " ";
                i++;
            }
        }
        return morseCode;
    }

    public static String decodeMorse(String morseCode) {
        String mainS = "";
        String[] words;
        char[] vocabulary = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1',
                '2', '3', '4', '5', '6', '7', '8', '9', '0', ',', '.', '?', '!'};
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-",
                ".....", "-....", "--...", "---..", "----.", "-----", "--..--", ".-.-.-",
                "..--..", "−−..−−"};
        words = morseCode.split("   ");
        for (int i = 0; i < words.length; i++) {
            String[] vocab = words[i].split(" ");
            for (int j = 0; j < vocab.length; j++) {
                mainS = mainS + vocabulary[searchChar(morse, vocab[j])];
            }
            mainS = mainS + " ";
        }
        String str = "";
        for (int i = 0; i < mainS.length() - 1; i++) {
            str = str + mainS.charAt(i);
        }
        return str.toUpperCase();
    }

    private static int searchChar(String[] strings, String s) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(s)) {
                return i;
            }
        }
        return '!';
    }
}

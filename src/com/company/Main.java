package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(MorseCodeDecoder.decodeMorse(".... . -.--   .--- ..- -.. ."));
        System.out.println(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBits
                ("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011")));
                //···· · −·−−   ·−−− ··− −·· ·

    }
}

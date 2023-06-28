package current;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindrome125Test {

    @Test
    void shouldPassIsValidPalindrome1() {
        Assertions.assertTrue(ValidPalindrome125.isPalindrome(" "), () -> " ");
    }

    @Test
    void shouldPassIsValidPalindrom2() {
        Assertions.assertTrue(ValidPalindrome125.isPalindrome("racecar"), () -> "racecar");
    }

    @Test
    void shouldPassIsValidPalindrome3() {
        Assertions.assertTrue(ValidPalindrome125.isPalindrome("rac e car"), () -> "rac e car");
    }


    @Test
    void shouldPassIsValidPalindrome4() {
        Assertions.assertTrue(
                ValidPalindrome125.isPalindrome(
                        "A man, a plan, a canal: Panama"),
                () -> "A man, a plan, a canal: Panama");
    }

    @Test
    void shouldPassIsValidPalindrome5() {
        Assertions.assertTrue(ValidPalindrome125.isPalindrome("A"), () -> "A");
    }

    @Test
    void shouldPassIsValidPalindrome6() {
        Assertions.assertTrue(ValidPalindrome125.isPalindrome("aa"), () -> "aa");
    }

    @Test
    void shouldFailIsNotValidPalindrome1(){
        Assertions.assertFalse(ValidPalindrome125.isPalindrome(""), () -> "{EMPTY STRING} ie \"\"");
    }

    @Test
    void shouldFailIsNotValidPalindrome2(){
        Assertions.assertFalse(ValidPalindrome125.isPalindrome("pumpkin"), () -> "pumpkin");
    }

    @Test
    void shouldFailIsNotValidPalindrome3(){
        Assertions.assertFalse(ValidPalindrome125.isPalindrome("sa"), () -> "sa");
    }
}
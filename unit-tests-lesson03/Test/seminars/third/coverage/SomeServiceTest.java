package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SomeServiceTest {
    private SomeService someService;

    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }

    @Test
    void numTestFizz() {
        assertThat(someService.fizzBuzz(3)).isEqualTo("Fizz");
    }

    @Test
    void returnFizzBuzz() {
        assertThat(someService.fizzBuzz(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void returnTestBuzz() {
        assertThat(someService.fizzBuzz(5)).isEqualTo("Buzz");
    }

    @Test
    void returnTestFizzBuzz() {
        assertThat(someService.fizzBuzz(7)).isEqualTo("7");
    }

    @Test
    void firstSixElement(){
        assertTrue(someService.firstLast6(new int[]{6,1,2,3}));
    }
    @Test
    void LastSixElement(){
        assertTrue(someService.firstLast6(new int[]{1,2,3,6}));
    }
    @Test
    void firstLastNoSixElement(){
        assertFalse(someService.firstLast6(new int[]{1,2,3,4,5}));
    }

    @Test
    void LuckySumA(){
        assertThat(someService.luckySum(13, 2, 3)).isEqualTo(5);
    }
    @Test
    void LuckySumB(){
        assertThat(someService.luckySum(2, 13, 3)).isEqualTo(5);
    }
    @Test
    void LuckySumC(){
        assertThat(someService.luckySum(3, 2, 13)).isEqualTo(5);
    }
    @Test
    void LuckySumNot13(){
        assertThat(someService.luckySum(3, 2, 5)).isEqualTo(10);
    }





}
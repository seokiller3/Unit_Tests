package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TestDrivenDevelopment {

    /**
     * Нужно написать (TDD) класс MoodAnalyser, который оценивает фразы по настроению
     */


    private MoodAnalyser moodAnalyser;
    @BeforeEach
    void setUp(){
        moodAnalyser = new MoodAnalyser();
    }
    @Test
    void testMoodAnalysisIsHappy() {
        String str = "хорошее настроение";
        assertThat(moodAnalyser.analyze(str)).isEqualTo("happy");
    }
    @Test
    void testMoodAnalysisIsSad() {
        String str = "плохое настроение";
        assertThat(moodAnalyser.analyze(str)).isEqualTo("sad");
    }
    @Test
    void testMoodAnalysisIsSoSo() {
        String str = "нейтральное настроение";
        assertThat(moodAnalyser.analyze(str)).isEqualTo("So so");
    }

}
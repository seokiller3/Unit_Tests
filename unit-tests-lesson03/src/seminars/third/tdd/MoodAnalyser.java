package seminars.third.tdd;

public class MoodAnalyser {

    public String analyze(String str) {
        if (str.contains("хорошее")){
            return "happy";
        }
        if (str.contains("плох")){
            return "sad";
        }
        return "So so";
    }
}

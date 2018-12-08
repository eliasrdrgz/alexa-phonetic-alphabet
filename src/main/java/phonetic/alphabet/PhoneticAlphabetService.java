package phonetic.alphabet;

import java.util.stream.Stream;

public class PhoneticAlphabetService {
    
    public static String spell(String inputWord)
    {
        if (inputWord == null || inputWord.trim().length() == 0)
        {
            return "";
        }
        StringBuilder spellingString = new StringBuilder();
        Stream<Character> sch = inputWord.chars().mapToObj(i -> (char)i);
        sch.forEach(ch -> spellingString.append(PhoneticLetter.fromChar(ch)).append(" <break time=\"0.5s\"/>"));

        return spellingString.toString();
    }
}

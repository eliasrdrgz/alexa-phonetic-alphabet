package phonetic.alphabet;

import java.util.stream.Stream;

public class PhoneticAlphabetService {
    
    public static String spell(String inputWord)
    {
        StringBuilder spellingString = new StringBuilder();
        Stream<Character> sch = inputWord.chars().mapToObj(i -> (char)i);
        sch.forEach(ch -> spellingString.append(PhoneticLetter.fromChar(ch)).append(" "));

        return spellingString.toString();
    }
}

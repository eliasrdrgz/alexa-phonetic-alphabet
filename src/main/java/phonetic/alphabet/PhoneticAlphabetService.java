package phonetic.alphabet;

import java.text.Normalizer;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;


public class PhoneticAlphabetService {
    
    public static final String BREAK_TIME_0_5S = " <break time=\"0.5s\"/>";

    public static boolean specialCharacters(String inputWord)
    {
        return !Normalizer.isNormalized(inputWord, Normalizer.Form.NFKD);
    }

    public static String spell(String inputWord)
    {
        System.out.println("> [" + inputWord + "]");
        if (inputWord == null || inputWord.trim().length() == 0)
        {
            System.out.println("< []");
            return "";
        }
        StringBuilder spellingString = new StringBuilder();
        if (specialCharacters(inputWord))
        {
            //inputWord = Normalizer.normalize(inputWord, Normalizer.Form.NFD);
            inputWord = StringUtils.stripAccents(inputWord);
            System.out.println(">> [" + inputWord.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "") + "]");
        }
        Stream<Character> characterStream = inputWord.chars()
                .filter(i -> i != ' ' && i != '-' && i != '_' && i != '/')
            .mapToObj(i -> (char)i);
        characterStream.forEach(ch -> spellingString.append(PhoneticLetter.fromChar(ch)).append(BREAK_TIME_0_5S));

        String result = spellingString.toString();
        System.out.println("< [" + result + "]");
        return result;
    }
}

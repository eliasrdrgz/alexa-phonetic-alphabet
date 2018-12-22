package phonetic.alphabet;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Enum to implement letter to word map
 * <p>
 * Alfa, Bravo, Charlie, Delta, Echo, Foxtrot, Golf, Hotel, India, Juliett,
 * Kilo, Lima, Mike, November, Oscar, Papa, Quebec, Romeo, Sierra, Tango,
 * Uniform, Victor, Whiskey, X-ray, Yankee, Zulu
 * 
 * @see https://en.wikipedia.org/wiki/NATO_phonetic_alphabet
 */
public class PhoneticLetter
{
    private static final Map<Character, String> _Char2wordMap = Stream.of(new Object[][]{
        {'A', "Alpha"},
        {'B', "Bravo"},
        {'C', "Charlie"},
        {'D', "Delta"},
        {'E', "Echo"},
        {'F', "Foxtrot"},
        {'G', "Golf"},
        {'H', "Hotel"},
        {'I', "India"},
        {'J', "Juliett"},
        {'K', "Kilo"},
        {'L', "Lima"},
        {'M', "Mike"},
        {'N', "November"},
        {'O', "Oscar"},
        {'P', "Papa"},
        {'Q', "Quebec"},
        {'R', "Romeo"},
        {'S', "Sierra"},
        {'T', "Tango"},
        {'U', "Uniform"},
        {'V', "Victor"},
        {'W', "Whiskey"},
        {'X', "X-ray"},
        {'Y', "Yankee"},
        {'Z', "Zulu"} ,
        {'0', "Zero"},
        {'1', "One"},
        {'2', "Two"},
        {'3', "Three"},
        {'4', "Four"},
        {'5', "Five"},
        {'6', "Six"},
        {'7', "Seven"},
        {'8', "Eight"},
        {'9', "Nine"}}).collect(Collectors.toMap(data -> (Character)data[0], data -> (String) data[1]));
        
    public static String fromChar(Character ch)
    {
        // TODO: better filtering of supported characters
        Character upperCase = Character.toUpperCase(ch);
        if (!_Char2wordMap.containsKey(upperCase))
        {
            System.out.println(String.format("Unsupported character %c", ch));
        }
        return _Char2wordMap.get(Character.toUpperCase(ch));
    }
}
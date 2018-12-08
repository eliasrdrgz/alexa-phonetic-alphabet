package phonetic.alphabet;

import org.junit.Assert;

import org.junit.Test;

import phonetic.alphabet.PhoneticAlphabetService;

public class PhoneticTests
{
    @Test
    public void testSingleWord() throws Exception
    {
        String givenWord = "Alphabet";
        String whenServiceSpells = PhoneticAlphabetService.spell(givenWord);

        Assert.assertEquals("Unexpected spelling", 
            "Alpha Lima Papa Hotel Alpha Bravo Echo Tango ".replaceAll("\\s+","<break time=\"0.5s\"/>"), 
            whenServiceSpells);
    }

    @Test
    public void testNullWord() throws Exception
    {
        PhoneticAlphabetService.spell(null);
    }

    @Test
    public void testOnlyNumbersWord() throws Exception
    {
        String givenWord = "0-123456789";
        String whenServiceSpells = PhoneticAlphabetService.spell(givenWord);
        
        System.out.println(givenWord);
        System.out.println(whenServiceSpells);

        Assert.assertEquals("Unexpected spelling", 
            "Zero One Two Three Four Five Six Seven Eight Nine ".replaceAll("\\s+","<break time=\"0.5s\"/>"), 
            whenServiceSpells);
    }
}
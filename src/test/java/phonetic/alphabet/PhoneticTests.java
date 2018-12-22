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
        String expectedResult = "Alpha Lima Papa Hotel Alpha Bravo Echo Tango ".replaceAll("\\s+",PhoneticAlphabetService.BREAK_TIME_0_5S);
        spellTest(givenWord, expectedResult);
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
        String expectedResult = "Zero One Two Three Four Five Six Seven Eight Nine ".replaceAll("\\s+", PhoneticAlphabetService.BREAK_TIME_0_5S);
        spellTest(givenWord, expectedResult);
    }

    @Test
    public void testAccentWord() throws Exception
    {
        String givenWord = "á";
        String expectedResult = "Alpha"+PhoneticAlphabetService.BREAK_TIME_0_5S;
        
        spellTest(givenWord, expectedResult);
    }

	private void spellTest(String givenWord, String expectedResult) {
		String whenServiceSpells = PhoneticAlphabetService.spell(givenWord);
        
        Assert.assertEquals("Unexpected spelling",
                expectedResult,
                whenServiceSpells);
    }
}
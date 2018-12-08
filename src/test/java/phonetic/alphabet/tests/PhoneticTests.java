package phonetic.alphabet.tests;

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

        Assert.assertEquals("Unexpected spelling", "Alpha Lima Papa Hotel Alpha Bravo Echo Tango ", whenServiceSpells);
    }
}
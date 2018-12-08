package phonetic.alphabet.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import phonetic.alphabet.PhoneticAlphabetService;
import phonetic.alphabet.PhoneticAlphabetStreamHandler;

import java.util.Optional;

public class PhoneticAlphabetRequestHandler implements RequestHandler {
    private static final String WORD_KEY = "WORD";
    private static final String WORD_SLOT = "Word";

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("PhoneticAlphabetIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String inputWord = (String) input.getAttributesManager().getSessionAttributes().get(WORD_KEY);
        
        System.out.println("Word -> " + inputWord);
        String phoneticAlphabetSpelledWord = PhoneticAlphabetService.spell(inputWord);

        String speechText = String.format("La palabra %s deletreada según el alfabeto fonético es %s",
            inputWord, phoneticAlphabetSpelledWord);
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard(PhoneticAlphabetStreamHandler.SKILL_TITLE, speechText)
                .withShouldEndSession(true)
                .build();
    }
}

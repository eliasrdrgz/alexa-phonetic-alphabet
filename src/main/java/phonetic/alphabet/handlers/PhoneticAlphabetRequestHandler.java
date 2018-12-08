package phonetic.alphabet.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.request.Predicates;

import phonetic.alphabet.PhoneticAlphabetService;
import phonetic.alphabet.PhoneticAlphabetStreamHandler;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class PhoneticAlphabetRequestHandler implements RequestHandler {
    private static final String WORD_KEY = "WORD";
    private static final String WORD_SLOT = "word";

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("PhoneticAlphabetIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        // Get the color slot from user input.
        Slot wordSlot = slots.get(WORD_SLOT);
        String speechText, repromptText;

        if (wordSlot != null)
        {
            String word = wordSlot.getValue();
            input.getAttributesManager().setSessionAttributes(Collections.singletonMap(WORD_KEY, word));
            speechText = String.format("La palabra %s deletreada según el alfabeto fonético es %s",
                word, PhoneticAlphabetService.spell(word));
            repromptText = "Puedes preguntarme por palabras para que sean deletreadas según el alfabeto fonético";
        }
        else
        {
            // word slot not found
            speechText = "Vaya, no te he entendido.  Por favor, dime una palabra para deletrear diciendo 'deletrea fonéticamente la palabra fonética'";
            repromptText = "No sé muy bien qué palabra deletrear.  Inténtalo de nuevo diciendo 'deletrea fonéticamente la palabra alfabeto'";
        }

        return input.getResponseBuilder()
                .withReprompt(repromptText)
                .withSpeech(speechText)
                .withSimpleCard(PhoneticAlphabetStreamHandler.SKILL_TITLE, speechText)
                .withShouldEndSession(true)
                .build();
    }
}

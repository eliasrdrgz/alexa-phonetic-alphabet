package phonetic.alphabet.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import phonetic.alphabet.PhoneticAlphabetStreamHandler;

import java.util.Optional;

public class HelpIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.HelpIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Puedo deletrear fonéticamente la palabra que me digas";

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard(PhoneticAlphabetStreamHandler.SKILL_TITLE, speechText)
                .withReprompt(speechText)
                .build();
    }
}

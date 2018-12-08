package phonetic.alphabet.handlers;

import static com.amazon.ask.request.Predicates.requestType;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import phonetic.alphabet.PhoneticAlphabetStreamHandler;

import java.util.Optional;


public class LaunchRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Bienvenido a \"Alfabeto fonético\". Me puedes pedir que deletree fonéticamente una palabra.";
        return input.getResponseBuilder()
                .withSimpleCard(PhoneticAlphabetStreamHandler.SKILL_TITLE, speechText)
                .withSpeech(speechText)
                .withReprompt(speechText)
                .build();
    }
}

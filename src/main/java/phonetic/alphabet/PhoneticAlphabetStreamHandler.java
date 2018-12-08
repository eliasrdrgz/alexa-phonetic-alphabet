package phonetic.alphabet;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import phonetic.alphabet.handlers.CancelandStopIntentHandler;
import phonetic.alphabet.handlers.HelpIntentHandler;
import phonetic.alphabet.handlers.LaunchRequestHandler;
import phonetic.alphabet.handlers.PhoneticAlphabetRequestHandler;
import phonetic.alphabet.handlers.SessionEndedRequestHandler;

public class PhoneticAlphabetStreamHandler extends SkillStreamHandler {

    public static final String SKILL_TITLE = "Phonetic Alphabet";

    private static Skill getSkill() {
        return Skills
                .standard()
                .addRequestHandlers(
                        new LaunchRequestHandler(),
                        new CancelandStopIntentHandler(),
                        new SessionEndedRequestHandler(),
                        new HelpIntentHandler(),
                        new PhoneticAlphabetRequestHandler()
                )
                .build();
    }

    public PhoneticAlphabetStreamHandler() {
        super(getSkill());
    }
}

package org.sid.comptemanagement.util;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

import java.time.Instant;
import java.util.Random;
import java.util.UUID;

public class Util {

    public static String generateUniqueString() {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .filteredBy(CharacterPredicates.DIGITS, CharacterPredicates.LETTERS)
                .build();

        return generator.generate(8);
    }

}

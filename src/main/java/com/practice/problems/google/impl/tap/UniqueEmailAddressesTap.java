package com.practice.problems.google.impl.tap;

import com.practice.problems.google.UniqueEmailAddresses;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddressesTap extends UniqueEmailAddresses {

    @Override
    protected int countUniqueEmailAddresses(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            StringBuilder address = new StringBuilder();
            for (int i = 0; i < email.length(); i++) {
                char ch = email.charAt(i);

                if (ch == '.') continue;
                else if (ch == '+') {
                    while (email.charAt(i) != '@') i++;

                    address.append(email.substring(i));
                    break;
                } else if (ch == '@') {
                    address.append(email.substring(i));
                    break;
                } else address.append(ch);
            }

            uniqueEmails.add(address.toString());
        }

        return uniqueEmails.size();
    }
}

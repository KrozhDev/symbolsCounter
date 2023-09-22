package ru.t1consulting.test_task.service;

import org.springframework.stereotype.Service;
import ru.t1consulting.test_task.entity.Counter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CounterService {

    public String getStringCounting(String stringToCount) {

        Map<String, Integer> frequency = getFrequencyMap(stringToCount);

        List<Counter> counters = getCountersList(frequency);

        return makePrettyString(counters);
    }

    /**
     * Method for getting letters with frequency from Map, converting into Counter, sorting and putting into List
     * @param frequency - empty map
     * @return list with Counter objects
     */
    private List<Counter> getCountersList(Map<String, Integer> frequency) {
        List<Counter> counters = new ArrayList<>();
        for (String key : frequency.keySet()) {
            counters.add(new Counter(key, frequency.get(key)));
        }
        counters = counters.stream()
                .sorted(Comparator.comparing(Counter::getAmount).reversed())
                .collect(Collectors.toList());
        return counters;
    }

    /**
     * Method for simple counting amount of each word
     * key is a word
     * value - is an amount
     * @param stringToCount is string from Controller
     * @return frequency map
     */
    private Map<String, Integer> getFrequencyMap(String stringToCount) {
        Map<String, Integer> frequency = new HashMap<>();
        for (String i : List.of(stringToCount.trim().toLowerCase(Locale.ROOT).split(""))) {
            if (!" ".equals(i))
                frequency.compute(i, (k, v) -> (v == null) ? 1 : v + 1);
        }
        return frequency;
    }

    /**
     * Method for outputting a beautiful string according to instructions
     * @param counters - empty list for Counter objects
     * @return "b": 2, "a": 1
     */
    private String makePrettyString(List<Counter> counters) {
        StringBuilder sb = new StringBuilder();

        for (Counter c : counters) {
            sb.append(c.toString());
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

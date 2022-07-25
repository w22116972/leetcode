package design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AnalyzeUserWebsiteVisitPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        final LinkedList<String> result = new LinkedList<>();

        // 1. Group visits by user
        final HashMap<String, List<WebsiteByTimestamp>> websiteByTimestampPerUser = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            if (websiteByTimestampPerUser.containsKey(username[i])) {
                websiteByTimestampPerUser.get(username[i]).add(new WebsiteByTimestamp(timestamp[i], website[i]));
            } else {
                websiteByTimestampPerUser.put(username[i], List.of(new WebsiteByTimestamp(timestamp[i], website[i])));
            }
        }
        // 2. Generate permutation by user


        // 3. Merge permutations into final list and count frequencies

        // 4. Select most frequent

        return result;
    }

    static class WebsiteByTimestamp {
        Integer timestamp;
        String website;

        public WebsiteByTimestamp(Integer timestamp, String website) {
            this.timestamp = timestamp;
            this.website = website;
        }
    }
}

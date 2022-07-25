package design;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class WebCrawlerMultithreaded {
    HashSet<String> visitedUrls = new HashSet<>();
    Queue<String> willVisitUrls = new LinkedList<>();
    List<String> result = new LinkedList<>();

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        willVisitUrls.offer(startUrl);
        while (!willVisitUrls.isEmpty()) {
            String visitingUrl = willVisitUrls.poll();

            if (!visitedUrls.contains(visitingUrl) && visitingUrl.split("/")[2].equals(startUrl.split("/")[2])) {
                result.add(visitingUrl);
            }
            visitedUrls.add(visitingUrl);
            final List<String> nextUrls = htmlParser.getUrls(visitingUrl).stream()
                    .filter(url -> !visitedUrls.contains(url))
                    .filter(url -> url.split("/")[2].equals(startUrl.split("/")[2]))
                    .collect(Collectors.toList());
            willVisitUrls.addAll(nextUrls);
        }

        return result;
    }
}

interface HtmlParser {
    List<String> getUrls(String url);
}

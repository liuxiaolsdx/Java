package info.liuxiao.crawler.parser;

import info.liuxiao.crawler.frontier.OutUrlQueues;
import info.liuxiao.crawler.frontier.WaitingUrlQueues;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * 从当前页面提取url
 * Created by Sean on 16/2/25.
 */
public class UrlParser {
    public void getUrl(String url, String content, Boolean isVerticalCrawler) {
        if (url == null || content == null || url.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }

        Document doc = Jsoup.parse(content, url);
        Elements links = doc.getElementsByTag("a");

        //垂直爬虫:只获取本站的url
        if (!links.isEmpty() && isVerticalCrawler) {
            links.forEach((l) -> {
                String absUrl = l.absUrl("href");//获得完整连接
                if (!OutUrlQueues.contains(absUrl) && absUrl.startsWith(url)) {
                    WaitingUrlQueues.add(absUrl);
                }
            });
        } else if (!links.isEmpty() && !isVerticalCrawler) {
            links.forEach((l) -> {
                String absUrl = l.absUrl("href");
                if (!OutUrlQueues.contains(absUrl) && absUrl.startsWith("http")) {
                    WaitingUrlQueues.add(absUrl);
                }
            });
        }

    }
}

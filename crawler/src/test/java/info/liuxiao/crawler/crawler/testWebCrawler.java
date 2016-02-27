package info.liuxiao.crawler.crawler;

/**
 * test crawler
 * Created by Sean on 16/2/27.
 */
public class testWebCrawler {
    public static void main(String[] args) {
        String url = "http://liuxiao.info";
        Boolean isVerticalCrawler = true;
        String storageFolder = "/Users/Sean/app_logs/";

        Thread t = new Thread(new WebCrawler(url, storageFolder, isVerticalCrawler));
        t.start();
    }
}

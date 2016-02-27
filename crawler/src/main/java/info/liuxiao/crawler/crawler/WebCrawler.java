package info.liuxiao.crawler.crawler;

import info.liuxiao.crawler.fetcher.PageFetchResult;
import info.liuxiao.crawler.fetcher.PageFetcher;
import info.liuxiao.crawler.frontier.WaitingUrlQueues;
import info.liuxiao.crawler.parser.UrlParser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * WebCrawler class in the Runnable class that is executed by each crawler thread.
 * Created by Sean on 16/2/26.
 */
public class WebCrawler implements Runnable{

    private String url;//初始url
    private String storageFolder;//存放爬取下来的内容的文件夹路径
    private boolean isVerticalCrawler;//是否是垂直爬虫

    public WebCrawler(String url, String storageFolder, Boolean isVerticalCrawler) {
        this.url = url;
        WaitingUrlQueues.add(url);
        this.storageFolder = storageFolder;
        this.isVerticalCrawler = isVerticalCrawler;
    }

    public void run() {
        while (!WaitingUrlQueues.isEmpty()) {
            //get an url from waiting url queues
            String focusUrl = WaitingUrlQueues.poll();

            //fetch page by url
            PageFetcher pageFetcher = new PageFetcher();
            PageFetchResult result = pageFetcher.fetchPage(focusUrl);

            //get url from page and store into url queues
            UrlParser.getUrl(result.getUrl(),result.getContent(),isVerticalCrawler);

            //store page to computer
            this.downloadPage(result);
        }
    }

    private void downloadPage(PageFetchResult result) {
        String[] urlName = url.split("/");
        String fileName = urlName[urlName.length - 1] + ".html";
        File storageFolder = new File(this.storageFolder);

        if (!storageFolder.exists()) {
            if (storageFolder.mkdirs()) {
                System.out.println(storageFolder.getAbsolutePath());
            } else {
                throw new RuntimeException(
                        "couldn't create the storage folder: " + storageFolder.getAbsolutePath() + " does it already exist ?");
            }
        }

        File storageFile = new File(storageFolder + File.separator + fileName);

        if (!storageFile.exists()) {
            try {
                if (storageFile.createNewFile()) {
                    System.out.println(storageFile.getAbsolutePath());
                } else {
                    throw new RuntimeException(
                            "couldn't create the storage file: " + storageFile.getAbsolutePath() + " does it already exist ?");
                }
            } catch (IOException e) {
                System.out.println(storageFile.getAbsolutePath());
                e.printStackTrace();
            }
       }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(storageFile.getAbsolutePath()));
            bw.write(result.getContent());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

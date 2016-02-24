package info.liuxiao.crawler.fetcher;

/**
 * 保存抓取的内容,url,content
 * Created by Sean on 16/2/24.
 */
public class PageFetchResult {

    private String url = null;
    private String content = null;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

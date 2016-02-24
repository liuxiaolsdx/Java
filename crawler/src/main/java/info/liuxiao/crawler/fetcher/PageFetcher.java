package info.liuxiao.crawler.fetcher;

import info.liuxiao.crawler.frontier.OutUrlQueues;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 传进来一个url,抓取该页面的内容,存入PageFetchResult.
 * Created by Sean on 16/2/24.
 */
public class PageFetcher {
    private CloseableHttpClient client = null;

    public PageFetchResult fetchPage(String url) {
        if (url == null) {
            return null;
        }
        PageFetchResult result = new PageFetchResult();
        //create a HttpClient
        client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();

            OutUrlQueues.add(url);//已遍历的url加入已访问的url队列

            if (entity != null) {
                result.setUrl(url);
                result.setContent(EntityUtils.toString(entity, "utf-8"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}

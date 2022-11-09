import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.never.left.NeverLeftApplication;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author dong.zhang
 * @description
 * @date 2022/11/8 22:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = NeverLeftApplication.class)
public class MyTest {

    @Test
    public void test() {
        queryDocument("北斗");
    }

    public static void main(String[] args) {
        queryDocument("北斗");
    }
    public static void queryDocument(String documentName){
        WebClient browser = new WebClient();
        browser.getOptions().setCssEnabled(false);
        browser.getOptions().setJavaScriptEnabled(true);
        browser.getOptions().setThrowExceptionOnScriptError(false);
        String url = "https://www.yad.com";
        try {
            HtmlPage htmlPage = browser.getPage(url);
            browser.waitForBackgroundJavaScript(3000);
            Document document = Jsoup.parse(htmlPage.asXml());
            Element paper = document.getElementById("paper");
            System.out.println(paper);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

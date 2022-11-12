package com.never.left.utils;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author dong.zhang
 * @description
 * @date 2022/11/10 22:10
 */
public class HtmlUtils {

    public static Document queryDocument(String url){
        WebClient browser = new WebClient();
        browser.getOptions().setCssEnabled(false);
        browser.getOptions().setJavaScriptEnabled(true);
        browser.getOptions().setThrowExceptionOnScriptError(false);
        try {
            HtmlPage htmlPage = browser.getPage(url);
            browser.waitForBackgroundJavaScript(3000);

            return Jsoup.parse(htmlPage.asXml());
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            browser.close();
        }
        return null;
    }
}

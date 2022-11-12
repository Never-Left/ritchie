package yy.com.yad;

import com.alibaba.excel.EasyExcel;
import com.never.left.NeverLeftApplication;
import com.never.left.utils.HtmlUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import yy.com.kyfungame.KyfungameInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dong.zhang
 * @description
 * @date 2022/11/9 1:22
 */
@NoArgsConstructor
@Data
@RunWith(SpringRunner.class)
@SpringBootTest(classes = NeverLeftApplication.class)
public class YadTest {



    @Test
    public void test(){
        List<YadInfo> games = new ArrayList<>();
        String yadUrl = "https://www.yad.com/";
        Document yad = HtmlUtils.queryDocument(yadUrl);
        Elements thumbs = yad.getElementsByClass("thumb");
        for (Element thumb : thumbs) {
            String gameName = thumb.getElementsByClass("GameName").html();
            String gameUrl = yadUrl+gameName.replaceAll(" ","-");
            YadInfo game = new YadInfo();
            game.setTitle(gameName);
            game.setUrl(gameUrl);
            System.out.printf(gameUrl+"______");
            Document gameDocument = HtmlUtils.queryDocument(gameUrl);
            if (gameDocument!=null){
                // 描述
                String gameDesc = gameDocument.getElementsByClass("game_content_left_desc").html();
                if (StringUtils.isNoneBlank(gameDesc)){
                    String desc = gameDesc.substring(0, gameDesc.indexOf("<a"));
                    game.setIntro(desc);
                    games.add(game);
                }
                // icon
                Element clickToPlayHref = gameDocument.getElementById("ClickToPlayHref");
                if (clickToPlayHref!=null){
                    Elements clickToPlayHrefChild = clickToPlayHref.children();
                    if (CollectionUtils.isNotEmpty(clickToPlayHrefChild)){
                        String imgUrl = clickToPlayHrefChild.get(0).attributes().get("src");
                        imgUrl= imgUrl.replaceFirst("/","");
                        game.setIcon(yadUrl+imgUrl);
                    }
                }

                games.add(game);
            }

        }
        String fileName = "D:\\yad.xlsx";
        EasyExcel.write(fileName, YadInfo.class).sheet("yad网站游戏信息").doWrite(games);

//        String fileName = "D:\\kyfungame.xlsx";
//        EasyExcel.write(fileName, GameInfo.class).sheet("kyfungame网站游戏信息").doWrite(games);

    }

}

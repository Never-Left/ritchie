package yy.com.kyfungame;

import com.alibaba.excel.EasyExcel;
import com.never.left.NeverLeftApplication;
import com.never.left.utils.HttpUtils;
import com.never.left.utils.ResultVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class KyfungameTest {



    @Test
    public void test(){
        ResultVo<KyfungameVo> resultVo = HttpUtils.get("https://api.kyfungame.com/index/api/v1/index/getGameList?cate_name=home&page=1&limit=9999999&client_type=p&client_version=v1", null, KyfungameVo.class);
        System.out.println(resultVo);
        List<KyfungameInfo> games = resultVo.getData().getGames();


//        String fileName = "D:\\kyfungame.xlsx";
//        EasyExcel.write(fileName, KyfungameInfo.class).sheet("kyfungame网站游戏信息").doWrite(games);

        String template =
                "<div class=\"col-lg-3 col-sm-6\">\n" +
                "    <div class=\"item\" onclick = \"window.open('%s,_self')\">\n" +
                "        <img src=\"%s\" alt=\"\">\n" +
                "        <h4>%s<br><span>%s</span></h4>\n" +
                "        <ul>\n" +
                "            <li><i class=\"fa fa-star\"></i>%s</li>\n" +
                "            <li><i class=\"fa fa-download\"></i>%s</li>\n" +
                "        </ul>\n" +
                "    </div>\n" +
                "</div>";
        List<String> htmlList = new ArrayList<>();
        for (KyfungameInfo game : games) {
            String tags = game.getTags().replaceAll("\\[", "");
            tags= tags.replaceAll("\\]","");
            String html = String.format(template, game.getUrl(),game.getIcon(),game.getTitle(),tags,game.getPlayers(),game.getLikeNum());
//            htmlList.add(html);
            System.out.println(html);
        }

    }

}

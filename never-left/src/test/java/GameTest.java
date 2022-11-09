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
public class GameTest {



    @Test
    public void test(){
        ResultVo<KyfungameVo> resultVo = HttpUtils.get("https://api.kyfungame.com/index/api/v1/index/getGameList?cate_name=home&page=1&limit=9999999&client_type=p&client_version=v1", null, KyfungameVo.class);
        System.out.println(resultVo);
        List<GameInfo> games = resultVo.getData().getGames();


        String fileName = "D:\\kyfungame.xlsx";
        EasyExcel.write(fileName, GameInfo.class).sheet("kyfungame网站游戏信息").doWrite(games);

    }

}

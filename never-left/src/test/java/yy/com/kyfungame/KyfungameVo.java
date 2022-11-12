package yy.com.kyfungame;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author dong.zhang
 * @description
 * @date 2022/11/9 1:45
 */
@Data
public class KyfungameVo {
    @JsonProperty("games")
    private List<KyfungameInfo> games;
}

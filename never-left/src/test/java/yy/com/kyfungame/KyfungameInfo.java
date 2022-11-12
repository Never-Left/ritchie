package yy.com.kyfungame;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author dong.zhang
 * @description
 * @date 2022/11/9 1:34
 */

/**
 * appid
 */
@Data
public class KyfungameInfo {

    /**
     * appid
     */
    @JsonProperty("appid")
    private String appid;


    /**
     * 标题
     */
    @JsonProperty("title")
    private String title;

    /**
     * 图标
     */
    @JsonProperty("icon")
    private String icon;

    /**
     * appid
     */
    @JsonProperty("icon_bg_color")
    private String iconBgColor;

    /**
     * appid
     */
    @JsonProperty("like_num")
    private Integer likeNum;

    /**
     * appid
     */
    @JsonProperty("dislike_num")
    private Integer dislikeNum;

    /**
     * appid
     */
    @JsonProperty("players")
    private Integer players;

    /**
     * appid
     */
    @JsonProperty("ratings")
    private Integer ratings;

    /**
     * appid
     */
    @JsonProperty("intro")
    private String intro;

    /**
     * appid
     */
    @JsonProperty("url")
    private String url;

    /**
     * appid
     */
    @JsonProperty("tags")
    private String tags;

    public void setTags(List<String> tags) {
        this.tags = tags.toString();
    }

    /**
     * appid
     */
    @JsonProperty("is_hot")
    private Integer isHot;

    /**
     * appid
     */
    @JsonProperty("is_new")
    private Integer isNew;

    /**
     * appid
     */
    @JsonProperty("manifest")
    private String manifest;

    /**
     * appid
     */
    @JsonProperty("orientation")
    private Integer orientation;

    /**
     * appid
     */
    @JsonProperty("url_video")
    private String urlVideo;
}

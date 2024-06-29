package com.walnutek.healthcareapi.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 貼文
 *
 * @author Walnutek-Xunhaoz
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("`post`")
public class Post extends BaseColumns {

    /**
     * 貼文標題
     */
    private String title;

    /**
     * 貼文內容
     */
    private String content;
}

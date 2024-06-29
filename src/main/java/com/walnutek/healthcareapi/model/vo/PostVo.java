package com.walnutek.healthcareapi.model.vo;

import com.walnutek.healthcareapi.model.entity.BaseColumns;
import com.walnutek.healthcareapi.model.entity.Post;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Schema(title = "貼文VO")
@Data
@EqualsAndHashCode(callSuper = false)
public class PostVo extends BaseColumns {

    @Schema(title = "貼文標題", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @Schema(title = "貼文內容", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;

    public Post toPost() {
        var data = new Post();

        data.setTitle(title);
        data.setContent(content);

        syncBaseColumns(this, data);

        return data;
    }
}

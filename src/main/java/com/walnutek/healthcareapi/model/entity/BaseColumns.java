package com.walnutek.healthcareapi.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Extending this class to have below fields and use system auto update mechanism to deal with it
 *
 * if you use @Data , please add @EqualsAndHashCode(callSuper = false) for dismiss the warning
 * @author Walnutek-Sam
 *
 */
@Data
public class BaseColumns {
    /**
     * PK
     */
    @Schema(title = "主鍵", description = "primary key", accessMode = Schema.AccessMode.READ_ONLY)
    @TableId(type = IdType.AUTO)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    /**
     * 新增資料時間
     */
    @Schema(title = "新增資料時間", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    @TableField(fill = FieldFill.INSERT)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime createTime = LocalDateTime.now();


    /**
     * 更新資料時間
     */
    @Schema(title = "更新資料時間", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    @TableField(fill = FieldFill.UPDATE, select = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime updateTime;

    public static <S extends BaseColumns, T extends BaseColumns> void syncBaseColumns(S source, T target) {
        target.setId(source.getId());
        target.setCreateTime(source.getCreateTime());
        target.setUpdateTime(source.getUpdateTime());
    }
}

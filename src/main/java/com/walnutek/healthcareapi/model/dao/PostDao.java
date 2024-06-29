package com.walnutek.healthcareapi.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.walnutek.healthcareapi.model.entity.Post;
import com.walnutek.healthcareapi.model.vo.PostVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostDao extends BaseMapper<Post> {
    PostVo getDetail(@Param("id") Integer id);
}

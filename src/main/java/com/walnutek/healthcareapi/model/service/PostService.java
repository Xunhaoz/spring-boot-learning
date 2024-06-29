package com.walnutek.healthcareapi.model.service;

import com.walnutek.healthcareapi.exception.AppException;
import com.walnutek.healthcareapi.exception.AppException.Code;
import com.walnutek.healthcareapi.model.dao.PostDao;
import com.walnutek.healthcareapi.model.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PostService extends BaseService {

    @Autowired
    private PostDao postDao;

    public PostVo getDetail(Integer id) {
        return Optional.ofNullable(postDao.getDetail(id)).orElseThrow(() -> new AppException(Code.E004));
    }

    public void post(PostVo postVo) {
        postDao.insert(postVo.toPost());
    }

    public void put(Integer id, PostVo postVo) {
        var data = postDao.selectById(id);
        data.setTitle(postVo.getTitle());
        data.setContent(postVo.getContent());
        postDao.updateById(data);
    }

    public void delete(Integer id) {
        postDao.deleteById(id);
    }
}

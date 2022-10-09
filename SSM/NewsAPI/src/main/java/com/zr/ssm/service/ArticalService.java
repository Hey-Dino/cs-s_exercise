package com.zr.ssm.service;

import com.zr.ssm.pojo.Artical;

import java.util.List;

public interface ArticalService {

    Boolean addArtical(Artical artical);

    List<Object> getArtical(Integer pagenum, Integer pagesize, Integer cate_id, String state);

    Boolean deleteArtical(Integer id);

    Artical getOneArtical(Integer id);
}

package com.zr.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zr.ssm.mapper.ArticalMapper;
import com.zr.ssm.pojo.Artical;
import com.zr.ssm.service.ArticalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ArticalServiceImpl implements ArticalService {

    ArticalMapper articalMapper;

    @Override
    public Boolean addArtical(Artical artical) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        artical.setPub_date(format.format(new Date()));
        int i = articalMapper.insert(artical);
        return i == 1? true : false;
    }

   /*
       1、设置分页信息：
           获取第1页，10条内容，默认查询总数count
           PageHelper.startPage(1, 10);
           紧跟着的第一个select方法会被分页
           List<Country> list = countryMapper.selectIf(1);
       2、取分页信息
           分页后，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>，
           Page<Country> listCountry = (Page<Country>)list;
           listCountry.getTotal();
       3、取分页信息的第二种方法
           获取第1页，10条内容，默认查询总数count
           PageHelper.startPage(1, 10);
           List<Country> list = countryMapper.selectAll();
           用PageInfo对结果进行包装
           PageInfo page = new PageInfo(list);
           测试PageInfo全部属性
           PageInfo包含了非常全面的分页属性
   */

    @Override
    public List<Object> getArtical(Integer pagenum, Integer pagesize, Integer cate_id, String state) {
        PageHelper.startPage(pagenum, pagesize);

        List<Artical> articals = articalMapper.selectAll(cate_id, state);

        // 用PageInfo对结果进行包装
        PageInfo page = new PageInfo(articals);
        // 获取总数
        Integer total = (int) page.getTotal();
        List<Object> data = new ArrayList<Object>();
        data.add(articals);
        data.add(total);

        return data;
    }

    @Override
    public Boolean deleteArtical(Integer id) {
        int i = articalMapper.deletById(id);
        return i == 1? true :false;
    }

    @Override
    public Artical getOneArtical(Integer id) {
        Artical artical = articalMapper.selectById(id);
        return artical != null ? artical : null;
    }

    @Override
    public Boolean updateArtical(Artical artical) {
        // 获取影响行数
        int influenceLine = articalMapper.updateArtical(artical);

        return influenceLine == 1 ? true : false;
    }
}

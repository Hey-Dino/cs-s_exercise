package com.zr.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artical {
    Integer id;
    String title;
    String content;
    String cover_img;
    String pub_date;
    String state;
    Boolean is_delete;
    Integer cate_id;
    Integer author_id;
    String cate_name;

    public Artical(String title, Integer cate_id, String content, String state){
        this.title = title;
        this.cate_id = cate_id;
        this.content = content;
        this.state = state;
    }

}

package com.zr.ssm.pojo;

import org.apache.ibatis.jdbc.SQL;

public class ArticalSql {
        /**
         * 动态sql的 sql 语句的拼接
         * @param : 接口的输入参数
         * @return: 就一个 sql语句
         */
        public String getDynamicSql(final Integer cate_id, final String state) {
            // 匿名内部类
            SQL sql = new SQL() {
                {
                    SELECT("eva.id, eva.title, eva.pub_date, eva.state, evc.name AS cate_name");
                    FROM("ev_articles eva, ev_article_cate evc");
                    WHERE("eva.cate_id = evc.id");
                    if (cate_id != null) {
                        WHERE("eva.cate_id = " + cate_id);
                    }
                    if (state != null && !(state.isEmpty())) {
                        WHERE("eva.state = " + state);
                    }
                }
            };

            // 将 sql 对象 变成 sql语句
            return sql.toString();
        }
}
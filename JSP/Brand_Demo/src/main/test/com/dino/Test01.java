package com.dino;

import com.dino.pojo.Brand;
import com.dino.service.BrandService;
import org.junit.Test;

import java.util.List;

public class Test01 {
    @Test
    public void testBrandService() {
        BrandService brandService = new BrandService();

        // 测试查询服务
        List<Brand> brands = brandService.selectAll();
        System.out.println("Select All:" + brands);

        // 测试添加服务
        /*Brand brand = new Brand(12, "创维", "创维集团有限公司", 100, "凝聚健康科技", 1);
        brandService.addBrand(brand);*/

        // 测试删除服务
        brandService.delById(10);
    }
}

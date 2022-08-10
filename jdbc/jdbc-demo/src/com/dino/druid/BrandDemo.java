package com.dino.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.dino.pojo.Brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class BrandDemo {
    public static void main(String[] args) throws Exception {
        // 插入
        Brand dji = new Brand("大疆创新", "深圳市大疆创新科技有限公司", 40, "The Future of Possible", 1);
        // addBrand(dji);

        // 查询所有数据
        List<Brand> brands = queryAll();

        // 获取需要修改的对象
        Brand tempBrand = brands.stream().filter(brand -> brand.getBrandName().equals("华为")).collect(Collectors.toList()).get(0);
        tempBrand.setDescription("构建万物互联的智能世界");
        updateBrand(tempBrand.getId(), tempBrand);

        // 删除数据
        int delId = brands.stream().filter(brand -> brand.getBrandName().equals("三只松鼠")).collect(Collectors.toList()).get(0).getId();
        deleteBrandById(delId);
    }

    public static List<Brand> queryAll() throws Exception {
        // 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/com/dino/druid.properties"));

        // 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 获取连接对象
        Connection conn = dataSource.getConnection();

        // 定义SQL语句
        String sql = "SELECT * FROM brand";

        // SQL语句执行对象
        PreparedStatement ps = conn.prepareStatement(sql);  // 无需设置参数

        // 执行SQL语句
        ResultSet rs = ps.executeQuery();

        List<Brand> list = new ArrayList<>();
        // 遍历获取到的对象
        while (rs.next()) {
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");

            list.add(new Brand(id, brandName, companyName, ordered, description, status));
        }
        System.out.println(list);

        // 释放资源
        rs.close();
        ps.close();
        conn.close();

        return list;
    }

    public static void addBrand(Brand brand) throws Exception {
        // 1.加载配置资源
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/com/dino/druid.properties"));

        // 2.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 3.获取数据库连接对象
        Connection conn = dataSource.getConnection();

        // 4.定义SQL
        String sql = "INSERT INTO brand(brand_name, company_name, ordered, description, status) VALUES(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, brand.getBrandName());
        ps.setString(2, brand.getCompanyName());
        ps.setInt(3, brand.getOrdered());
        ps.setString(4, brand.getDescription());
        ps.setInt(5, brand.getStatus());

        // 5.执行SQL
        int count = ps.executeUpdate();

        // 6.输出执行结果
        System.out.println("插入结果：" + count);

        // 7.释放资源
        ps.close();
        conn.close();
    }

    public static void updateBrand(int id, Brand brand) throws Exception {
        // 定义配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/com/dino/druid.properties"));
        // 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        // 从连接池中获取连接对象
        Connection conn = dataSource.getConnection();
        // 定义SQL语句
        String sql = "UPDATE brand SET brand_name=?, company_name=?, ordered=?, description=?, status=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, brand.getBrandName());
        ps.setString(2, brand.getCompanyName());
        ps.setInt(3, brand.getOrdered());
        ps.setString(4, brand.getDescription());
        ps.setInt(5, brand.getStatus());
        ps.setInt(6, brand.getId());
        // 执行SQL语句
        int count = ps.executeUpdate();
        // 获取执行结果
        System.out.println("更新结果:" + count);
        // 释放资源
        ps.close();
        conn.close();
    }

    public static void deleteBrandById(int id) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/com/dino/druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();

        String sql = "DELETE FROM brand WHERE id=?";
        PreparedStatement qs = conn.prepareStatement(sql);
        qs.setInt(1, id);

        int count = qs.executeUpdate();     // 影响的行数

        System.out.println("删除结果:" + count);

        qs.close();
        conn.close();
    }
}

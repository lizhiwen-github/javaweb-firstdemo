package com.lzw.service;
import com.lzw.entity.Brand;
import com.lzw.entity.PageBean;
import com.lzw.mapper.BrandMapper;
import com.lzw.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;
/**
 * @Classname BrandService
 * @Description TODO 逻辑控制层
 * @Version 1.0.0
 * @Created by 李志文
 * @Date 2022/1/19 13:41
 */
public class BrandService {
    public static List<Brand> selectAll(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> list = mapper.selectAll();
        sqlSession.close();
        return list;
    }
    public static void insertBrand(Brand brand){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.insertBrand(brand);
        sqlSession.close();
    }
    public static void deleteByIds(int[] ids){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.close();
    }
    /**
     * @param currentPage 当前的页码
     * @param pageSize 每页显示的条数
     * @return com.lzw.entity.PageBean javaBean
     * @author 李志文
     * @date 2022/1/20 12:17
     * @description: TODO 分页查询的servic层
     */
    public static PageBean selectByPage(int currentPage,int pageSize){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        currentPage=(currentPage-1)*pageSize;
        List<Brand> list = mapper.selectByPage(currentPage, pageSize);
        int count = mapper.selectBrandCount();
        PageBean pageBean=new PageBean();
        pageBean.setRows(list);
        pageBean.setTotalCount(count);
       return pageBean;
    }
    /**
     * @param currentPage 当前页码
     * @param pageSize 每页显示的条数
     * @param brand 品牌的实体类
     * @return com.lzw.entity.PageBean
     * @author 李志文
     * @date 2022/1/20 17:57
     * @description: TODO 按条件进行分页查询
     */
    public static PageBean selectByPageAndCondition(int currentPage,int pageSize,Brand brand){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        currentPage=(currentPage-1)*pageSize;
        //进行模糊查询
        String brandName = brand.getBrandName();
        if(brandName!=null&&brandName.length()>0){
            brand.setBrandName("%"+brandName+"%");
        }
        String companyName=brand.getCompanyName();
        if(companyName!=null&&companyName.length()>0){
            brand.setCompanyName("%"+companyName+"%");
        }
        List<Brand> list = mapper.selectByPageAndCondition(currentPage,pageSize,brand);
        int count = mapper.selectTotalCountByCondotion(brand);
        PageBean pageBean=new PageBean();
        pageBean.setTotalCount(count);
        pageBean.setRows(list);
        sqlSession.close();
        return pageBean;
    }
     /**
      * @param id 数据库中数据的主键id
      * @return void
      * @author 李志文
      * @date 2022/1/23 13:27
      * @description: TODO  根据指定的id值，将数据中对应的数据的删除
      */
    public static void deleteById(int id){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.close();
    }
    /**
     * @param id  主键
     * @return com.lzw.entity.Brand
     * @author 李志文
     * @date 2022/1/23 13:28
     * @description: TODO 根据id值，从数据库中查询对应的品牌数据，并返回封装好的对象
     */
    public static Brand getBrandById(int id){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }
    /**
     * @param brand 商品实体类
     * @return void
     * @author 李志文
     * @date 2022/1/23 17:21
     * @description: TODO 修改商品的品牌数据
     */
    public static void UpdateBrand(Brand brand){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.updateBrand(brand);
        sqlSession.close();
    }
}

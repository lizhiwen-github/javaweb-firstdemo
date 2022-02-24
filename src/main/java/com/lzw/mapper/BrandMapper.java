package com.lzw.mapper;
import com.lzw.entity.Brand;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * @Classname BrandMapper
 * @Description TODO
 * @Version 1.0.0
 * @Created by 李志文
 * @Date 2022/1/19 13:07
 */
public interface BrandMapper {
    List<Brand> selectAll(); //查询所有品牌
    void insertBrand(Brand brand);//向数据库中插入数据
    void deleteByIds(@Param("ids") int[] ids); //从数据库中批量删除数据
    /**
     * @param begin 起始页码
     * @param size 每页的条数
     * @return java.util.List<com.lzw.entity.Brand>
     * @author 李志文
     * @date 2022/1/20 12:11
     * @description: TODO 进行分页查询
     */
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);
    int selectBrandCount();
    List<Brand> selectByPageAndCondition(@Param("begin")int begin,@Param("size")int size,@Param("brand") Brand brand);
    int selectTotalCountByCondotion(Brand brand);
    void deleteById(@Param("rowId") int id);//按照id数值从数据库中将指定的数据删除
    Brand selectById(@Param("rowId") int id);
    void updateBrand(Brand brand);
}

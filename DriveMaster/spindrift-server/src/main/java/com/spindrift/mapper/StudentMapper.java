package com.spindrift.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spindrift.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * ClassName: StudentMapper
 * Package: com.spindrift.mapper
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/18 15:57
 * @Version 1.0
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    @Select("select MAX(id) AS id from student")
    Long selectMaxId();


    void insertRecord(Student student);

    void selectById();
}

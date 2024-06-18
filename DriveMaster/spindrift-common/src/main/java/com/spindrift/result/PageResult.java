package com.spindrift.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: PageResult
 * Package: com.spindrift.result
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/17 13:40
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> implements Serializable {

    private long total; //总记录数

    private List<T> records; //当前页数据集合

}

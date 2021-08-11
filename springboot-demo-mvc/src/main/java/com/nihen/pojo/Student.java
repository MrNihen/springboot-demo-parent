package com.nihen.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @Description 学生实体类
 * @Author zhuguanglong
 * @Company
 * @Date 2021/08/02 1:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = -5620720909998834090L;
    @Id
    @JSONField(ordinal = 1)//保证fastjson序列化后的顺序
    private Integer sid;
    @JSONField(ordinal = 2)
    private String sname;
    @JSONField(ordinal = 3)
    private String sex;
    @JSONField(ordinal = 4)
    private Integer age;
    @JSONField(ordinal = 5)
    private String addr;
    @JSONField(ordinal = 6)
    private Integer cid;
    @Transient  //不进行实例化
    private String cname;
}

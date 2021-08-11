package com.nihen.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Description 班级实体类
 * @Author zhuguanglong
 * @Company
 * @Date 2021/08/02 1:09
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classes implements Serializable {
    private static final long serialVersionUID = -3172843634270133923L;
    @Id
    @JSONField(ordinal = 1)
    private Integer cid;
    @JSONField(ordinal = 2)
    private String cname;
}

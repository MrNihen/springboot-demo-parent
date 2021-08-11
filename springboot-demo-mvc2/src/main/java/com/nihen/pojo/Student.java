package com.nihen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @Description
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
    private Integer sid;

    private String sname;

    private String sex;

    private Integer age;

    private String addr;

    private Integer cid;
    @Transient
    private String cname;
}

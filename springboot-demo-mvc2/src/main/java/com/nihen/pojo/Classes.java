package com.nihen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
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
public class Classes implements Serializable {
    private static final long serialVersionUID = -3172843634270133923L;
    @Id
    private Integer cid;

    private String cname;
}

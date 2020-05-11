package com.hdgs.great.object.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 省/市/区的实体类
 * @author jingfeng999
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class District {

    private Integer id;
    private String parent;
    private String code;
    private String name;


}

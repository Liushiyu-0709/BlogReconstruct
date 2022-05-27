package com.sherry.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Alias("ResidentSuppliesRef")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResidentSuppliesRef {
    private Integer residentId;
    private Integer suppliesId;
    private boolean getSituation;
}

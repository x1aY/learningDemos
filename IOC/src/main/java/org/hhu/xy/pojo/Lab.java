package org.hhu.xy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author cn.hhu.xy
 */

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lab {
    private String labName;
    private String labLocation;
}

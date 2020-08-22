package cn.fred.lombok;

import lombok.Data;

/**
 * @Value，所有成员变量都是final的
 */
@Data
public class LbStudent {
    private String name;
    private int age;
}

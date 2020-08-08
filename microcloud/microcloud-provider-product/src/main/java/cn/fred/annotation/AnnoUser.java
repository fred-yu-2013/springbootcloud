package cn.fred.annotation;

import cn.fred.annotation.AnnoExample;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 演示如何使用注解工作
 */
@Data
public class AnnoUser {

    private static final Logger LOG = LoggerFactory.getLogger(AnnoUser.class);

    @AnnoExample(name="zhangsan")
    private String name;

    public static void main(String[] args) {
        AnnoUser user = new AnnoUser();
        user.setName("lisi");
        AnnoParser.parserAnnotation(user);
        LOG.debug("User's name with annotation is " + user.getName());
    }

}

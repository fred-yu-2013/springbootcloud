springboot例子，具体参见spring boot教程及视频文档

1.restful api，参见springboothello工程
2.mybatis
    - 添加mybatis和mysql-connector的依赖，添加mysql-connector是因为可以有可能有其他数据库的connector
    - 添加spring.datasource、mybatis mapper文件的路径配置
    - idea使用插件mybatis-generator-plus生成mapper文件，通过database中选择表的右键菜单的Generate Mybatis Code，即可生成mapper文件
    - App上增加mapper接口的扫描，接口不需要加注解：@MapperScan("cn.fred.dao")
    - 添加controller和test代码
    - 支持事务，只需要在实现类的方法上增加注解@Transactional

3.@ControllerAdvice和@ExceptionHandler处理全局异常

4.swagger用来编写接口文档，主要配置3个地方：包引入/配置/controller方法上加注解



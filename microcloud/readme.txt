微服务例子演示，原子教程和视频

- Java8需要升级到最新的版本（8.261），否则会编译报错

microcloud-api 模块，作为公共的信息导入配置模块；公共工具类，jar包依赖
microcloud-provider-product：作为服务提供者;
microcloud-consumer：作为微服务调用的客户端使用;

1.创建microcloud-api，创建microcloud-provider-product包装提供服务的controller
2.测试链接http://localhost:8080/product/get/1，表示服务microcloud-provider-product正常工作
3.创建microcloud-consumer使用服务，测试连接http://localhost/consumer/product/get?id=1
4.provider服务里面注入security模块，并设置账户，访问则需要用户名密码(application.yml)
5.consumer配置帐户信息，即可直接调用
6.创建security模块jar,provider里面转成对这个jar的依赖,其他一样,此时provider上面不用作任何的security配置(仅需要引入依赖即可)，
但是consumer里面仍然是需要的，可以看作consumer是外网的服务
7.引入eureka服务，走微服务框架那一套，依赖的包比较多
8.provider作为eureka客户端，需要设置几个地方：依赖包／配置文件／App上注解/actuator配置(以便页面上能看到详情）
9.eureka可以设置被注册和查服务的帐户(4.4)

[provider-product]

注解
1.定义注解->作用于成员变量上->定义解析注解的方法->main里面生成对象，调用解析注解的方法即可

lombok
1.特性参见这里：https://projectlombok.org/features/all，功能很有趣，比如：var, @CleanUp, @Builder, @Log
2.例子参见annotation包

mybatis-plus
1.github: https://github.com/baomidou/mybatis-plus


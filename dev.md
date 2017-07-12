*Cannot determine embedded datasource
mybatis和datasource的配置数据应该写在系统生成的application.properties中，否则不能加载进来


* resources/static目录下默认为default页面
jsp视图管理：
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
若无这个依赖，controller返回的字符串将无法和页面映射起来
* 使用velocity模板引擎
添加依赖
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-velocity</artifactId>
            <version>1.4.7.RELEASE</version>
        </dependency>
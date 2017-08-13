* Cannot determine embedded datasource
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
使用velocity无法找到默认的viewResolver，自己写的时候发现springmvcjar包中关于velocity的类都废弃掉了，索性换freemarker吧
     
        
#freemarker
FreeMarker的插值有如下两种类型:1,通用插值${expr};2,数字格式化插值:#{expr}或#{expr;format} 
如果该指令是一个用户指令而不是系统内建指令时,应将#符号改成@符号. 


jquery时间插件
前后端String和Date互转

表结构设计不合理
前后端的数据模型规划不够好
优化页面显示（room+time）

页面优化
index页面增加日期下拉搜索栏

增加预定记录表展示（staffrecord）

预定弹窗，预定成功/失败之后时关闭弹出的页面，同时刷新index页面
预定成功后可取消预定
提交预定时做状态校验
添加登录页面
freemarker中map的用法
通过sprngSecurity添加简单的权限控制
#todo
aop配合Actuator做监控
webpack+npm+bootstrap+babel


使用Security的时候，页面要使用thymeleaf，否则无法传递CSRF token

获得登录用户信息，并记录操作人名称（*怎么实现*）（折中方法，取消时，填写预订人信息，校验信息是否一致）
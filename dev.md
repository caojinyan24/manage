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

#todo
页面优化


添加layout
优化页面显示（room+time）
预定弹窗，预定成功/失败之后时关闭弹出的页面，同时刷新index页面
增加预定记录表展示（staffrecord）
index页面增加日期下拉搜索栏
预定成功后可取消预定
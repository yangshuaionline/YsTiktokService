- [CSDN](https://blog.csdn.net/yangshuaionline)
- [GitHub](https://github.com/yangshuaionline/YsTiktokService)

### 用到技术
> 容器：docker
> 数据库：mysql
> 代理服务器：nginx




- 目录结构：

    -   java
        - config:配置文件（比方说跨域配置）
        - controller：控制层，处理用户输入请求        
        - dao：持久化层，提供数据表存取机制，主要是 ORM 框架实现以对象-关系数据库的映射
        - entity：模型层，存放实体类，存放项目自身使用模型
        - filter：拦截器
        - mapper:关联映射xml文件
        - proto：存放proto模型
        - service：数据服务
        - utils：工具类   
    -   resources
        - indect: 存放注入文件（filter等）？`未定存在疑问`
        - mapper：存放mybatis映射
        - static：用于存放静态html、css、js、图片等资源
        - templates：用于存放动态html
        - application.properties：项目配置文件
        - banner.txt：修改banner
# 						DarkMS-微服务架构

## 简介

* 采用前后端分离的模式，微服务版本前端(基于 [darkMS-client](https://github.com/guankaiheiwa/darkMS-client))。
* 后端采用Spring Boot、Spring Cloud & Alibaba。
* 注册中心、配置中心选型Nacos。
* 流量控制框架选型Sentinel。
* 分布式锁采用2种实现。
  * 基于Zookeeper实现一致性锁。
  * 基于Redisson实现高可用锁。
* 分布式事务，采用三种模式实现。
  * 基于阿里Seata的AT模式
  * 基于RocketMQ实现可靠消息最终一致性事务
  * 基于RocketMQ实现最大努力通知
* 搜索引擎使用ElasticSearch。
* 采用Sharding-jdbc实现数据库分片扩展。
* 数据缓存采用Redis主从集群。
* 数据库持久化使用Mysql主从集群。

## 组织结构

```
com.darkms   
├── darkms-gateway         // 网关模块 [8080]
├── darkms-auth            // 认证中心 [9200]
├── darkms-api             // 接口模块
├── darkms-common          // 通用模块
│       └── com.darkms.core                         // 核心模块
│       └── com.darkms.datascope                    // 权限范围
│       └── com.darkms.log                          // 日志记录
│       └── com.darkms.redis                        // 缓存服务
│       └── com.darkms.security                     // 安全模块
│       └── com.darkms.swagger                      // 系统接口
├── darkms-modules         // 业务模块
│       └── darkms-admin                            // 系统模块 [9201]
│       └── darkms-gen                              // 代码生成 [9202]
│       └── darkms-job                              // 定时任务 [9203]
├──pom.xml                // 公共依赖
```

## 架构图

![架构图](http://img.yegame.com/dark/darkms.png)

## 技术栈

| 技术           | 说明           | 官网                                                        |
| -------------- | -------------- | ----------------------------------------------------------- |
| SpringBoot     | 容器/MVC框架   | https://spring.io/projects/spring-boot                      |
| SpringSecurity | 认证授权框架   | https://spring.io/projects/spring-security                  |
| MyBatis-Plus   | ORM框架        | https://baomidou.com/                                       |
| Swagger-UI     | 文档生产工具   | https://github.com/swagger-api/swagger-ui                   |
| Elasticsearch  | 搜索引擎       | https://github.com/elastic/elasticsearch                    |
| RocketMQ       | 消息队列       | http://rocketmq.apache.org/                                 |
| Redis          | 分布式缓存     | https://redis.io/                                           |
| MySql          | 关系数据库     | https://www.mysql.com/                                      |
| Nacos          | 注册/配置中心  | https://nacos.io/                                           |
| Seata          | 分布式事务     | http://seata.io/zh-cn/                                      |
| Sentinel       | 熔断/降级/限流 | https://github.com/alibaba/Sentinel/wiki/%E4%B8%BB%E9%A1%B5 |
| Docker         | 应用容器引擎   | https://www.docker.com                                      |
| Druid          | 数据库连接池   | https://github.com/alibaba/druid                            |
| OSS            | 对象存储       | https://github.com/aliyun/aliyun-oss-java-sdk               |
| MinIO          | 对象存储       | https://github.com/minio/minio                              |
| JWT            | JWT登录支持    | https://github.com/jwtk/jjwt                                |
| Sharding-jdbc  | 数据库分片     | https://shardingsphere.apache.org/                          |
| Lombok         | 对象封装工具   | https://github.com/rzwitserloot/lombok                      |
| Jenkins        | 自动化部署     | https://github.com/jenkinsci/jenkins                        |

## 功能介绍

## 环境搭建

### 	1.开发工具

| 工具          | 说明                 | 官网                                    |
| ------------- | -------------------- | --------------------------------------- |
| IDEA          | 开发IDE              | https://www.jetbrains.com/idea/download |
| QuickRedis    | Redis客户端连接工具  | https://quick123.net/                   |
| Typora        | Markdown编辑器       | https://typora.io/                      |
| SwitchHosts   | 本地host管理         | https://oldj.github.io/SwitchHosts/     |
| ShellCraft    | Osx连接Linux远程工具 | http://www.shellcraftapp.com/           |
| Navicat       | 数据库连接工具       | http://www.formysql.com/xiazai.html     |
| PowerDesigner | 数据库设计工具       | http://powerdesigner.de/                |
| Processon     | 在线图形设计工具     | https://processon.com/                  |
| MindMaster    | 思维导图设计工具     | http://www.edrawsoft.cn/mindmaster      |
| ScreenToGif   | Gif录制工具          | https://www.screentogif.com/            |
| Postman       | API接口调试工具      | https://www.postman.com/                |
| PicPick       | 图片处理工具         | https://picpick.app/zh/                 |
| Snipaste      | 屏幕截图工具         | https://www.snipaste.com/               |
| Jmeter        | 压力测试工具         | https://jmeter.apache.org/              |
| Hbuilder      | HTML5的Web开发IDE    | https://www.dcloud.io/                  |

### 	2.开发环境

| 环境     | 版本号 | 下载                                                         |
| -------- | ------ | ------------------------------------------------------------ |
| JDK      | 1.8    | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| Mysql    | 5.7    | https://www.mysql.com/                                       |
| Redis    | 5.0    | https://redis.io/download                                    |
| Nacos    | 1.4.0  | https://nacos.io/                                            |
| RocketMQ | 4.7.1  | http://rocketmq.apache.org/                                  |
| Nginx    | 1.10   | http://nginx.org/en/download.html                            |
| Docker   | 2.5.0  | https://www.docker.com                                       |
| Sentinel | 1.8.0  | https://github.com/alibaba/Sentinel/wiki                     |
| Maven    | 3.6.3  | https://maven.apache.org/                                    |

## 搭建步骤

请阅读：doc/
# MUWPOB-Spring-Research
关于spring boot的实践的科研。

先声明本人毫无Java基础，这就是一个一拍脑袋就新建的不知道什么时候跑路的垃圾项目，主要目的就是熟悉一下Spring项目结构。

#### 依赖

|                | 版本                                                      | 下载链接                                                     | 说明     |
| -------------- | --------------------------------------------------------- | ------------------------------------------------------------ | -------- |
| java           | openjdk-11.0.2_windows-x64_bin                            |                                                              |          |
| gradle         | gradle-6.9.3                                              |                                                              |          |
| 消息队列中间件 | RocketMQ：5.0.0                                           | https://rocketmq.apache.org/zh/download                      | 待研究   |
| 数据库         | mysql-community-server-core_8.0.32-1ubuntu22.04_amd64.deb | https://downloads.mysql.com/archives/get/p/23/file/mysql-community-server-core_8.0.32-1ubuntu22.04_amd64.deb | TODO     |
| 自动化运维     | Ansible：2.14.1                                           |                                                              | 可能会用 |
|                |                                                           |                                                              |          |

### 第三方库

|      |      |      |
| ---- | ---- | ---- |
|      |      |      |
|      |      |      |
|      |      |      |



### build.gradle参数更改

```gradle
plugins {
    id 'java'
    id 'org.springframework.boot' version '2.7.12'
    id 'io.spring.dependency-management' version '1.0.15.RELEASE'
}

group = 'com.straycat'
version = '0.0.1-SNAPSHOT'

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
```

@SpringBootApplication注解的文件要扔到其他代码的上级或者同级，否则可能会无法成功运行。


# MUWPOB-Spring-Research
关于spring boot的实践的科研

#### 依赖

java：openjdk-11.0.2_windows-x64_bin
gradle：gradle-6.9.3

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


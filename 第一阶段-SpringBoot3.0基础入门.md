# 第一阶段：Spring Boot 3.0基础入门（第1-2周）

## 🎯 阶段学习目标

完成本阶段学习后，你将能够：

- 理解Spring Boot 3.0的新特性和改进
- 独立创建和配置Spring Boot 3.0项目
- 掌握核心注解和自动配置原理
- 编写简单的RESTful API
- 进行单元测试和集成测试
- 打包和部署Spring Boot 3.0应用

***

## 📚 背景知识点

### 知识点1.1：Spring Boot 3.0新特性

**Java 17支持和要求**

- Spring Boot 3.0要求Java 17作为最低版本
- 可利用Java 17新特性：Records、Pattern Matching、Sealed Classes
- 需要升级JDK版本，可能需要调整现有代码

**AOT编译和GraalVM支持**

- AOT（Ahead-of-Time）编译将Java应用编译为原生可执行文件
- GraalVM是高性能JDK，支持AOT编译
- 优势：更快的启动时间、更低的内存占用、更好的性能

**云原生应用支持**

- 增强了云原生应用支持，与Kubernetes等云原生环境无缝集成
- 健康检查、指标监控、配置管理
- 容器化部署优化

**性能优化和安全增强**

- 启动时间优化、内存使用优化
- 默认安全配置、依赖安全检查
- 改进的Actuator端点

### 知识点1.2：项目结构与配置

**标准项目结构**

- src/main/java：Java源代码
- src/main/resources：配置文件和静态资源
- src/test/java：测试代码
- pom.xml：Maven项目配置

**配置文件类型**

- application.properties：传统键值对格式
- application.yml：层次化YAML格式
- 多环境配置：dev、test、prod

**配置文件加载顺序**

- 命令行参数（最高优先级）
- SPRING\_APPLICATION\_JSON环境变量
- JNDI属性
- Java系统属性
- 操作系统环境变量
- jar包外的application-{profile}.properties
- jar包内的application-{profile}.properties
- jar包外的application.properties
- jar包内的application.properties
- @PropertySource注解
- 默认属性

### 知识点1.3：核心注解与自动配置

**@SpringBootApplication注解**

- 组合注解，包含三个部分：
  - @SpringBootConfiguration：标识为配置类
  - @EnableAutoConfiguration：启用自动配置
  - @ComponentScan：自动扫描组件

**自动配置原理**

- 基于条件注解决定是否加载配置
- 常用条件注解：
  - @ConditionalOnClass：类路径下存在指定类时生效
  - @ConditionalOnMissingBean：容器中不存在指定Bean时生效
  - @ConditionalOnProperty：配置属性满足条件时生效
  - @ConditionalOnWebApplication：Web应用环境时生效

**组件扫描机制**

- 默认扫描启动类所在包及其子包
- 可通过scanBasePackages自定义扫描范围
- 可通过excludeFilters排除某些组件

**自定义配置类**

- @Configuration标识配置类
- @Bean定义Bean实例
- @Import导入其他配置类
- @Profile指定环境配置

### 知识点1.4：RESTful API开发

**@RestController注解**

- 组合注解，包含@Controller和@ResponseBody
- 直接返回JSON数据，不渲染视图
- 适合开发RESTful API

**@RequestMapping及其派生注解**

- @RequestMapping：通用请求映射
- @GetMapping：GET请求
- @PostMapping：POST请求
- @PutMapping：PUT请求
- @DeleteMapping：DELETE请求
- @PatchMapping：PATCH请求

**请求参数绑定**

- @RequestParam：查询参数
- @PathVariable：路径参数
- @RequestBody：请求体参数
- @RequestHeader：请求头参数

**响应数据处理**

- ResponseEntity：完整响应对象，包含状态码、头信息、响应体
- @ResponseBody：直接返回响应体
- @ResponseStatus：设置HTTP状态码

**异常处理**

- @ExceptionHandler：异常处理方法
- @ControllerAdvice：全局异常处理
- @ResponseStatus：异常响应状态

### 知识点1.5：依赖注入与Bean管理

**@Autowired自动装配**

- 按类型自动注入Bean
- 可通过required属性设置是否必须
- 可通过@Qualifier指定Bean名称

**组件注解**

- @Component：通用组件注解
- @Service：服务层组件
- @Repository：数据访问层组件
- @Controller：控制器层组件

**@Configuration和@Bean注解**

- @Configuration：标识配置类
- @Bean：定义Bean实例
- Bean名称：默认为方法名，可通过value属性自定义

**作用域和生命周期**

- @Scope：指定Bean作用域（singleton、prototype等）
- @PostConstruct：初始化回调
- @PreDestroy：销毁回调
- @Lazy：延迟初始化

**条件化Bean创建**

- @ConditionalOnProperty：基于配置属性
- @ConditionalOnClass：基于类路径
- @ConditionalOnMissingBean：基于Bean存在性

### 知识点1.6：测试与打包部署

**@SpringBootTest注解**

- 启动完整的Spring Boot应用上下文
- 可通过webEnvironment指定Web环境类型
- 可通过properties指定配置属性

**MockMvc和Mock测试**

- MockMvc：模拟HTTP请求进行Web层测试
- @MockBean：模拟Bean实例
- @SpyBean：监视Bean实例

**单元测试和集成测试**

- 单元测试：测试单个方法或类
- 集成测试：测试多个组件协作
- 测试覆盖率：确保代码质量

**Jar包和War包打包**

- Jar包：可执行Jar，包含内嵌Tomcat
- War包：部署到外部Servlet容器
- Maven打包命令：mvn clean package

**Docker容器化部署**

- Dockerfile：定义镜像构建规则
- 容器运行：docker run命令
- 环境变量：容器配置管理

***

## 🛠 实操步骤

### 实操步骤1.1：创建Spring Boot 3.0项目

**步骤1：访问Spring Initializr**

```bash
# 打开浏览器访问
https://start.spring.io/
```

**步骤2：配置项目参数**

```
选择配置：
- Project: Maven
- Language: Java
- Spring Boot: 3.0.0
- Packaging: Jar
- Java: 17
- Group: com.example
- Artifact: demo
- Name: demo
- Description: Spring Boot 3.0 Demo Project
- Package Name: com.example.demo
- Dependencies:
  - Spring Web
  - Spring Boot Actuator
  - Spring Boot DevTools
```

**步骤3：生成并下载项目**

```
点击"Generate"按钮下载项目压缩包
或使用命令行：
curl https://start.spring.io/starter.zip?type=maven-project&language=java&bootVersion=3.0.0&baseDir=demo&groupId=com.example&artifactId=demo&name=demo&description=Spring+Boot+3.0+Demo+Project&packageName=com.example.demo&packaging=jar&javaVersion=17&dependencies=web,actuator,devtools -o demo.zip
```

**步骤4：解压项目包**

```bash
# 解压下载的项目包
unzip demo.zip
cd demo
```

**步骤5：导入到IDE**

```
IntelliJ IDEA：
- File -> Open -> 选择demo目录
- 等待IDE导入和索引完成

Eclipse：
- File -> Import -> Existing Maven Projects -> 选择demo目录
- 点击Finish完成导入
```

**步骤6：验证项目结构**

```bash
# 查看项目目录结构
tree demo/

# 应该看到标准Maven项目结构
```

### 实操步骤1.2：配置多环境

**步骤1：创建application.properties**

```properties
# 主配置文件
server.port=8080
spring.application.name=spring-boot-3.0-demo
spring.profiles.active=dev

# 日志配置
logging.level.root=INFO
logging.level.com.example=DEBUG
```

**步骤2：创建application-dev.properties**

```properties
# 开发环境配置
server.port=8080

# 数据库配置（开发环境）
spring.datasource.url=jdbc:mysql://localhost:3306/dev_db
spring.datasource.username=root
spring.datasource.password=dev_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# 日志配置（开发环境）
logging.level.root=DEBUG
logging.level.com.example=DEBUG

# 自定义配置
app.name=开发环境
app.environment=development
```

**步骤3：创建application-prod.properties**

```properties
# 生产环境配置
server.port=80

# 数据库配置（生产环境）
spring.datasource.url=jdbc:mysql://prod-server:3306/prod_db
spring.datasource.username=prod_user
spring.datasource.password=prod_secure_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# 日志配置（生产环境）
logging.level.root=WARN
logging.level.com.example=WARN
logging.file.name=logs/application.log

# 自定义配置
app.name=生产环境
app.environment=production
```

**步骤4：创建application.yml**

```yaml
server:
  port: 8080

spring:
  application:
    name: spring-boot-3.0-demo
  profiles:
    active: dev

logging:
  level:
    root: INFO
    com.example: DEBUG
```

### 实操步骤1.3：创建RESTful API控制器

**步骤1：创建控制器类**

```java
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @GetMapping
    public String getAllUsers() {
        return "获取所有用户";
    }
    
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id) {
        return "获取用户ID: " + id;
    }
    
    @PostMapping
    public String createUser(@RequestBody String user) {
        return "创建用户: " + user;
    }
    
    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody String user) {
        return "更新用户ID: " + id + ", 数据: " + user;
    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return "删除用户ID: " + id;
    }
}
```

**步骤2：创建数据模型类**

```java
package com.example.demo.model;

public class User {
    private Long id;
    private String username;
    private String email;
    private Integer age;
    
    // 构造方法
    public User() {}
    
    public User(Long id, String username, String email, Integer age) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.age = age;
    }
    
    // Getter和Setter方法
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
}
```

**步骤3：创建服务类**

```java
package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    
    private List<User> users = new ArrayList<>();
    
    public List<User> getAllUsers() {
        return users;
    }
    
    public User getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public User createUser(User user) {
        user.setId((long) (users.size() + 1));
        users.add(user);
        return user;
    }
    
    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setAge(user.getAge());
        }
        return existingUser;
    }
    
    public void deleteUser(Long id) {
        users.removeIfPresent(user -> user.getId().equals(id));
    }
}
```

**步骤4：在控制器中使用服务**

```java
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
```

### 实操步骤1.4：编写单元测试

**步骤1：创建测试类**

```java
package com.example.demo.service;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    
    @Autowired
    private UserService userService;
    
    @Test
    public void testGetAllUsers() {
        assertNotNull(userService.getAllUsers());
    }
    
    @Test
    public void testCreateUser() {
        User user = new User(null, "张三", "zhangsan@example.com", 25);
        User createdUser = userService.createUser(user);
        assertNotNull(createdUser);
        assertNotNull(createdUser.getId());
    }
    
    @Test
    public void testGetUserById() {
        User user = new User(1L, "李四", "lisi@example.com", 30);
        userService.createUser(user);
        
        User foundUser = userService.getUserById(1L);
        assertNotNull(foundUser);
        assertEquals("李四", foundUser.getUsername());
    }
    
    @Test
    public void testUpdateUser() {
        User user = new User(1L, "王五", "wangwu@example.com", 28);
        userService.createUser(user);
        
        User updateUser = new User(1L, "王五更新", "wangwu_new@example.com", 29);
        User updatedUser = userService.updateUser(1L, updateUser);
        assertNotNull(updatedUser);
        assertEquals("王五更新", updatedUser.getUsername());
    }
    
    @Test
    public void testDeleteUser() {
        User user = new User(1L, "赵六", "zhaoliu@example.com", 27);
        userService.createUser(user);
        
        userService.deleteUser(1L);
        User deletedUser = userService.getUserById(1L);
        assertNull(deletedUser);
    }
}
```

**步骤2：创建Web层测试**

```java
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private UserService userService;
    
    @Test
    public void testGetAllUsers() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    @Test
    public void testGetUserById() throws Exception {
        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testCreateUser() throws Exception {
        String userJson = "{\"username\":\"张三\",\"email\":\"zhangsan@example.com\",\"age\":25}";
        
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testUpdateUser() throws Exception {
        String userJson = "{\"username\":\"李四更新\",\"email\":\"lisi_new@example.com\",\"age\":31}";
        
        mockMvc.perform(put("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isOk());
    }
}
```

**步骤3：运行测试**

```bash
# 运行所有测试
mvn test

# 运行特定测试类
mvn test -Dtest=UserServiceTest

# 查看测试覆盖率报告
mvn clean test jacoco:report
```

### 实操步骤1.5：打包和部署应用

**步骤1：打包应用**

```bash
# 清理并打包
mvn clean package

# 跳过测试打包
mvn clean package -DskipTests

# 查看打包结果
ls target/
# 应该看到：
# - demo-1.0.0-SNAPSHOT.jar（可执行Jar）
# - demo-1.0.0-SNAPSHOT.jar.original（原始Jar）
```

**步骤2：运行Jar包**

```bash
# 直接运行Jar包
java -jar target/demo-1.0.0-SNAPSHOT.jar

# 指定配置文件运行
java -jar target/demo-1.0.0-SNAPSHOT.jar --spring.profiles.active=prod

# 指定端口运行
java -jar target/demo-1.0.0-SNAPSHOT.jar --server.port=9090

# 后台运行
nohup java -jar target/demo-1.0.0-SNAPSHOT.jar > app.log 2>&1 &
```

**步骤3：创建Dockerfile**

```dockerfile
FROM openjdk:17-slim

WORKDIR /app

COPY target/demo-1.0.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
```

**步骤4：构建Docker镜像**

```bash
# 构建Docker镜像
docker build -t spring-boot-demo:latest .

# 查看构建的镜像
docker images
```

**步骤5：运行Docker容器**

```bash
# 运行Docker容器
docker run -p 8080:8080 spring-boot-demo:latest

# 后台运行容器
docker run -d -p 8080:8080 --name spring-boot-app spring-boot-demo:latest

# 查看容器日志
docker logs spring-boot-app

# 停止容器
docker stop spring-boot-app

# 删除容器
docker rm spring-boot-app
```

**步骤6：创建启动脚本**

Linux/Mac启动脚本：

```bash
#!/bin/bash

APP_NAME="demo"
JAR_FILE="target/demo-1.0.0-SNAPSHOT.jar"
LOG_FILE="logs/application.log"
PID_FILE="application.pid"

start() {
    if [ -f $PID_FILE ]; then
        PID=$(cat $PID_FILE)
        if ps -p $PID > /dev/null; then
            echo "应用已在运行，PID: $PID"
            exit 1
        fi
    fi
    
    echo "正在启动应用..."
    nohup java -jar $JAR_FILE > $LOG_FILE 2>&1 &
    echo $! > $PID_FILE
    echo "应用启动成功，PID: $(cat $PID_FILE)"
}

stop() {
    if [ ! -f $PID_FILE ]; then
        echo "应用未运行"
        exit 1
    fi
    
    PID=$(cat $PID_FILE)
    if ps -p $PID > /dev/null; then
        echo "正在停止应用，PID: $PID"
        kill $PID
        rm $PID_FILE
        echo "应用已停止"
    else
        echo "应用未运行"
        rm $PID_FILE
    fi
}

restart() {
    stop
    sleep 2
    start
}

status() {
    if [ -f $PID_FILE ]; then
        PID=$(cat $PID_FILE)
        if ps -p $PID > /dev/null; then
            echo "应用正在运行，PID: $PID"
        else
            echo "应用未运行"
        fi
    else
        echo "应用未运行"
    fi
}

case "$1" in
    start)
        start
        ;;
    stop)
        stop
        ;;
    restart)
        restart
        ;;
    status)
        status
        ;;
    *)
        echo "使用方法: $0 {start|stop|restart|status}"
        exit 1
        ;;
esac
```

Windows启动脚本：

```batch
@echo off
set APP_NAME=demo
set JAR_FILE=target\demo-1.0.0-SNAPSHOT.jar
set LOG_FILE=logs\application.log

if "%1"=="start" (
    echo 正在启动应用...
    start java -jar %JAR_FILE%
    echo 应用启动成功
) else if "%1"=="stop" (
    echo 正在停止应用...
    taskkill /F /IM java.exe
    echo 应用已停止
) else (
    echo 使用方法: %0 {start|stop}
)
```

***

## 📊 阶段检查点

### 理论掌握检查

- [ ] 理解Spring Boot 3.0的新特性
- [ ] 掌握核心注解的使用
- [ ] 理解自动配置原理
- [ ] 掌握配置文件的使用

### 实践能力检查

- [ ] 能够独立创建Spring Boot 3.0项目
- [ ] 能够编写简单的RESTful API
- [ ] 能够进行单元测试和集成测试
- [ ] 能够打包和部署应用

### 问题解决能力检查

- [ ] 能够解决启动问题
- [ ] 能够解决配置问题
- [ ] 能够解决依赖问题

***

## 🎯 阶段总结

完成本阶段学习后，你已经掌握了Spring Boot 3.0的基础知识，能够独立开发简单的RESTful API应用，并具备基本的测试和部署能力。这为后续的Web开发、数据访问、高级特性学习奠定了坚实的基础。

**下一步：** 进入第二阶段 - Web开发进阶，学习Spring MVC 3.0的高级特性和Thymeleaf模板引擎。

# 第二阶段：Web开发进阶（第3-5周）

## 🎯 阶段学习目标

完成本阶段学习后，你将能够：
- 掌握Spring MVC 3.0的高级特性
- 熟练使用Thymeleaf模板引擎
- 实现文件上传和下载功能
- 了解响应式编程WebFlux
- 开发完整的Web应用

---

## 📚 背景知识点

### 知识点2.1：Spring MVC 3.0架构

**Spring MVC 3.0新特性**
- 支持AOT编译优化
- 增强的类型安全
- 改进的异常处理机制
- 更好的性能表现

**控制器高级用法**
- @RestControllerAdvice全局异常处理
- @ModelAttribute模型属性绑定
- @SessionAttribute会话属性
- @InitBinder数据绑定器

**拦截器和过滤器**
- HandlerInterceptor：请求拦截器
- OncePerRequestFilter：单次执行过滤器
- FilterRegistrationBean：过滤器注册
- 执行顺序控制

**全局异常处理**
- @ControllerAdvice：全局控制器异常处理
- @ExceptionHandler：方法级异常处理
- ResponseEntity：统一响应格式
- 自定义异常类型

**数据验证和绑定**
- @Valid和@Validated注解
- BindingResult验证结果
- 自定义验证器
- 国际化错误消息

### 知识点2.2：静态资源与国际化

**静态资源管理**
- 静态资源目录结构：/static/css、/static/js、/static/images
- 资源版本控制：使用MD5或SHA1命名
- 缓存控制：设置缓存过期时间
- WebJars使用：前端库打包为Jar引用

**国际化i18n支持**
- MessageSource：消息源配置
- LocaleResolver：区域解析器
- AcceptHeaderLocaleResolver：基于请求头
- CookieLocaleResolver：基于Cookie
- SessionLocaleResolver：基于会话

**多语言配置**
- messages.properties：默认消息
- messages_zh_CN.properties：中文消息
- messages_en_US.properties：英文消息
- 国际化参数传递

**时区和日期格式化**
- TimeZone：时区设置
- DateTimeFormat：日期格式化
- NumberFormat：数字格式化
- 自定义格式化器

### 知识点2.3：安全基础

**Spring Security基础**
- 认证机制：用户身份验证
- 授权机制：访问权限控制
- 密码加密：BCryptPasswordEncoder
- 会话管理：安全会话控制

**CSRF防护**
- 同步令牌模式：CSRF Token
- 异步令牌模式：CSRF Token
- 令牌存储：Session或Cookie
- 令牌验证：CsrfTokenRepository

**密码加密**
- BCrypt算法：单向加密
- 密码强度验证
- 密码重置流程
- 密码历史记录

**JWT令牌**
- JWT生成和验证
- 令牌过期处理
- 刷新令牌机制
- 权限声明

### 知识点2.4：Thymeleaf模板引擎

**Thymeleaf 3.0新特性**
- 支持Java 17特性
- 性能优化改进
- 更好的模板缓存
- 增强的调试支持

**模板语法和表达式**
- 变量表达式：${...}
- 选择变量表达式：*{...}
- 消息表达式：#{...}
- 链接表达式：@{...}

**条件判断和循环**
- th:if：条件判断
- th:unless：反向条件
- th:each：循环遍历
- th:switch：多条件选择
- th:case：分支选择

**表单处理**
- th:field：表单字段绑定
- th:object：对象绑定
- th:action：表单提交地址
- th:method：请求方法

**模板继承和布局**
- th:fragment：片段定义
- th:replace：片段替换
- th:insert：片段插入
- 布局装饰器模式

### 知识点2.5：文件上传功能

**MultipartFile接口**
- 文件上传处理
- 多文件上传支持
- 文件类型验证
- 文件大小限制

**文件存储策略**
- 本地文件系统存储
- 数据库存储：BLOB字段
- 云存储：OSS、S3
- 分布式文件系统

**全局异常处理**
- 文件大小超限异常
- 文件类型不支持异常
- 存储空间不足异常
- 统一错误响应

**文件下载功能**
- Content-Disposition响应头
- 文件名编码处理
- 断点续传支持
- 下载进度显示

### 知识点2.6：响应式编程WebFlux

**WebFlux 3.0新特性**
- 响应式编程模型
- 非阻塞I/O处理
- 背压支持
- 更好的资源利用

**Reactor库使用**
- Flux：0到N个元素的序列
- Mono：0到1个元素的结果
- 操作符：map、filter、flatMap
- 错误处理机制

**路由和处理器**
- RouterFunction：路由函数
- HandlerFunction：处理函数
- ServerResponse：响应构建
- 请求和响应处理

**响应式数据库访问**
- R2DBC：响应式数据库连接
- Spring Data R2DBC：响应式数据访问
- 事务管理：响应式事务
- 批量操作优化

### 知识点2.7：Web开发最佳实践

**RESTful API设计规范**
- 资源命名：使用复数名词
- HTTP方法使用：GET查询、POST创建、PUT更新、DELETE删除
- 状态码规范：200成功、201创建、400客户端错误、500服务器错误
- 版本控制：API版本管理

**前后端分离**
- JSON数据交换格式
- 跨域处理：CORS配置
- 认证令牌传递：Authorization头
- 接口文档：Swagger/OpenAPI

**性能优化技巧**
- 数据库查询优化
- 缓存策略：Redis缓存
- 异步处理：@Async注解
- 连接池配置：合理设置连接数

**安全防护措施**
- SQL注入防护：参数化查询
- XSS攻击防护：输入过滤和转义
- CSRF防护：令牌验证
- 请求限流：防止恶意请求

**日志和监控**
- 请求日志记录
- 异常日志记录
- 性能指标监控
- 用户行为分析

---

## 🛠 实操步骤

### 实操步骤2.1：创建Spring MVC项目

**步骤1：创建项目结构**
```bash
# 创建项目目录
mkdir spring-mvc-demo
cd spring-mvc-demo

# 创建标准Maven目录结构
mkdir -p src/main/java/com/example/mvc/{controller,service,model,config}
mkdir -p src/main/resources/{templates,static/{css,js,images}}
mkdir -p src/test/java/com/example/mvc
```

**步骤2：配置pom.xml**
```xml
<dependencies>
    <!-- Spring MVC -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Thymeleaf -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    
    <!-- Validation -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    
    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

**步骤3：创建配置类**
```java
@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(3600);
    }
    
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return slr;
    }
    
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
```

### 实操步骤2.2：实现拦截器和过滤器

**步骤1：创建登录拦截器**
```java
@Component
public class LoginInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, 
                           HttpServletResponse response, 
                           Object handler) throws Exception {
        String uri = request.getRequestURI();
        String token = request.getHeader("Authorization");
        
        // 检查登录状态
        if (token == null && !uri.contains("/login")) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, 
                            HttpServletResponse response, 
                            Object handler, 
                            ModelAndView modelAndView) throws Exception {
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, 
                                 HttpServletResponse response, 
                                 Object handler, 
                                 Exception ex) throws Exception {
    }
}
```

**步骤2：注册拦截器**
```java
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    
    @Autowired
    private LoginInterceptor loginInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/static/**");
    }
}
```

**步骤3：创建字符编码过滤器**
```java
@Component
public class CharacterEncodingFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
                        FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    
    @Override
    public void destroy() {
    }
}
```

**步骤4：注册过滤器**
```java
@Configuration
public class FilterConfig {
    
    @Bean
    public FilterRegistrationBean<CharacterEncodingFilter> characterEncodingFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean<>();
        registration.setFilter(new CharacterEncodingFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }
}
```

### 实操步骤2.3：实现全局异常处理

**步骤1：创建自定义异常类**
```java
public class BusinessException extends RuntimeException {
    private String code;
    private String message;
    
    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    
    public String getCode() {
        return code;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
}
```

**步骤2：创建统一响应类**
```java
public class ApiResponse<T> {
    private Integer code;
    private String message;
    private T data;
    
    public ApiResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    
    public static <T> success(T data) {
        return new ApiResponse<>(200, "success", data);
    }
    
    public static <T> error(String message) {
        return new ApiResponse<>(500, message, null);
    }
    
    public static <T> error(Integer code, String message) {
        return new ApiResponse<>(code, message, null);
    }
    
    // Getter方法
    public Integer getCode() { return code; }
    public String getMessage() { return message; }
    public T getData() { return data; }
}
```

**步骤3：创建全局异常处理器**
```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Void>> handleBusinessException(BusinessException ex) {
        return ResponseEntity.ok(ApiResponse.error(ex.getCode(), ex.getMessage()));
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception ex) {
        return ResponseEntity.ok(ApiResponse.error(500, "系统错误：" + ex.getMessage()));
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.ok(ApiResponse.error(400, "参数验证失败：" + message));
    }
}
```

### 实操步骤2.4：实现国际化

**步骤1：创建消息资源文件**
```properties
# messages.properties（默认）
welcome.message=Welcome
user.notfound=User not found
login.success=Login successful

# messages_zh_CN.properties（中文）
welcome.message=欢迎
user.notfound=用户不存在
login.success=登录成功

# messages_en_US.properties（英文）
welcome.message=Welcome
user.notfound=User not found
login.success=Login successful
```

**步骤2：创建国际化控制器**
```java
@RestController
@RequestMapping("/api/i18n")
public class I18nController {
    
    @Autowired
    private MessageSource messageSource;
    
    @GetMapping("/welcome")
    public String getWelcomeMessage(@RequestParam String lang) {
        Locale locale = Locale.forLanguageTag(lang);
        return messageSource.getMessage("welcome.message", null, locale);
    }
    
    @GetMapping("/user/{id}")
    public String getUserMessage(@PathVariable Long id, @RequestParam String lang) {
        Locale locale = Locale.forLanguageTag(lang);
        return messageSource.getMessage("user.notfound", null, locale);
    }
}
```

**步骤3：测试国际化**
```bash
# 测试中文
curl "http://localhost:8080/api/i18n/welcome?lang=zh_CN"

# 测试英文
curl "http://localhost:8080/api/i18n/welcome?lang=en_US"

# 测试默认
curl "http://localhost:8080/api/i18n/welcome"
```

### 实操步骤2.5：实现文件上传

**步骤1：配置文件上传**
```properties
# application.properties
spring.servlet.multipart.enabled=true
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
spring.servlet.multipart.location=uploads/
```

**步骤2：创建文件上传控制器**
```java
@RestController
@RequestMapping("/api/files")
public class FileUploadController {
    
    @PostMapping("/upload")
    public ApiResponse<Map<String, String>> uploadFile(
            @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ApiResponse.error(400, "请选择文件");
        }
        
        try {
            String fileName = file.getOriginalFilename();
            String filePath = "uploads/" + fileName;
            File dest = new File(filePath);
            file.transferTo(dest);
            
            Map<String, String> result = new HashMap<>();
            result.put("fileName", fileName);
            result.put("filePath", filePath);
            result.put("fileSize", file.getSize() + " bytes");
            
            return ApiResponse.success(result);
        } catch (IOException e) {
            return ApiResponse.error(500, "文件上传失败：" + e.getMessage());
        }
    }
    
    @PostMapping("/uploads")
    public ApiResponse<List<Map<String, String>>> uploadFiles(
            @RequestParam("files") MultipartFile[] files) {
        List<Map<String, String>> results = new ArrayList<>();
        
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String filePath = "uploads/" + fileName;
                File dest = new File(filePath);
                file.transferTo(dest);
                
                Map<String, String> result = new HashMap<>();
                result.put("fileName", fileName);
                result.put("filePath", filePath);
                result.put("fileSize", file.getSize() + " bytes");
                results.add(result);
            }
        }
        
        return ApiResponse.success(results);
    }
    
    @GetMapping("/download/{fileName}")
    public void downloadFile(@PathVariable String fileName, HttpServletResponse response) {
        File file = new File("uploads/" + fileName);
        
        if (!file.exists()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", 
                         "attachment; filename=\"" + fileName + "\"");
        
        try (FileInputStream in = new FileInputStream(file);
             OutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } finally {
            in.close();
            out.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
```

**步骤3：创建文件上传页面**
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>文件上传</title>
    <style>
        .upload-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .upload-form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        .form-group {
            display: flex;
            flex-direction: column;
        }
        .form-group label {
            margin-bottom: 5px;
            font-weight: bold;
        }
        .btn {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .result {
            margin-top: 20px;
            padding: 15px;
            background-color: #f8f9fa;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="upload-container">
        <h2>文件上传</h2>
        
        <form class="upload-form" action="/api/files/upload" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label>选择文件：</label>
                <input type="file" name="file" required>
            </div>
            <button type="submit" class="btn">上传</button>
        </form>
        
        <form class="upload-form" action="/api/files/uploads" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label>选择多个文件：</label>
                <input type="file" name="files" multiple required>
            </div>
            <button type="submit" class="btn">批量上传</button>
        </form>
        
        <div class="result" id="uploadResult"></div>
    </div>
    
    <script>
        document.querySelector('.upload-form').addEventListener('submit', async function(e) {
            e.preventDefault();
            const formData = new FormData(this);
            const resultDiv = document.getElementById('uploadResult');
            
            try {
                const response = await fetch(this.action, {
                    method: 'POST',
                    body: formData
                });
                const data = await response.json();
                
                if (data.code === 200) {
                    resultDiv.innerHTML = `
                        <h3>上传成功</h3>
                        <p>文件名：${data.data.fileName}</p>
                        <p>文件路径：${data.data.filePath}</p>
                        <p>文件大小：${data.data.fileSize}</p>
                    `;
                } else {
                    resultDiv.innerHTML = `<h3>上传失败</h3><p>${data.message}</p>`;
                }
            } catch (error) {
                resultDiv.innerHTML = `<h3>上传错误</h3><p>${error.message}</p>`;
            }
        });
    </script>
</body>
</html>
```

### 实操步骤2.6：实现Thymeleaf模板

**步骤1：创建模板页面**
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
    <div class="container">
        <h1>用户管理</h1>
        
        <table class="user-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>用户名</th>
                    <th>邮箱</th>
                    <th>年龄</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <tr th:each="user : ${users}">
                    <td th:text="${user.id}">1</td>
                    <td th:text="${user.username}">张三</td>
                    <td th:text="${user.email}">zhangsan@example.com</td>
                    <td th:text="${user.age}">25</td>
                    <td>
                        <a th:href="@{/api/users/{id}(id=${user.id})}">编辑</a>
                        <a th:href="@{/api/users/{id}(id=${user.id})}" 
                           onclick="return confirm('确定删除？')">删除</a>
                    </td>
                </tr>
            </tbody>
        </table>
        
        <a href="/api/users/add" class="btn">添加用户</a>
    </div>
    
    <script src="/static/js/app.js"></script>
</body>
</html>
```

**步骤2：创建模板片段**
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>模板片段</title>
</head>
<body>
    <div th:fragment="header">
        <header>
            <h1>用户管理系统</h1>
            <nav>
                <a href="/">首页</a>
                <a href="/api/users">用户列表</a>
                <a href="/api/users/add">添加用户</a>
            </nav>
        </header>
    </div>
    
    <div th:fragment="footer">
        <footer>
            <p>&copy; 2024 用户管理系统</p>
        </footer>
    </div>
</body>
</html>
```

**步骤3：使用模板片段**
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
</head>
<body>
    <div th:replace="~{fragments/header :: header}"></div>
    
    <div class="container">
        <h1>用户列表</h1>
        <!-- 用户表格内容 -->
    </div>
    
    <div th:replace="~{fragments/footer :: footer}"></div>
</body>
</html>
```

### 实操步骤2.7：实现WebFlux响应式编程

**步骤1：创建WebFlux控制器**
```java
@RestController
@RequestMapping("/api/webflux")
public class WebFluxController {
    
    @GetMapping("/users")
    public Flux<User> getAllUsers() {
        return Flux.just(
            new User(1L, "张三", "zhangsan@example.com", 25),
            new User(2L, "李四", "lisi@example.com", 30),
            new User(3L, "王五", "wangwu@example.com", 28)
        );
    }
    
    @GetMapping("/users/{id}")
    public Mono<User> getUserById(@PathVariable Long id) {
        return Mono.just(new User(id, "用户" + id, "user" + id + "@example.com", 25));
    }
    
    @PostMapping("/users")
    public Mono<User> createUser(@RequestBody User user) {
        return Mono.just(user);
    }
    
    @GetMapping("/stream")
    public Flux<String> streamUsers() {
        return Flux.interval(Duration.ofMillis(100))
                .map(sequence -> "User " + sequence)
                .take(10);
    }
}
```

**步骤2：创建WebFlux配置**
```java
@Configuration
public class WebFluxConfig {
    
    @Bean
    public NettyRouteProvider nettyRouteProvider() {
        return new NettyRouteProvider();
    }
    
    @Bean
    public WebFluxConfigurer webFluxConfigurer() {
        return new WebFluxConfigurer() {
            @Override
            public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
                configurer.defaultCodecs([new CharSequenceCodec()]);
            }
        };
    }
}
```

**步骤3：测试WebFlux端点**
```bash
# 测试Flux端点
curl "http://localhost:8080/api/webflux/users"

# 测试Mono端点
curl "http://localhost:8080/api/webflux/users/1"

# 测试流式端点
curl "http://localhost:8080/api/webflux/stream"
```

### 实操步骤2.8：实现安全配置

**步骤1：添加Spring Security依赖**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

**步骤2：创建安全配置类**
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/static/**", "/api/public/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login")
                .permitAll()
            )
            .csrf(csrf -> csrf.disable())
            .build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

**步骤3：创建用户详情服务**
```java
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRoles())
                .build();
    }
}
```

---

## 📊 阶段检查点

### 理论掌握检查
- [ ] 理解Spring MVC 3.0的高级特性
- [ ] 掌握Thymeleaf模板引擎
- [ ] 了解响应式编程WebFlux
- [ ] 掌握文件上传实现

### 实践能力检查
- [ ] 能够开发完整的Web应用
- [ ] 能够实现文件上传下载
- [ ] 能够使用Thymeleaf开发动态页面
- [ ] 能够实现基本的安全配置

### 问题解决能力检查
- [ ] 能够解决前端集成问题
- [ ] 能够解决文件上传问题
- [ ] 能够解决模板渲染问题

---

## 🎯 阶段总结

完成本阶段学习后，你已经掌握了Spring Boot 3.0的Web开发进阶知识，能够开发功能完整的Web应用，包括文件上传、模板引擎、响应式编程等高级特性。这为后续的数据访问和高级特性学习奠定了坚实的基础。

**下一步：** 进入第三阶段 - 数据访问与缓存，学习JPA、MyBatis、MongoDB、Redis等数据访问技术。
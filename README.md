# example-spring-boot-grpc

### 什么是gRPC

gRPC 是Google发起的一个开源远程过程调用 系统。该系统基于HTTP/2 协议传输，使用**Protocol Buffers** 作为接口描述语言。 其他功能： 认证 双向流 流控制 过期 最常见的应用场景是： 微服务框架下，多种语言服务之间的高效交互。 将手机服务、浏览器连接至后台 产生高效的客户端库。

**简单来说就是，基于Protocol Buffers通信协议的RPC框架**

#### 支持的客户端语言

-   Android
    
-   C#
    
-   C++
    
-   Dart
    
-   Go
    
-   Java
    
-   Objective-C
    
-   PHP
    
-   Python
    
-   Ruby
    
-   Web


### 运行

1. 导入IDEA
2. 执行gradle generateProto
3. 启动ExampleGrpcApplication
4. 访问http://localhost:8080/

查看控制台

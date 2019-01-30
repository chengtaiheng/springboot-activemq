# springboot-activemq
## 这是一个springboot项目与activemq简单整合的项目
### 步骤如下
>第一步 安装一个activemq
>
>第二步配置application.yml
>
**修改activemq配置中相应的**
+ ip
+ 端口
+ 用户名
+ 密码
>第三步启动项目
>
>第四步访问接口（默认端口号是1667）
 ip/activemq/send-message
 **有两个参数**
 + messgae：要发送的信息
 + delayTime：延迟时间（时间为0或者负数的时候无延迟） 
 >
 >查看验证
 访问接口成功以后，会返回一个json字符串，格式如下
**{
    "message": "加油，泰恒"
}**
 

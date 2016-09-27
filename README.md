# ShaBoService
SpringBoot生产项目

## 软件环境
1.数据库使用mysql 5.6版本
2.java 8U91
3.默认端口8088

## api列表
## 返回格式统一说明
返回的信息都由com.shabo.shaboservice.entity.StMessage序列化而成
其中 state为状态码，1为成功，0为失败，-1为服务内部错误
还包括一个时间戳（UNIX）,每一个具体需要返回的信息都由addMessage方法放入message（Map）里面，最后序列化的结果作为统一返回结果
### 用户登录注册类（/userhandle）
1.用户注册 (/singup,post)
需提交参数 username,password
普通返回
2.用户登录（/singin,post）
需提交参数 username,password
返回示例:{
       "state": 1,
       "time": 1474947713294,
       "message": {
         "token": "CiEshr9qHBy3k88tFO9uSw==" //token是以后通信的凭证
       }
     }

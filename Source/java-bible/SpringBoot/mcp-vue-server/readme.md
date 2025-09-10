### 1. Login
```
Url: http://localhost:8090/doLogin
POST
username: kg
password: 123
```

&nbsp;

### 2. Logout
```
Url: http://localhost:8090/logout
GET
logout 接口 是 spring security 默认的注销接口，我们也可以配置自己的
eg:
.logout()
.logoutUrl("/syslogout")
```

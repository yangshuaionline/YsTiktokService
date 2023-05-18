### 接口
域名 http://192.168.1.207:8080
登录获取验证码 http://192.168.1.207:8080/login/getCode
> 1. 请求形式GET
> 2. 参数 phone 类型 String 必传
> 3. 参数 code_type 类型 int 0为app 1为运营后台 必传

登录接口  http://192.168.1.207:8080/login/setLogin
> 1. 请求形式GET
> 2. 参数 phone 手机号 类型 String 必传
> 3. 参数 code 验证码 类型 int 必传
> 4. 参数 login_type 类型 int 0为app 1为运营后台 必传


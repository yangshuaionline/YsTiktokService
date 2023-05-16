package yang.shuai.ys_tiktok_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan//filter拦截生效
@MapperScan("yang.shuai.ys_tiktok_service.mapper")//扫描调用mapper的class文件
@SpringBootApplication
public class YsTiktokServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(YsTiktokServiceApplication.class, args);
    }

}

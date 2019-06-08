package cn.boommanpro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/6/8 17:51
 * @since 1.0.0
 */
@Slf4j
@SpringBootApplication
public class AdminPlatformApplication {
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext context = new SpringApplication(AdminPlatformApplication.class).run(args);
        ServerProperties serverProperties = context.getBean(ServerProperties.class);
        Integer port = Optional.ofNullable(serverProperties.getPort()).orElse(8080);
        String contextPath = Optional.ofNullable(serverProperties.getServlet().getContextPath()).orElse("");
        String inetAddress = InetAddress.getLocalHost().getHostAddress();
      log.info("<------------------------ http://{}:{}{}/ ------------------------>",inetAddress,port,contextPath);
    }
}

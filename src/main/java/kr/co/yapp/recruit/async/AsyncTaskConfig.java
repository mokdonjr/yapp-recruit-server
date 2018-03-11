package kr.co.yapp.recruit.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncTaskConfig {

	/**
	 * 
	 * @author seungchanbaeg
	 * 2018.03.10
	 * 지원자에게 이메일을 비동기적으로 전송 
	 *
	 */
	@Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);
        taskExecutor.initialize();
        return taskExecutor;
    }
}

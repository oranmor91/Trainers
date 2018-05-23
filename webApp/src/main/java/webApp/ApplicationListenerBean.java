package webApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.trainer.manager.impl.StartUpManagerImpl;

public class ApplicationListenerBean implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ApplicationContext applicationContext = ((ContextRefreshedEvent) event).getApplicationContext();
        StartUpManagerImpl startBean = applicationContext.getBean(StartUpManagerImpl.class);
        startBean.start();
	}

}

package com.fundamentos.fundamentos;

import com.fundamentos.fundamentos.bean.MyBean;
import com.fundamentos.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.fundamentos.component.ComponentDependency;
import com.fundamentos.fundamentos.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	// Inyectar dependencia
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	//Constructor
	//Inyectamos nuestra dependencia
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + " - " + userPojo.getPassword());
		try {
			// error
		} catch (Exception e) {
			LOGGER.error("Esto es un error del aplicativo");
		}
	}
}

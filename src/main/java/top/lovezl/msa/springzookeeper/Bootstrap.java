package top.lovezl.msa.springzookeeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.lovezl.msa.springzookeeper.bean.User;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class Bootstrap {
	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private ConsumerClient consumerClient;
	public static void main(String[] args) {
		SpringApplication.run(Bootstrap.class, args);
	}

	@RequestMapping("/{user_id}")
	@ResponseBody
	public User hello(@PathVariable("user_id") int user_id) {
		/**
		 * 服务发现：1. discoveryClient 2. Feign 3. RestTemplate
		 *
		 */
		List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("spring-zookeeper");
		System.out.println(serviceInstanceList.size());
		User user = new User();
		user.setId(user_id);
		user.setName("xuhe");
		user.setAge(28);
		return user;
	}

	@RequestMapping("/hello1")
	public String hello1() {
		return consumerClient.get(1);
	}
}

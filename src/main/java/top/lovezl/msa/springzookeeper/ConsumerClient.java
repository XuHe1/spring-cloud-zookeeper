package top.lovezl.msa.springzookeeper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Desc: ConsumerClient
 * Author: xuhe
 * Date: 2018/10/8 下午5:02
 * Version: 1.0
 */
@FeignClient(value = "spring-zookeeper", fallback = ConsumerClientImpl.class)
public interface ConsumerClient {
    @GetMapping(value = "/{user_id}")
    String get(@PathVariable("user_id") int user_id);
}

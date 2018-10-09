package top.lovezl.msa.springzookeeper;

import org.springframework.stereotype.Service;

/**
 * Desc: ConsumerClientImpl
 * Author: xuhe
 * Date: 2018/10/8 下午5:07
 * Version: 1.0
 */
@Service
public class ConsumerClientImpl implements ConsumerClient{

    @Override
    public String get(int user_id) {
        return "error";
    }
}

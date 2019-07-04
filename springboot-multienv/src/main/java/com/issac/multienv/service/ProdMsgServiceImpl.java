package com.issac.multienv.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author: ywy
 * @date: 2019-07-01
 * @desc:
 */
@Service
@Profile("prod")
public class ProdMsgServiceImpl implements MsgService {
    @Override
    public String send() {
        System.out.println("--------- ProdMsgServiceImpl -----------");
        return "prod";
    }
}

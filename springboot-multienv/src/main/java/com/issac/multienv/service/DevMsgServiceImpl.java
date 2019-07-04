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
@Profile("dev")
public class DevMsgServiceImpl implements MsgService {
    @Override
    public String send() {
        System.out.println("--------- DevMsgServiceImpl -----------");
        return "dev";
    }
}

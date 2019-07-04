package com.issac.multienv.controller;

import com.issac.multienv.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author: ywy
 * @date: 2019-07-01
 * @desc:
 */
@RestController
public class MsgController {

    @Autowired
    private MsgService msgService;

    @GetMapping("/send")
    public String sendHandler() {
        return msgService.send();
    }

}

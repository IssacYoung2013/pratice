package com.issac.ssm.design_pattern.adapter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-27
 * @desc:
 */
public class HotelTest {

    @Test
    public void test() {
        GJBZSocket socket = new SocketAdapter(new GBSocketImpl());
        socket.charge();
    }
}
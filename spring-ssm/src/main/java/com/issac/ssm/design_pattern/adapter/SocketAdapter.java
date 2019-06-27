package com.issac.ssm.design_pattern.adapter;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-27
 * @desc: 适配器 将不同类型的 socket 都适配成gjbz适配器
 */
public class SocketAdapter implements GJBZSocket {

    private Object gbSocket;

    public SocketAdapter(Object gbSocket) {
        this.gbSocket = gbSocket;
    }

    @Override
    public void charge() {
        if(gbSocket instanceof GBSocket) {
            ((GBSocket)gbSocket).charge();
        } else if(gbSocket instanceof DBSocket) {
            ((DBSocket)gbSocket).charge();
        }
    }
}

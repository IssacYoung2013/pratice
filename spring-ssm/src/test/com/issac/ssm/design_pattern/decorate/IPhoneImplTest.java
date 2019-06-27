package com.issac.ssm.design_pattern.decorate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-27
 * @desc:
 */
public class IPhoneImplTest {

    @Test
    public void test() {
        Phone phone = new IPhoneDecorate(new IPhoneImpl());
        phone.call();
    }
}
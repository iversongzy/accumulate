package org.lgt.design;

/**
 * @Description
 * @Author liuguotai
 * @Date2021/1/29 21:29
 **/
public class NaiveMerchant extends MerChan{
    @Override
    public Double actionPrice(double price, Custom customer) {
        return new Double(1.1);
    }
}

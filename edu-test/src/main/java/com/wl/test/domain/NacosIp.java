package com.wl.test.domain;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * nacos ip
 * @author 南顾北衫
 */
public class NacosIp {
    public static void main(String[] args) throws SocketException {
        String s="网卡名：%s,展示名：%s;IP:%s";
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()){
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            System.out.println(String.format(s,networkInterface.getName(),networkInterface.getDisplayName(),networkInterface.getInetAddresses().nextElement().getHostAddress()));

        }
    }
}

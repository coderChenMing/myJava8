package com.learn.java8.example;

import javax.net.ssl.SNIServerName;
import java.util.Collections;
import java.util.List;

/**
 * Project: myJava8
 * File Created at 2022-05-05 10:51:10:51
 * {@link}
 * 代码review 看看有多少问题
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type ServerNameSpec.java
 * @Description
 * @date 2022/5/5 10:51
 */
class ServerNameSpec {
    final List serverNames;

    ServerNameSpec(List serverNames) {
        this.serverNames = Collections.unmodifiableList(serverNames);
    }

    public void addServerName(SNIServerName serverName) {
        serverNames.add(serverName);
    }

    public String toString() {
        if (serverNames == null || serverNames.isEmpty())
            return "<no server name indicator specified>";

        StringBuilder builder = new StringBuilder(512);
        /*for (SNIServerName sn : serverNames) {
            builder.append(sn.toString());
            builder.append("\n");
        }*/

        return builder.toString();
    }
}

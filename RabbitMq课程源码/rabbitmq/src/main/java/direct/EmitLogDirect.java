/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.
 *
   Copyright 2007-2015 Pivotal Software, Inc.
   https://github.com/rabbitmq/rabbitmq-tutorials
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       https://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package direct;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 描述：     direct类型的交换机，发送消息
 */
public class EmitLogDirect {

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        String message = "info：Hello World!";

        channel.basicPublish(EXCHANGE_NAME, "info", null, message.getBytes("UTF-8"));
        System.out.println("发送了消息，" + "等级为info,消息内容：" + message);

        message = "warning：Hello World!";
        channel.basicPublish(EXCHANGE_NAME, "warning", null, message.getBytes("UTF-8"));
        System.out.println("发送了消息，" + "等级为warning,消息内容：" + message);

        message = "error：Hello World!";
        channel.basicPublish(EXCHANGE_NAME, "error", null, message.getBytes("UTF-8"));
        System.out.println("发送了消息，" + "等级为error,消息内容：" + message);
        channel.close();
        connection.close();
    }
}

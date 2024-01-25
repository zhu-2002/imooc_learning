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
package topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 描述：     topic模式交换机，发送消息
 */
public class EmitLogTopic {

    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        String message = "Animal World";

        String[] routingKeys = new String[9];
        routingKeys[0] = "quick.orange.rabbit";
        routingKeys[1] = "lazy.orange.elephant";
        routingKeys[2] = "quick.orange.fox";
        routingKeys[3] = "lazy.brown.fox";
        routingKeys[4] = "lazy.pink.rabbit";
        routingKeys[5] = "quick.brown.fox";
        routingKeys[6] = "orange";
        routingKeys[7] = "quick.orange.male.rabbit";
        routingKeys[8] = "lazy.orange.male.rabbit";

        for (int i = 0; i < routingKeys.length; i++) {
            channel.basicPublish(EXCHANGE_NAME, routingKeys[i], null, message.getBytes("UTF-8"));
            System.out.println("发送了：" + message+" routingKey:"+routingKeys[i]);
        }

        channel.close();
        connection.close();
    }
}

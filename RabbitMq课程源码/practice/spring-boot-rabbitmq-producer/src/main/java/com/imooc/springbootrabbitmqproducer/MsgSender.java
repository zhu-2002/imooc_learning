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
package com.imooc.springbootrabbitmqproducer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述：     发送消息
 */
@Component
public class MsgSender {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    public void send1() {
        String message = "This is message 1, routing key is dog.red";
        System.out.println("发送了："+message);
        this.rabbitmqTemplate.convertAndSend("bootExchange", "dog.red", message);
    }

    public void send2() {
        String message = "This is message 2, routing key is dog.black";
        System.out.println("发送了："+message);
        this.rabbitmqTemplate.convertAndSend("bootExchange", "dog.black", message);
    }
}

package org.nh.mq.common.constants;

/**
 * @program: MqConstants.java
 * @description:
 * @author: yindanqing
 * @create: 2020/6/22 10:41
 */
public interface MqConstants {

    String FEEDBACK = "success";

    String DIRECT_EXCHANGE = "DIRECT_EXCHANGE";

    String DIRECT_EXCHANGE_ROUTINGKEY_LIFE = "DIRECT_LIFE";

    String DIRECT_EXCHANGE_ROUTINGKEY_WORK = "DIRECT_WORK";

    String DIRECT_QUEUE_LIFE = "DIRECT_QUEUE_LIFE";

    String DIRECT_QUEUE_WORK = "DIRECT_QUEUE_WORK";



    String FANOUT_EXCHANGE = "FANOUT_EXCHANGE";

    String FANOUT_EXCHANGE_ROUTINGKEY_LIFE = "FANOUT_LIFE";

    String FANOUT_EXCHANGE_ROUTINGKEY_WORK = "FANOUT_WORK";

    String FANOUT_QUEUE_LIFE = "FANOUT_QUEUE_LIFE";

    String FANOUT_QUEUE_WORK = "FANOUT_QUEUE_WORK";

}

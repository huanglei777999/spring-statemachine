package com.example.statemachine.controller;

import com.example.statemachine.enmu.Events;
import com.example.statemachine.enmu.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @BelongProjecet statemachine
 * @BelongPackage com.example.statemachine.controller
 * @Description:
 * @Copyright 2019 赢鼎教育 - Powered By 研发二组
 * @Author: huanglei
 * @Date: 2019-07-26 10:52
 * @Version V1.0
 */
@RestController
public class StateMachineController {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    /**
     * 我们定义了整个流程的处理过程，其中start()就是创建这个订单流程，
     * 根据之前的定义，该订单会处于待支付状态，然后通过调用sendEvent(Events.PAY)执行支付操作，
     * 最后通过掉用sendEvent(Events.RECEIVE)来完成收货操作
     */
    @GetMapping("/test/statemachine")
    public void testStateMachine(){
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);
    }
}

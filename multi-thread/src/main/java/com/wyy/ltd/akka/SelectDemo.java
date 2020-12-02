package com.wyy.ltd.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * 根据路径远程调用
 */
public class SelectDemo {
    public static void main(String[] args) {
        ActorSystem remote = ActorSystem.create("remote");
        remote.actorOf(Props.create(ActorToActor.Actor_2.class),"remote_1");
        remote.actorOf(Props.create(ActorToActor.Actor_2.class),"remote_2");

        //可以匹配地址
        ActorSelection actorSelection = remote.actorSelection("akka://remote/user/remote*");
        actorSelection.tell(new Person("远程调用"), ActorRef.noSender());
    }
}

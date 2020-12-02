package com.wyy.ltd.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.japi.pf.FI;
import akka.japi.pf.ReceiveBuilder;

public class AkkaStart {
    public static void main(String[] args) {
        //actor的管理者
        ActorSystem actorSystem = ActorSystem.create("admin");
        ActorRef actorRef = actorSystem.actorOf(Props.create(AkkaActor.class), "actorName");
        actorRef.tell(new Person("张三"),ActorRef.noSender());
        
    }
    //定义一个actor
    static class AkkaActor extends AbstractActor{
        //接收消息并处理
        @Override
        public Receive createReceive() {
            ReceiveBuilder match = receiveBuilder().match(Person.class, new FI.UnitApply<Person>() {
                @Override
                public void apply(Person person) throws Exception {
                    System.out.println("this is AkkaActor");
                    ActorRef sender = getSender();
//                    System.out.println(sender);
                    person.name = "改了";
                    Thread.sleep(500);
                    sender.tell(person,getSelf()); //返回处理结果给sender
                    System.out.println(Thread.currentThread().getName() + " --> " + person.name);
                }
            });
            return match.build();
        }
    }
}
class Person{
    int age;
    String name;

    public Person(String name) {
        this.name = name;
    }
}
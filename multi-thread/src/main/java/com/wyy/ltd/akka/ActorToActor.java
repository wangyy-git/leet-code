package com.wyy.ltd.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.japi.pf.FI;
import akka.japi.pf.ReceiveBuilder;
import akka.pattern.Patterns;
import scala.Function1;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;
import scala.util.Try;

public class ActorToActor {
    public static void main(String[] args) {
        //actor的管理者
        ActorSystem actorSystem = ActorSystem.create("admin2");
        ActorRef actorRef = actorSystem.actorOf(Props.create(Actor_2.class), "actor2Name");
        actorRef.tell(new Person("李四"),ActorRef.noSender());
    }

    static class Actor_2 extends AbstractActor {
        //接收消息并处理
        @Override
        public Receive createReceive() {
            ReceiveBuilder match = receiveBuilder().match(Person.class, new FI.UnitApply<Person>() {
                @Override
                public void apply(Person person) throws Exception {
                    System.out.println("这是actor_2,param -> " + person.name);
                    //根据上下文创建之前的actor的引用 从而调用 防止调用者对actor逻辑的更改 这里是异步调用
                    ActorRef ref = getContext().actorOf(Props.create(AkkaStart.AkkaActor.class));
                    System.out.println(ref);
                    //tell 方法是异步调用
//                    ref.tell(new Person(person.name),getSelf());
                    //同步调用
                    Future<Object> future = Patterns.ask(ref, person, 10000);
                    future.onComplete(new Function1<Try<Object>, Object>() {
                        @Override
                        public Object apply(Try<Object> v1) {
                            Object o = v1.get();
                            System.out.println(o);
                            return null;
                        }
                    }, new ExecutionContext() {
                        @Override
                        public void execute(Runnable runnable) {
                            runnable.run();
                        }

                        @Override
                        public void reportFailure(Throwable cause) {
                            System.out.println(cause);
                        }
                    });
                    
                    System.out.println(person.name);
                }
            });
            return match.build();
        }
    }
}

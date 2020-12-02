package com.wyy.ltd.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.japi.pf.FI;

public class BecomeTest {
    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("become");
        ActorRef ref = actorSystem.actorOf(Props.create(BecomeActor.class));
        ref.tell("1",ActorRef.noSender());
        ref.tell("2",ActorRef.noSender());
        ref.tell("3",ActorRef.noSender());
        ref.tell("toC",ActorRef.noSender());
        ref.tell("4",ActorRef.noSender());
        ref.tell("5",ActorRef.noSender());
        ref.tell("unbecomeC",ActorRef.noSender());
        ref.tell("6",ActorRef.noSender());
    }
    static class BecomeActor extends AbstractActor{
        private int count;
        Receive receiveC = receiveBuilder().match(String.class, o -> {
            if (o.equals("unbecomeC")) getContext().unbecome();
            else System.out.println("this is C -> " + o);
        }).build();
        Receive receiveB = receiveBuilder().match(String.class, o -> {
            if (o.equals("toC")) getContext().become(receiveC,false);
            else if (o.equals("unbecomeB")) getContext().unbecome();
            else System.out.println("this is B -> " + o);
        }).build();
        @Override
        public Receive createReceive() {
            return receiveBuilder().matchAny((o)->{
                count++;
                //become之后就会一直使用B 直到unbecome
                if (count == 2) getContext().become(receiveB,false);
                System.out.println("this is A -> " + o);
            }).build();
        }
    }
}

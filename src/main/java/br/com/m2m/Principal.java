package br.com.m2m;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class Principal extends UntypedActor {

	private ActorRef intActorRef = getContext().actorOf(
			new Props(IntActor.class));
	private ActorRef stringActorRef = getContext().actorOf(
			new Props(StringActor.class));

	public Principal(ActorRef intActor, ActorRef stringActorRef) {

		this.intActorRef = intActor;
		this.stringActorRef = stringActorRef;

	}

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof String) {

			System.out.println("mandou mensagem para o ator de string");

		} else if (message instanceof IntActor)

			System.out.println("Inteiro");
	}

	public static void main(String[] args) throws Exception {
		ActorSystem _system = ActorSystem.create("BecomeUnbecome");
		ActorRef atorPrincipal = _system.actorOf(new Props(Principal.class),"principal");
		atorPrincipal.tell("2");
		Thread.sleep(2000);
		_system.shutdown();
	}

}

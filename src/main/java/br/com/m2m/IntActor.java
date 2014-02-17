package br.com.m2m;

import akka.actor.UntypedActor;

public class IntActor extends UntypedActor{
	
	
	@Override
	public void onReceive(Object message) throws Exception {
		
		if(message instanceof Integer){
			System.out.println("Ator de inteiros");
		}
		
	}

}

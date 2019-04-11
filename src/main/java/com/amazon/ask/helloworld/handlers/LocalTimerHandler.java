package com.amazon.ask.helloworld.handlers;

import java.time.LocalDateTime;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

public class LocalTimerHandler implements RequestHandler{
	
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("timeIntent"));
     }

     public Optional<Response> handle(HandlerInput input) {
    	 
    	 LocalDateTime now = LocalDateTime.now();
    	 
         String speechText = "It is " + now.getHour() + " and " + now.getMinute();
         
         return input.getResponseBuilder()
                 .withSpeech(speechText)
                 .withSimpleCard("Hello Alan", speechText)
                 .build();
     }
	

}

package com.amazon.ask.helloworld.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

public class LaunchRequestHandler implements RequestHandler {

     public boolean canHandle(HandlerInput input) {
         return input.matches(Predicates.requestType(LaunchRequest.class));
     }

     public Optional<Response> handle(HandlerInput input) {
         String speechText = "Welcome to the Dragon, you can say hello dragon";
         return input.getResponseBuilder()
                 .withSpeech(speechText)
                 .withSimpleCard("Dragon Says hi!", speechText)
                 .withReprompt(speechText)
                 .build();
     }

}

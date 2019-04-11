package com.amazon.ask.helloworld.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

public class InventorNameHandler implements RequestHandler {

     public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("inventorNameIntent"));
     }

     public Optional<Response> handle(HandlerInput input) {
         String speechText = "My inventor is Alan Saberi";
         return input.getResponseBuilder()
                 .withSpeech(speechText)
                 .withSimpleCard("Inventor name", speechText)
                 .build();
     }

}

/**
 * 
 */
package com.amazon.ask.helloworld.handlers;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;
import com.scrum.selector.Selector;

/**
 * @author alan.saberi
 *
 */
public class SelectorHandler implements RequestHandler{
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("GetNextpersonIntent"));
     }

     public Optional<Response> handle(HandlerInput input) {
    	 
    	 Selector mySelector = Selector.getInstance();
    	 String nextPerson = mySelector.getNextPerson();
    	   	 
         String speechText = "It is " + nextPerson;
         
         return input.getResponseBuilder()
                 .withSpeech(speechText)
                 .withSimpleCard("Speaker is", speechText)
                 .build();
     }	

}

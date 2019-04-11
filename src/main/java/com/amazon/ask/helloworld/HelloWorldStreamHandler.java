/**
 * 
 */
package com.amazon.ask.helloworld;

/**
 * @author alan.saberi
 *
 */
import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;

import com.amazon.ask.helloworld.handlers.CancelandStopIntentHandler;
import com.amazon.ask.helloworld.handlers.HelloWorldIntentHandler;
import com.amazon.ask.helloworld.handlers.HelpIntentHandler;
import com.amazon.ask.helloworld.handlers.InventorNameHandler;
import com.amazon.ask.helloworld.handlers.SessionEndedRequestHandler;
import com.amazon.ask.helloworld.handlers.LaunchRequestHandler;
import com.amazon.ask.helloworld.handlers.LocalTimerHandler;
import com.amazon.ask.helloworld.handlers.SelectorHandler;

 public class HelloWorldStreamHandler extends SkillStreamHandler {

     private static Skill getSkill() {
         return Skills.standard()
                 .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new HelloWorldIntentHandler(),
                        new LocalTimerHandler(),
                        new SelectorHandler(),
                        new InventorNameHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler()
                        )
                 .build();
     }

     public HelloWorldStreamHandler() {
         super(getSkill());
     }

 }

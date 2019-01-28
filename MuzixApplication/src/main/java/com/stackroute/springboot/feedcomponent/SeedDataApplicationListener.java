//package com.stackroute.springboot.feedcomponent;
//
//
//import com.stackroute.springboot.domain.Track;
//import com.stackroute.springboot.exception.TrackAlreadyExistsException;
//import com.stackroute.springboot.service.TrackService;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//@Component
//
//    @Data
//
//    @Primary
//
//    public class SeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent>
//
//    {
//
//        @Autowired
//
//        Environment environment;
//
//        @Autowired
//
//        TrackService trackService;
//
//        Track feedTrackData=new Track();
//
//
//
//        @Override
//
//        public void onApplicationEvent(ContextRefreshedEvent event)
//
//        {
//
//            feedTrackData.setTId(Integer.parseInt(environment.getProperty("song.1.tId")));
//
//            feedTrackData.setTName(environment.getProperty("song.1.tName"));
//
//            feedTrackData.setTComment(environment.getProperty("song.1.tComment"));
//
//            try {
//
//                trackService.saveTrack(feedTrackData);
//
//            } catch (TrackAlreadyExistsException e) {
//
//                e.printStackTrace();
//
//            }
//
//
//
//            feedTrackData.setTId(Integer.parseInt(environment.getProperty("song.2.tId")));
//
//            feedTrackData.setTName(environment.getProperty("song.2.tName"));
//
//            feedTrackData.setTComment(environment.getProperty("song.2.tComment"));
//
//            try {
//
//                trackService.saveTrack(feedTrackData);
//
//            } catch (TrackAlreadyExistsException e) {
//
//                e.printStackTrace();
//
//            }
//
//
//
//            feedTrackData.setTId(Integer.parseInt(environment.getProperty("song.3.tId")));
//
//            feedTrackData.setTName(environment.getProperty("song.3.tName"));
//
//            feedTrackData.setTComment(environment.getProperty("song.3.tComment"));
//
//            try {
//
//                trackService.saveTrack(feedTrackData);
//
//            } catch (TrackAlreadyExistsException e) {
//
//                e.printStackTrace();
//
//            }
//
//        }
//
//    }
//
//
//

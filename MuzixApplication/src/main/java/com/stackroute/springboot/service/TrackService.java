package com.stackroute.springboot.service;

import com.stackroute.springboot.domain.Track;
import com.stackroute.springboot.exception.TrackAlreadyExistsException;
import com.stackroute.springboot.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public List<Track> getAllTracks();
    public Track deleteTrack(int id) throws TrackNotFoundException;;
    public Track updateTrack(Track track);
    public Track trackFindByName(String name);


}

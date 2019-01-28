package com.stackroute.springboot.domain;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;


@Document(collection="MusicTracks")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "databases generated track id")
    private int tId;
    @ApiModelProperty(notes = "Track name" , required = true)
    private String tName;
    @ApiModelProperty(notes = "do comment about track")
    private String tComment;

    public Track(String tName, String tComment) {
        super();
        this.tName = tName;
        this.tComment = tComment;
   }
}

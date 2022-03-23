package br.com.coddingSchool.model;

import br.com.coddingSchool.validations.ObjectValidator;
import br.com.coddingSchool.validations.StringValidator;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Video extends Activity{

    private String url;
    @Column(name = "video_time")
    private int videoTime;
    private String transcription;

    public Video(String title, String code, Section section, String url, int videoTime, String transcription) {

        super(title, code, section);

        StringValidator.cantBeBlank(url, "The URL can't be empty or null");

        ObjectValidator.cantBeNull(transcription, "The transcription can't be null");

        this.url = url;
        this.transcription = transcription;
        this.videoTime = videoTime;
    }

    public Video() {

    }

    @Override
    public String toString() {
        return "Video{" +
                "url='" + url + '\'' +
                ", videoTime=" + videoTime +
                ", transcription='" + transcription + '\'' +
                '}';
    }
}

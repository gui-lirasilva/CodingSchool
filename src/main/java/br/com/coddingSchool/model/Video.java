package br.com.coddingSchool.model;

import br.com.coddingSchool.validations.ObjectValidator;
import br.com.coddingSchool.validations.StringValidator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Video extends Activity{

    @NotBlank(message = "The URL can't be empty or null")
    private String url;
    @Column(name = "video_time")
    private int videoTime;
    @NotNull(message = "The transcription can't be null")
    private String transcription;

    public Video(String title, String code, Section section, String url, int videoTime, String transcription) {
        super(title, code, section);
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

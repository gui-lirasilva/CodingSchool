package school;

import validations.ObjectValidator;
import validations.StringValidator;

public class Video extends Activity{

    private String url;
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

    @Override
    public String toString() {
        return "Video{" +
                "url='" + url + '\'' +
                ", videoTime=" + videoTime +
                ", transcription='" + transcription + '\'' +
                '}';
    }
}

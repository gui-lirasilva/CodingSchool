package school;

import validations.StringValidator;

public class Video extends Activity{

    private String url;
    private int videoTime;
    private String transcription;

    public Video(String title, String code, Section section, String url, int videoTime, String transcription) {
        super(title, code, section);

        StringValidator.cantBeBlank(url, "The URL can't be empty or null");
        this.url = url;

        StringValidator.cantBeNull(transcription, "The transcription can't be null");
        this.transcription = transcription;

        this.videoTime = videoTime;
    }

    public String getUrl() {
        return url;
    }

    public int getVideoTime() {
        return videoTime;
    }

    public String getTranscription() {
        return transcription;
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

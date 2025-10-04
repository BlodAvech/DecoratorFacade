package Devices;

public class MusicSystem implements Device{

    private boolean isPlaying = false;
    private String currentMusic = "";

    @Override
    public String operate() {
        String log = "Music (" + currentMusic + ") " + (isPlaying ? "already playing" : "start playing");
        isPlaying = true;
        return log;
    }

    public void setMusic(String music)
    {
        isPlaying = true;
        this.currentMusic = music;
        System.out.println("Music switched to " + music);
    }

    public void resetMusic()
    {
        isPlaying = false;
        System.out.println("Music (" + currentMusic + ") is reset");
        this.currentMusic = "";
    }

    public void stopPlaying()
    {
        isPlaying = false;
        System.out.println("Music (" + currentMusic + ") is stop");
    }

    public String getCurrentMusic() {
        return currentMusic;
    }
}

package Devices;

import Enums.MusicVolume;

public class MusicSystem implements Device{

    private boolean isPlaying = false;
    private String currentMusic = "";
    private MusicVolume volume = MusicVolume.MUTE;

    @Override
    public String operate() {
        String log = "Music (" + currentMusic + ") " + (isPlaying ? "already playing" : "start playing") + " Volume(" + volume + ") ";
        isPlaying = true;
        return log;
    }

    public void setVolume(MusicVolume newVolume)
    {
        System.out.println("Volume changed from " + volume + " to " + newVolume);
        volume = newVolume;
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

package main;

import javax.sound.sampled.*;
import java.net.URL;

public class Sound {
    Clip clip;
    URL[] soundURl = new URL[30];

    public Sound() {
        soundURl[0] = getClass().getResource("../res/sound/BlueBoyAdventure.wav");
        soundURl[1] = getClass().getResource("../res/sound/coin.wav");
        soundURl[2] = getClass().getResource("../res/sound/powerup.wav");
        soundURl[3] = getClass().getResource("../res/sound/unlock.wav");
        soundURl[4] = getClass().getResource("../res/sound/fanfare.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURl[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}

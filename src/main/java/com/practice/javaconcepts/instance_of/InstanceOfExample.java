package com.practice.javaconcepts.instance_of;

public class InstanceOfExample {

    public static void main(String[] args) {
        AbstractFile abstractFile = new MusicFile();
        useInstanceOf_OLD(abstractFile);
        useInstanceOf_NEW(abstractFile);
    }

    private static void useInstanceOf_OLD(AbstractFile abstractFile) {
        if (abstractFile instanceof MusicFile) {
            ((MusicFile) abstractFile).playMusic();
        }
    }

    // Since Java14
    private static void useInstanceOf_NEW(AbstractFile abstractFile) {
        if (abstractFile instanceof MusicFile musicFile) musicFile.playMusic();
    }
}

class AbstractFile {
}

class MusicFile extends AbstractFile {
    public void playMusic() {
        System.out.println("Playing music");
    }
}

class VideoFile extends AbstractFile {
    public void playVideo() {
        System.out.println("Playing video");
    }
}

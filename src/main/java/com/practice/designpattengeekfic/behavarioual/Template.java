package com.practice.designpattengeekfic.behavarioual;

public class Template {

    public static void main(String[] args) {
        Template template = new Template();
        template.call();
    }

    private void call() {
        WorldOfWarcraftLoader worldOfWarcraftLoader = new WorldOfWarcraftLoader();
        worldOfWarcraftLoader.load();

        DiabloLoader diabloLoader = new DiabloLoader();
        diabloLoader.load();
    }
}

abstract class BaseGameLoader {

    public void load() {
        byte[] data = loadLocalData();
        createObjects(data);
        downloadAdditionalFiles();
        cleanTempFiles();
        initializeProfiles();
    }

    protected void cleanTempFiles() {
        System.out.println("Cleaning temporary files...");
    }

    protected abstract byte[] loadLocalData();

    protected abstract void createObjects(byte[] data);

    protected abstract void downloadAdditionalFiles();

    protected abstract void initializeProfiles();
}

class WorldOfWarcraftLoader extends BaseGameLoader {

    @Override
    protected byte[] loadLocalData() {
        System.out.println("Loading local data for WorldOfWarcarft...");
        return new byte[0];
    }

    @Override
    protected void createObjects(byte[] data) {
        System.out.println("Creating objects for WorldOfWarcarft...");
    }

    @Override
    protected void downloadAdditionalFiles() {
        System.out.println("Downloading files for WorldOfWarcarft...");
    }

    @Override
    protected void initializeProfiles() {
        System.out.println("Downloading files for WorldOfWarcarft...");
    }
}

class DiabloLoader extends BaseGameLoader {

    @Override
    protected byte[] loadLocalData() {
        System.out.println("Loading local data for Diablo...");
        return new byte[0];
    }

    @Override
    protected void createObjects(byte[] data) {
        System.out.println("Creating objects for Diablo...");
    }

    @Override
    protected void downloadAdditionalFiles() {
        System.out.println("Downloading files for Diablo...");
    }

    @Override
    protected void initializeProfiles() {
        System.out.println("Downloading files for Diablo...");
    }
}

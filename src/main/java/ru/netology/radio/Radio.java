package ru.netology.radio;

public class Radio {
    private int currentRadioStation;
    private int currentVolume;

    public void setCurrentRadioStation(int numberRadio) {
        if (numberRadio < 0) {
            currentRadioStation = 0;
        } else if (numberRadio > 9) {
            currentRadioStation = 9;
        } else {
            currentRadioStation = numberRadio;
        }
    }

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentVolume(int levelVolume) {
        currentVolume = levelVolume;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void nextRadioStation() {
        if (currentRadioStation < 9) {
            currentRadioStation++;
            return;
        }
        if (currentRadioStation == 9) {
            currentRadioStation = 0;
        }
    }

    public void prevRadioStation() {
        if (currentRadioStation > 0) {
            currentRadioStation--;
            return;
        }
        if (currentRadioStation == 0) {
            currentRadioStation = 9;
        }
    }


    public void increaseVolume() {
        if (currentVolume < 10) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}

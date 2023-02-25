package ru.netology.radio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Radio {

    private int maxRadioStation = 9;
    private int minRadioStation = 0;
    private int currentRadioStation = minRadioStation;
    private int maxVolume = 10;
    private int minVolume = 0;
    private int currentVolume = minVolume;

    /*
        public Radio() {

        }
    */
//оставил незакомментированными конструкторы и функции, которых нет в аннотации lombok,
// либо setter'ы без проверки устанавливаемого значения
    public Radio(int size) {
        if (size > 0) {
            maxRadioStation = minRadioStation + size - 1;
        }
    }

    public Radio(int minVolume, int maxVolume) {
        if (minVolume <= maxVolume) {
            this.minVolume = minVolume;
            this.maxVolume = maxVolume;
            this.currentVolume = minVolume;
        }
    }

    public void setCurrentRadioStation(int numberRadio) {
        if (numberRadio < minRadioStation) {
            currentRadioStation = minRadioStation;
        } else if (numberRadio > maxRadioStation) {
            currentRadioStation = maxRadioStation;
        } else {
            currentRadioStation = numberRadio;
        }
    }

    /*
        public int getCurrentRadioStation() {
            return currentRadioStation;
        }
    */
    public void setCurrentVolume(int levelVolume) {
        if (levelVolume < minVolume) {
            currentVolume = minVolume;
        } else if (levelVolume > maxVolume) {
            currentVolume = maxVolume;
        } else {
            currentVolume = levelVolume;
        }
    }
/*
    public int getCurrentVolume() {
        return currentVolume;
    }
*/

    public void nextRadioStation() {
        currentRadioStation = currentRadioStation >= maxRadioStation ? minRadioStation : currentRadioStation + 1;
    }

    public void prevRadioStation() {
        currentRadioStation = currentRadioStation <= minRadioStation ? maxRadioStation : currentRadioStation - 1;
    }

    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > minVolume) {
            currentVolume--;
        }
    }
}

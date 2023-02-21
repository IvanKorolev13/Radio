package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    //тесты на ввод значений радиостанции,
    // граничные значений (-1, 0, 1, 8, 9, 10)
    @Test
    public void radioStationSetOutLowerBorder() { //ввод значения ниже нижней границы (за пределами границ)
        Radio inputStation = new Radio();
        inputStation.setCurrentRadioStation(-1);

        int expected = 0;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioStationSetOutUpperBorder() { //ввод значения выше верхней границы (за пределами границ)
        Radio inputStation = new Radio();
        inputStation.setCurrentRadioStation(10);

        int expected = 9;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioStationSetInLowerBorder() { //ввод значения на нижней границы
        Radio inputStation = new Radio();
        inputStation.setCurrentRadioStation(0);

        int expected = 0;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioStationSetInUpperBorder() { //ввод значения на верхней границы
        Radio inputStation = new Radio();
        inputStation.setCurrentRadioStation(9);

        int expected = 9;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioStationSetAboveLowerBorder() { //ввод значения выше нижней границы
        Radio inputStation = new Radio();
        inputStation.setCurrentRadioStation(1);

        int expected = 1;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioStationSetBelowUpperBorder() { //ввод значения ниже верхней границы
        Radio inputStation = new Radio();
        inputStation.setCurrentRadioStation(8);

        int expected = 8;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    //тесты на работу следующий и предыдущий,
    // предыдущий- от 0 и 1,
    // следующий- от 8 и 9
    @Test
    public void radioStationEqualLowerBorderAndPullPrev() { //значения равное нижней границы и предыдущий
        Radio inputStation = new Radio();
        inputStation.setCurrentRadioStation(0);
        inputStation.prevRadioStation();

        int expected = 9;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioStationAboveLowerBorderAndPullPrev() { //ввод значения выше нижней границы и предыдущий
        Radio inputStation = new Radio();
        inputStation.setCurrentRadioStation(1);
        inputStation.prevRadioStation();

        int expected = 0;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioStationEqualUpperBorderAndPullNext() { //ввод значения равное верхней границы и следущее
        Radio inputStation = new Radio();
        inputStation.setCurrentRadioStation(9);
        inputStation.nextRadioStation();

        int expected = 0;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioStationBelowUpperBorderAndPullNext() { //ввод значения ниже верхней границы и следущее
        Radio inputStation = new Radio();
        inputStation.setCurrentRadioStation(8);
        inputStation.nextRadioStation();

        int expected = 9;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    //тесты работу увеличения и уменьшения громкости,
    // уменьшение- от 0 и 1
    // увеличение- от 9 и 10
    @Test
    public void volumeEqualLowerBorderAndPullMinus() { //значения равное нижней границы и увеличение
        Radio inputVolume = new Radio();
        inputVolume.setCurrentVolume(0);
        inputVolume.decreaseVolume();

        int expected = 0;
        int actual = inputVolume.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeAboveLowerBorderAndPullMinus() { //значения выше нижней границы и увеличение
        Radio inputVolume = new Radio();
        inputVolume.setCurrentVolume(1);
        inputVolume.decreaseVolume();

        int expected = 0;
        int actual = inputVolume.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeEqualUpperBorderAndPullPlus() { //значения равное верхней границы и уменьшение
        Radio inputVolume = new Radio();
        inputVolume.setCurrentVolume(10);
        inputVolume.increaseVolume();

        int expected = 10;
        int actual = inputVolume.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeBelowUpperBorderAndPullPlus() { //значения ниже верхней границы и уменьшение
        Radio inputVolume = new Radio();
        inputVolume.setCurrentVolume(9);
        inputVolume.increaseVolume();

        int expected = 10;
        int actual = inputVolume.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }
}
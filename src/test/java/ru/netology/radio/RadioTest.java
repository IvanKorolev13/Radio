package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio inputStation = new Radio(30);
    Radio inputVolume = new Radio(0, 100);
    //тесты на ввод значений радиостанции
    // граничные значений (-1, 0, 1, 8, 9, 10)- новые значения (-1, 0, 1, 28, 29, 30)
    @Test
    public void radioStationSetOutLowerBorder() { //ввод значения ниже нижней границы (за пределами границ)
        inputStation.setCurrentRadioStation(-1);

        int expected = 0;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioStationSetOutUpperBorder() { //ввод значения выше верхней границы (за пределами границ)
        inputStation.setCurrentRadioStation(30);

        int expected = 29;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioStationSetInLowerBorder() { //ввод значения на нижней границы
        inputStation.setCurrentRadioStation(0);

        int expected = 0;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioStationSetInUpperBorder() { //ввод значения на верхней границы
        inputStation.setCurrentRadioStation(29);

        int expected = 29;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioStationSetAboveLowerBorder() { //ввод значения выше нижней границы
        inputStation.setCurrentRadioStation(1);

        int expected = 1;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioStationSetBelowUpperBorder() { //ввод значения ниже верхней границы
        inputStation.setCurrentRadioStation(28);

        int expected = 28;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    //тесты на работу следующий и предыдущий,
    // предыдущий- от 0 и 1,
    // следующий- от 28 и 29
    @Test
    public void radioStationEqualLowerBorderAndPullPrev() { //значения равное нижней границы и предыдущий
        inputStation.setCurrentRadioStation(0);
        inputStation.prevRadioStation();

        int expected = 29;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioStationAboveLowerBorderAndPullPrev() { //ввод значения выше нижней границы и предыдущий
        inputStation.setCurrentRadioStation(1);
        inputStation.prevRadioStation();

        int expected = 0;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioStationEqualUpperBorderAndPullNext() { //ввод значения равное верхней границы и следущее
        inputStation.setCurrentRadioStation(29);
        inputStation.nextRadioStation();

        int expected = 0;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioStationBelowUpperBorderAndPullNext() { //ввод значения ниже верхней границы и следущее
        inputStation.setCurrentRadioStation(28);
        inputStation.nextRadioStation();

        int expected = 29;
        int actual = inputStation.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    //тесты работу увеличения и уменьшения громкости,
    // уменьшение- от 0 и 1
    // увеличение- от 99 и 100
    @Test
    public void volumeEqualLowerBorderAndPullMinus() { //значения равное нижней границы и увеличение
        inputVolume.setCurrentVolume(0);
        inputVolume.decreaseVolume();

        int expected = 0;
        int actual = inputVolume.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeAboveLowerBorderAndPullMinus() { //значения выше нижней границы и увеличение
        inputVolume.setCurrentVolume(1);
        inputVolume.decreaseVolume();

        int expected = 0;
        int actual = inputVolume.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeEqualUpperBorderAndPullPlus() { //значения равное верхней границы и уменьшение
        inputVolume.setCurrentVolume(100);
        inputVolume.increaseVolume();

        int expected = 100;
        int actual = inputVolume.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeBelowUpperBorderAndPullPlus() { //значения ниже верхней границы и уменьшение
        inputVolume.setCurrentVolume(99);
        inputVolume.increaseVolume();

        int expected = 100;
        int actual = inputVolume.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }
}
package com.silvesters.fulls.texttime;

public class TextTime {
    private final int WORDS_PER_MINUTE = 275;

    private String text;
    private int hours;
    private int minutes;
    private int seconds;
    private int wordCount;

    public TextTime(String text)
    {
        if (text.length() == 0)
        {
            throw new IllegalArgumentException();
        }

        this.text = text;

        calculateTime();
    }

    private void calculateTime() {
        float milliseconds = averageReadMinutes(wordCount()) * 60 * 1000;

        hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
        minutes = (int) ((milliseconds) / (1000 * 60) % 60);
        seconds = (int) ((milliseconds) / 1000) % 60;
    }

    public String readTimeHuman(TimeType timeType)
    {
        String averageReadTime = "";

        switch (timeType)
        {
            case HOURS:
                averageReadTime = hours + "h";
                break;
            case MINUTES:
                averageReadTime = minutes + "m";
                break;
            case HOURS_AND_MINUTES:
                averageReadTime = hours + "h" + minutes + "m";
                break;
            case MINUTES_AND_SECONDS:
                averageReadTime = minutes + "m" + seconds + "s";
                break;
            case FULL:
                averageReadTime = hours + "h" + minutes + "m" + seconds + "s";
                break;
        }

        return averageReadTime;
    }

    private float averageReadMinutes(float wordCount) {
        return wordCount / WORDS_PER_MINUTE;
    }

    public int calculateWordCountFromMinutes(int minutes){ return minutes * WORDS_PER_MINUTE;}

//    public void checkTextEndsInFullStop(StringBuilder stringBuilder, int endPoint)
//    {
//        int fullStopIndex = -1;
//        int wordCountPoint = 10;
////        fullStopIndex = stringBuilder.substring((endPoint-11), endPoint-1).indexOf(';');
//        System.out.println("Outside conditions " + stringBuilder.substring(endPoint-wordCountPoint, endPoint));
////        System.out.println(stringBuilder.substring(0,endPoint-39));
//        if (stringBuilder.substring((endPoint-wordCountPoint), endPoint).indexOf(',') != -1 )
//            {
//                System.out.println("First Condition " + stringBuilder.substring((endPoint-wordCountPoint), endPoint));
//                System.out.println("First Condition " + stringBuilder.substring(0, endPoint-stringBuilder.substring((endPoint-wordCountPoint), endPoint).indexOf(',')));
//                fullStopIndex = stringBuilder.substring((endPoint-wordCountPoint), endPoint).indexOf(',');
//            }
//        else if (stringBuilder.substring((endPoint-wordCountPoint), endPoint).indexOf(';') != -1)
//        {
//            System.out.println("Second Condition " + stringBuilder.substring((endPoint-wordCountPoint), endPoint));
//            fullStopIndex = stringBuilder.substring((endPoint-wordCountPoint), endPoint).indexOf(';');
//        }
//        else if (stringBuilder.substring((endPoint-(wordCountPoint*2)), endPoint).indexOf('.') != -1)
//        {
//            System.out.println("Third Condition " + stringBuilder.substring((endPoint-wordCountPoint), endPoint));
//            fullStopIndex = stringBuilder.substring((endPoint-wordCountPoint), endPoint).indexOf('.');
//        }
//        else
//        {
//            System.out.println(stringBuilder.substring((endPoint-wordCountPoint), endPoint));
//            fullStopIndex = stringBuilder.substring((endPoint-(wordCountPoint*4)), endPoint).indexOf(',');
//        }
//        System.out.println("Text time checker fullStop at "+fullStopIndex);
//    }
    public int wordCount() {
        String trimmed = text.trim();
        int words = trimmed.split("\\s+").length;

        return words;
    }

    public int getSeconds()
    {
        return seconds;
    }

    public int getMinutes()
    {
        return minutes;
    }

    public int getHours()
    {
        return hours;
    }

    @Override
    public String toString()
    {
        return text;
    }
}

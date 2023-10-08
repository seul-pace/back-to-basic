package com.seul.backtobasic.chap10.survey;

public class SurveyFactory {

    public static Survey createApprovedSurvey(Long l) {
        return new Survey();
    }
}

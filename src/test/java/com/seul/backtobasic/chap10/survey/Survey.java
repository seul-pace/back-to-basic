package com.seul.backtobasic.chap10.survey;

import java.util.List;

public class Survey {

    private long surveyId;
    private long respondentId;
    private List<Integer> answers;

    public long getSurveyId() {
        return surveyId;
    }

    public long getRespondentId() {
        return respondentId;
    }

    public List<Integer> getAnswers() {
        return answers;
    }
}

package com.seul.backtobasic.chap10.survey;

import java.util.HashMap;
import java.util.Map;

public class MemoryRepository implements SurveyRepository {

    private Map<String, Survey> surveys = new HashMap<>();

    @Override
    public void save(Survey survey) {
        surveys.put(String.valueOf(survey.getSurveyId()), survey);
    }

    public SurveyAnswer findBySurveyAndRespondent(long surveyId, long respondentId) {
        Survey survey = surveys.get(surveyId);
        return null;
    }

}

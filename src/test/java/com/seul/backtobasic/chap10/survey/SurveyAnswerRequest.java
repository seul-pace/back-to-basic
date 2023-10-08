package com.seul.backtobasic.chap10.survey;

import java.util.List;

public class SurveyAnswerRequest {
    private long surveyId;
    private long respondentId;
    private List<Integer> answers;

    private SurveyAnswerRequest() {}

    public SurveyAnswerRequest(long surveyId, long respondentId, List<Integer> answers) {
        this.surveyId = surveyId;
        this.respondentId = respondentId;
        this.answers = answers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private SurveyAnswerRequest request = new SurveyAnswerRequest();

        public Builder surveyId(long surveyId) {
            request.surveyId = surveyId;
            return this;
        }

        public Builder respondentId(long respondentId) {
            request.respondentId = respondentId;
            return this;
        }

        public Builder answers(List<Integer> answers) {
            request.answers = answers;
            return this;
        }

        public SurveyAnswerRequest build() {
            return request;
        }
    }
}

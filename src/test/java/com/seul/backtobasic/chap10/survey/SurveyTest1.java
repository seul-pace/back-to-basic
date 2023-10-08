package com.seul.backtobasic.chap10.survey;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurveyTest1 {

    @DisplayName("")
    @Test
    public void saveAnswerSuccessfully() {
        SurveyRepository surveyRepository = new MemoryRepository();

        // 답변할 설문이 존재
        Survey survey = SurveyFactory.createApprovedSurvey(1L);
        surveyRepository.save(survey);

        // 설문 답변
        SurveyAnswerRequest surveyAnswer = SurveyAnswerRequest.builder()
                .surveyId(1L)
                .respondentId(100L)
                .answers(Arrays.asList(1,2,3,4))
                .build();

//        svc.answerServey(surveyAnswer);
//
//        // 저장 결과 확인
//        SurveyAnswer savedAnswer = surveyRepository.findBySurveyAndRespondent(1L, 100L);
//        assertAll(
//                () -> assertEquals(100L, savedAnswer.getRespondentId()),
//                () -> assertEquals(4, savedAnswer.getAnswers().size()),
//                () -> assertEquals(1, savedAnswer.getAnswers().get(0)),
//                () -> assertEquals(2, savedAnswer.getAnswers().get(1)),
//                () -> assertEquals(3, savedAnswer.getAnswers().get(2)),
//                () -> assertEquals(4, savedAnswer.getAnswers().get(3))
//        );
    }
}

package com.kondrashov.demo.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestServiceImpl implements TestService {

    private final int optionsCount = 4;
    private Scanner in = new Scanner(System.in);
    private int countOfRightAnswers;
    private String testFileName;

    public void setTestFileName(String testFileName) {
        this.testFileName = testFileName;
    }

    @Override
    public void startTesting(String studentName){

        countOfRightAnswers = 0;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(testFileName);

        InputStreamReader input = new InputStreamReader(inputStream);
        CSVParser csvParser = null;
        try {
            csvParser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(input);
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл с вопросами");
            e.printStackTrace();
        }
        int questionNumber = 0;
        for (CSVRecord record : csvParser) {
            for (int i = 0; i <= optionsCount; i++) {
                System.out.printf("%s %s \n",
                        i > 0
                                ? i +") "
                                :  "Вопрос №" + ++questionNumber + ":",
                        record.get(i)
                );
            }
            int answerIndex = 0;
            do {

                answerIndex = in.nextInt();
                if (answerIndex > optionsCount) {
                    System.out.printf("Есть только %s варианта ответа, введите номер правильного ответа", optionsCount);
                    answerIndex = 0;
                }
                if (answerIndex == optionsCount) countOfRightAnswers++;

            } while (answerIndex == 0);
        }

        System.out.printf("%s - результат тестирования : %s/%s", studentName, countOfRightAnswers, questionNumber);

    }
}

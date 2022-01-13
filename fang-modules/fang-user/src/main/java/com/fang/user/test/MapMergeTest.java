package com.fang.user.test;

import com.fang.user.entity.StudentScore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:fxm
 * @createTime:2021/9/22 17:27
 */
public class MapMergeTest {

    private static List<StudentScore> buildATestList(){
        List<StudentScore> studentScoreList = new ArrayList<>();
        StudentScore studentScore1 = new StudentScore(){{
            setStuName("张三");
            setSubject("语文");
            setScore(70);
        }};
        StudentScore studentScore2 = new StudentScore() {{
            setStuName("张三");
            setSubject("数学");
            setScore(80);
        }};
        StudentScore studentScore3 = new StudentScore() {{
            setStuName("张三");
            setSubject("英语");
            setScore(65);
        }};
        StudentScore studentScore4 = new StudentScore() {{
            setStuName("李四");
            setSubject("语文");
            setScore(68);
        }};
        StudentScore studentScore5 = new StudentScore() {{
            setStuName("李四");
            setSubject("数学");
            setScore(70);
        }};
        StudentScore studentScore6 = new StudentScore() {{
            setStuName("李四");
            setSubject("英语");
            setScore(90);
        }};
        StudentScore studentScore7 = new StudentScore() {{
            setStuName("王五");
            setSubject("语文");
            setScore(80);
        }};
        StudentScore studentScore8 = new StudentScore() {{
            setStuName("王五");
            setSubject("数学");
            setScore(85);
        }};
        StudentScore studentScore9 = new StudentScore() {{
            setStuName("王五");
            setSubject("英语");
            setScore(70);
        }};
        studentScoreList.add(studentScore1);
        studentScoreList.add(studentScore2);
        studentScoreList.add(studentScore3);
        studentScoreList.add(studentScore4);
        studentScoreList.add(studentScore5);
        studentScoreList.add(studentScore6);
        studentScoreList.add(studentScore7);
        studentScoreList.add(studentScore8);
        studentScoreList.add(studentScore9);
        return studentScoreList;
    }


    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<StudentScore> studentScoreList = MapMergeTest.buildATestList();

        Map<String, Integer> studentScoreMap = new HashMap<>();

        studentScoreList.forEach(item ->{
            if(studentScoreMap.containsKey(item.getStuName())){
                studentScoreMap.put(item.getStuName(),studentScoreMap.get(item.getStuName())+item.getScore());
            }else{
                studentScoreMap.put(item.getStuName(),item.getScore());
            }
        });

        System.out.println(objectMapper.writeValueAsString(studentScoreMap));

        Map<String, Integer> studentScoreMap2 = new HashMap<>();
        studentScoreList.forEach(item -> studentScoreMap2.merge(
                item.getStuName(),
                item.getScore(),
                Integer::sum
        ));
        System.out.println(objectMapper.writeValueAsString(studentScoreMap2));
    }
}

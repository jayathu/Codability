package self.learning.RealInterviewQuestions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.*;
import java.util.*;

public class Roblox {

    /*
You are a developer for a university. Your current project is to develop a system for students to find courses they share with friends. The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.

Write a function that takes in a list of (student ID number, course name) pairs and returns, for every pair of students, a list of all courses they share.

Sample Output (pseudocode, in any order)

find_pairs(student_course_pairs) =>
{
    [58, 17]: ["Software Design", "Linear Algebra"]
    [58, 94]: ["Economics"]
    [17, 94]: []
}

List<Integer> pair;
List<String>
HashMap< List<Integer>, List<String> >

58: SoftwareDesign, LA, Eco, Me
94: AH, OS, Eco
17: LA, SD, PS
*/

        public static HashMap<List<Integer>, List<String>> find_pairs(String[][] studentCoursePairs)
        {
            HashMap<List<Integer>, List<String>> results = new HashMap<>();
            HashMap<Integer, List<String>> tempMap = new HashMap<>();

            System.out.println(studentCoursePairs.length);
            System.out.println(studentCoursePairs[0].length);

            for(int row = 0; row < studentCoursePairs.length; row++)
            {
                Integer id = Integer.parseInt(studentCoursePairs[row][0]);
                if(tempMap.containsKey(id))
                {
                    List<String> courses = tempMap.get(id);
                    courses.add(studentCoursePairs[row][1]);
                    tempMap.put(id, courses);
                }
                else
                {
                    List<String> courses = new ArrayList<>();
                    courses.add(studentCoursePairs[row][1]);
                    tempMap.put(id, courses);
                }
            }

            List<Integer> keyList = new ArrayList<Integer>(tempMap.keySet());
            for(int i = 0; i < keyList.size(); i++)
            {
                for(int j = 0; j < keyList.size(); j++)
                {
                    if(i != j)
                    {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(i);
                        pair.add(j);

                        List<String> courses_i = tempMap.get(keyList.get(i));
                        List<String> courses_j = tempMap.get(keyList.get(j));

                        List<String> values = new ArrayList<>();

                        for (String si : courses_i
                                ) {

                            for (String sj : courses_j
                                    ) {

                                if(si == sj)
                                {
                                    values.add(si);
                                }
                            }
                        }

                        results.put(pair, values);
                        System.out.println(results);
                    }
                }
            }

            return results;
        }
//        public static void main(String[] args) {
//            String[][] studentCoursePairs = {
//                    {"58", "Software Design"},
//                    {"58", "Linear Algebra"},
//                    {"94", "Art History"},
//                    {"94", "Operating Systems"},
//                    {"17", "Software Design"},
//                    {"58", "Mechanics"},
//                    {"58", "Economics"},
//                    {"17", "Linear Algebra"},
//                    {"17", "Political Science"},
//                    {"94", "Economics"}
//            };
//
//            find_pairs(studentCoursePairs);
//
//        }

}

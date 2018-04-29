package self.learning.RealInterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonQuestion1 {

    public static void  retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude) {

        HashMap<String, Integer> frequencyMap = new HashMap<>();

        int i = 0, j = 0;
        while (i < literatureText.length()) {
            if (literatureText.charAt(i) != ' ') {
                i++;
            } else {
                String word = literatureText.substring(j, i);
                if (!wordsToExclude.contains(word)) {
                    AddToDictionary(word, frequencyMap);
                }

                i++;
                j = i;
            }
        }

        String word = literatureText.substring(j, i);
        if (!wordsToExclude.contains(word)) {
            AddToDictionary(word, frequencyMap);
        }

        List<String> mostFrequentWords = new ArrayList<>();
        Integer maxFrequency = 0;
        for (Map.Entry<String, Integer> map : frequencyMap.entrySet()) {

            if(map.getValue() > maxFrequency) {
                maxFrequency = map.getValue();
            }
        }

        for (Map.Entry<String, Integer> map : frequencyMap.entrySet()) {

            if(map.getValue() == maxFrequency) {
                mostFrequentWords.add(map.getKey());
                System.out.println(map.getKey());
            }
        }


    }

    static void AddToDictionary(String word, HashMap<String, Integer> frequencyMap)
    {
        if(frequencyMap.containsKey(word))
        {
            Integer val = frequencyMap.get(word);
            frequencyMap.put(word, val + 1);
        }
        else{
            frequencyMap.put(word, 1);
        }
    }


    public static void reOrderLines(int logSizeFile, List<String> logFile)
    {
        String[] lines = new String[logSizeFile];

        for(int i = 0; i < logSizeFile; i++)
        {
            lines[i] = logFile.get(i);
        }

//        for(String s: lines)
//        {
//            System.out.println(s);
//        }

        quickSort(lines, 0, logSizeFile - 1);

        for(String s: lines)
        {
            System.out.println(s);
        }
    }

    static void quickSort(String[] logFile, int start, int end)
    {
        if(start < end) {
            int partitionIndex = partition(logFile, start, end);
            quickSort(logFile, start, partitionIndex -1 );
            quickSort(logFile, partitionIndex + 1, end);
        }

    }

    static int partition(String[] logFile, int start, int end)
    {
        int pIndex = start;
        for(int i = start; i < end; i++)
        {
            if(isString(logFile[i]))
            {
                String temp = logFile[i];
                logFile[i] = logFile[pIndex];
                logFile[pIndex] = temp;
                pIndex++;
            }
        }

        String temp = logFile[pIndex];
        logFile[pIndex] = logFile[end];
        logFile[end] = temp;
        return pIndex;

    }

    static boolean isString(String s)
    {
        char[] arr = s.toCharArray();
        int i = 0;
        while(i < arr.length && arr[i] != ' ')
        {
            i++;
        }
        i++;
        if(arr[i] >= '0' && arr[i] <= '9')
        {
            return false;
        }
        return true;
    }

}

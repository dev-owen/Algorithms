package kakao;

import java.io.*;
import java.util.*;

public class Solution1 {
	public String[] solution(String[] record) {
		List<String[]> list = new LinkedList<>();
		Map<String, String> hashMap = new HashMap<>();
		for(int i=0; i<record.length; i++) {
			String[] str = record[i].split(" ");
			if(str[0].equals("Enter") || str[0].equals("Change")) hashMap.put(str[1], str[2]);
			if(str[0].equals("Enter") || str[0].equals("Leave")) list.add(str);
		}
		String[] answer = new String[list.size()];
		for(int i=0; i<list.size(); i++) {
			String[] output = list.get(i);
			if(output[0].equals("Enter")) answer[i] = hashMap.get(output[1])+"´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
			else answer[i] = hashMap.get(output[1])+"´ÔÀÌ ³ª°¬½À´Ï´Ù.";
		}
		return answer;
    }
}
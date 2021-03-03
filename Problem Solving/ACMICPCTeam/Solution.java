import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int n = topic.length;
        int m = topic[0].length();
        int maxSkills = 0;
        int maxSkillTeams = 0;
        int [] result = new int [2];
        
        for(int i = 0; i < n; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                String member1 = topic[i];
                String member2 = topic[j];
                int skillSet = 0;
                
                for(int k = 0; k < m; k++)
                {
                    if(member1.charAt(k) == '1' || member2.charAt(k) == '1')
                    {
                        skillSet++;
                    }
                }

                maxSkillTeams += (maxSkills == skillSet) ? 1 : 0;
                
                if(skillSet > maxSkills)
                {
                    maxSkillTeams = 1;
                    maxSkills = skillSet;
                }
            }
        }
        result[0] = maxSkills;    
        result[1] = maxSkillTeams;
        return result;
    }
    
   
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        scanner.close();
    }
}

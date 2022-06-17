import java.io.*;
import java.util.*;

public class BJ_1043_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;

        int peopleN = Integer.parseInt(st.nextToken());
        int partyN = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int knownTruthN = Integer.parseInt(st.nextToken());
        HashSet<Integer> knownTruthPeople = new HashSet<>();
        // 진실 아는 사람들 추가
        for (int i = 0; i < knownTruthN; i++) {
            knownTruthPeople.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer>[] partyPeopleList = new ArrayList[partyN];
        for (int i = 0; i < partyN; i++) {
            st = new StringTokenizer(br.readLine());
            int partyPeopleN = Integer.parseInt(st.nextToken());
            ArrayList<Integer> partyPeople = new ArrayList<>();
            for (int j = 0; j < partyPeopleN; j++) {
                partyPeople.add(Integer.parseInt(st.nextToken()));
            }
            partyPeopleList[i] = partyPeople;
        }
        // System.out.println(Arrays.deepToString(partyPeopleList));
        for (int i = 0; i < partyPeopleList.length; i++) {
            boolean updateCheck = false;
            boolean restartCheck = false;
            // if (knownTruthN == 0) {
            //     result = partyN;
            //     break;
            // }

            // 파티내에 진실아는 사람 있는지 확인
            for (int j = 0; j < partyPeopleList[i].size(); j++) {
                // 있다면 그 파티는 모두 진실을 아는거
                if (knownTruthPeople.contains(partyPeopleList[i].get(j))) {
                    updateCheck = true;
                    if (updateCheck) {
                        for (int k = 0; k < partyPeopleList[i].size(); k++) {
                            if (!knownTruthPeople.contains(partyPeopleList[i].get(k))) {
                                restartCheck = true;
                                knownTruthPeople.addAll(partyPeopleList[i]);
                                break;
                            }
                        }
                    }
                    break;
                }
            }
            if (updateCheck && restartCheck) {
                i = 0;
                updateCheck = false;
                restartCheck = false;
            }
            updateCheck = false;
            restartCheck = false;
        }
        // System.out.println(knownTruthPeople.toString());
        for (int i = 0; i < partyPeopleList.length; i++) {
            boolean resultCheck = true;
            for (int j = 0; j < partyPeopleList[i].size(); j++) {
                if (knownTruthPeople.contains(partyPeopleList[i].get(j))) {
                    resultCheck = false;
                    break;
                }
            }
            if (resultCheck) {
                result++;
            }
        }
        System.out.println(result);
    }
}
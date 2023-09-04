import java.util.*;
class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, List<Integer>> genreMap = new HashMap<>();
        Map<String, Integer> totalMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            if (!genreMap.containsKey(genre)) genreMap.put(genre, new ArrayList<>());
            List<Integer> songList = genreMap.get(genre);
            songList.add(i);

            totalMap.put(genre, totalMap.getOrDefault(genre, 0) + plays[i]);
        }

        // 장르 전체 재생 횟수 내림차순 정렬
        List<Map.Entry<String, Integer>> mapList = new ArrayList<>(totalMap.entrySet());
        Collections.sort(mapList, (e1, e2) -> e2.getValue() - e1.getValue());

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>(); // 정렬된 genreMap
        for (Map.Entry<String, Integer> entry : mapList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // 장르별 재생 횟수가 많은 노래 선정
        for (String genre : sortedMap.keySet()) {
            // 장르별 노래 재생 횟수 내림차순 정렬
            List<Integer> songList = genreMap.get(genre);
            Collections.sort(songList, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return plays[o2] - plays[o1];
                }
            });
            answer.add(songList.get(0));
            if (songList.size() >= 2) {
                answer.add(songList.get(1));
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
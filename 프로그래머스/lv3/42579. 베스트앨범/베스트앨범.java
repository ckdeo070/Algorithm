import java.util.*;

public class Solution {

  class Song {

    String genre;
    int idx;
    int play;
    int totalPlay;
  }

  public int[] solution(String[] genres, int[] plays) {
    ArrayList<Song> list = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < genres.length; i++) {
      map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
    }
    
    for (int i = 0; i < genres.length; i++) {
      Song song = new Song();
      song.genre = genres[i];
      song.idx = i;
      song.play = plays[i];
      song.totalPlay = map.get(genres[i]);
      list.add(song);
    }
    
    Collections.sort(list, new Comparator<Song>() {
      @Override
      public int compare(Song o1, Song o2) {
        if (o1.totalPlay < o2.totalPlay) {
          return 1;
        } else if (o1.totalPlay > o2.totalPlay) {
          return -1;
        } else {
          if (o1.play <= o2.play) {
            return 1;
          } else {
            return -1;
          }
        }
      }
    });
    
    ArrayList<Integer> ans = new ArrayList<>();
    for (String k : map.keySet()) {
      map.replace(k, 0);
    }
    for (Song s : list) {
      if (map.get(s.genre) != 2) {
        ans.add(s.idx);
        map.put(s.genre, map.get(s.genre) + 1);
      }
    }
    int[] answer = new int[ans.size()];
    for (int i = 0; i < ans.size(); i++) {
      answer[i] = ans.get(i);
    }
    return answer;
  }
}
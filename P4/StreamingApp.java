/*
DO NOT MODIFY THE CODE STUB
NO NEED TO DEFINE main()
*/

import java.util.*;

class StreamingApp
{
	public static Map<String, ArrayList<String> > getFavouriteGenres(Map<String, ArrayList<String> > userMovies, Map<String, ArrayList<String> > movieGenres)
	{
		Map<String, ArrayList<String> > favGenres = new HashMap<String, ArrayList<String> >();
		for(Map.Entry<String, ArrayList<String> > m: userMovies.entrySet()) {
			String userName = m.getKey();
			ArrayList<String> al = m.getValue();
			Map<String, Integer> genreCount = new HashMap<String, Integer>();
			for(String s: al) {
				for(Map.Entry<String, ArrayList<String> > mp: movieGenres.entrySet()) {
					ArrayList<String> ml = mp.getValue();
					if(ml.contains(s)) {
						genreCount.put(mp.getKey(), genreCount.getOrDefault(mp.getKey(), 0) + 1);
					}
				}
			}
			Integer max = 0;
			for(Map.Entry<String, Integer > gc: genreCount.entrySet()) {
				if(gc.getValue() > max) max = gc.getValue();
			}
			ArrayList<String> als = new ArrayList<String>();
			for(Map.Entry<String, Integer > gc: genreCount.entrySet()) {
				if(gc.getValue() == max) als.add(gc.getKey());
			}
			favGenres.put(userName, als);
		}
		return favGenres;
	}
	// public static void main(String args[]) {
	// 	Map<String, ArrayList<String> > userMovies = new HashMap<String, ArrayList<String> >();
	// 	Map<String, ArrayList<String> > movieGenres = new HashMap<String, ArrayList<String> >();
	// 	userMovies.put("David", new ArrayList<String>(Arrays.asList("The Conjuring", "Shoah", "The Purge", "13th", "The Dictator")));
	// 	userMovies.put("Emma",  new ArrayList<String>(Arrays.asList("The Matrix", "Captain America: Civil War", "John Wick")));
	// 	movieGenres.put("Horror",  new ArrayList<String>(Arrays.asList("The Conjuring", "The Purge")));
	// 	movieGenres.put("Action",  new ArrayList<String>(Arrays.asList("John Wick")));
	// 	movieGenres.put("Documentary",  new ArrayList<String>(Arrays.asList("Shoah", "13th")));
	// 	movieGenres.put("Science Fiction",  new ArrayList<String>(Arrays.asList("The Matrix", "Captain America: Civil War")));
	// 	movieGenres.put("Comedy",  new ArrayList<String>(Arrays.asList("The Dictator")));
	// 	Map<String, ArrayList<String> > favGenres = getFavouriteGenres(userMovies, movieGenres);
	// 	for(Map.Entry<String, ArrayList<String> > m: favGenres.entrySet()) {
	// 		String userName = m.getKey();
	// 		ArrayList<String> al = m.getValue();
	// 		System.out.println(userName);
	// 		for(String s: al) {
	// 			System.out.println(s);
	// 		}
	// 	}
	// }
}
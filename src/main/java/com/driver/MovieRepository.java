package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class MovieRepository {

    private    Map<String ,Movie> movieMap=new HashMap<>();
 private Map<String, Directer>directorMap=new HashMap<>();

 private HashMap<String, List<String>>directorMovieMapping;

 public MovieRepository(){
     this.movieMap=new HashMap<String,Movie>();
     this.directorMap=new HashMap<String,Directer>();
     this.directorMovieMapping=new HashMap<String,List<String>>();


 }

 public void saveMovie(Movie movie){
     movieMap.put(movie.getName(),movie);
 }
 public void  saveDirector(Directer directer){
     directorMap.put(directer.getName(),directer);
 }

 public ArrayList<String> saveMovieDirectorPair(String movie, String directer){
     if(movieMap.containsKey(movie)&& directorMap.containsKey(directer)){
         List<String>currentMoviesByDirector=new ArrayList<>();
         if(directorMovieMapping.containsKey(directer))
             currentMoviesByDirector=directorMovieMapping.get(directer);
         currentMoviesByDirector.add(movie);
         directorMovieMapping.put(directer,currentMoviesByDirector);
     }

 public List<String>FindAllMovies(){
         return new ArrayList<>(movieMap.keySet());
     }

 }
}

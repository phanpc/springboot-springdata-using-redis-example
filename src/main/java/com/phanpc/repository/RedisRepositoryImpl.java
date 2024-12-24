package com.phanpc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.phanpc.model.Movie;

import java.util.Map;
import jakarta.annotation.PostConstruct;

@Repository
public class RedisRepositoryImpl implements RedisRepository {
    private static final String KEY = "Movie";
    
    private RedisTemplate<String, Object> redisTemplate;

    //<String, Object, Object> -> Hash, HashKey, HashValue
    private HashOperations<String, Object, Object> hashOperations;
    
    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }
    
    public void add(final Movie movie) {
        hashOperations.put(KEY, movie.getId(), movie.getName());
    }

    public void delete(final String id) {
        hashOperations.delete(KEY, id);
    }
    
    public Movie findMovie(final String id){
        return (Movie) hashOperations.get(KEY, id);
    }
    
    public Map<Object, Object> findAllMovies(){
        return hashOperations.entries(KEY);
    }  
}

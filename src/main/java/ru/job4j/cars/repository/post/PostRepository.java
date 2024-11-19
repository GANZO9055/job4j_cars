package ru.job4j.cars.repository.post;

import ru.job4j.cars.model.Post;

import java.util.List;

public interface PostRepository {
    List<Post> getPostLastDay();
    List<Post> getPostWithPhoto();
    List<Post> getPostByNameBrand(String nameBrand);
}

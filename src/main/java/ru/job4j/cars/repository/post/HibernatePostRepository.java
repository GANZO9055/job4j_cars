package ru.job4j.cars.repository.post;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class HibernatePostRepository implements PostRepository {

    private final CrudRepository crudRepository;

    @Override
    public List<Post> getPostLastDay() {
        return crudRepository.query(
                String.format("FROM Post WHERE created >= :%s", LocalDateTime.now().minusDays(1)),
                Post.class
        );
    }

    @Override
    public List<Post> getPostWithPhoto() {
        return crudRepository.query(
                "FROM Post WHERE postFile != null",
                Post.class
        );
    }

    @Override
    public List<Post> getPostByNameBrand(String nameBrand) {
        return crudRepository.query(
                "FROM Post WHERE car.brand = brand",
                Post.class,
                Map.of("brand", nameBrand)
        );
    }
}

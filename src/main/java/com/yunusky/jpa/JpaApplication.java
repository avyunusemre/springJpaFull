package com.yunusky.jpa;

import com.github.javafaker.Faker;
import com.yunusky.jpa.entities.Author;
import com.yunusky.jpa.entities.Video;
import com.yunusky.jpa.repositories.AuthorRepository;
import com.yunusky.jpa.repositories.VideoRepository;
import com.yunusky.jpa.specification.AuthorSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repository, VideoRepository videoRepository) {
		return args -> {
			/*for (int i = 0; i < 10; i++) {
				Faker faker = new Faker();
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19, 50))
						.email(faker.name().lastName() + "@yunusky.com")
						.build();
				repository.save(author);
			}
			*/
			//repository.updateAuthor(31, 1);

			//repository.updateAllAuthorsAges(99);

			//repository.findByNamedQuery(32)
			//		.forEach(System.out::println);

			//update with named query


			/*var video = Video.builder()
					.name("abc")
					.length(5)
					.build();
			videoRepository.save(video);
			 */

			Specification<Author> spec = Specification
					.where(AuthorSpecification.hasAge(34))
					.or(AuthorSpecification.firstNameLike("Ir"));
			repository.findAll(spec).forEach(System.out::println);
		};
	}
}

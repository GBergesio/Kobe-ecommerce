package challenge.ecommerce;

import challenge.ecommerce.enums.Category;
import challenge.ecommerce.enums.UserType;
import challenge.ecommerce.models.Client;
import challenge.ecommerce.models.Product;
import challenge.ecommerce.repositories.ClientRepository;
import challenge.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class EcommerceApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProductRepository productRepository, ClientRepository clientRepository) {
		return (args) -> {
			Product product1 = new Product(
					"https://st3.depositphotos.com/34053336/35555/i/1600/depositphotos_355551334-stock-photo-library-three-funko-pop-toys.jpg"
			,"funko de astronauta","Buzz", 1500,10, Category.ACTIONFIGURES,"figuras");
			productRepository.save(product1);

			Product product2 = new Product("url-img-2","funko de naruto","Naruto", 1800,20,
					Category.ACTIONFIGURES,"figuras");
			productRepository.save(product2);

			Product product3 = new Product("url-img-3","funko de gon","Gon", 1700,30,
					Category.ACTIONFIGURES,"figuras");
			productRepository.save(product3);

			Product product4 = new Product("url-img-4","Mmanga de naruto tomo 6","Manga de naruto", 1000,16,
					Category.MANGA,"mangas");
			productRepository.save(product4);

			Product product5 = new Product("url-img-5","Manga de hxh tomo 9","Manga de Gon", 1000,24,
					Category.MANGA,"mangas");
			productRepository.save(product5);

			Product product6 = new Product("url-img-6","Comic de superman vs godzila","Comic de superman vol 4",
					1100,14, Category.COMIC,"comics");
			productRepository.save(product6);

			Client admin = new Client("admin", "admin","admin@kobestore.com", passwordEncoder.encode("123"),UserType.ADMIN);
			clientRepository.save(admin);

			Client client = new Client("client", "client","client@mail", passwordEncoder.encode("123"),UserType.CLIENT);
			clientRepository.save(client);
		};
	}
}

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
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class EcommerceApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
		System.out.println("Application started :)");
	}

//	@Bean
//	public WebMvcConfigurer corsConfiguration() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/*").allowedOrigins("http://localhost:8080/", "http://127.0.0.1:5500/%22").allowedMethods("").allowedHeaders("*");
//			}
//		};
//	}

	@Bean
	public CommandLineRunner initData(ProductRepository productRepository, ClientRepository clientRepository) {
		return (args) -> {

			// Clients
			Client admin = new Client("admin", "admin","admin@kobestore.com", passwordEncoder.encode("123"),UserType.ADMIN);
			clientRepository.save(admin);

			Client client = new Client("client", "client","client@mail", passwordEncoder.encode("123"),UserType.CLIENT);
			clientRepository.save(client);

			Client validatedClient = new Client("Melba", "Morel","melba@mindhub.com", passwordEncoder.encode("123"),UserType.CLIENT);
			validatedClient.setActive(true);
			clientRepository.save(validatedClient);

			//Products

			//Funko POPS!
			Product product1 = new Product("Funko POP! Goku Casual","Figura de Goku ssj en vinilo de 9 cm",
					"https://i.ibb.co/1mKLVDX/funko-pop-goku-casual-dragon-ball-z.jpg", "",
					(short) 15,2499.0,"Dragon Ball Z", Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product1);
					Product product2 = new Product("Funko POP! Gotenks Casual","Figura de Gotenks en vinilo de 9 cm",
							"https://i.ibb.co/3htX09L/funko-pop-gotenks-dragon-ball.jpg", "",
							(short) 31,2699.0, "Dragon Ball Z", Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product2);
			Product product3 = new Product("Funko POP! Future Trunks","Figura de Future Trunks en vinilo de 9 cm",
					"https://i.ibb.co/TbZdL17/funko-pop-trunks-del-futuro-dragon-ball.jpg", "",(short) 9,4499.0,
					"Dragon Ball Z", Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product3);
			Product product4 = new Product("Funko POP! Android 18","Figura de Android 18 en vinilo de 9 cm",
					"https://i.ibb.co/2scTHyV/212286-800-auto.webp", "", (short) 5,4999.0,
					"Dragon Ball Z", Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product4);
			Product product5 = new Product("Funko POP! Thanos Gold","Figura de Thanos Gold en vinilo de 9 cm",
					"https://i.ibb.co/DWXjyNs/204545-800-auto.webp","", (short) 10,6999.0,
					"Marvel", Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product5);
			Product product6 = new Product("Funko POP! Thor","Figura de Thor en vinilo de 9 cm",
					"https://i.ibb.co/ZX4Pppx/204651-800-auto.webp", "", (short) 14,4999.0,
					"Marvel", Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product6);
			Product product7 = new Product("Funko POP! Cyclops","Figura de Cyclops en vinilo de 9 cm",
					"https://i.ibb.co/6v7v9XX/205860-800-auto.webp","", (short) 13,3499.0,
					"Marvel", Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product7);
			Product product8 = new Product("Funko POP! Storm","Figura de Storm en vinilo de 8 cm",
					"https://i.ibb.co/wS2SWtF/212264-800-auto.webp","", (short) 7,4999.0,
					"Marvel", Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product8);
			Product product9 = new Product("Funko POP! Kefla Ssj","Figura de Kefla Ssj en vinilo de 8 cm",
					"https://i.ibb.co/xHb1zdx/205868-800-auto.webp", "", (short) 14,4999.0,
					"Dragon Ball Z", Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product9);
			Product product10 = new Product("Funko POP! Thor Gold","Figura de Thor Gold en vinilo de 10 cm",
					"https://i.ibb.co/2ZNLfWd/212275-800-auto.webp","", (short) 12,5999.0,
					"Marvel", Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product10);

			//Static Figures
			Product product11 = new Product("Marvel Series - Winter Soldier","Figura estatica de Winter Soldier de 20 cm de altura",
					"https://i.ibb.co/hdx9bNN/entrega-011-P24032-9a-marvel-figurines-1647803149626.webp","",
					(short) 7,6999.0,"Marvel", Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product11);
			Product product12 = new Product("Marvel Series - War Machine","Figura estatica de War Machine de 20 cm de altura",
					"https://i.ibb.co/7nJjFk3/entrega-011-P24031-marvel-figurines-entrega31a-maquina-guerra-1647287255924.webp","",
					(short) 11,6999.0,"Marvel", Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product12);
			Product product13 = new Product("Marvel Series - Iron Man","Figura estatica de Iron Man de 20 cm de altura",
					"https://i.ibb.co/v4y4GyC/entrega-011-N19055-Marvel-Movie-Collection-entrega55-iron-man-a-1601847012273-cloned-at1635108877273.webp","",
					(short) 4,7999.0,"Marvel", Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product13);
			Product product14 = new Product("Marvel Series - Ultron","Figura estatica de Ultron de 20 cm de altura",
					"https://i.ibb.co/LzkQHF9/entrega-011-N19024-24a-marvel-figurines-1560511549346-cloned-at1636317846851.webp","",
					(short) 7,6999.0,"Marvel", Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product14);
			Product product15 = new Product("Marvel Series - Captain America","Figura estatica de Captain America de 20 cm de altura",
					"https://i.ibb.co/gd2X0bH/entrega-011-N19028-28a-marvel-figurines-1564738782765-cloned-at1637490474173.webp","",
					(short) 9,7999.0,"Marvel", Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product15);
			Product product16 = new Product("Marvel Series - Thor","Figura estatica de Thor de 20 cm de altura",
					"https://i.ibb.co/ZSg6BKp/entrega-011-P24022-Marvel-Movie-Collection-entrega56-thor-a-1638988647449.webp","",
					(short) 12,7999.0,"Marvel", Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product16);
			Product product17 = new Product("Marvel Series - Hela","Figura estatica de Hela de 20 cm de altura",
					"https://i.ibb.co/rHPMBNK/entrega-011-P24023-Marvel-Movie-Collection-entrega44-hela-a-1639982180388.webp","",
					(short) 17,5999.0,"Marvel", Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product17);
			Product product18 = new Product("Marvel Series - Black Widow","Figura estatica de Black Widow de 20 cm de altura",
					"https://i.ibb.co/rmVKbY7/entrega-011-P24024-viuda-negra-2-1642009101980.webp","", (short) 3,
					7999.0,"Marvel", Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product18);
			Product product19 = new Product("Marvel Series - Black Panther","Figura estatica de Black Panther de 20 cm de altura",
					"https://i.ibb.co/S076Dbp/entrega-011-P24028-Marvel-Movie-Collection-entrega51-erik-killmonger-a-1654370239943.webp","",
					(short) 8,6999.0,"Marvel", Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product19);
			Product product20 = new Product("Marvel Series - Vison","Figura estatica de Vision de 20 cm de altura",
					"https://i.ibb.co/yQ6f1Cj/entrega-011-P24027-19a-marvel-figurines-1652632580845.webp","",
					(short) 13,6999.0,"Marvel", Category.ACTIONFIGURES , "Static Figures");
			productRepository.save(product20);

			//ACCESORIES
			Product product21 = new Product("Marvel Series - Iron Man","Funda edición Marvel para Iphone","https://i.ibb.co/X37WPqw/71d-BJa-Hi-X3-S-AC-SS450.jpg","https://i.ibb.co/4YHG0Fd/avengers-endgame-iron-man-tony-stark-crop1619139044711-jpg-33663383.jpg", (short) 15,1999.0,"Marvel", Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product21);
			Product product22 = new Product("Marvel Series - Iron Man","Funda edición Marvel para Iphone","https://i.ibb.co/603h0hL/0525968ee93a59b56b41517b7ceddedcf9c3cbb5-original.jpg","https://i.ibb.co/4YHG0Fd/avengers-endgame-iron-man-tony-stark-crop1619139044711-jpg-33663383.jpg", (short)15, 1999.0,"Marvel", Category.ACCESSORIES, "Iphone Cases");
			productRepository.save(product22);
			Product product23 = new Product("Marvel Series - Thor","Funda edición Marvel para Iphone","https://i.ibb.co/6FwyFvk/images-q-tbn-ANd9-Gc-Te-ELnsjkpa-L-TNs-Mtudxfa-L5-Z7f-RFgsd55-Ax-H1x-ZHNJPf-Mx-Aw3-LDc4-VTKr-A-u-G5x.jpg","https://i.ibb.co/TgQHRdF/D-NQ-NP-2-X-628203-MLA45669767978-042021-F.webp", (short) 10,2999.0,"Marvel",  Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product23);
			Product product24 = new Product("Marvel Series - Spider Man","Funda edición Marvel para Iphone","https://i.ibb.co/72khn8j/icr-iphone-13-soft-back-a-x600-pad-600x600-f8f8f8-u2.jpg","https://i.ibb.co/72khn8j/icr-iphone-13-soft-back-a-x600-pad-600x600-f8f8f8-u2.jpg", (short) 16,1999.0,"Marvel",  Category.ACCESSORIES,  "Iphone Cases");
			productRepository.save(product24);
			Product product25 = new Product("Marvel Series - IronMan","Funda edición Marvel para Iphone","https://i.ibb.co/9n2tyVq/images-q-tbn-ANd9-Gc-Tlom-Cd-XOagkg-Uu4d-VSTLd3-Duk-Sk9-Uo-APxy-Rw-usqp-CAU.jpg","https://i.ibb.co/4YHG0Fd/avengers-endgame-iron-man-tony-stark-crop1619139044711-jpg-33663383.jpg", (short) 15,1999.0,"Marvel",  Category.ACCESSORIES,  "Iphone Cases");
			productRepository.save(product25);
			Product product26 = new Product("Marvel Series - Capitan America","Funda edición Marvel para Iphone","https://i.ibb.co/9c6QzTS/il-570x-N-1271762446-970y.jpg","https://i.ibb.co/CVDZJfv/YRDRN2-AWWNATVHH3-CPLXR4-FUPA.jpg", (short) 9,1999.0,"Marvel",  Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product26);
			Product product27 = new Product("Marvel Series - Venom","Funda edición Marvel para Iphone","https://i.ibb.co/jhHTfFW/il-570x-N-2489432825-ssxc.jpg","https://i.ibb.co/TgQHRdF/D-NQ-NP-2-X-628203-MLA45669767978-042021-F.webp", (short) 1,1999.0,"Marvel",  Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product27);
			Product product28 = new Product("Marvel Series - Thor","Funda edición Marvel para Iphone","https://i.ibb.co/H4QnWbH/D-NQ-NP-804791-MCO31877551570-082019-O.jpg","https://i.ibb.co/TgQHRdF/D-NQ-NP-2-X-628203-MLA45669767978-042021-F.webp", (short) 18,1999.0,"Marvel",  Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product28);
			Product product29 = new Product("Marvel Series - Capitan America","Funda edición Marvel para Iphone","https://i.ibb.co/VwYbxrP/61j-Wcmmt-VAL-AC-SS450.jpg","https://i.ibb.co/CVDZJfv/YRDRN2-AWWNATVHH3-CPLXR4-FUPA.jpg", (short) 16,1999.0,"Marvel",  Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product29);
			Product product30 = new Product("Marvel Series - Spider Man","Funda edición Marvel para Iphone","https://i.ibb.co/xgtq4yf/71-Erkv-Rvhd-L-AC-SS450.jpg","https://i.ibb.co/4YHG0Fd/avengers-endgame-iron-man-tony-stark-crop1619139044711-jpg-33663383.jpg", (short) 10,1999.0,"Marvel",  Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product30);
			Product product31 = new Product("Marvel Series - Spider Man","Funda edición Marvel para Iphone","https://i.ibb.co/6DCxppQ/a94459bedad7cb94e53cfe621ce23a5570d452f6-original.jpg","https://i.ibb.co/4YHG0Fd/avengers-endgame-iron-man-tony-stark-crop1619139044711-jpg-33663383.jpg", (short) 10,1999.0,"Marvel",  Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product31);
			Product product32 = new Product("Dragon Ball - Gohan","Funda edición Dragon Ball para Iphone","https://i.ibb.co/5v8Fr9s/1aa21b82eef6422f6ffb2d817a81120e5272ae87-original.jpg","https://i.ibb.co/5GvLkjC/hasv-V6-Dq-400x400.jpg", (short) 1,2999.0,"Marvel",  Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product32);
			Product product33 = new Product("Dragon Ball - Goku Saiyan","Funda edición Dragon Ball para Iphone","https://i.ibb.co/F43n4VH/71fm-Yla-DCDL-AC-SX522.jpg","https://i.ibb.co/5WHpT18/296-2967569-volador-nubes-goku-goku-en-la-nube-voladora.jpg", (short) 18,1999.0,"Marvel", Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product33);
			Product product34 = new Product("Dragon Ball - Vegeta Blue","Funda edición Dragon Ball para Iphone","https://i.ibb.co/9nQGnRv/998b237ad0cf74f30a2efa7228971084cd3c53b3-original.jpg","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg", (short) 16,1999.0,"Marvel", Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product34);
			Product product35 = new Product("Dragon Ball - Goku ","Funda edición Dragon Ball para Iphone","https://i.ibb.co/bBYCvR0/1-2-300x300.png","https://i.ibb.co/PDWJm09/VNb-J8f-Gm-400x400.jpg ",(short) 14,1800.0,"Marvel", Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product35);
			Product product36 = new Product("Dragon Ball - Vegetta","Funda edición Dragon Ball para Iphone","https://i.ibb.co/KNP26nc/51t-MRe67-DXL-AC-SS450.jpg","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg", (short) 13,1999.0,"Marvel", Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product36);
			Product product37 = new Product("Dragon Ball - Vegetta","Funda edición Dragon Ball para Iphone","https://i.ibb.co/Pz7bHhK/fdad1bee2844cc1a0a0b5de095b26745.jpg","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg",(short) 13,1999.0,"Marvel", Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product37);
			Product product38 = new Product("Dragon Ball - Gotens Trunks","Funda edición Dragon Ball para Iphone","https://i.ibb.co/TKJgP7C/images-q-tbn-ANd9-Gc-SLy6-Gl-QNzl-OBo-LW0sjw-Smk88-T2-A0-Yi-Kg-CZg5-MS3u-VUDcl-Nt-AHRSo-Ju-ZYw-Job-I.jpg","https://i.ibb.co/mBxLCVH/pp-504x498-pad-600x600-f8f8f8.jpg", (short) 13,1999.0,"Marvel", Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product38);
			Product product39 = new Product("Dragon Ball - Vegetta","Funda edición Dragon Ball para Iphone","https://i.ibb.co/F62nP1S/icr-iphone-13-soft-back-a-x600-pad-600x600-f8f8f8.jpg","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg",  (short) 13,1999.0,"Marvel", Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product39);
			Product product40 = new Product("Dragon Ball - Vegetta","Funda edición Dragon Ball para Iphone","https://i.ibb.co/JzDxyKj/691dc9e9c3d632e829edb64b2cb1a97d7d4c83b3-original.jpg","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg",  (short) 13,1999.0,"Marvel", Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product40);
			Product product41 = new Product("Dragon Ball - Saiyan Blue ","Funda edición Dragon Ball para Iphone","https://i.ibb.co/k6jqYwS/9113292-0.png","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg",  (short) 13,6999.0,"Marvel",  Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product41);

			//BAZAR AND TOY GAMES
			Product product42 = new Product("Dragon Ball - Goku ","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/9pNftpr/images-q-tbn-ANd9-Gc-TKVBRnlcosf-Mov-UBwo-Yg3of-QZDcar-C1-HLDKis-OGVp9w268-PRI9jyz-Rv-SVYKfl-Swalr-A.jpg","https://i.ibb.co/PDWJm09/VNb-J8f-Gm-400x400.jpg",  (short) 13,999.0,"DRBZ",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product42);
			Product product43 = new Product("Dragon Ball - Z","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/MhCT2qK/images-q-tbn-ANd9-Gc-TYi-Z6-NNEJgdhu-Gnm0-R9-IMo-G-ehqv-P-Cmae-Lw-usqp-CAU.jpg","https://i.ibb.co/TgQHRdF/D-NQ-NP-2-X-628203-MLA45669767978-042021-F.webp",  (short) 13,999.0,"DRBZ",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product43);
			Product product44 = new Product("Dragon Ball - Gohan ","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/p2FZNb7/images-q-tbn-ANd9-Gc-Qiu-I2h332been-MF2-WAf-Uyw-DJ-8vt7-Sj-Wgy-Cw-usqp-CAU.jpg","https://i.ibb.co/5GvLkjC/hasv-V6-Dq-400x400.jpg",  (short) 13,999.0,"Marvel",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product44);
			Product product45 = new Product("Dragon Ball - Goku ","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/4ZCGCrK/images-q-tbn-ANd9-Gc-QUi-Agg-Pu4b7-Am-KTWZkej-UKrg-HAw-YPROXQYx-A-usqp-CAU.jpg","https://i.ibb.co/PDWJm09/VNb-J8f-Gm-400x400.jpg",  (short) 13,999.0,"Marvel",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product45);
			Product product46 = new Product("Dragon Ball - Vegeta ","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/4tdk81W/Dragon-Ball-Z-Jap-n-anime-figura-llavero-DBZ-vegetto.jpg","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg",  (short) 13,999.0,"Marvel",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product46);
			Product product47 = new Product("Dragon Ball - Gohan","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/5FpMCbw/images-q-tbn-ANd9-Gc-QFd-MMpa6-COa-Sucqp-y6co-Yv1x-2c-GQRLK96-Q-usqp-CAU.jpg","https://i.ibb.co/5GvLkjC/hasv-V6-Dq-400x400.jpg",  (short) 13,999.0,"Marvel",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product47);
			Product product48 = new Product("Dragon Ball - Vegeta","todo decoraciones, ideal para regalo o decoracion de la casa","https://static.bookscovers.es/imagenesP/3665361/366536103067.JPG","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg",  (short) 13,999.0,"Marvel",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product48);
			Product product49 = new Product("Dragon Ball - Vegeta ","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/5FRXn6V/41m-Wzi-NS-XL.jpg","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg",  (short) 13,999.0,"Marvel",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product49);
			Product product50 = new Product("Dragon Ball - Goku","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.pinimg.com/736x/9d/43/48/9d4348e22ec30a4c65c22979bde96ee7.jpg","https://i.ibb.co/PDWJm09/VNb-J8f-Gm-400x400.jpg",  (short) 13,999.0,"Marvel",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product50);
			Product product51 = new Product("Dragon Ball - Vegeta ","todo decoraciones, ideal para regalo o decoracion de la casa","https://cdn.shopify.com/s/files/1/0413/4253/3797/products/HTB1X5v3A41YBuNjy1zcq6zNcXXaz.jpg?v=1603124755","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg",  (short) 13,999.0,"Marvel",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product51);
			Product product52 = new Product("Marvel Series - Spider Man ","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/1Jgcr7C/image-63bbec126c7248f5b39943aa43002507.jpg","https://www.universalorlando.com/webdata/k2/es/us/files/Images/gds/ioa-amazing-adventures-of-spiderman-ride-animation-cf-b.jpg",  (short) 13,999.0,"Marvel",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product52);
			Product product53= new Product("Marvel Series - Thor ","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/3zjwkdw/llavero-mazo-martillo-thor-ragnarok-marvel-vengadores-metal-D-NQ-NP-883657-MLA30895344050-052019-O.jpg","https://i.ibb.co/TgQHRdF/D-NQ-NP-2-X-628203-MLA45669767978-042021-F.webp",  (short) 13,999.0,"Marvel",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product53);
			Product product54 = new Product("Marvel Series - Spider Man","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/nmtSQ7r/funko-pop-llavero-marvel-spiderman-cazador-de-zombies-what-if.jpg","https://www.universalorlando.com/webdata/k2/es/us/files/Images/gds/ioa-amazing-adventures-of-spiderman-ride-animation-cf-b.jpg",  (short) 13,999.0,"Marvel",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product54);
			Product product55 = new Product("Marvel Series - Capitan America","todo decoraciones, ideal para regalo o decoracion de la casa","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZKihJkoysHlZNLV7uiLjLX7y-WmcqKYXjxA&usqp=CAU","https://i.ibb.co/CVDZJfv/YRDRN2-AWWNATVHH3-CPLXR4-FUPA.jpg",  (short) 13,999.0,"Marvel",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product55);
			Product product56 = new Product("Marvel Series - Capitan America","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/bLR3j4G/diseno-sin-titulo-691-f256358cf6880caba916170552288604-640-0.png","https://i.ibb.co/CVDZJfv/YRDRN2-AWWNATVHH3-CPLXR4-FUPA.jpg",  (short) 13,999.0,"Marvel",  Category.BAZARANDTOYSHOP, "Keychains");
			productRepository.save(product56);
			Product product57 = new Product("Marvel Series - Spider Man ","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/8dNd3pG/e2a0176ab3688bc0cb18881f8a243420f25f5149430fa7b9d5d77931e7f6a7a7110248.png","https://www.universalorlando.com/webdata/k2/es/us/files/Images/gds/ioa-amazing-adventures-of-spiderman-ride-animation-cf-b.jpg",  (short) 13,999.0,"Marvel",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product57);
			Product product58 = new Product("Marvel Series - Iron Man","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/bg7n7cw/iron-man-keychain1-679b686df6ea1b7c4315627704095336-640-0.jpg","https://i.ibb.co/4YHG0Fd/avengers-endgame-iron-man-tony-stark-crop1619139044711-jpg-33663383.jpg",  (short) 13,999.0,"Marvel",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product58);
			Product product59 = new Product("Marvel Series - Iron Man","todo decoraciones, ideal para regalo o decoracion de la casa","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSu95MFW1a4qucR-pQFEdo1QM_szU7BnE7u_eBnxyzOcNjd70LEMwtkV-Fm1B2dMsBxpLE&usqp=CAU","https://i.ibb.co/4YHG0Fd/avengers-endgame-iron-man-tony-stark-crop1619139044711-jpg-33663383.jpg",  (short) 13,999.0,"Marvel",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product59);
			Product product60= new Product("Marvel Series - Thor","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/mz5dx1W/llavero-Mjolnir-martillo-de-Thor.jpg","https://i.ibb.co/TgQHRdF/D-NQ-NP-2-X-628203-MLA45669767978-042021-F.webp",  (short) 13,6999.0,"Marvel",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product60);
			Product product61 = new Product("Marvel Series - Spider Man ","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/5jg0Xfm/images-q-tbn-ANd9-Gc-Sm-Uu5iv0-25ith-Yl-T3t0tew-TQCNz-NMk-R-eeg-usqp-CAU.jpg","https://www.universalorlando.com/webdata/k2/es/us/files/Images/gds/ioa-amazing-adventures-of-spiderman-ride-animation-cf-b.jpg",  (short) 13,999.0,"Marvel",  Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product61);

			//mousePad
			Product product62 = new Product("Marvel Series - Iron Man","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/r3btBQ1/a83e0e4cd56d87284872dcaa5e314b4b-product.jpg","https://i.ibb.co/4YHG0Fd/avengers-endgame-iron-man-tony-stark-crop1619139044711-jpg-33663383.jpg",  (short) 13,899.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product62);
			Product product63 = new Product("Marvel Series - Iron Man ","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/5F8gfRH/161014aa94ad48a6a19ebe34b11312ef-product.jpg","https://i.ibb.co/4YHG0Fd/avengers-endgame-iron-man-tony-stark-crop1619139044711-jpg-33663383.jpg",  (short) 13,899.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product63);
			Product product64 = new Product("Marvel Series - Spider Man","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/zP8HH1W/6d7f5bd3366bf7eacd0ec8af392e9e79.jpg","https://www.universalorlando.com/webdata/k2/es/us/files/Images/gds/ioa-amazing-adventures-of-spiderman-ride-animation-cf-b.jpg",  (short) 13,899.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product64);
			Product product65 = new Product("Marvel Series - Spider Man ","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/X2Wbp51/2b41a4bb131c15bbd683c4275ca36786.jpg","https://www.universalorlando.com/webdata/k2/es/us/files/Images/gds/ioa-amazing-adventures-of-spiderman-ride-animation-cf-b.jpg",  (short) 13,899.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product65);
			Product product66 = new Product("Marvel Series - Thor ","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/HT2zkTn/Maiya-High-Quality-Marvel-Thor-Laptop-Gaming-Mice-Mousepad-Top-Selling-Wholesale-Gaming-Pad-mouse-jp.jpg","https://i.ibb.co/TgQHRdF/D-NQ-NP-2-X-628203-MLA45669767978-042021-F.webp",  (short) 13,899.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product66);
			Product product67 = new Product("Marvel Series - Thor ","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/DtKL4XM/42f921100db4b957dc8208d459184acf-product.jpg","https://i.ibb.co/TgQHRdF/D-NQ-NP-2-X-628203-MLA45669767978-042021-F.webp",  (short) 13,899.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product67);
			Product product68 = new Product("Marvel Series - Capitan America ","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/71s0HDg/5a752f03c5425cf2ae414e8d361403e4a6536f2482f1420a8983f5e803aed46b35326.png","https://i.ibb.co/CVDZJfv/YRDRN2-AWWNATVHH3-CPLXR4-FUPA.jpg",  (short) 13,899.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product68);
			Product product69= new Product("Marvel Series - Capitan America ","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/WGD9Jtw/1ed36b58ad80aaa74df9dee2cdedc55b-product.jpg","https://i.ibb.co/CVDZJfv/YRDRN2-AWWNATVHH3-CPLXR4-FUPA.jpg",  (short) 13,899.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product69);
			Product product70= new Product("Marvel Series - Capitan America ","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/Nyystcm/d1c4e3a0d8bc106320fc30b270397d6e-product.jpg","https://i.ibb.co/CVDZJfv/YRDRN2-AWWNATVHH3-CPLXR4-FUPA.jpg",  (short) 13,899.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product70);
			Product product71= new Product("Marvel Series - Capitan America ","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/s2tfJD1/bcb4372c933eeefbdfd3e34a75a8d432-character-art-mice.jpg","https://i.ibb.co/CVDZJfv/YRDRN2-AWWNATVHH3-CPLXR4-FUPA.jpg",  (short) 13,899.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product71);
			Product product72= new Product("Marvel Series - Capitan America ","todo decoraciones, ideal para regalo o decoracion de la casa","https://d3ugyf2ht6aenh.cloudfront.net/stores/171/765/products/20210714_2047441-c875e20b515d6bda1116263077431160-1024-1024.jpg","https://i.ibb.co/CVDZJfv/YRDRN2-AWWNATVHH3-CPLXR4-FUPA.jpg",  (short) 13,1200.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product72);
			Product product73= new Product("Marvel Series - Capitan America ","todo decoraciones, ideal para regalo o decoracion de la casa","https://d3ugyf2ht6aenh.cloudfront.net/stores/806/999/products/de2a00261-6f7bbf6be3a581735b16421735463422-640-0.jpg","https://i.ibb.co/CVDZJfv/YRDRN2-AWWNATVHH3-CPLXR4-FUPA.jpg",  (short) 13,1200.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product73);
			Product product74= new Product("Marvel Series - Spider Man","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/Yp08ZmK/pyramid-taza-spiderman-kawaii-315-ml.jpg","https://www.universalorlando.com/webdata/k2/es/us/files/Images/gds/ioa-amazing-adventures-of-spiderman-ride-animation-cf-b.jpg",  (short) 13,1200.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product74);
			Product product75= new Product("Marvel Series - Spider Man","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/WgFJ9nr/b18b4ee1b28f487aefd0b48a4981927e.jpg","https://www.universalorlando.com/webdata/k2/es/us/files/Images/gds/ioa-amazing-adventures-of-spiderman-ride-animation-cf-b.jpg",  (short) 13,1200.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product75);
			Product product76= new Product("Marvel Series - Iron Man","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/CJDz83Z/HTB1-DKGpg-Ct-YBe-Nj-Sspaq6y-OOFXa-D.jpg","https://i.ibb.co/4YHG0Fd/avengers-endgame-iron-man-tony-stark-crop1619139044711-jpg-33663383.jpg",  (short) 13,1200.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product76);
			Product product77= new Product("Marvel Series - Iron Man","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/pwJrHzZ/de2a00221-a5634107295cc8c67816421734039333-640-0.jpg","https://i.ibb.co/4YHG0Fd/avengers-endgame-iron-man-tony-stark-crop1619139044711-jpg-33663383.jpg",  (short) 13,1200.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product77);
			Product product78= new Product("Marvel Series - Thor","todo decoraciones, ideal para regalo o decoracion de la casa","https://cf.shopee.com.ar/file/c8bb916b33341cdf1201dba9e65aa176_tn","https://i.ibb.co/TgQHRdF/D-NQ-NP-2-X-628203-MLA45669767978-042021-F.webp",  (short) 13,1200.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product78);
			Product product79= new Product("Marvel Series - Thor","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/nPZ1y7L/Tazas-de-caf-de-Thor-de-Marvel-martillo-de-cer-mica-tazas-en-forma-de-hoja.jpg","https://i.ibb.co/TgQHRdF/D-NQ-NP-2-X-628203-MLA45669767978-042021-F.webp",  (short) 13,1200.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product79);
			Product product80= new Product("Marvel Series - Thor","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/XVjFk23/4fea55424fce56d086a82684fb54a79d.jpg","https://i.ibb.co/TgQHRdF/D-NQ-NP-2-X-628203-MLA45669767978-042021-F.webp",  (short) 13,1200.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product80);
			Product product81= new Product("Marvel Series - Thor","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/6WT9mJR/51-L7-EQQr4t-L.jpg","https://i.ibb.co/TgQHRdF/D-NQ-NP-2-X-628203-MLA45669767978-042021-F.webp",  (short) 13,1200.0,"Marvel",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product81);
			Product product82= new Product("Dragon Ball - Goku","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/r3yqffz/fc653387e6670d86893bc6189626e55f.jpg","https://i.ibb.co/PDWJm09/VNb-J8f-Gm-400x400.jpg ",  (short) 13,1200.0,"Dragon Ball Z",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product82);
			Product product83= new Product("Dragon Ball - Goku","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/QJZfnmT/dball-goku-henki-taza21-084c1e32ac942bd81015621885701568-480-0.jpg","https://i.ibb.co/PDWJm09/VNb-J8f-Gm-400x400.jpg ",  (short) 13,1800.0,"Dragon Ball Z",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product83);
			Product product84= new Product("Dragon Ball - Vegeta","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/3RyCTKJ/dball-vegeta-taza3-7337ea734c75ccf93615621889570985-1024-1024.jpg","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg",  (short) 13,1800.0,"Dragon Ball Z",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product84);
			Product product85= new Product("Dragon Ball - Vegeta","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/BttNzT3/images-q-tbn-ANd9-Gc-REQsjcqd-Xqtye-SYK-F5i-GWk-Z5w8-Dzi-MOJPNt-Awvda4-Uxn1iw5-Ijw-I86-M1i-UIwa934b4.jpg","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg",  (short) 13,1200.0,"Dragon Ball Z",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product85);
			Product product86= new Product("Dragon Ball - Gohan","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/QN3BFtq/6a1704b6e8e6b8b8eb5b81627c50703d.jpg","https://i.ibb.co/5GvLkjC/hasv-V6-Dq-400x400.jpg",  (short) 13,1800.0,"Dragon Ball Z",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product86);
			Product product87= new Product("Dragon Ball - Gohan","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/hHTWyBd/618572fd5843b7-92711056.jpg","https://i.ibb.co/5GvLkjC/hasv-V6-Dq-400x400.jpg",  (short) 13,1200.0,"Dragon Ball Z",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product87);
			Product product88= new Product("Dragon Ball - Gotenks","todo decoraciones, ideal para regalo o decoracion de la casa","hola","https://i.ibb.co/mBxLCVH/pp-504x498-pad-600x600-f8f8f8.jpg",  (short) 13,1200.0,"Dragon Ball Z",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product88);
			Product product89= new Product("Dragon Ball - Gotenks","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/Q8kRyQT/mug-standard-x334-right-pad-600x600-f8f8f8.jpg","https://i.ibb.co/mBxLCVH/pp-504x498-pad-600x600-f8f8f8.jpg",  (short) 13,1200.0,"Dragon Ball Z",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product89);
			Product product90= new Product("Dragon Ball - Goku","todo decoraciones, ideal para regalo o decoracion de la casa","https://i.ibb.co/k5kZm8M/16449361154841-065d20a22deea3f94016449383669437-640-0.png","https://i.ibb.co/PDWJm09/VNb-J8f-Gm-400x400.jpg",  (short) 13,1200.0,"Dragon Ball Z",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product90);
			Product product91= new Product("Dragon Ball - Goku","todo decoraciones, ideal para regalo o decoracion de la casa","https://cdn.shopify.com/s/files/1/0399/1833/8203/products/taza-dragon-ball-super-goku-black-rose.jpg?v=1638009719","https://i.ibb.co/PDWJm09/VNb-J8f-Gm-400x400.jpg",  (short) 13,1200.0,"Dragon Ball Z",  Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product91);
			Product product92= new Product("Dragon Ball - DBZ","juegos de mesa, ideal para regalo o entretenimiento de la casa","https://i.ibb.co/SJ5W65T/images-q-tbn-ANd9-Gc-Qqk4-H0mdyd-FNy-UAT3-VBp-Kq-WYk-1t0-Bg-Nf-R3qzidjh-VEW-Ei1eg-LTOktc3-Dw-V4-WY6b.jpg","https://i.ibb.co/Ws38zRt/eleven-force-dragon-ball-z-monopoly-spanish.jpg",  (short) 13,5000.0,"Dragon Ball Z",  Category.BAZARANDTOYSHOP , "Board Games");
			productRepository.save(product92);
			Product product93= new Product("Dragon Ball - DBZ","juegos de mesa, ideal para regalo o entretenimiento de la casa","https://www.oxfordlibreria.com.ar/media/catalog/product/cache/5a38f6614905178fa07804facc7b33a0/2/5/2567603269015_20220325200034.jpg","https://image.api.playstation.com/vulcan/ap/rnd/202206/0609/do5IApyEkMcmw17gnaCSDH8g.png",  (short) 13,5000.0,"Dragon Ball Z",  Category.BAZARANDTOYSHOP , "Board Games");
			productRepository.save(product93);
			Product product94= new Product("Marvel Series - Marvel","juegos de mesa, ideal para regalo o entretenimiento de la casa","https://i.ibb.co/2yL0X9x/D-NQ-NP-775731-MLA45982875870-052021-O.jpg","https://i.ibb.co/jLfJtp0/images-q-tbn-ANd9-Gc-Ql-I2-CSrgmu-Ettg-M-s-Ug-VLd-BTs2-Sowlqp-Tb-M5sdr-ISIWt-QVDOm2-Hjmir-Kgta-zt-AJ.png",  (short) 13,5000.0,"Marvel",  Category.BAZARANDTOYSHOP , "Board Games");
			productRepository.save(product94);
			Product product95= new Product("Marvel Series - Marvel","juegos de mesa, ideal para regalo o entretenimiento de la casa","https://i.ibb.co/FqPK6XM/images-q-tbn-ANd9-Gc-QRcjw4-UPsdt-LOP5e-Bijx-CCp-EL3k6-BW4-W07-G147kj-Lk-Kfr-YDSJEpbv-EYPTGYL5-J0vto.jpg","https://i.ibb.co/LrdTHSB/TURISTA-DE-MARVEL-NOVELTY-2.jpg",  (short) 13,5000.0,"Marvel",  Category.BAZARANDTOYSHOP , "Board Games");
			productRepository.save(product95);

			//Mouse pads
			Product product101 = new Product("Mouse pad Charlotte Katakuri",
					"Mouse pad (25x30) de Charlotte Katakuri del anime One Piece, de poliester",
					"https://i.ibb.co/4SyCrrh/1-img.jpg",
					"https://i.ibb.co/YLZq5fM/1-imgSec.jpg",
					(short) 20,2200.0,"One Piece",
					Category.ACCESSORIES , "Mouse Pad");
			productRepository.save(product101);

			Product product102 = new Product("Mouse pad Gotoubun no Hanayome",
					"Mouse pad XL(80x40) de Gotoubun no Hanayome",
					"https://i.ibb.co/5KWnWQZ/2-img.jpg",
					"https://i.ibb.co/PmGHGct/2-imgSec.jpg",
					(short) 15,4200.0,"Gotoubun No Hanayome",
					Category.ACCESSORIES , "Mouse Pad");
			productRepository.save(product102);

			Product product103 = new Product("Mouse pad Jujutsu Kaisen",
					"Mouse pad XL(80x40) de Jujutsu Kaisen extra gruesa",
					"https://i.ibb.co/qxDy1zX/3-img.jpg",
					"https://i.ibb.co/c1F8xXx/3-imgSec.jpg",
					(short) 15,4200.0,"Jujutsu Kaisen",
					Category.ACCESSORIES , "Mouse Pad");
			productRepository.save(product103);

			Product product104 = new Product("Mouse pad de Senku",
					"Mouse pad (20x25) de Senku de Dr Stone",
					"https://i.ibb.co/X25ypWf/4-img.jpg",
					"https://i.ibb.co/xXZ1XK0/4-imgSec.jpg",
					(short) 15,2000.0,"Dr Stone",
					Category.ACCESSORIES , "Mouse Pad");
			productRepository.save(product104);

			Product product105 = new Product("Mouse pad de Naruto",
					"Mouse pad XL(80x40) de Naruto",
					"https://i.ibb.co/hY4Kgn1/5-img.jpg",
					"https://i.ibb.co/g38YFj2/5-imgSec.jpg",
					(short) 19,3800.0,"Naruto Shippuden",
					Category.ACCESSORIES , "Mouse Pad");
			productRepository.save(product105);

			Product product106 = new Product("Mouse pad de Pikachu",
					"Mouse pad XL(80x40) de Pikachu Pokemon",
					"https://i.ibb.co/9sxN0By/6-img.jpg",
					"https://i.ibb.co/BnGRmvD/6-s.jpg",
					(short) 19,3800.0,"Pokemon",
					Category.ACCESSORIES , "Mouse Pad");
			productRepository.save(product106);

			Product product107 = new Product("Mouse pad de Natsu Fairy Tail",
					"Mouse pad XL(80x40) de Natsu",
					"https://i.ibb.co/9Vcqvb0/7.jpg",
					"https://i.ibb.co/5M1rdQY/7s.jpg",
					(short) 22,3900.0,"Fairy Tail",
					Category.ACCESSORIES , "Mouse Pad");
			productRepository.save(product107);

			Product product108 = new Product("Mouse pad de Nami",
					"Mouse pad (20x25) de Nami de One Piece",
					"https://i.ibb.co/Vgph6xt/8.jpg",
					"https://i.ibb.co/TtWxXDM/8s.jpg",
					(short) 12,2500.0,"One Piece",
					Category.ACCESSORIES , "Mouse Pad");
			productRepository.save(product108);

			Product product109 = new Product("Mouse pad de Nanachi Made in abyss",
					"Mouse pad (25x30) de Nanachi, anime made in abyss, antideslizante",
					"https://i.ibb.co/w62YXhL/9.jpg",
					"https://i.ibb.co/7p03Qq8/9s.jpg",
					(short) 17,2300.0,"Made in Abyss",
					Category.ACCESSORIES , "Mouse Pad");
			productRepository.save(product109);

			Product product110 = new Product("Mouse pad de Monogatarie series",
					"Mouse pad (30x25) de Monogatarie series, antideslizante",
					"https://i.ibb.co/xS0qLzP/10.jpg",
					"https://i.ibb.co/8mX2kJZ/10s.jpg",
					(short) 19,2250.0,"Monogatarie Series",
					Category.ACCESSORIES , "Mouse Pad");
			productRepository.save(product110);

			Product product111 = new Product("Mouse pad de Raphtalia",
					"Mouse pad (30x25) de Raphtalia del anime Tate no yuusha",
					"https://i.ibb.co/kh51ndz/11.jpg",
					"https://i.ibb.co/GRFkbMB/11s.jpg",
					(short) 22,2050.0,"Tate No Yuusha",
					Category.ACCESSORIES , "Mouse Pad");
			productRepository.save(product111);

			Product product112 = new Product("Mouse pad de FLCL",
					"Mouse pad (30x25) de FLCL antideslizante de goma",
					"https://i.ibb.co/F8vNtN6/12.jpg",
					"https://i.ibb.co/HxJDH2R/12s.jpg",
					(short) 12,2050.0,"FLCL",
					Category.ACCESSORIES , "Mouse Pad");
			productRepository.save(product112);

			Product product113 = new Product("Mouse pad de Koro sensei",
					"Mouse pad (30x25) de Koro sensei del anime Assassination Classroom, antideslizante de goma",
					"https://i.ibb.co/2MkV1Mr/13.jpg",
					"https://i.ibb.co/RpHRYGK/13s.jpg",
					(short) 16,2250.0,"Assassination Classroom",
					Category.ACCESSORIES , "Mouse Pad");
			productRepository.save(product113);

			Product product114 = new Product("Mouse pad de Koe no Katachi",
					"Mouse pad (30x25) del anime Koe no Katachi, de tela de poliester",
					"https://i.ibb.co/SnZjCxd/14.jpg",
					"https://i.ibb.co/yq8q8B2/14s.jpg",
					(short) 19,2300.0,"Koe No Katachi",
					Category.ACCESSORIES , "Mouse Pad");
			productRepository.save(product114);

			Product product115 = new Product("Mouse pad de Okumura",
					"Mouse pad (30x25) de Okumura del anime Ao no Exorcist, de tela de poliester",
					"https://i.ibb.co/r59bp98/15.jpg",
					"https://i.ibb.co/PwnZ83T/15s.jpg",
					(short) 12,2200.0,"Ao No Exorcist",
					Category.ACCESSORIES , "Mouse Pad");
			productRepository.save(product115);

			Product product116 = new Product("Uno",
					"Juego de cartas almacenado en una lata, apto para mayores de 7 años",
					"https://i.ibb.co/n0fzsJK/16.jpg",
					"https://i.ibb.co/cF0w1nn/16s.jpg",
					(short) 12,2200.0,"varios",
					Category.BAZARANDTOYSHOP, "Board Games");
			productRepository.save(product116);

			Product product117 = new Product("Catan",
					"Juego de estrategia de hasta 4 jugadores, apto para mayores de 7 años",
					"https://i.ibb.co/tsxYk8F/17.jpg",
					"https://i.ibb.co/7z94yhC/17s.jpg",
					(short) 10,5000.0,"varios",
					Category.BAZARANDTOYSHOP , "Board Games");
			productRepository.save(product117);

			Product product118 = new Product("Attack on titan: the last stand",
					"Juego de mesa ambientado en el mundo de Shingeki no Kyojin, hasta 6 jugadores",
					"",
					"",
					(short) 12,5400.0,"Shingeki no Kyojin",
					Category.BAZARANDTOYSHOP , "Board Games");
			productRepository.save(product118);

			Product product119 = new Product("Attack on titan: the last stand",
					"Juego de cartas de hasbro en los que se pueden tocar temas sensibles, apto para mayores de 16 años",
					"https://i.ibb.co/LnFtPvb/18.jpg",
					"https://i.ibb.co/thqtVbr/18s.jpg",
					(short) 12,5400.0,"varios",
					Category.BAZARANDTOYSHOP , "Board Games");
			productRepository.save(product119);

			Product product120 = new Product("El embustero",
					"Juego de cartas de asociacion de palabras,faroles y sospechas, apto para mayores de 12 años",
					"https://i.ibb.co/vwV1wYd/20.jpg",
					"https://i.ibb.co/w4Tt6Vz/20s.jpg",
					(short) 12,2800.0,"varios",
					Category.BAZARANDTOYSHOP , "Board Games");
			productRepository.save(product120);

			Product product121 = new Product("Virus",
					"Juego de cartas en el que gana el primero en armar un cuerpo sano, apto para todo publico",
					"https://i.ibb.co/m0s420x/21.jpg",
					"https://i.ibb.co/zX3YBBL/21s.jpg",
					(short) 14,2600.0,"varios",
					Category.BAZARANDTOYSHOP , "Board Games");
			productRepository.save(product121);

			Product product122 = new Product("Tribu de sinverguenzas",
					"Juego de mesa para echarse unas risas, muy gamberro que empieza donde termina la vergüenza",
					"https://i.ibb.co/d4pxTBz/22.jpg",
					"https://i.ibb.co/nQLJ3Wp/22s.jpg",
					(short) 11,2800.0,"varios",
					Category.BAZARANDTOYSHOP , "Board Games");
			productRepository.save(product122);

			Product product123 = new Product("Fantasma blitz",
					"Juego de reflejo, el mas rapido en llevarse la pieza gana un punto, aptop para mayores de 14",
					"https://i.ibb.co/k51NPWf/23.jpg",
					"https://i.ibb.co/vshwR8g/23s.jpg",
					(short) 4,3200.0,"varios",
					Category.BAZARANDTOYSHOP , "Board Games");
			productRepository.save(product123);

			Product product124 = new Product("Polilla tranmposa",
					"Juego de cartas donde el objetivo es hacer trampa para quedarte sin cartas",
					"https://i.ibb.co/FJRg3rc/24.jpg",
					"https://i.ibb.co/N2WsLcy/24s.jpg",
					(short) 14,3000.0,"varios",
					Category.BAZARANDTOYSHOP , "Board Games");
			productRepository.save(product124);

			//tazas
			Product product130 = new Product("Star wars - Stormtrooper",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/xStHXJp/304d3ca35b1cdc8b038c3337e8a9bf32-800x1-a31baac780ed8c0b6215948413189623-640-0.jpg",
					"https://i.ibb.co/SncD9DB/transparent.png",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product130);
			Product product131 = new Product("Star wars - Stormtrooper",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/KxDw2KV/images-q-tbn-ANd9-Gc-Szglyw-XKhnb-LMGp-I0or-M-rp-Iuwm9-Wxi-TAZg-usqp-CAU.jpg",
					"https://i.ibb.co/SncD9DB/transparent.png",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product131);
			Product product132 = new Product("Star wars - Darth Vader",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/3zkcSW6/01-Taza-Darth-Vader-Star-Wars.jpg",
					"https://www.hasbro.com/common/productimages/en_US/748B115080434F2D9D488427B3988BCE/9ac9e32e83f35b3e00dfaaa8c5a7055c8dfbe4d8.jpg",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product132);
			Product product133 = new Product("Star wars - Darth Vader",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/b2CYPGJ/images-q-tbn-ANd9-Gc-SIMYw1-E86wn-Le-GYDH-dk-Bg-Hk9-Tz0e-Dwq6c6-Q-usqp-CAU.jpg",
					"https://www.hasbro.com/common/productimages/en_US/748B115080434F2D9D488427B3988BCE/9ac9e32e83f35b3e00dfaaa8c5a7055c8dfbe4d8.jpg",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product133);
			Product product134 = new Product("Star wars - Yoda",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/T2P5twY/Baby-Yoda-Cafe.jpg",
					"https://i.ibb.co/kS1hKtc/image.jpg",
					(short) 3,2500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product134);
			Product product135 = new Product("Star wars - Yoda",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/Fq8ZJgZ/20210629-1820511-d8510a090127864f7516250032187395-480-0.jpg",
					"https://i.ibb.co/kS1hKtc/image.jpg",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product135);
			Product product136 = new Product("Star wars - chewbacca",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/S0jtWsX/s-l300.jpg",
					"https://i.ibb.co/RpqST8S/BPCT32-VD4-BA6-HF7-BK7-SGJ7-XVAA.jpg",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product136);
			Product product137 = new Product("Star wars - chewbacca",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/9bXgX3Q/taza-chewbacca-star-wars-upset-a-wookiee.jpg",
					"https://i.ibb.co/RpqST8S/BPCT32-VD4-BA6-HF7-BK7-SGJ7-XVAA.jpg",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product137);
			Product product138 = new Product("Star wars - Darth Vader",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/Q9GgNfW/taza-darth-vader-star-wars-strong.jpg",
					"https://www.hasbro.com/common/productimages/en_US/748B115080434F2D9D488427B3988BCE/9ac9e32e83f35b3e00dfaaa8c5a7055c8dfbe4d8.jpg",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product138);
			Product product139 = new Product("Star wars - Darth Vader",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/KwV0pv3/taza-darth-vader-star-wars-latte-550-ml-dark-side.jpg",
					"https://www.hasbro.com/common/productimages/en_US/748B115080434F2D9D488427B3988BCE/9ac9e32e83f35b3e00dfaaa8c5a7055c8dfbe4d8.jpg",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product139);
			Product product140 = new Product("Star wars - Darth Vader",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/MS9pvzN/s-l500.png",
					"https://www.hasbro.com/common/productimages/en_US/748B115080434F2D9D488427B3988BCE/9ac9e32e83f35b3e00dfaaa8c5a7055c8dfbe4d8.jpg",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product140);
			Product product141 = new Product("Star wars - Darth Vader",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/WscPktC/81t0h-Lr7kd-L-AC-SS450.jpg",
					"https://www.hasbro.com/common/productimages/en_US/748B115080434F2D9D488427B3988BCE/9ac9e32e83f35b3e00dfaaa8c5a7055c8dfbe4d8.jpg",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product141);
			Product product142 = new Product("Star wars - Yoda",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/Yh2XjzJ/gsc-112868903-438853-1-wid-800-hei-800-qlt-70.jpg",
					"https://i.ibb.co/kS1hKtc/image.jpg",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product142);
			Product product143 = new Product("Star wars - Yoda",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/pLY4NDK/D-NQ-NP-751308-MLA46910485595-072021-O.jpg",
					"https://i.ibb.co/kS1hKtc/image.jpg",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product143);
			Product product144 = new Product("Star wars - Yoda",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/wWPSpJW/the-child-this-is-my-good-side-mouse-pad-rbb9d888018894497a1d0ffe5b916bc6b-0898s-8byvr-704.webp",
					"https://i.ibb.co/kS1hKtc/image.jpg",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product144);
			Product product145 = new Product("Star wars - Yoda",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/jfhZ2jW/images-q-tbn-ANd9-Gc-RIEHYN-vs9u-TFRq-2kaof-R8j6-Mvp-Cr3-4kaw-usqp-CAU.jpg",
					"https://i.ibb.co/kS1hKtc/image.jpg",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product145);
			Product product146 = new Product("Star wars - Stormtrooper",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/y58L1DW/713-U06ls-O8-L-AC-SY450.jpg",
					"https://i.ibb.co/SncD9DB/transparent.png",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product146);
			Product product147 = new Product("Star wars - Stormtrooper",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/KzS6zLs/D-NQ-NP-821656-MLA46133200757-052021-O.jpg",
					"https://i.ibb.co/SncD9DB/transparent.png",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product147);
			Product product148 = new Product("Star wars - chewbacca",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/Q69GjQL/chewbacca-mouse-pad.jpg",
					"https://i.ibb.co/RpqST8S/BPCT32-VD4-BA6-HF7-BK7-SGJ7-XVAA.jpg",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product148);
			Product product149 = new Product("Star wars - chewbacca",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/3pr632t/chewbacca-cartoon-doodle-mouse-pad-rfe8ebcebeae241fda2cba6daf1375913-0898s-8byvr-704.webp",
					"https://i.ibb.co/RpqST8S/BPCT32-VD4-BA6-HF7-BK7-SGJ7-XVAA.jpg",
					(short) 14,1500.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product149);
			Product product150 = new Product("Star wars - chewbacca",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/870MW9T/funko-pop-llavero-star-wars-chewbacca.jpg",
					"https://i.ibb.co/RpqST8S/BPCT32-VD4-BA6-HF7-BK7-SGJ7-XVAA.jpg",
					(short) 14,999.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product150);
			Product product151 = new Product("Star wars - chewbacca",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/SVCz1Np/images-q-tbn-ANd9-Gc-RR3k-ZGe-F56-EOwm-Aco7s0-Prajo-PTzfble41e-Q-usqp-CAU.jpg",
					"https://i.ibb.co/RpqST8S/BPCT32-VD4-BA6-HF7-BK7-SGJ7-XVAA.jpg",
					(short) 14,999.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product151);
			Product product152 = new Product("Star wars - chewbacca",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/gMVYygg/images-q-tbn-ANd9-Gc-QWkki4-T3xrpt-Ktmxyavk24-Na8n-9-k-J-Ebw-usqp-CAU.jpg",
					"https://i.ibb.co/RpqST8S/BPCT32-VD4-BA6-HF7-BK7-SGJ7-XVAA.jpg",
					(short) 14,999.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product152);
			Product product153 = new Product("Star wars - chewbacca",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/t2qdtyC/images-q-tbn-ANd9-Gc-Sc57-ZJ7v9y-Vi6v-HPn-Wv-Xcdmy-Rp-Q0-sx-Wx-JQFSX-a-Tv7w68cy2i-BF-Yx-TB71-Qi-ZXpz.jpg",
					"https://i.ibb.co/RpqST8S/BPCT32-VD4-BA6-HF7-BK7-SGJ7-XVAA.jpg",
					(short) 14,999.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product153);
			Product product154 = new Product("Star wars - Stormtrooper",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/KwFRsrH/images-q-tbn-ANd9-Gc-R7-Nis-BToo-Ysm-Ee-T2psf-ZPHq-Xalv-Yx9-Nylfjg-usqp-CAU.jpg",
					"https://i.ibb.co/SncD9DB/transparent.png",
					(short) 14,999.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product154);
			Product product155 = new Product("Star wars - Stormtrooper",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/PW4SwPd/llavero-casco-stormtrooper-star-wars.jpg",
					"https://i.ibb.co/SncD9DB/transparent.png",
					(short) 14,999.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product155);
			Product product156 = new Product("Star wars - Darth Vader",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/wwv9JfV/D-NQ-NP-814561-CBT44432679681-122020-O-removebg-preview.png",
					"https://www.hasbro.com/common/productimages/en_US/748B115080434F2D9D488427B3988BCE/9ac9e32e83f35b3e00dfaaa8c5a7055c8dfbe4d8.jpg",
					(short) 14,999.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product156);
			Product product157 = new Product("Star wars - Darth Vader",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/RHKzjdg/n-57ab7bd2-e9a4-11ec-bb22-0a77ebf6f2f9.jpg",
					"https://www.hasbro.com/common/productimages/en_US/748B115080434F2D9D488427B3988BCE/9ac9e32e83f35b3e00dfaaa8c5a7055c8dfbe4d8.jpg",
					(short) 14,999.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product157);
			Product product158= new Product("Star wars - Yoda",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/bXX586M/H2da2fb00921c46bf8b42924f1b697103u.jpg",
					"https://i.ibb.co/kS1hKtc/image.jpg",
					(short) 14,999.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product158);
			Product product159 = new Product("Star wars - Yoda",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/Ns8zW2x/d219e3d1-9d35-4e84-8abe-88ea98388222-21-278ff1c148b6fce2a316128074025350-1024-1024.jpg",
					"https://i.ibb.co/kS1hKtc/image.jpg",
					(short) 14,999.0," Star Wars",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product159);
			//fundas
			Product product160 = new Product("Star wars - Yoda",
					"Funda edición Star Wars para Iphone",
					"https://i.ibb.co/YXpc6nw/fundababyyoda-2000x.jpg",
					"https://i.ibb.co/kS1hKtc/image.jpg",
					(short) 14,1999.0," Star Wars",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product160);
			Product product161 = new Product("Star wars - Yoda",
					"Funda edición Star Wars para Iphone",
					"https://i.ibb.co/DRqDKj1/s-l300.jpg",
					"https://i.ibb.co/kS1hKtc/image.jpg",
					(short) 4,3999.0," Star Wars",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product161);
			Product product162 = new Product("Star wars - Darth Vader",
					"Funda edición Star Wars para Iphone",
					"https://i.ibb.co/gSKN9sD/H31e43374ffdb41a28727e42ce47bb71ee-jpg.webp",
					"https://www.hasbro.com/common/productimages/en_US/748B115080434F2D9D488427B3988BCE/9ac9e32e83f35b3e00dfaaa8c5a7055c8dfbe4d8.jpg",
					(short) 14,1999.0," Star Wars",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product162);
			Product product163 = new Product("Star wars - chewbacca",
					"Funda edición Star Wars para Iphone",
					"https://i.ibb.co/0h1cmnk/icr-iphone-13-soft-back-a-x600-pad-600x600-f8f8f8.jpg",
					"https://i.ibb.co/RpqST8S/BPCT32-VD4-BA6-HF7-BK7-SGJ7-XVAA.jpg",
					(short) 14,1999.0," Star Wars",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product163);
			Product product164 = new Product("Star wars - chewbacca",
					"Funda edición Star Wars para Iphone",
					"https://i.ibb.co/RjYHspV/il-300x300-3750713221-tov7.jpg",
					"https://i.ibb.co/RpqST8S/BPCT32-VD4-BA6-HF7-BK7-SGJ7-XVAA.jpg",
					(short) 14,1999.0," Star Wars",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product164);
			Product product165 = new Product("Star wars - Stormtrooper",
					"Funda edición Star Wars para Iphone",
					"https://i.ibb.co/7vg7qj4/images-q-tbn-ANd9-Gc-Sw-Psip7-G0-QAO3-E1vq-DAms0hmag-N6-LFOOstsc3-Kqx-L9u-A7-Lh2-PEY27k-TCy-OWrrg4-Q.jpg",
					"https://i.ibb.co/SncD9DB/transparent.png",
					(short) 14,1999.0," Star Wars",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product165);
			Product product166 = new Product("Star wars - Stormtrooper",
					"Funda edición Star Wars para Iphone",
					"https://i.ibb.co/5sKbHkS/images-q-tbn-ANd9-Gc-Tqn1zu-Ti-Fjv-WJar-QSJ4-IPRLVb-LXGWGADHTQ-usqp-CAU.jpg",
					"https://i.ibb.co/SncD9DB/transparent.png",
					(short) 14,1999.0," Star Wars",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product166);
			Product product167= new Product("Star wars - Stormtrooper",
					"Funda edición Star Wars para Iphone",
					"https://i.ibb.co/QFxM0V2/1639727310275-680.png",
					"https://i.ibb.co/SncD9DB/transparent.png",
					(short) 14,1999.0," Star Wars",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product167);
			Product product168 = new Product("Star wars - Stormtrooper",
					"Funda edición Star Wars para Iphone",
					"https://i.ibb.co/G3Jf7t1/81y33c-LDs-OL-AC-SX522.jpg",
					"https://i.ibb.co/SncD9DB/transparent.png",
					(short) 14,1999.0," Star Wars",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product168);
			Product product169 = new Product("Star wars - Darth Vader",
					"Funda edición Star Wars para Iphone",
					"https://i.ibb.co/fqDD3YJ/ac-01547251-1.jpg",
					"https://www.hasbro.com/common/productimages/en_US/748B115080434F2D9D488427B3988BCE/9ac9e32e83f35b3e00dfaaa8c5a7055c8dfbe4d8.jpg",
					(short) 14,1999.0," Star Wars",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product169);
			Product product170 = new Product("Star wars - Stormtrooper","Figura de  vinilo de 10 cm",
					"https://i.ibb.co/sgYd34S/images-q-tbn-ANd9-Gc-Sr-Qs9iivq7-OCa-NZGg-1s-Lr-WI4-He-HYnpt-Tt-Hg-usqp-CAU.jpg",
					"https://i.ibb.co/SncD9DB/transparent.png",
					(short) 12,5999.0,"Star wars",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product170);
			Product product171 = new Product("Star wars - Stormtrooper","Figura de  vinilo de 10 cm",
					"https://i.ibb.co/8mKWxJb/D-NQ-NP-930956-MLA49007959088-022022-V.jpg",
					"https://i.ibb.co/SncD9DB/transparent.png",
					(short) 12,5999.0,"Star wars",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product171);
			Product product172 = new Product("Star wars - chewbacca","Figura de vinilo de 10 cm",
					"https://i.ibb.co/FWSpsvw/640-1654221214.png",
					"https://i.ibb.co/RpqST8S/BPCT32-VD4-BA6-HF7-BK7-SGJ7-XVAA.jpg",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product172);
			Product product173 = new Product("Star wars - chewbacca","Figura de vinilo de 10 cm",
					"https://i.ibb.co/4TpGtPT/images-q-tbn-ANd9-Gc-Tz6-Ju0-IV0u-XMs-Ks1i3ns4b7-Ouvdh-Wf-EZGGa-Q-usqp-CAU.jpg",
					"https://i.ibb.co/RpqST8S/BPCT32-VD4-BA6-HF7-BK7-SGJ7-XVAA.jpg",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product173);
			Product product174 = new Product("Star wars - Yoda","Figura de vinilo de 10 cm",
					"https://i.ibb.co/Y3XM6yH/e498b8c52ebfcb0f0d958babe153112b.jpg",
					"https://i.ibb.co/kS1hKtc/image.jpg",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product174);
			Product product175 = new Product("Star wars - Yoda","Figura de vinilo de 10 cm",
					"https://http2.mlstatic.com/D_NQ_NP_832133-MLA44197089938_112020-O.webp",
					"https://i.ibb.co/kS1hKtc/image.jpg",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product175);
			Product product176 = new Product("Star wars - Darth Vader","Figura de vinilo de 10 cm",
					"https://i.ibb.co/6wghsSb/funko-pop-star-wars-176-darth-vader-tie-fighter-40-aniversario-exclusive.jpg",
					"https://www.hasbro.com/common/productimages/en_US/748B115080434F2D9D488427B3988BCE/9ac9e32e83f35b3e00dfaaa8c5a7055c8dfbe4d8.jpg",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product176);
			Product product177 = new Product("Star wars - Darth Vader","Figura de vinilo de 10 cm",
					"https://i.ibb.co/fX8YpJ7/funko-pop-star-wars-176-darth-vader-tie-fighter-40-aniversario-exclusive.jpg",
					"https://www.hasbro.com/common/productimages/en_US/748B115080434F2D9D488427B3988BCE/9ac9e32e83f35b3e00dfaaa8c5a7055c8dfbe4d8.jpg",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product177);
			Product product178 = new Product("Star wars - chewbacca","Figura de vinilo de 10 cm",
					"https://i.ibb.co/KjtmGJr/funko-pop-star-wars-chewbacca-dorado-800x800.jpg",
					"https://i.ibb.co/RpqST8S/BPCT32-VD4-BA6-HF7-BK7-SGJ7-XVAA.jpg",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product178);
			Product product179 = new Product("Star wars - chewbacca","Figura de vinilo de 10 cm",
					"https://i.ibb.co/M8RtwDZ/funko-pop-chebwacca-1951-b8f3484e5df1ee0f0d16347755338234-1024-1024.png",
					"https://i.ibb.co/RpqST8S/BPCT32-VD4-BA6-HF7-BK7-SGJ7-XVAA.jpg",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product179);
			Product product180 = new Product("Star wars - chewbacca","Figura de accion de 20 cm",
					"https://i.ibb.co/DwRP3sR/images-q-tbn-ANd9-Gc-S-h-K9-BTAp-DETr-Tdp0-ALXV-Raheakk-LR9-V8g-usqp-CAU.jpg",
					"https://i.ibb.co/RpqST8S/BPCT32-VD4-BA6-HF7-BK7-SGJ7-XVAA.jpg",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product180);
			Product product181 = new Product("Star wars - chewbacca","Figura de accion de 20 cm",
					"https://i.ibb.co/L9Xrwyc/b2bfe2a7-401e-4ad3-9a20-af4d55a0c244-CR0-0-2000-2000-PT0-SX300.jpg",
					"https://i.ibb.co/RpqST8S/BPCT32-VD4-BA6-HF7-BK7-SGJ7-XVAA.jpg",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product181);
			Product product182 = new Product("Star wars - Yoda","Figura de accion de 20 cm",
					"https://www.hasbro.com/common/productimages/es_MX/AE1258C259564DD4B1BDAED55C39693A/af8d90f11e8e95aaa85f18cb025efb3e9a57abe0.jpg",
					"https://i.ibb.co/kS1hKtc/image.jpg",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product182);
			Product product183 = new Product("Star wars - Yoda","Figura de accion de 20 cm",
					"https://www.hasbro.com/common/productimages/es_MX/AE1258C259564DD4B1BDAED55C39693A/af8d90f11e8e95aaa85f18cb025efb3e9a57abe0.jpg",
					"https://i.ibb.co/kS1hKtc/image.jpg",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product183);
			Product product184 = new Product("Static Figures Darth Vader","Figura de accion de 20 cm",
					"https://http2.mlstatic.com/D_NQ_NP_787982-MLA31591942007_072019-O.webp",
					"https://www.hasbro.com/common/productimages/en_US/748B115080434F2D9D488427B3988BCE/9ac9e32e83f35b3e00dfaaa8c5a7055c8dfbe4d8.jpg",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product184);
			Product product185 = new Product("Star wars - Darth Vader","Figura de accion de 20 cm",
					"https://i.ibb.co/0BKJJJW/casco-dark-vader-star-wars-black-series-hasbro.jpg",
					"https://www.hasbro.com/common/productimages/en_US/748B115080434F2D9D488427B3988BCE/9ac9e32e83f35b3e00dfaaa8c5a7055c8dfbe4d8.jpg",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product185);
			Product product186 = new Product("Star wars - Darth Vader","Figura de accion de 20 cm",
					"https://i.ibb.co/tsTpLY4/D-NQ-NP-651076-MLA48623141451-122021-O.webp",
					"https://www.hasbro.com/common/productimages/en_US/748B115080434F2D9D488427B3988BCE/9ac9e32e83f35b3e00dfaaa8c5a7055c8dfbe4d8.jpg",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product186);
			Product product187 = new Product("Star wars - Darth Vader","Figura de accion de 20 cm",
					"https://i.ibb.co/0YVcd1G/D-NQ-NP-787982-MLA31591942007-072019-O.webp",
					"https://www.hasbro.com/common/productimages/en_US/748B115080434F2D9D488427B3988BCE/9ac9e32e83f35b3e00dfaaa8c5a7055c8dfbe4d8.jpg",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product187);
			Product product188= new Product("Star wars - Stormtrooper","Figura de accion de 20 cm",
					"https://www.hasbro.com/common/productimages/es_MX/C41027FB5BC14EC1BF4DF4E9AE213682/780A2FE1348247E483BC2D2F7433E08C.jpg",
					"https://i.ibb.co/SncD9DB/transparent.png",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product188);
			Product product189= new Product("Star wars - Stormtrooper","Figura de accion de 20 cm",
					"https://www.hasbro.com/common/productimages/es_MX/C41027FB5BC14EC1BF4DF4E9AE213682/780A2FE1348247E483BC2D2F7433E08C.jpg",
					"https://i.ibb.co/SncD9DB/transparent.png",
					(short) 12,5999.0," Star Wars",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product189);

			//DC
			Product product190= new Product("DC - Superman","Figura de accion de 20 cm",
					"https://i.ibb.co/SNqFwK3/images-q-tbn-ANd9-Gc-T02-UNMIg-QVVMJsha3-Rpjtx-NUkunj-Aurnfjeb-Y5p-Af-V0-DPp-TOFKre-M95-B0-T3-E9-Yp3.jpg",
					"https://i.ibb.co/gDv2dnL/7b8e9768fb5f20c2e8c498786ce6579c.jpg",
					(short) 12,5999.0,"DC",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product190);
			Product product191= new Product("DC -  Superman","Figura de accion de 20 cm",
					"https://i.ibb.co/kgz4k3f/images-q-tbn-ANd9-Gc-SCP-k3v-PMVINENBE8gwrxtm-Nf7-A82-SPSTV2-N6-GTm-TPWQ8b-A3-K1a4-PEb-LIbv-R-gt-Pl.jpg",
					"https://i.ibb.co/gDv2dnL/7b8e9768fb5f20c2e8c498786ce6579c.jpg",
					(short) 12,5999.0,"DC",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product191);
			Product product192= new Product("Static Figures Batman","Figura de accion de 20 cm",
					"https://i.ibb.co/q5Npkvt/6a82d090977b4c9243270fe531b34d4b-large.jpg",
					"https://i.ibb.co/tDvMVNd/ecbf66484f8439fd7021f3ef224a50a8.jpg",
					(short) 12,5999.0,"DC",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product192);
			Product product193= new Product("DC - Batman","Figura de accion de 20 cm",
					"https://i.ibb.co/VB7HvWn/887961662832.jpg",
					"https://i.ibb.co/tDvMVNd/ecbf66484f8439fd7021f3ef224a50a8.jpg",
					(short) 12,5999.0,"DC",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product193);
			Product product194= new Product("DC - Batman","Figura de accion de 20 cm",
					"https://i.ibb.co/xF8MTRf/batman-y-joker-estatua-30-cm-the-dark-knight-returns-batman-hunt-the-dark-knight-artfx.jpg",
					"https://i.ibb.co/tDvMVNd/ecbf66484f8439fd7021f3ef224a50a8.jpg",
					(short) 12,5999.0,"DC",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product194);
			Product product195= new Product("DC -  Batman","Figura de accion de 20 cm",
					"https://i.ibb.co/QDLfBZY/Busto-DC-Direct-Heroes-of-the-Universe-Busto-de-Batman-20cm.jpg",
					"https://i.ibb.co/tDvMVNd/ecbf66484f8439fd7021f3ef224a50a8.jpg",
					(short) 12,11999.0,"DC",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product195);
			Product product196= new Product("DC - Batman ","Figura de accion de 20 cm",
					"https://i.ibb.co/Vw8Bx61/fa7946e10da9a74360b62eb93aba424b.jpg",
					"https://i.ibb.co/ZcnWF8r/m-5ca15984d1aa25934bbbc582.jpg",
					(short) 12,5999.0,"DC",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product196);
			Product product197= new Product("DC - Batman ","Figura de accion de 20 cm",
					"https://i.ibb.co/HTR7Chq/estatua-diorama-joker-dc-comics-23cm-800x800.jpg",
					"https://i.ibb.co/ZcnWF8r/m-5ca15984d1aa25934bbbc582.jpg",
					(short) 12,5999.0,"DC",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product197);
			Product product198= new Product("DC - Flash ","Figura de accion de 20 cm",
					"https://i.ibb.co/Y3MVv3N/Bandai-figuras-de-acci-n-de-DC-Comics-para-ni-os-y-ni-as-juguetes-originales-jpg-Q90-jpg.webp",
					"https://i.ibb.co/NywdBtF/cdcd8d2b4c87df4eb940083eac793cb3.png",
					(short) 12,7999.0,"DC",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product198);
			Product product199= new Product("DC - Flash ","Figura de accion de 20 cm",
					"https://i.ibb.co/zf4HxKZ/Figura-de-acci-n-de-16cm-modelo-coleccionable-de-PVC-Juguetes-jpg-Q90-jpg.webp",
					"https://i.ibb.co/NywdBtF/cdcd8d2b4c87df4eb940083eac793cb3.png",
					(short) 12,3999.0,"DC",
					Category.ACTIONFIGURES, "Static Figures");
			productRepository.save(product199);
			Product product200 = new Product("DC - Superman","Figura de accion de 20 cm",
					"https://i.ibb.co/dcQFSCH/funko-pop-superman-402-palacio-imperial-dc-comics.jpg",
					"https://i.ibb.co/gDv2dnL/7b8e9768fb5f20c2e8c498786ce6579c.jpg",
					(short) 12,5999.0,"DC",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product200);
			Product product201 = new Product("DC - Superman","Figura de accion de 20 cm",
					"https://i.ibb.co/KFSB3vY/funko-pop-dc-holiday-superman-with-sweater.jpg",
					"https://i.ibb.co/gDv2dnL/7b8e9768fb5f20c2e8c498786ce6579c.jpg",
					(short) 12,5999.0,"DC",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product201);
			Product product202 = new Product("DC - Superman","Figura de accion de 20 cm",
					"https://i.ibb.co/Z1KmZcG/images-q-tbn-ANd9-Gc-Su5ugp70xo-4-UZRtgpue-OD7cdcb-AK11-E9x67ft0n-Oh-Lk-Ugx-zfj-JPRd-S-k8vb-MVg-Vs-X.jpg",
					"https://i.ibb.co/gDv2dnL/7b8e9768fb5f20c2e8c498786ce6579c.jpg",
					(short) 12,5999.0,"DC",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product202);
			Product product203 = new Product("DC - Batman","Figura de accion de 20 cm",
					"https://i.ibb.co/5sqpTS4/images-q-tbn-ANd9-Gc-Rh96-GQ8h-Tp-CK1-f7b-OEy-EFT3uza925-ed-Fdw-usqp-CAU.jpg",
					"https://i.ibb.co/ZcnWF8r/m-5ca15984d1aa25934bbbc582.jpg",
					(short) 12,5999.0,"DC",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product203);
			Product product204 = new Product("DC - Batman","Figura de accion de 20 cm",
					"https://i.ibb.co/bznDPwC/images-q-tbn-ANd9-Gc-Ql-Zf-A-Qo-AJG-mq-Aj-Sw-UU-746n-Lv7a-La-K6i8g-usqp-CAU.jpg",
					"https://i.ibb.co/ZcnWF8r/m-5ca15984d1aa25934bbbc582.jpg",
					(short) 12,5999.0,"DC",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product204);
			Product product205 = new Product("DC - Flash","Figura de accion de 20 cm",
					"https://i.ibb.co/ChBRb5w/flash-caja.jpg",
					"https://i.ibb.co/NywdBtF/cdcd8d2b4c87df4eb940083eac793cb3.png",
					(short) 12,5999.0,"DC",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product205);
			Product product206 = new Product("DC - Flash","Figura de accion de 20 cm",
					"https://i.ibb.co/wL7XFCj/pop-flash-713.jpg",
					"https://i.ibb.co/NywdBtF/cdcd8d2b4c87df4eb940083eac793cb3.png",
					(short) 12,5999.0,"DC",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product206);
			Product product207 = new Product("DC - Linterna Verde","Figura de accion de 20 cm",
					"https://i.ibb.co/k53fFfb/funko-pop-dc-imperial-linterna-verde-52431.jpg",
					"https://i.ibb.co/MpGmrF7/logo-3216326-1280.png",
					(short) 12,5999.0,"DC",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product207);
			Product product208 = new Product("DC - Linterna Verde","Figura de accion de 20 cm",
					"https://i.ibb.co/nc66TZ6/s-l400.jpg",
					"https://i.ibb.co/MpGmrF7/logo-3216326-1280.png",
					(short) 12,5999.0,"DC",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product208);
			Product product209 = new Product("DC - Superman","Figura de accion de 20 cm",
					"https://i.ibb.co/Yhtgd5w/Funko-Pop-Superman-25cm-Exclusivo-CHASE-159.jpg",
					"https://i.ibb.co/gDv2dnL/7b8e9768fb5f20c2e8c498786ce6579c.jpg",
					(short) 12,5999.0,"DC",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product209);
			//tazas
			Product product210 = new Product("DC - Superman","todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/XptR0Rj/images-q-tbn-ANd9-Gc-SRUXRAo-Hm2-OPWs-EI21xp-Vq-Bjr-WFsk-M4-XT0jw-usqp-CAU.jpg",
					"https://i.ibb.co/gDv2dnL/7b8e9768fb5f20c2e8c498786ce6579c.jpg",
					(short) 12,1000.0,"DC",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product210);
			Product product211 = new Product("DC - Superman","todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/h7PMWF3/D-NQ-NP-846302-MLA49552329375-042022-W.jpg",
					"https://i.ibb.co/gDv2dnL/7b8e9768fb5f20c2e8c498786ce6579c.jpg",
					(short) 12,1000.0,"DC",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product211);
			Product product212 = new Product("DC - Batman","todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/ngDD3cG/20210506-1655051-5499e90104b841cdd516209210270569-1024-1024.jpg",
					"https://i.ibb.co/ZcnWF8r/m-5ca15984d1aa25934bbbc582.jpg",
					(short) 12,1000.0,"DC",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product212);
			Product product213 = new Product("DC - Batman","todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/cQqy2Rn/photoroom-20210415-1419351-316bea790284b8885b16185108264707-640-0.jpg",
					"https://i.ibb.co/ZcnWF8r/m-5ca15984d1aa25934bbbc582.jpg",
					(short) 12,1000.0,"DC",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product213);
			Product product214 = new Product("DC - Linterna Verde","todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/6Bt3ZbX/images-q-tbn-ANd9-Gc-QUk-Thw50y4m-SXn9iu9tpv-Hh-M7-Gr-T69y-KU9-KA-usqp-CAU.jpg",
					"https://i.ibb.co/MpGmrF7/logo-3216326-1280.png",
					(short) 12,1000.0,"DC",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product214);
			Product product215 = new Product("DC - Linterna Verde","todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/3sf1x4H/D-NQ-NP-735368-MLA43109705467-082020-O.webp",
					"https://i.ibb.co/MpGmrF7/logo-3216326-1280.png",
					(short) 12,1000.0,"DC",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product215);
			Product product216 = new Product("DC - Flash","todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/kyn9qgX/12714154-1.jpg",
					"https://i.ibb.co/NywdBtF/cdcd8d2b4c87df4eb940083eac793cb3.png",
					(short) 12,1000.0,"DC",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product216);
			Product product217 = new Product("DC - Flash","todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/kyn9qgX/12714154-1.jpg",
					"https://i.ibb.co/NywdBtF/cdcd8d2b4c87df4eb940083eac793cb3.png",
					(short) 12,1000.0,"DC",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product217);
			Product product218 = new Product("DC - Flash","todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/PWsCtrF/5f90aa57ab4d01-78616986.jpg",
					"https://i.ibb.co/NywdBtF/cdcd8d2b4c87df4eb940083eac793cb3.png",
					(short) 12,1000.0,"DC",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product218);
			Product product219 = new Product("DC - Flash","todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/TK1yqcD/61-Np-I1-INwr-L-AC-SX679.jpg",
					"https://i.ibb.co/NywdBtF/cdcd8d2b4c87df4eb940083eac793cb3.png",
					(short) 12,1000.0,"DC",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product219);
			//Mouse Pad
			Product product220 = new Product("DC - Flash","Mouse pad (30x25) de Monogatarie series, antideslizante",
					"https://i.ibb.co/r65z4zT/51h-Nc6-RCdt-L-AC-SS450.jpg",
					"https://i.ibb.co/NywdBtF/cdcd8d2b4c87df4eb940083eac793cb3.png",
					(short) 12,800.0,"DC",
					Category.BAZARANDTOYSHOP, "Mouse Pad");
			productRepository.save(product220);
			Product product221 = new Product("DC - Flash","Mouse pad (30x25) de Monogatarie series, antideslizante",
					"https://i.ibb.co/hsHSJzL/the-flash-lightning-bolt-mouse-pad-r5fbc50bdfa43417b9702533ddeaa4d13-x74vi-8byvr-704.webp",
					"https://i.ibb.co/NywdBtF/cdcd8d2b4c87df4eb940083eac793cb3.png",
					(short) 12,800.0,"DC",
					Category.BAZARANDTOYSHOP, "Mouse Pad");
			productRepository.save(product221);
			Product product222 = new Product("DC - Superman","Mouse pad (30x25) de Monogatarie series, antideslizante",
					"https://i.linio.com/p/005ae37726cf11e962fe8ca11215e34a-product.jpg",
					"https://i.ibb.co/gDv2dnL/7b8e9768fb5f20c2e8c498786ce6579c.jpg",
					(short) 12,800.0,"DC",
					Category.BAZARANDTOYSHOP, "Mouse Pad");
			productRepository.save(product222);
			Product product223 = new Product("DC - Superman","Mouse pad (30x25) de Monogatarie series, antideslizante",
					"https://i.ibb.co/ZmKNYYv/005ae37726cf11e962fe8ca11215e34a-product.jpg",
					"https://i.ibb.co/gDv2dnL/7b8e9768fb5f20c2e8c498786ce6579c.jpg",
					(short) 12,800.0,"DC",
					Category.BAZARANDTOYSHOP, "Mouse Pad");
			productRepository.save(product223);
			Product product224 = new Product("DC - Linterna Verde","Mouse pad (30x25) de Monogatarie series, antideslizante",
					"https://i.ibb.co/gjhg26S/d0f0a5b1c6ca6f046e2cec39eab27dfc-product.jpg",
					"https://i.ibb.co/MpGmrF7/logo-3216326-1280.png",
					(short) 12,800.0,"DC",
					Category.BAZARANDTOYSHOP, "Mouse Pad");
			productRepository.save(product224);
			Product product225 = new Product("DC - Linterna Verde","Mouse pad (30x25) de Monogatarie series, antideslizante",
					"https://i.ibb.co/sg5zXfp/2086806e4b39aea5c7cf982834740549-product.jpg",
					"https://i.ibb.co/MpGmrF7/logo-3216326-1280.png",
					(short) 12,800.0,"DC",
					Category.BAZARANDTOYSHOP, "Mouse Pad");
			productRepository.save(product225);
			Product product226 = new Product("DC - Batman","Mouse pad (30x25) de Monogatarie series, antideslizante",
					"https://i.ibb.co/JCk3hYL/s-l500.jpg",
					"https://i.ibb.co/ZcnWF8r/m-5ca15984d1aa25934bbbc582.jpg",
					(short) 12,800.0,"DC",
					Category.BAZARANDTOYSHOP, "Mouse Pad");
			productRepository.save(product226);
			Product product227 = new Product("DC - Batman","Mouse pad (30x25) de Monogatarie series, antideslizante",
					"https://i.ibb.co/CVWKwHQ/s-l500.jpg",
					"https://i.ibb.co/ZcnWF8r/m-5ca15984d1aa25934bbbc582.jpg",
					(short) 12,800.0,"DC",
					Category.BAZARANDTOYSHOP, "Mouse Pad");
			productRepository.save(product227);
			Product product228 = new Product("DC - Batman",
					"Funda edición DC para Iphone",
					"https://i.ibb.co/8gpgW8x/R-just-funda-de-protecci-n-estilo-Batman-para-Iphone-12-Pro-carcasa-h-brida-de-jpg-Q90-jpg.webp",
					"https://i.ibb.co/ZcnWF8r/m-5ca15984d1aa25934bbbc582.jpg",
					(short) 14,1999.0,"DC",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product228);
			Product product229 = new Product("DC - Batman",
					"Funda edición DC para Iphone",
					"https://i.ibb.co/ZSyMMqz/funda-para-iphone-12-mini-oficial-de-dc-comics-batman-logo-transparente-dc-comics.jpg",
					"https://i.ibb.co/ZcnWF8r/m-5ca15984d1aa25934bbbc582.jpg",
					(short) 14,1999.0,"DC",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product229);
			Product product230 = new Product("DC - Superman",
					"Funda edición DC para Iphone",
					"https://i.ibb.co/NSksd0Z/images-q-tbn-ANd9-Gc-QPmd-B3-ZQb6-Vm-Dpdt-JFy9tr-Alyaund6v-XZRzg-usqp-CAU.jpg",
					"https://i.ibb.co/gDv2dnL/7b8e9768fb5f20c2e8c498786ce6579c.jpg",
					(short) 14,1999.0,"DC",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product230);
			Product product231 = new Product("DC - Superman",
					"Funda edición DC para Iphone",
					"https://i.ibb.co/wLwmx8G/8a89d23698c201d96e44e3001f767b01745b892b-original.jpg",
					"https://i.ibb.co/gDv2dnL/7b8e9768fb5f20c2e8c498786ce6579c.jpg",
					(short) 14,1999.0,"DC",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product231);
			Product product232 = new Product("DC - Linterna Verde",
					"Funda edición DC para Iphone",
					"https://i.ibb.co/Y0rXZVL/images-q-tbn-ANd9-Gc-Tq-VGtw8kv89-Gtqzs-F-USWs-MSXkugt-KNv-BDg-usqp-CAU.jpg",
					"https://i.ibb.co/MpGmrF7/logo-3216326-1280.png",
					(short) 14,1999.0,"DC",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product232);
			Product product233 = new Product("DC - Linterna Verde",
					"Funda edición DC para Iphone",
					"https://i.ibb.co/CP8VDGY/icr-iphone-13-soft-back-a-x600-pad-600x600-f8f8f8.jpg",
					"https://i.ibb.co/MpGmrF7/logo-3216326-1280.png",
					(short) 14,1999.0,"DC",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product233);
			Product product234 = new Product("DC - Flash",
					"Funda edición DC para Iphone",
					"https://i.ibb.co/VVGTcxc/icr-iphone-13-soft-back-a-x1000-pad-1000x1000-f8f8f8-u2.jpg",
					"https://i.ibb.co/NywdBtF/cdcd8d2b4c87df4eb940083eac793cb3.png",
					(short) 14,1999.0,"DC",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product234);
			Product product235 = new Product("DC - Flash",
					"Funda edición DC para Iphone",
					"https://i.ibb.co/cYhBN32/icr-iphone-13-soft-back-a-x600-pad-600x600-f8f8f8-u3.jpg",
					"https://i.ibb.co/NywdBtF/cdcd8d2b4c87df4eb940083eac793cb3.png",
					(short) 14,1999.0,"DC",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product235);
			//llavero
			Product product236 = new Product("DC - Flash",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/QFpn9kN/a71c3052f398aa74ad88837efcfdf945.jpg",
					"https://i.ibb.co/NywdBtF/cdcd8d2b4c87df4eb940083eac793cb3.png",
					(short) 14,999.0,"DC",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product236);
			Product product237 = new Product("DC - Flash",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/MR4yx3K/funko-pop-llavero-dc-flash1-af4c810119c9ec9df416333955026069-1024-1024.jpg",
					"https://i.ibb.co/NywdBtF/cdcd8d2b4c87df4eb940083eac793cb3.png",
					(short) 4,1299.0,"DC",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product237);
			Product product238 = new Product("DC - Batman",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/9vq84TQ/b86f575177fb9787347a79a4917e2aa25e1664edae5aa9208dc25057c4c8242a52979.jpg",
					"https://i.ibb.co/ZcnWF8r/m-5ca15984d1aa25934bbbc582.jpg",
					(short) 14,999.0,"DC",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product238);
			Product product239 = new Product("DC - Batman",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/56ct9Yn/batman.jpg",
					"https://i.ibb.co/ZcnWF8r/m-5ca15984d1aa25934bbbc582.jpg",
					(short) 14,999.0,"DC",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product239);
			Product product240 = new Product("DC - Superman",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwgfMuI95ulgzzdSKDKX-kgo6sIZGcKTDpmg&usqp=CAU",
					"https://i.ibb.co/gDv2dnL/7b8e9768fb5f20c2e8c498786ce6579c.jpg",
					(short) 14,999.0,"DC",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product240);
			Product product241 = new Product("DC - Superman",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/hyLMZ41/51-Dxpz-BBn-FL-AC-SS450.jpg",
					"https://i.ibb.co/gDv2dnL/7b8e9768fb5f20c2e8c498786ce6579c.jpg",
					(short) 14,999.0,"DC",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product241);
			Product product242 = new Product("DC - Linterna Verde",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSoTm0N96OGLoJgJqs1Ep8iy1Zfli9IFNW9PQ&usqp=CAU",
					"https://i.ibb.co/MpGmrF7/logo-3216326-1280.png",
					(short) 14,999.0,"DC",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product242);
			Product product243 = new Product("DC - Linterna Verde",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/vD2nPtz/images-q-tbn-ANd9-Gc-So-Tm0-N96-OGLo-Jg-Jqs1-Ep8iy1-Zfli9-IFNW9-PQ-usqp-CAU.jpg",
					"https://i.ibb.co/MpGmrF7/logo-3216326-1280.png",
					(short) 14,999.0,"DC",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product243);
			//naruto
			Product product244 = new Product("Naruto - Naruto",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/Prwrdsz/images-q-tbn-ANd9-Gc-Sw-Bxe-R7k-Awf-Ngpzd-Vj-Reh6-S8l-QBloizgb6-Kzu-Xg-ybt-Ou8b2-Vnf-Xu6j-HGUDO8-Yi9.jpg",
					"https://i.ibb.co/HptHGKC/brand.gif",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product244);
			Product product245 = new Product("Naruto - Naruto",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/v1D4s8B/llavero-naruto.jpg",
					"https://i.ibb.co/HptHGKC/brand.gif",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product245);
			Product product246 = new Product("Naruto - Sasuke",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/fqK9SQJ/D-NQ-NP-610822-MLA47396114323-092021-O.jpg",
					"https://i.ibb.co/1f7gZZb/ed9f508adbfaee0548133a878a273b5b.jpg",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product246);
			Product product247 = new Product("Naruto - Sasuke",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/jZ1GMJp/fd4e6aef07c59d3c0abc1f052409af426346cd1935287e3508130c77b34ff7b353097.jpg",
					"https://i.ibb.co/1f7gZZb/ed9f508adbfaee0548133a878a273b5b.jpg",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product247);
			Product product248 = new Product("Naruto - Sakura",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/1KxRBN7/81-EQNoi-IUw-L-AC-UL1500.jpg",
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwthPInAlKku-c-309rEyCZ7vudXXrUbuwJlFrWDCXLKIwW6B0zBhJqRbbOEuHf1m9mIc&usqp=CAU",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product248);
			Product product249 = new Product("Naruto - Sakura",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/b6rCyMQ/D-NQ-NP-712618-CBT49331582720-032022-V.jpg",
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwthPInAlKku-c-309rEyCZ7vudXXrUbuwJlFrWDCXLKIwW6B0zBhJqRbbOEuHf1m9mIc&usqp=CAU",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product249);
			Product product250 = new Product("Naruto - Kakashi",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/xjZzdSm/images-q-tbn-ANd9-Gc-Qt-Img-ORGd1zb9ypa3z-SZLLq-Dukm94pjh-ID9-A-usqp-CAU.jpg",
					"https://i.ibb.co/NFLGrM9/transparent.png",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product250);
			Product product251 = new Product("Naruto - Kakashi",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/PgRHxd7/49220e774b7775501ce60c52082e040a.jpg",
					"https://i.ibb.co/NFLGrM9/transparent.png",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Keychains");
			productRepository.save(product251);
			//tazas
			Product product252 = new Product("Naruto - Kakashi",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/THCkJmM/615-NYw35-CBL-AC-SX466.jpg",
					"https://i.ibb.co/NFLGrM9/transparent.png",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product252);
			Product product253 = new Product("Naruto - Kakashi",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/6v7qSj0/Tazas-de-caf-de-Anime-Naruto-tazas-de-t-de-Sasuke-Kakashi-Itachi-creativas-cambio-de.jpg",
					"https://i.ibb.co/NFLGrM9/transparent.png",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product253);
			Product product254 = new Product("Naruto - Naruto",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/JsqsS6Q/6.png",
					"https://i.ibb.co/HptHGKC/brand.gif",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product254);
			Product product255 = new Product("Naruto - Naruto",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/gdM54P1/TAZA-CARA-NARUTO-300x300.png",
					"https://i.ibb.co/HptHGKC/brand.gif",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product255);
			Product product256 = new Product("Naruto - Sakura",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/wMThvDH/D-NQ-NP-674270-MLM48457508504-122021-W.jpg",
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwthPInAlKku-c-309rEyCZ7vudXXrUbuwJlFrWDCXLKIwW6B0zBhJqRbbOEuHf1m9mIc&usqp=CAU",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product256);
			Product product257 = new Product("Naruto - Sakura",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/MNbxtwJ/sakura-mockup-1616747507.jpg",
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwthPInAlKku-c-309rEyCZ7vudXXrUbuwJlFrWDCXLKIwW6B0zBhJqRbbOEuHf1m9mIc&usqp=CAU",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product257);
			Product product258 = new Product("Naruto - Sasuke",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/YcF86bC/12714204-1-wid-1500-hei-1500-qlt-70.jpg",
					"https://i.ibb.co/1f7gZZb/ed9f508adbfaee0548133a878a273b5b.jpg",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product258);
			Product product259 = new Product("Naruto - Sasuke",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/sHqpKst/692-28-121-1614787347913-260-Naruto-sasuke-portable-680.png",
					"https://i.ibb.co/1f7gZZb/ed9f508adbfaee0548133a878a273b5b.jpg",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Mugs");
			productRepository.save(product259);
			//mouse pad
			Product product260 = new Product("Naruto - Sasuke",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/k8j5y6t/Alfombrilla-de-rat-n-de-Anime-Uchiha-Sasuke-RGB-accesorios-para-juegos-con-retroiluminaci-n-Luz-jpg.webp",
					"https://i.ibb.co/1f7gZZb/ed9f508adbfaee0548133a878a273b5b.jpg",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product260);
			Product product261 = new Product("Naruto - Sasuke",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/2FZN7GG/D-NQ-NP-826765-MLA47251322252-082021-V.jpg",
					"https://i.ibb.co/1f7gZZb/ed9f508adbfaee0548133a878a273b5b.jpg",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product261);
			Product product262 = new Product("Naruto - Naruto",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/XbXgZcj/1250a1-f21e7071df76e4da2515997830227161-1024-1024.jpg",
					"https://i.ibb.co/HptHGKC/brand.gif",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product262);
			Product product263 = new Product("Naruto - Naruto",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/qCTn41L/D-NQ-NP-970879-MLA48612764605-122021-V.jpg",
					"https://i.ibb.co/HptHGKC/brand.gif",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product263);
			Product product264 = new Product("Naruto - Sakura",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/Bq4J5PH/4b42bc624b6b1d61c4451be32d5446d9.jpg",
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwthPInAlKku-c-309rEyCZ7vudXXrUbuwJlFrWDCXLKIwW6B0zBhJqRbbOEuHf1m9mIc&usqp=CAU",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product264);
			Product product265 = new Product("Naruto - Sakura",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/QbSGKzT/image-a-HR0c-HM6-Ly9pb-WFn-ZXMtbm-Euc3-Ns-LWlt-YWdlcy1hb-WF6b24u-Y29t-L2lt-YWdlcy9-JLzcx-NXp6-VWol-M.jpg",
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwthPInAlKku-c-309rEyCZ7vudXXrUbuwJlFrWDCXLKIwW6B0zBhJqRbbOEuHf1m9mIc&usqp=CAU",
					(short) 14,999.0,"Naruto",
					Category.BAZARANDTOYSHOP , "Mouse Pad");
			productRepository.save(product265);
			//celular
			Product product266 = new Product("Naruto - Sakura",
					"Funda edición Naruto para Iphone",
					"https://i.ibb.co/LvHJBVc/icr-iphone-13-soft-back-a-x600-pad-600x600-f8f8f8.jpg",
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwthPInAlKku-c-309rEyCZ7vudXXrUbuwJlFrWDCXLKIwW6B0zBhJqRbbOEuHf1m9mIc&usqp=CAU",
					(short) 14,999.0,"Naruto",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product266);
			Product product267 = new Product("Naruto - Sakura",
					"Funda edición Naruto para Iphone",
					"https://i.ibb.co/1Q7jqmj/funda-naruto-sakura-1200x1200.jpg",
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwthPInAlKku-c-309rEyCZ7vudXXrUbuwJlFrWDCXLKIwW6B0zBhJqRbbOEuHf1m9mIc&usqp=CAU",
					(short) 14,999.0,"Naruto",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product267);
			Product product268 = new Product("Naruto - Naruto",
					"Funda edición Naruto para Iphone",
					"https://i.ibb.co/2M60Gjf/images-q-tbn-ANd9-Gc-RXI-a-RYRSb-YXWEv-Reobb-NWDxc-Lt-KLKy-Q7-Q27-T0m-Knyg-YD0l-A0-AQr-Bq-ILrl2-FNPs.png",
					"https://i.ibb.co/HptHGKC/brand.gif",
					(short) 14,999.0,"Naruto",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product268);
			Product product269 = new Product("Naruto - Naruto",
					"Funda edición Naruto para Iphone",
					"https://i.ibb.co/j6bjp0Q/25911278-0.png",
					"https://i.ibb.co/HptHGKC/brand.gif",
					(short) 14,999.0,"Naruto",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product269);
				Product product270 = new Product("Naruto - Sasuke",
					"Funda edición Naruto para Iphone",
					"https://i.ibb.co/4Sv7Wmx/1639726062879-680.png",
					"https://i.ibb.co/1f7gZZb/ed9f508adbfaee0548133a878a273b5b.jpg",
					(short) 14,999.0,"Naruto",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product270);
			Product product271 = new Product("Naruto - Sasuke",
					"Funda edición Naruto para Iphone",
					"https://i.ibb.co/zfHNBTK/funda-naruto-sasuke-1200x1200.jpg",
					"https://i.ibb.co/1f7gZZb/ed9f508adbfaee0548133a878a273b5b.jpg",
					(short) 14,999.0,"Naruto",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product271);
			Product product272 = new Product("Naruto - Kakashi",
					"Funda edición Naruto para Iphone",
					"https://i.ibb.co/1QYn9xQ/H8399c37eb99d4c41b2979c1fb514c43et.jpg",
					"https://i.ibb.co/NFLGrM9/transparent.png",
					(short) 14,999.0,"Naruto",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product272);
			Product product273 = new Product("Naruto - Kakashi",
					"Funda edición Naruto para Iphone",
					"https://i.ibb.co/b7vT103/funda-naruto-kakashi-1200x1200.jpg",
					"https://i.ibb.co/NFLGrM9/transparent.png",
					(short) 14,999.0,"Naruto",
					Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product273);
			//juguetes
			Product product274 = new Product("Naruto - Kakashi",
					"Figura de Naruto en vinilo de 9 cm",
					"https://i.ibb.co/59cnRz8/Kakashi-182-09403-1642458939.jpg",
					"https://i.ibb.co/NFLGrM9/transparent.png",
					(short) 14,2499.0,"Naruto",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product274);
			Product product275 = new Product("Naruto - Kakashi",
					"Figura de Naruto en vinilo de 9 cm",
					"https://i.ibb.co/qNkJMNT/Kakashi-anbu.jpg",
					"https://i.ibb.co/NFLGrM9/transparent.png",
					(short) 14,2499.0,"Naruto",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product275);
			Product product276 = new Product("Naruto - Naruto",
					"Figura de Naruto en vinilo de 9 cm",
					"https://i.ibb.co/yQS0q4p/1c4bdbed69dcad5358505f881425288206823ef6dc2046b02797f0b4e17f4c4713243.jpg",
					"https://i.ibb.co/HptHGKC/brand.gif",
					(short) 14,2499.0,"Naruto",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product276);
			Product product277 = new Product("Naruto - Naruto",
					"Figura de Naruto en vinilo de 9 cm",
					"https://i.ibb.co/XYt1C36/e49baad47a523293d8d9febeee724fea.jpg",
					"https://i.ibb.co/HptHGKC/brand.gif",
					(short) 14,2499.0,"Naruto",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product277);
			Product product278 = new Product("Naruto - Sasuke",
					"Figura de Naruto en vinilo de 9 cm",
					"https://i.ibb.co/p1GfNRz/D-NQ-NP-648656-MLA44363110706-122020-O.jpg",
					"https://i.ibb.co/1f7gZZb/ed9f508adbfaee0548133a878a273b5b.jpg",
					(short) 14,2499.0,"Naruto",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product278);
			Product product279 = new Product("Naruto - Sasuke",
					"Figura de Naruto en vinilo de 9 cm",
					"https://i.ibb.co/mJd25Jd/naruto-sasuke-cursed-mark-funko-pop-455.jpg",
					"https://i.ibb.co/1f7gZZb/ed9f508adbfaee0548133a878a273b5b.jpg",
					(short) 14,2499.0,"Naruto",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product279);
			Product product280 = new Product("Naruto - Sakura",
					"Figura de Naruto en vinilo de 9 cm",
					"https://i.ibb.co/Mgn1TSh/funko-pop-sakura-1200x1200.png",
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwthPInAlKku-c-309rEyCZ7vudXXrUbuwJlFrWDCXLKIwW6B0zBhJqRbbOEuHf1m9mIc&usqp=CAU",
					(short) 14,2499.0,"Naruto",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product280);
			Product product281 = new Product("Naruto - Sakura",
					"Figura de Naruto en vinilo de 9 cm",
					"https://i.ibb.co/QCD4Tp0/product-image-1938767690-2000x.jpg",
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwthPInAlKku-c-309rEyCZ7vudXXrUbuwJlFrWDCXLKIwW6B0zBhJqRbbOEuHf1m9mIc&usqp=CAU",
					(short) 14,2499.0,"Naruto",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product281);
			Product product282 = new Product("Naruto - Sakura",
					"Figura de Naruto en vinilo de 9 cm",
					"https://cf.shopee.com.br/file/d1e2324ef49b2d38e083335538bf7dd8",
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwthPInAlKku-c-309rEyCZ7vudXXrUbuwJlFrWDCXLKIwW6B0zBhJqRbbOEuHf1m9mIc&usqp=CAU",
					(short) 14,2499.0,"Naruto",
					Category.ACTIONFIGURES, "Static Figures!");
			productRepository.save(product282);
			Product product283 = new Product("Naruto - Sakura",
					"Figura de Naruto en vinilo de 9 cm",
					"https://i.ibb.co/yyf1gTK/d1e2324ef49b2d38e083335538bf7dd8.jpg",
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwthPInAlKku-c-309rEyCZ7vudXXrUbuwJlFrWDCXLKIwW6B0zBhJqRbbOEuHf1m9mIc&usqp=CAU",
					(short) 14,2499.0,"Naruto",
					Category.ACTIONFIGURES, "Static Figures!");
			productRepository.save(product283);
			Product product284 = new Product("Naruto - Sasuke",
					"Figura de Naruto en vinilo de 9 cm",
					"https://i.ibb.co/2d9dFyS/3ed93885eac5a86db239956c7d7676a5.jpg",
					"https://i.ibb.co/1f7gZZb/ed9f508adbfaee0548133a878a273b5b.jpg",
					(short) 14,2499.0,"Naruto",
					Category.ACTIONFIGURES, "Static Figures!");
			productRepository.save(product284);
			Product product285 = new Product("Naruto - Sasuke",
					"Figura de Naruto en vinilo de 9 cm",
					"https://i.ibb.co/QJwRJbF/Naruto-Sasuke-uchiha-figuras-21-cm-Jap-n-anime-megahouse-GEM-PVC-Shippuden-pel-cula-figuras.jpg",
					"https://i.ibb.co/1f7gZZb/ed9f508adbfaee0548133a878a273b5b.jpg",
					(short) 14,2499.0,"Naruto",
					Category.ACTIONFIGURES, "Static Figures!");
			productRepository.save(product285);
			Product product286 = new Product("Naruto - Naruto",
					"Figura de Naruto en vinilo de 9 cm",
					"https://i.ibb.co/Pm93rxL/8286131-1-wid-800-hei-800-qlt-70.jpg",
					"https://i.ibb.co/HptHGKC/brand.gif",
					(short) 14,2499.0,"Naruto",
					Category.ACTIONFIGURES, "Static Figures!");
			productRepository.save(product286);
			Product product287 = new Product("Naruto - Naruto",
					"Figura de Naruto en vinilo de 9 cm",
					"https://i.ibb.co/2KZh0N9/Naruto-Gk-Cosplay-Anime-Action-Figure-Model-Toy.jpg",
					"https://i.ibb.co/HptHGKC/brand.gif",
					(short) 14,2499.0,"Naruto",
					Category.ACTIONFIGURES, "Static Figures!");
			productRepository.save(product287);
			Product product288 = new Product("Naruto - Kakashi",
					"Figura de Naruto en vinilo de 9 cm",
					"https://i.ibb.co/HVQ0Lkv/5.jpg",
					"https://i.ibb.co/NFLGrM9/transparent.png",
					(short) 14,2499.0,"Naruto",
					Category.ACTIONFIGURES, "Static Figures!");
			productRepository.save(product288);
			Product product289 = new Product("Naruto - Kakashi",
					"Figura de Naruto en vinilo de 9 cm",
					"https://i.ibb.co/Jv2rG9b/Figura-de-acci-n-de-Naruto-Kakashi-Hatake-17-cm-PVC-Anime-Chidori-modelo-kits-de-jpg-Q90-jpg.webp",
					"https://i.ibb.co/NFLGrM9/transparent.png",
					(short) 14,2499.0,"Naruto",
					Category.ACTIONFIGURES, "Static Figures!");
			productRepository.save(product289);
			//one piece
			Product product290 = new Product("One Piece - Luffy",
					"Figura de One Piece en vinilo de 9 cm",
					"https://i.ibb.co/3CpVkjT/Figura-de-Luffy-de-Grandista-Monkey-D-27cm-juguete-de-Grandline-Anime-mu-ecos-coleccionables.jpg",
					"https://i.ibb.co/6gkwCs2/bf1d317827ae2e9592a260db9eda9471eedfa451-00.jpg",
					(short) 14,2499.0,"One Piece",
					Category.ACTIONFIGURES, "Static Figures!");
			productRepository.save(product290);
			Product product291 = new Product("One Piece - Luffy",
					"Figura de One Piece en vinilo de 9 cm",
					"https://i.ibb.co/gdr7vn5/r-BVa-EVmy-R7-OAV2cb-AAHCz-IT-u-Tc518.jpg",
					"https://i.ibb.co/6gkwCs2/bf1d317827ae2e9592a260db9eda9471eedfa451-00.jpg",
					(short) 14,2499.0,"One Piece",
					Category.ACTIONFIGURES, "Static Figures!");
			productRepository.save(product291);
			Product product292 = new Product("One Piece - Zoro",
					"Figura de One Piece en vinilo de 9 cm",
					"https://i.ibb.co/cYHtH4r/Anime-de-one-piece-Roronoa-Zoro-Articulaci-n-M-vil-figura-de-acci-n-juguetes-18.jpg",
					"https://i.ibb.co/b3Qsny2/fanart-zoro-one-piece.jpg",
					(short) 14,2499.0,"One Piece",
					Category.ACTIONFIGURES, "Static Figures!");
			productRepository.save(product292);
			Product product293 = new Product("One Piece - Zoro",
					"Figura de One Piece en vinilo de 9 cm",
					"https://i.ibb.co/vDT3f5r/afe2779f41edde6adbce22209caf0a836bd799f1-original.jpg",
					"https://i.ibb.co/b3Qsny2/fanart-zoro-one-piece.jpg",
					(short) 14,2499.0,"One Piece",
					Category.ACTIONFIGURES, "Static Figures!");
			productRepository.save(product293);
			Product product294 = new Product("One Piece - Franky",
					"Figura de One Piece en vinilo de 9 cm",
					"https://i.ibb.co/1RMLp4s/7182a83cdf9c689c6c3148ae19c1ed7a-product.jpg",
					"https://i.ibb.co/0KDwRyK/bd25d6710d38539099ba3171cefbeaf4.jpg",
					(short) 14,2499.0,"One Piece",
					Category.ACTIONFIGURES, "Static Figures!");
			productRepository.save(product294);
			Product product295 = new Product("One Piece - Franky",
					"Figura de One Piece en vinilo de 9 cm",
					"https://i.ibb.co/Bfcc5Bg/r-BVa-EFm158-AAlv-NAAFFl-MBOq4c894.jpg",
					"https://i.ibb.co/0KDwRyK/bd25d6710d38539099ba3171cefbeaf4.jpg",
					(short) 14,2499.0,"One Piece",
					Category.ACTIONFIGURES, "Static Figures!");
			productRepository.save(product295);
			Product product296 = new Product("One Piece - Sanji",
					"Figura de One Piece en vinilo de 9 cm",
					"https://i.ibb.co/Mp4DWdN/r-BVa-WF6-VWOy-AQVEi-AAMV3-DYr-Yx-Y957.jpg",
					"https://i.ibb.co/Ydq5VZJ/46d976910b261a600fa78ca382d193eee9de37cf-00.jpg",
					(short) 14,2499.0,"One Piece",
					Category.ACTIONFIGURES, "Static Figures!");
			productRepository.save(product296);
			Product product297 = new Product("One Piece - Sanji",
					"Figura de One Piece en vinilo de 9 cm",
					"https://i.ibb.co/DgXqz1G/Hda33cc7daf97498da150e1dc31de27dbh.jpg",
					"https://i.ibb.co/Ydq5VZJ/46d976910b261a600fa78ca382d193eee9de37cf-00.jpg",
					(short) 14,2499.0,"One Piece",
					Category.ACTIONFIGURES, "Static Figures!");
			productRepository.save(product297);
			Product product298 = new Product("One Piece - Sanji",
					"Figura de One Piece en vinilo de 9 cm",
					"https://i.ibb.co/74SbLHR/b17f0b96380d48a2070689b3f72d35681-3de7a557d1ceed645416071038196351-640-0.jpg",
					"https://i.ibb.co/Ydq5VZJ/46d976910b261a600fa78ca382d193eee9de37cf-00.jpg",
					(short) 14,2499.0,"One Piece",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product298);
			Product product299 = new Product("One Piece - Sanji",
					"Figura de One Piece en vinilo de 9 cm",
					"https://i.ibb.co/bd0fqL7/images-q-tbn-ANd9-Gc-Q02-Ve-Vll-Jt-Q7-PHG1d-P2-Re-Mq95-Omz-Vj-XE8k-IA-usqp-CAU.jpg",
					"https://i.ibb.co/Ydq5VZJ/46d976910b261a600fa78ca382d193eee9de37cf-00.jpg",
					(short) 14,2499.0,"One Piece",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product299);
			Product product300 = new Product("One Piece - Luffy",
					"Figura de One Piece en vinilo de 9 cm",
					"https://i.ibb.co/1T2rbc6/250147bd04d887fe6047c1ee0207e7fe.jpg",
					"https://i.ibb.co/6gkwCs2/bf1d317827ae2e9592a260db9eda9471eedfa451-00.jpg",
					(short) 14,2499.0,"One Piece",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product300);
			Product product301 = new Product("One Piece - Luffy",
					"Figura de One Piece en vinilo de 9 cm",
					"https://i.ibb.co/TkG8JMq/Funko-POP-One-Piece-Luffy-in-Kimono-Metallic-Special-Edition-tienda-oficial-funko-funko-pop-original.webp",
					"https://i.ibb.co/6gkwCs2/bf1d317827ae2e9592a260db9eda9471eedfa451-00.jpg",
					(short) 14,2499.0,"One Piece",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product301);
			Product product302 = new Product("One Piece - Franky",
					"Figura de One Piece en vinilo de 9 cm",
					"https://i.ibb.co/0KDwRyK/bd25d6710d38539099ba3171cefbeaf4.jpg",
					"",
					(short) 12,2399.0,"One Piece",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product302);
			Product product303 = new Product("One Piece - Franky",
					"Figura de One Piece en vinilo de 9 cm",
					"https://i.pinimg.com/736x/65/19/49/65194986df9d2bafb1a6150dff0619d1.jpg",
					"https://i.ibb.co/0KDwRyK/bd25d6710d38539099ba3171cefbeaf4.jpg",
					(short) 3,2799.0,"One Piece",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product303);
			Product product304 = new Product("One Piece - Zoro",
					"Figura de One Piece en vinilo de 9 cm",
					"https://i.ibb.co/yNjh7cv/x-fk54462.jpg",
					"https://i.ibb.co/b3Qsny2/fanart-zoro-one-piece.jpg",
					(short) 14,2499.0,"One Piece",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product304);
			Product product305 = new Product("One Piece - Zoro",
					"Figura de One Piece en vinilo de 9 cm",
					"https://i.ibb.co/q0vz9CF/D-NQ-NP-673564-MLM26765562381-022018-O.jpg",
					"https://i.ibb.co/b3Qsny2/fanart-zoro-one-piece.jpg",
					(short) 5,2699.0,"One Piece",
					Category.ACTIONFIGURES, "Funko POP!");
			productRepository.save(product305);
			//tazas
			Product product306 = new Product("One Piece - Zoro",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/kXNY2sc/taza-mug-11oz-one-piece-zoro.jpg",
					"https://i.ibb.co/b3Qsny2/fanart-zoro-one-piece.jpg",
					(short) 14,1200.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product306);
			Product product307 = new Product("One Piece - Zoro",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/YQH7JLX/2113535-1.jpg",
					"https://i.ibb.co/b3Qsny2/fanart-zoro-one-piece.jpg",
					(short) 14,1200.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product307);
			Product product308 = new Product("One Piece - Luffy",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/QjFwhBg/taza-mug-11oz-one-piece-luffy.jpg",
					"https://i.ibb.co/6gkwCs2/bf1d317827ae2e9592a260db9eda9471eedfa451-00.jpg",
					(short) 14,1200.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product308);
			Product product309 = new Product("One Piece - Luffy",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/S00fJqB/tazap66.jpg",
					"https://i.ibb.co/6gkwCs2/bf1d317827ae2e9592a260db9eda9471eedfa451-00.jpg",
					(short) 6,1300.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product309);
			Product product310 = new Product("One Piece - Luffy",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/6wCKvt5/487545-1.jpg",
					"https://i.ibb.co/6gkwCs2/bf1d317827ae2e9592a260db9eda9471eedfa451-00.jpg",
					(short) 14,1200.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product310);
			Product product311 = new Product("One Piece - Sanji",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/QnRx6xf/3076156-0.jpg",
					"https://i.ibb.co/Ydq5VZJ/46d976910b261a600fa78ca382d193eee9de37cf-00.jpg",
					(short) 14,1200.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product311);
			Product product312 = new Product("One Piece - Sanji",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/FqwDpF4/mug-standard-x334-right-pad-600x600-f8f8f8.jpg",
					"https://i.ibb.co/Ydq5VZJ/46d976910b261a600fa78ca382d193eee9de37cf-00.jpg",
					(short) 14,1200.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product312);
			Product product313 = new Product("One Piece - Franky",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/BBrByQ6/11960229-0.jpg",
					"https://i.ibb.co/0KDwRyK/bd25d6710d38539099ba3171cefbeaf4.jpg",
					(short) 14,1200.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product313);
			Product product314 = new Product("One Piece - Franky",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/HzB4s2t/554-28-67-1614784083682-fusion-splendide-220.png",
					"https://i.ibb.co/0KDwRyK/bd25d6710d38539099ba3171cefbeaf4.jpg",
					(short) 14,1200.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Mugs");
			productRepository.save(product314);
			//llavero
			Product product315 = new Product("One Piece - Franky",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/NF1wvZr/images-q-tbn-ANd9-Gc-R6k9-Oswza6-Mo-KDx-UHDXJJtj-Bu0-Uc-Yu9-EC2e-Bp-DY99ra-VU9c4lt-Wn-Bkmi067s23-Uve.jpg",
					"https://i.ibb.co/0KDwRyK/bd25d6710d38539099ba3171cefbeaf4.jpg",
					(short) 14,999.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Keychains");
			productRepository.save(product315);
			Product product316 = new Product("One Piece - Franky",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/TBwC5t8/LLavero-de-dibujos-animados-de-One-Piece-Zoro-llavero-de-doble-cara-colgante-acr-lico-accesorios-jpg.jpg",
					"https://i.ibb.co/0KDwRyK/bd25d6710d38539099ba3171cefbeaf4.jpg",
					(short) 6,1399.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Keychains");
			productRepository.save(product316);
			Product product317 = new Product("One Piece - Zoro",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/KxmvH72/Llavero-One-Piece-Zoro.jpg",
					"https://i.ibb.co/b3Qsny2/fanart-zoro-one-piece.jpg",
					(short) 14,999.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Keychains");
			productRepository.save(product317);
			Product product318 = new Product("One Piece - Zoro",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/y0D9gQm/one-piece-keychain-pvc-zoro-sd-x4-1-1609246390.jpg",
					"https://i.ibb.co/b3Qsny2/fanart-zoro-one-piece.jpg",
					(short) 14,999.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Keychains");
			productRepository.save(product318);
			Product product319 = new Product("One Piece - Luffy",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/NLQf32m/Akihabara-Colombia-Llavero-Luffy.jpg",
					"https://i.ibb.co/6gkwCs2/bf1d317827ae2e9592a260db9eda9471eedfa451-00.jpg",
					(short) 14,999.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Keychains");
			productRepository.save(product319);
			Product product320 = new Product("One Piece - Luffy",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/YRdDSxD/llavero-one-piece-sombrero-luffy-monkey-fotocaja-tienda-geek-cordoba-21-fb8b75353f4684e2531563293293.jpg",
					"https://i.ibb.co/6gkwCs2/bf1d317827ae2e9592a260db9eda9471eedfa451-00.jpg",
					(short) 14,999.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Keychains");
			productRepository.save(product320);
			Product product321 = new Product("One Piece - Sanji",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkogXA7UTgmG64Mk2ygoIAntoksdlYlQy2zA&usqp=CAU",
					"https://i.ibb.co/Ydq5VZJ/46d976910b261a600fa78ca382d193eee9de37cf-00.jpg",
					(short) 14,999.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Keychains");
			productRepository.save(product321);
			Product product322 = new Product("One Piece - Sanji",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://i.ibb.co/ZHDffZH/images-q-tbn-ANd9-Gc-Qkog-XA7-UTgm-G64-Mk2ygo-IAntoksdl-Yl-Qy2z-A-usqp-CAU.jpg",
					"https://i.ibb.co/Ydq5VZJ/46d976910b261a600fa78ca382d193eee9de37cf-00.jpg",
					(short) 14,999.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Keychains");
			productRepository.save(product322);
			//mouse pad
			Product product323 = new Product("One Piece - Luffy",
					"todo decoraciones, ideal para regalo o decoracion de la casa",
					"https://http2.mlstatic.com/D_NQ_NP_820455-MLB42936764802_072020-O.jpg",
					"",
					(short) 3,1299.0,"One Piece",
					Category.BAZARANDTOYSHOP, "Mouse Pad");
			productRepository.save(product323);

		};
	}

}
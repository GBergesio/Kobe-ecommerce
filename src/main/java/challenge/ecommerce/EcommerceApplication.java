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

	@Bean
	public CommandLineRunner initData(ProductRepository productRepository, ClientRepository clientRepository) {
		return (args) -> {

			// Clients
			Client admin = new Client("admin", "admin","admin@kobestore.com", passwordEncoder.encode("123"),UserType.ADMIN);
			clientRepository.save(admin);

			Client client = new Client("client", "client","client@mail", passwordEncoder.encode("123"),UserType.CLIENT);
			clientRepository.save(client);

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
			Product product23 = new Product("Marvel Series - Thor","Funda edición Marvel para Iphone","https://i.ibb.co/6FwyFvk/images-q-tbn-ANd9-Gc-Te-ELnsjkpa-L-TNs-Mtudxfa-L5-Z7f-RFgsd55-Ax-H1x-ZHNJPf-Mx-Aw3-LDc4-VTKr-A-u-G5x.jpg","https://i.ibb.co/TgQHRdF/D-NQ-NP-2-X-628203-MLA45669767978-042021-F.webp", (short) 1,6999.0,"Marvel",  Category.ACCESSORIES , "Iphone Cases");
			productRepository.save(product23);
			Product product24 = new Product("Marvel Series - Spider Man","Funda edición Marvel para Iphone","https://i.ibb.co/72khn8j/icr-iphone-13-soft-back-a-x600-pad-600x600-f8f8f8-u2.jpg","https://i.ibb.co/72khn8j/icr-iphone-13-soft-back-a-x600-pad-600x600-f8f8f8-u2.jpg", (short) 16,1999.0,"Marvel",  Category.ACCESSORIES,  "Iphone Cases");
			productRepository.save(product24);
			Product product25 = new Product("Marvel Series - IronMan","Funda edición Marvel para Iphone","https://i.ibb.co/9n2tyVq/images-q-tbn-ANd9-Gc-Tlom-Cd-XOagkg-Uu4d-VSTLd3-Duk-Sk9-Uo-APxy-Rw-usqp-CAU.jpg","https://i.ibb.co/4YHG0Fd/avengers-endgame-iron-man-tony-stark-crop1619139044711-jpg-33663383.jpg", (short) 15,1999.0,"Marvel",  Category.ACCESSORIES,  "Iphone Cases");
			productRepository.save(product25);
			Product product26 = new Product("Marvel Series - Capitan America","Funda edición Marvel para Iphone","https://i.ibb.co/9c6QzTS/il-570x-N-1271762446-970y.jpg","https://i.ibb.co/CVDZJfv/YRDRN2-AWWNATVHH3-CPLXR4-FUPA.jpg", (short) 1,1999.0,"Marvel",  Category.ACCESSORIES , "Iphone Cases");
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
					(short) 14,3200.0,"varios",
					Category.BAZARANDTOYSHOP , "Board Games");
			productRepository.save(product123);

			Product product124 = new Product("Polilla tranmposa",
					"Juego de cartas donde el objetivo es hacer trampa para quedarte sin cartas",
					"https://i.ibb.co/FJRg3rc/24.jpg",
					"https://i.ibb.co/N2WsLcy/24s.jpg",
					(short) 14,3000.0,"varios",
					Category.BAZARANDTOYSHOP , "Board Games");
			productRepository.save(product124);
		};
	}

}

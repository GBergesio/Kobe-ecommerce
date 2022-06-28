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

			//cover
			Product product21 = new Product("Marvel Series - Iron Man","Funda edición Marvel para Iphone","https://i.ibb.co/X37WPqw/71d-BJa-Hi-X3-S-AC-SS450.jpg","https://i.ibb.co/4YHG0Fd/avengers-endgame-iron-man-tony-stark-crop1619139044711-jpg-33663383.jpg", (short) 15,1999.0,"Marvel", Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product21);
			Product product22 = new Product("Marvel Series - Iron Man","Funda edición Marvel para Iphone","https://i.ibb.co/603h0hL/0525968ee93a59b56b41517b7ceddedcf9c3cbb5-original.jpg","https://i.ibb.co/4YHG0Fd/avengers-endgame-iron-man-tony-stark-crop1619139044711-jpg-33663383.jpg", (short)15, 1999.0,"Marvel", Category.ACCESSORIES, "Funda de celular");
			productRepository.save(product22);
			Product product23 = new Product("Marvel Series - Thor","Funda edición Marvel para Iphone","https://i.ibb.co/6FwyFvk/images-q-tbn-ANd9-Gc-Te-ELnsjkpa-L-TNs-Mtudxfa-L5-Z7f-RFgsd55-Ax-H1x-ZHNJPf-Mx-Aw3-LDc4-VTKr-A-u-G5x.jpg","https://i.ibb.co/TgQHRdF/D-NQ-NP-2-X-628203-MLA45669767978-042021-F.webp", (short) 1,6999.0,"Marvel",  Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product23);
			Product product24 = new Product("Marvel Series - Spider Man","Funda edición Marvel para Iphone","https://i.ibb.co/72khn8j/icr-iphone-13-soft-back-a-x600-pad-600x600-f8f8f8-u2.jpg","https://i.ibb.co/72khn8j/icr-iphone-13-soft-back-a-x600-pad-600x600-f8f8f8-u2.jpg", (short) 16,1999.0,"Marvel",  Category.ACCESSORIES,  "Funda de celular");
			productRepository.save(product24);
			Product product25 = new Product("Marvel Series - IronMan","Funda edición Marvel para Iphone","https://i.ibb.co/9n2tyVq/images-q-tbn-ANd9-Gc-Tlom-Cd-XOagkg-Uu4d-VSTLd3-Duk-Sk9-Uo-APxy-Rw-usqp-CAU.jpg","https://i.ibb.co/4YHG0Fd/avengers-endgame-iron-man-tony-stark-crop1619139044711-jpg-33663383.jpg", (short) 15,1999.0,"Marvel",  Category.ACCESSORIES,  "Funda de celular");
			productRepository.save(product25);
			Product product26 = new Product("Marvel Series - Capitan America","Funda edición Marvel para Iphone","https://i.ibb.co/9c6QzTS/il-570x-N-1271762446-970y.jpg","https://i.ibb.co/CVDZJfv/YRDRN2-AWWNATVHH3-CPLXR4-FUPA.jpg", (short) 1,1999.0,"Marvel",  Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product26);
			Product product27 = new Product("Marvel Series - Venom","Funda edición Marvel para Iphone","https://i.ibb.co/jhHTfFW/il-570x-N-2489432825-ssxc.jpg","https://i.ibb.co/TgQHRdF/D-NQ-NP-2-X-628203-MLA45669767978-042021-F.webp", (short) 1,1999.0,"Marvel",  Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product27);
			Product product28 = new Product("Marvel Series - Thor","Funda edición Marvel para Iphone","https://i.ibb.co/H4QnWbH/D-NQ-NP-804791-MCO31877551570-082019-O.jpg","https://i.ibb.co/TgQHRdF/D-NQ-NP-2-X-628203-MLA45669767978-042021-F.webp", (short) 18,1999.0,"Marvel",  Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product28);
			Product product29 = new Product("Marvel Series - Capitan America","Funda edición Marvel para Iphone","https://i.ibb.co/VwYbxrP/61j-Wcmmt-VAL-AC-SS450.jpg","https://i.ibb.co/CVDZJfv/YRDRN2-AWWNATVHH3-CPLXR4-FUPA.jpg", (short) 16,1999.0,"Marvel",  Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product29);
			Product product30 = new Product("Marvel Series - Spider Man","Funda edición Marvel para Iphone","https://i.ibb.co/xgtq4yf/71-Erkv-Rvhd-L-AC-SS450.jpg","https://i.ibb.co/4YHG0Fd/avengers-endgame-iron-man-tony-stark-crop1619139044711-jpg-33663383.jpg", (short) 10,1999.0,"Marvel",  Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product30);
			Product product31 = new Product("Marvel Series - Spider Man","Funda edición Marvel para Iphone","https://i.ibb.co/6DCxppQ/a94459bedad7cb94e53cfe621ce23a5570d452f6-original.jpg","https://i.ibb.co/4YHG0Fd/avengers-endgame-iron-man-tony-stark-crop1619139044711-jpg-33663383.jpg", (short) 10,1999.0,"Marvel",  Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product31);
			Product product32 = new Product("Dragon Ball - Gohan","Funda edición Dragon Ball para Iphone","https://i.ibb.co/5v8Fr9s/1aa21b82eef6422f6ffb2d817a81120e5272ae87-original.jpg","https://i.ibb.co/5GvLkjC/hasv-V6-Dq-400x400.jpg", (short) 1,2999.0,"Marvel",  Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product32);
			Product product33 = new Product("Dragon Ball - Goku Saiyan","Funda edición Dragon Ball para Iphone","https://i.ibb.co/F43n4VH/71fm-Yla-DCDL-AC-SX522.jpg","https://i.ibb.co/5WHpT18/296-2967569-volador-nubes-goku-goku-en-la-nube-voladora.jpg", (short) 18,1999.0,"Marvel", Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product33);
			Product product34 = new Product("Dragon Ball - Vegeta Blue","Funda edición Dragon Ball para Iphone","https://i.ibb.co/9nQGnRv/998b237ad0cf74f30a2efa7228971084cd3c53b3-original.jpg","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg", (short) 16,1999.0,"Marvel", Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product34);
			Product product35 = new Product("Dragon Ball - Goku ","Funda edición Dragon Ball para Iphone","https://i.ibb.co/bBYCvR0/1-2-300x300.png","https://i.ibb.co/PDWJm09/VNb-J8f-Gm-400x400.jpg ",(short) 14,1800.0,"Marvel", Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product35);
			Product product36 = new Product("Dragon Ball - Vegetta","Funda edición Dragon Ball para Iphone","https://i.ibb.co/KNP26nc/51t-MRe67-DXL-AC-SS450.jpg","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg", (short) 13,1999.0,"Marvel", Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product36);
			Product product37 = new Product("Dragon Ball - Vegetta","Funda edición Dragon Ball para Iphone","https://i.ibb.co/Pz7bHhK/fdad1bee2844cc1a0a0b5de095b26745.jpg","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg",(short) 13,1999.0,"Marvel", Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product37);
			Product product38 = new Product("Dragon Ball - Gotens Trunks","Funda edición Dragon Ball para Iphone","https://i.ibb.co/TKJgP7C/images-q-tbn-ANd9-Gc-SLy6-Gl-QNzl-OBo-LW0sjw-Smk88-T2-A0-Yi-Kg-CZg5-MS3u-VUDcl-Nt-AHRSo-Ju-ZYw-Job-I.jpg","https://i.ibb.co/mBxLCVH/pp-504x498-pad-600x600-f8f8f8.jpg", (short) 13,1999.0,"Marvel", Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product38);
			Product product39 = new Product("Dragon Ball - Vegetta","Funda edición Dragon Ball para Iphone","https://i.ibb.co/F62nP1S/icr-iphone-13-soft-back-a-x600-pad-600x600-f8f8f8.jpg","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg",  (short) 13,1999.0,"Marvel", Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product39);
			Product product40 = new Product("Dragon Ball - Vegetta","Funda edición Dragon Ball para Iphone","https://i.ibb.co/JzDxyKj/691dc9e9c3d632e829edb64b2cb1a97d7d4c83b3-original.jpg","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg",  (short) 13,1999.0,"Marvel", Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product40);
			Product product41 = new Product("Dragon Ball - Saiyan Blue ","Funda edición Dragon Ball para Iphone","https://i.ibb.co/k6jqYwS/9113292-0.png","https://i.ibb.co/b11L5yt/YVDKLIO6-LVBB5-BF2-CN5-DYPEYGA.jpg",  (short) 13,6999.0,"Marvel",  Category.ACCESSORIES , "Funda de celular");
			productRepository.save(product41);
		};
	}

}

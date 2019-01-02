package com.se.team21.backend;

import org.aspectj.weaver.ast.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import com.se.team21.backend.Entity.*;
import com.se.team21.backend.Repository.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(AgencyTypeRepository AgencyTypeRepository, CountryRepository CountryRepository, ProvinceRepository ProvinceRepository, RelatedInformationRepository RelatedInformationRepository, ActivitiesRepository ActivitiesRepository, TestRepository testRepository) {
		return args -> {

			Stream.of("กรุงเทพมหานคร", "กระบี่", "กาญจนบุรี", "กาฬสินธุ์", "กำแพงเพชร", "ขอนแก่น", "จันทบุรี", "ฉะเชิงเทรา", "ชลบุรี", "ชัยนาท"
					, "ชัยภูมิ", "ชุมพร", "เชียงราย", "เชียงใหม่", "ตรัง", "ตราด", "ตาก", "นครนายก", "นครปฐม", "นครพนม", "นครราชสีมา", "นครศรีธรรมราช"
					, "นครสวรรค์", "นนทบุรี", "นราธิวาส", "น่าน", "บึงกาฬ", "บุรีรัมย์", "ปทุมธานี", "ประจวบคีรีขันธ์", "ปราจีนบุรี", "ปัตตานี", "พระนครศรีอยุธยา"
					, "พังงา", "พัทลุง", "พิจิตร", "พิษณุโลก", "เพชรบุรี", "เพชรบูรณ์", "แพร่", "พะเยา", "ภูเก็ต", "มหาสารคาม", "มุกดาหาร", "แม่ฮ่องสอน"
					, "ยะลา", "ยโสธร", "ร้อยเอ็ด", "ระนอง", "ระยอง", "ราชบุรี", "ลพบุรี", "ลำปาง", "ลำพูน", "เลย", "ศรีสะเกษ", "สกลนคร", "สงขลา", "สตูล"
					, "สมุทรปราการ", "สมุทรสงคราม", "สมุทรสาคร", "สระแก้ว", "สระบุรี", "สิงห์บุรี", "สุโขทัย", "สุพรรณบุรี", "สุราษฎร์ธานี", "สุรินทร์", "หนองคาย"
					, "หนองบัวลำภู", "อ่างทอง", "อุดรธานี", "อุทัยธานี", "อุตรดิตถ์", "อุบลราชธานี", "อำนาจเจริญ").forEach(provinces -> {
				ProvinceEntity province = new ProvinceEntity();
				province.setProvinceName(provinces);
				ProvinceRepository.save(province);
			});

			Stream.of("Thailand", "Australia", "Canada", "USA").forEach(countrys -> {
				CountryEntity country = new CountryEntity();
				country.setCountryName(countrys);
				CountryRepository.save(country);
			});

			Stream.of("โรงพยาบาล", "สถานีตำรวจ", "มูลนิธิ").forEach(agencyTypes -> {
				AgencyTypeEntity agencyType = new AgencyTypeEntity();
				agencyType.setAgencyName(agencyTypes);
				AgencyTypeRepository.save(agencyType);
			});

			Stream.of("ปั่นอุ่นไอรัก", "วิ่งเพื่อสุขภาพ").forEach(activities -> {
				ActivitiesEntity activitie = new ActivitiesEntity();
				activitie.setActivitiesName(activities);
				ActivitiesRepository.save(activitie);
			});

			TestEntity test1 = new TestEntity();
			test1.settActivities("ปั่นอุ่นไอรัก");
			test1.settAddress("สนามหลวง");
			test1.settName("NS");
			testRepository.save(test1);

			TestEntity test2 = new TestEntity();
			test2.settActivities("วิ่งเพื่อสุขภาพ");
			test2.settAddress("SUT");
			test2.settName("NS");
			testRepository.save(test2);

		};
	}

}


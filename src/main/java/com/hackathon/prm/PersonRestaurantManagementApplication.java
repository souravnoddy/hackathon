package com.hackathon.prm;

import com.hackathon.prm.dtos.UserDetails;
import com.hackathon.prm.entities.PreferenceEntity;
import com.hackathon.prm.entities.UserEntity;
import com.hackathon.prm.services.PreferenceSettingService;
import com.hackathon.prm.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@SpringBootApplication
public class PersonRestaurantManagementApplication implements CommandLineRunner {

	@Autowired UserServices userServices;
	 @Autowired private ElasticsearchTemplate elasticsearchTemplate;
	 @Autowired private PreferenceSettingService preferenceSettingService;
	public static void main(String[] args) {
		SpringApplication.run(PersonRestaurantManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		elasticsearchTemplate.deleteIndex(UserEntity.class);
		elasticsearchTemplate.createIndex(UserEntity.class);
		elasticsearchTemplate.putMapping(UserEntity.class);
		UserEntity userEntity = userServices.addUser(UserDetails.builder()
				.userId("test1")
				.password("hackathon")
				.build());
		System.out.println(userEntity);

		elasticsearchTemplate.deleteIndex(PreferenceEntity.class);
		elasticsearchTemplate.createIndex(PreferenceEntity.class);
		elasticsearchTemplate.putMapping(PreferenceEntity.class);
		preferenceSettingService.addDummyPreferenceData();
	}
}

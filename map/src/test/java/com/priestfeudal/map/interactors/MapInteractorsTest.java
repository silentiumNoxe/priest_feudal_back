package com.priestfeudal.map.interactors;

import com.priestfeudal.map.MapApplication;
import com.priestfeudal.map.infrastructure.dao.map.repository.MapDAO;
import com.priestfeudal.map.infrastructure.model.MapModel;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest(classes = MapApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith({
        SpringExtension.class,
        MockitoExtension.class
})
public class MapInteractorsTest {

    @Autowired
    private MapDAO dao;

    @Container
    static MongoDBContainer mongo = new MongoDBContainer("mongo");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongo::getReplicaSetUrl);
    }

    @AfterEach
    void cleanUp() {
        dao.deleteAll();
    }

    @Test
    public void createTest() {
//        CreateMapDTO createMapDTO = new CreateMapDTO(12000, 13000, 14000, "map_1");
//        GetMapDTO getMapDTO = new GetMapDTO(12000, 13000, 14000, "map_1", 0L, "10-07-2023", "10-07-2023");
        MapModel model = new MapModel().withLengthX(12000).withLengthY(13000).withLengthZ(14000).withName("map_1").withCreatedAt(LocalDateTime.now()).withUpdatedAt(LocalDateTime.now());
        assertThat(dao.insert(model).getId()).isNotNull();
//        assertThat(createMapInteractor.create(createMapDTO)).isEqualTo(getMapDTO);
    }
}

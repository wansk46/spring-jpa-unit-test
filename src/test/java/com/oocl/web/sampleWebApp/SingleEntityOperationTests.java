package com.oocl.web.sampleWebApp;


import com.oocl.web.sampleWebApp.SingleEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

import static com.oocl.web.sampleWebApp.AssertHelper.assertThrows;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SingleEntityOperationTests {
    @Autowired
    private SingleEntityRepository singleEntityRepository;
    @Autowired
    private EntityManager entityManager;

    @Test
    public void should_not_store_to_database_if_length_exceed(){
        //Given
        final SingleEntity singleEntity = new SingleEntity();
        singleEntity.id = 1L;
        final String longName ="12345678901";
        singleEntity.name = longName;

        assertThrows(Exception.class,() -> {
            singleEntityRepository.save( singleEntity );
            singleEntityRepository.flush();
        });

    }


    @Test
    public void should_fetch_entity(){
        final SingleEntity singleEntity = new SingleEntity();
        singleEntity.id = 1L;
        singleEntity.name = "It's me";
        singleEntityRepository.save( singleEntity );

        final SingleEntity fetched =singleEntityRepository.getOne( 1L );

        assertEquals("It's me",fetched.name);
    }
}

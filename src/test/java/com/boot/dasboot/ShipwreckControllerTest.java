package com.boot.dasboot;

import com.boot.dasboot.controller.ShipwreckController;
import com.boot.dasboot.model.Shipwreck;
import com.boot.dasboot.repository.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShipwreckControllerTest {
    @InjectMocks
    private ShipwreckController sc;

    @Mock
    private ShipwreckRepository shipwreckRepository;

    @Before
    public  void init(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testShipwreckGet(){
        Shipwreck sw = new Shipwreck();
        sw.setId(1l);
        when(shipwreckRepository.getOne(1l)).thenReturn(sw);

        Shipwreck wreck = sc.get(1l);
        verify(shipwreckRepository).getOne(1l);
//        assertEquals(1l, wreck.getId().longValue());
        assertThat(wreck.getId(), is(1l));
    }
}

package com.manager.singlescreenapp;

import android.view.ViewGroup;

import com.manager.singlescreenapp.domain.entities.Author;
import com.manager.singlescreenapp.view.adapters.Adapter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

public class AdapterTest {


    @Mock
    private ViewGroup viewGroup;

    @Mock
    private List<Author> list;

    @Mock
    private Adapter adapter;


    @Before
    public void setUp(){
        adapter = new Adapter(list);
        viewGroup = new ViewGroup() {
            @Override
            protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

            }
        }
    }

    @Test
    public void onCreateViewHolderTest(){
        adapter.onCreateViewHolder(viewGroup,0);
    }

    @After
    public void tearDown(){

    }
}

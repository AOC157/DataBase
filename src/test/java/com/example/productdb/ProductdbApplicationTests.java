package com.example.productdb;

import com.example.productdb.controller.ProductController;
import com.example.productdb.model.Product;
import com.example.productdb.repository.ProductRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;


@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
class ProductdbApplicationTests {


    @Autowired
    private WebApplicationContext webApplicationContext;


    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    void contextLoads() {
    }

    @Test
    public void getOne() {
        Product created = new Product("cake", "black", 5000.0, "1399.12.05", "1400.12.05");
        when(productRepository.getOne(created.getId())).thenReturn(created);

        Product returned = productRepository.getOne(created.getId());

        assertEquals(created, returned);
    }

    @Test
    public void create() {
        Product created = new Product("cake", "black", 5000.0, "1399.12.05", "1400.12.05");

        when(productRepository.save(any(Product.class))).thenReturn(created);

        Product returned = productRepository.save(created);

        assertEquals(created, returned);
    }


}

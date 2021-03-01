package com.example.productdb;

import com.example.productdb.controller.ProductController;
import com.example.productdb.model.Product;
import com.example.productdb.repository.ProductRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static javax.management.Query.value;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;


@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
class ProductdbApplicationTests {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void contextLoads() {
    }


    @Test
    public void findAllTest() throws Exception {
        Product product1 = new Product("cake" , "black" , 5000.0, "1399.12.11" , "1400.12.11");
        Product product2 = new Product("cookie" , "brown" , 7000.0, "1399.10.00" , "1400.10.00");

        List<Product> allProducts = Arrays.asList(product1, product2);

        given(productRepository.findAll()).willReturn(allProducts);

        mockMvc.perform(get("/productList")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].name").value(product1.getName()));
    }

    @Test
    public void getOneTest() throws Exception {
        Product product = new Product("cake" , "black" , 5000.0, "1399.12.11" , "1400.12.11");

        given(productRepository.getOne(product.getId())).willReturn(product);

        mockMvc.perform(get("/oneProduct/" + product.getId())
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name"). value(product.getName()));
    }
}

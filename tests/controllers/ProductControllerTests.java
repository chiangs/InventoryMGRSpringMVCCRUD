package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import data.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "ProductControllerTests-context.xml" })
@WebAppConfiguration
public class ProductControllerTests {

		MockMvc mockMvc;

		@Autowired
		WebApplicationContext wc;

		@Autowired
		ProductController controller;

		MockProductDAO mockDAO;

		@Before
		public void setUp() {
			mockDAO = wc.getBean(MockProductDAO.class);
			// TODO - uncomment below to add a Mock object, which we control
			// TODO - build the MockMvc object with MockMvcBuilders
			controller.setDao(mockDAO);
			this.mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
		}

		@After
		public void tearDown() {
			mockDAO.loadInventory(); // cleanup
		}
		
		
		@Test
		public void test_Get_InventoryData_without_param_returns_List() {
			try {
				MvcResult result = mockMvc.perform(get("/GetInventory.do")).andExpect(status().isOk()).andReturn();
				ModelAndView mv = result.getModelAndView();
				assertEquals("viewInventory", mv.getViewName());
				ModelMap map = mv.getModelMap();
				List<Product> prodList = (List<Product>)map.get("productList");
				assertNotNull(prodList);
				assertEquals(2, prodList.size());
				
			}catch (Exception e) { 
				e.printStackTrace();
				fail(e.toString());
			}
		}
		
		@Test
		public void test_Get_ProductData_with_valid_ID_param_returns_Product() {
			try {
				MvcResult result = mockMvc.perform(get("/GetProductData.do").param("id", "3"))
						.andExpect(status().isOk()).andReturn();
				ModelAndView mv = result.getModelAndView();
				assertEquals("viewProduct", mv.getViewName());
				ModelMap map = mv.getModelMap();
				assertNotNull(map.get("product"));
				
				Product item = (Product)map.get("product");
				assertEquals(1, item.getID());
				assertEquals("Iskilde", item.getBrand());
				assertEquals("still", item.getType());
				assertEquals(33, item.getSize());
				assertEquals("2015-Jan", item.getBatch());
				assertEquals(12, item.getQtyCarton());
				assertEquals(1596, item.getQtyPallet());

			} catch (Exception e) {
				e.printStackTrace();
				fail(e.toString());
			}
		}
		
		@Test
		public void test_Get_ProductData_with_invalid_ID_param_returns_null() {
			try {
				MvcResult result = mockMvc.perform(get("/GetProductData.do").param("id", "3"))
						.andExpect(status().isOk()).andReturn();
				ModelAndView mv = result.getModelAndView();
				assertEquals("viewProduct", mv.getViewName());
				ModelMap map = mv.getModelMap();
				assertNull(map.get("product"));

			} catch (Exception e) {
				e.printStackTrace();
				fail(e.toString());
			}
		}
		
		@Test void test_Post_EditProduct_do_edits_product() {
//			try {
//				MvcResult result = mockMvc.perform(get("/GetProductData.do").param("id", "2"))
//						.andExpect(status().isOk()).andReturn();
//				ModelAndView mv = result.getModelAndView();
//				assertEquals("viewProduct", mv.getViewName());
//				ModelMap map = mv.getModelMap();
//				assertNotNull(map.get("product"));
//				
//				Product p = (Product) map.get("product");
//				p.setSize(42);
//				MvcResult result = mockMvc.perform(post("/EditProduct.do").param("id", "2").param("brand", "Iskilde").param("type", "sparkling").param("size", "67").param("batch (YYYY-Mmm)", "2016-Dec").param("Qty pr Carton", "12"))
//						.andExpect(status().isOk()).andReturn();
//				ModelAndView mv = result.getModelAndView();
//			
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//				fail(e.toString());
//			}
		}
		
		@Test
		public void test_Post_NewProduct_do_adds_product() {
			try {
				MvcResult result = mockMvc.perform(post("/NewProduct.do").param("id", "3").param("brand", "Iskilde").param("type", "sparkling").param("size", "67").param("batch (YYYY-Mmm)", "2016-Dec").param("Qty pr Carton", "12"))
						.andExpect(status().isOk()).andReturn();
				ModelAndView mv = result.getModelAndView();
				assertEquals("viewProduct", mv.getViewName());
				ModelMap map = mv.getModelMap();
				assertNotNull(map.get("product"));
				
				Product item = (Product)map.get("product");
				assertEquals(3, item.getID());
				assertEquals("Iskilde", item.getBrand());
				assertEquals("sparkling", item.getType());
				assertEquals(67, item.getSize());
				assertEquals(null, item.getBatch());
				assertEquals(null, item.getQtyCarton());
				assertEquals(null, item.getQtyPallet());


			} catch (Exception e) {
				e.printStackTrace();
				fail(e.toString());
			}	
		}
		
//		@Test
//		public void test_Post_DeleteProduct_do_deletes_product() {
//			
//		}
	}